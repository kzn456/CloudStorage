package com.udacity.jwdnd.course1.cloudstorage.model;

public class Credential {
    private Integer credentialId;
    private String url;
    private String userName;
    private String passWord;
    private Integer userid;

    public Credential(Integer credentialId, String url, String userName, String passWord, Integer userid){
        this.credentialId = credentialId;
        this.url = url;
        this.userName = userName;
        this.passWord = passWord;
        this.userid = userid;
    }

    public Integer getCredentialId(){ return credentialId; }

    public void setCredentialId(Integer credentialId){ this.credentialId = credentialId; }

    public String getUrl(){ return url; }

    public void setUrl(String url){ this.url = url; }

    public String getUserName(){ return userName; }

    public void setUserName(String userName){ this.userName = userName; }

    public String getPassWord(){ return passWord; }

    public void setPassWord(String passWord){ this.passWord = passWord; }

    public Integer getUserid(){return userid;}

    public void setUserid(Integer userid){this.userid = userid;}

}
