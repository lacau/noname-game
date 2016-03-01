package com.noname.server.service;

import java.util.Calendar;

import com.noname.server.adapter.CredentialAdapter;
import com.noname.server.entity.Credential;
import com.noname.server.exception.ResourceAlreadyExistsException;
import com.noname.server.exception.ResponseException;
import com.noname.server.json.CredentialIn;
import com.noname.server.json.CredentialOut;
import com.noname.server.repository.CredentialRepository;
import com.noname.server.util.CryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lacau on 12/02/16.
 */
@Service
public class AccountService {

    @Autowired
    private CredentialRepository credentialRepository;

    @Autowired
    private CredentialAdapter credentialAdapter;

    @Transactional(propagation = Propagation.REQUIRED)
    public CredentialOut createAccount(CredentialIn credentialIn) throws ResponseException {
        final Long countByLogin = credentialRepository.findCountByLogin(credentialIn.getLogin());
        if(countByLogin != 0)
            throw new ResourceAlreadyExistsException();

        Credential credential = new Credential();
        credential.setLogin(credentialIn.getLogin());
        credential.setPassword(CryptUtils.generateSHA256Password(credentialIn.getPassword()));
        credential.setToken(CryptUtils.generateToken(credential));
        credential.setTokenDate(Calendar.getInstance().getTime());

        credentialRepository.insert(credential);

        return credentialAdapter.adapt(credential);
    }
}