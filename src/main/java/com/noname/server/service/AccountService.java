package com.noname.server.service;

import com.noname.server.exception.AccountAlreadyExistsException;
import com.noname.server.json.CredentialIn;
import com.noname.server.repository.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lacau on 12/02/16.
 */
@Service
public class AccountService {

    @Autowired
    private CredentialRepository credentialRepository;

    public void createAccount(CredentialIn credentialIn) throws AccountAlreadyExistsException {
        Long countByLogin = credentialRepository.findCountByLogin(credentialIn.getLogin());
        if(countByLogin != 0)
            throw new AccountAlreadyExistsException();
    }
}