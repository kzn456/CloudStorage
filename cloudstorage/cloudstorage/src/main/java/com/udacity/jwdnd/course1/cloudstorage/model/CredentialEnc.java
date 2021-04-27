package com.udacity.jwdnd.course1.cloudstorage.model;

public class CredentialEnc {
    private Integer credentialId;
    private String url;
    private String userName;
    private String key;
    private String encPassWord;
    private Integer userid;

    public CredentialEnc(Integer credentialId, String url, String userName, String key, String encPassWord, Integer userid){
        this.credentialId = credentialId;
        this.url = url;
        this.userName = userName;
        this.key = key;
        this.encPassWord = encPassWord;
        this.userid = userid;
    }

    public Integer getCredentialId(){ return credentialId; }

    public void setCredentialId(Integer credentialId){ this.credentialId = credentialId; }

    public String getUrl(){ return url; }

    public void setUrl(String url){ this.url = url; }

    public String getUserName(){ return userName; }

    public void setUserName(String userName){ this.userName = userName; }

    public String getKey(){ return key; }

    public void setKey(String key){ this.key = key; }

    public String getEncPassWord(){ return encPassWord; }

    public void setEncPassWord(String encPassWord){ this.encPassWord = encPassWord; }

}
