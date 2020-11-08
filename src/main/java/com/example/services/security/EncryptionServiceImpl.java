package com.example.services.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.jasypt.util.password.StrongPasswordEncryptor;

@Service
public class EncryptionServiceImpl implements EncryptionService {

    private StrongPasswordEncryptor strongEncryptor;

    @Autowired
    public void setStrongEncryptor(StrongPasswordEncryptor strongEncryptor) {
        this.strongEncryptor = strongEncryptor;
    }

    public String encryptString(String input){
        return strongEncryptor.encryptPassword(input);
    }

    public boolean checkPassword(String plainPassword, String encryptedPassword){
        return strongEncryptor.checkPassword(plainPassword, encryptedPassword);
    }
}
