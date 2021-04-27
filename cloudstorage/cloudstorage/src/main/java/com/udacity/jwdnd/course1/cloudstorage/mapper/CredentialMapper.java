package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.CredentialEnc;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CredentialMapper {
    @Select("SELECT * FROM CREDENTIALS WHERE userid = #{userid}")
    List<CredentialEnc> getCredentialList(Integer userid);

    @Insert("INSERT INTO CREDENTIALS (url, userName, key ,passWord, userid) VALUES (#{url}, #{userName}, #{key}, #{encPassWord}, #{userid})")
    @Options(useGeneratedKeys = true, keyProperty = "credentialId")
    int saveCredential(CredentialEnc credentialEnc);

    @Delete("DELETE FROM CREDENTIALS WHERE credentialId = #{credentialId}")
    void deleteCredential(Integer credentialId);


}
