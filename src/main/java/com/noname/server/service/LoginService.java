package com.noname.server.service;

import java.util.Calendar;

import com.noname.server.converter.CredentialCacheConverter;
import com.noname.server.converter.CredentialConverter;
import com.noname.server.cache.CacheManager;
import com.noname.server.domain.entity.Credential;
import com.noname.server.exception.InvalidCredentialsException;
import com.noname.server.exception.ResponseException;
import com.noname.server.json.CredentialIn;
import com.noname.server.json.CredentialOut;
import com.noname.server.domain.repository.CredentialRepository;
import com.noname.server.security.CredentialValidator;
import com.noname.server.util.CryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lacau on 12/02/16.
 */
@Service
public class LoginService {

    @Autowired
    private CredentialRepository credentialRepository;

    @Autowired
    private CredentialConverter credentialConverter;

    @Autowired
    private CredentialCacheConverter credentialCacheConverter;

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private CredentialValidator credentialValidator;

    public void doLoginByToken(Credential credential) throws ResponseException {
        final Credential credentialDB = credentialRepository.findByIdAndToken(credential);
        if(credentialDB == null)
            throw new InvalidCredentialsException();

        cacheManager.store(credentialCacheConverter.convert(credentialDB));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public CredentialOut doLoginByCredential(CredentialIn credentialIn) throws ResponseException {
        Credential credential = new Credential();
        credential.setLogin(credentialIn.getLogin());
        credential.setPassword(CryptUtils.generateSHA256Password(credentialIn.getPassword()));
        Credential credentialDB = credentialRepository.findByLoginAndPassword(credential);
        if(credentialDB == null)
            throw new InvalidCredentialsException();

        if(!credentialValidator.isValidToken(credentialDB.getTokenDate().getTime())) {
            credentialDB.setToken(CryptUtils.generateToken(credentialDB));
            credentialDB.setTokenDate(Calendar.getInstance().getTime());
            credentialDB = credentialRepository.update(credentialDB);
        }

        cacheManager.store(credentialCacheConverter.convert(credentialDB));

        return credentialConverter.convert(credentialDB);
    }

    public void doLogout(Credential credential) throws ResponseException {
        final Credential credentialDB = credentialRepository.findByIdAndToken(credential);
        if(credentialDB == null)
            throw new InvalidCredentialsException();

        cacheManager.remove(credential.getCdId());
    }
}