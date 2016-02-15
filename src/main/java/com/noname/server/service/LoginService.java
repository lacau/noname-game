package com.noname.server.service;

import com.noname.server.adapter.CredentialAdapter;
import com.noname.server.entity.Credential;
import com.noname.server.exception.InvalidCredentialsException;
import com.noname.server.json.CredentialIn;
import com.noname.server.json.CredentialOut;
import com.noname.server.repository.CredentialRepository;
import com.noname.server.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lacau on 12/02/16.
 */
@Service
public class LoginService {

    @Autowired
    private CredentialRepository credentialRepository;

    @Autowired
    private CredentialAdapter credentialAdapter;

    public void doLoginByToken(Credential credential) throws InvalidCredentialsException {
        final Credential credentialDB = credentialRepository.findByIdAndToken(credential);
        if(credentialDB == null)
            throw new InvalidCredentialsException();

        // TODO: doLogin
    }

    public CredentialOut doLoginByCredential(CredentialIn credentialIn) throws InvalidCredentialsException {
        Credential credential = new Credential();
        credential.setLogin(credentialIn.getLogin());
        credential.setPassword(SecurityUtils.generateSHA256Password(credentialIn.getPassword()));
        final Credential credentialDB = credentialRepository.findByLoginAndPassword(credential);
        if(credentialDB == null)
            throw new InvalidCredentialsException();

        // TODO: doLogin

        return credentialAdapter.adapt(credentialDB);
    }
}