package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.File;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.*;

@Mapper
public interface FileMapper {
    @Select("SELECT * FROM FILES WHERE userid = #{userid}")
    List<File> getFileList(Integer userid);

    @Insert("INSERT INTO FILES (fileName, fileSize, fileData ,contentType, userid) VALUES (#{fileName}, #{fileSize}, #{fileData}, #{contentType}, #{userid})")
    @Options(useGeneratedKeys = true, keyProperty = "fileId")
    int saveFile(File file);
}
