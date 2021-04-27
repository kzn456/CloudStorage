package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.CredentialMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.CredentialEnc;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;

public class CredentialService {
    private final CredentialMapper credentialMapper;
    private final EncryptionService encryptionService;

    public CredentialService(CredentialMapper credentialMapper, EncryptionService encryptionService){
        this.credentialMapper = credentialMapper;
        this.encryptionService = encryptionService;
    }

    public int saveCredential(Credential credential){
        SecureRandom random = new SecureRandom();
        byte[] key = new byte[16];
        random.nextBytes(key);
        String encodedKey = Base64.getEncoder().encodeToString(key);
        String encryptedPassword = encryptionService.encryptValue(credential.getPassWord(), encodedKey);
        String decryptedPassword = encryptionService.decryptValue(encryptedPassword, encodedKey);
        CredentialEnc encryptedCredential = new CredentialEnc(credential.getCredentialId(), credential.getUrl(), credential.getUserName(), encodedKey, encryptedPassword, credential.getUserid());
        return credentialMapper.saveCredential(encryptedCredential);
    }

    public List<CredentialEnc> getCredEncListbyUser(Integer userid){
        return credentialMapper.getCredentialList(userid);
    }


}
