package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class FileUploadService {
    private final FileMapper fileMapper;

    public FileUploadService(FileMapper fileMapper){
        this.fileMapper = fileMapper;
    }

    public int saveFile(MultipartFile file, Integer userid) throws IOException {
        File filetosave = new File (file.getName(),file.getSize(),file.getBytes(),file.getContentType(),userid);
        return fileMapper.saveFile(filetosave);
    }

    public List<File> getFileList(Integer userid){
        return fileMapper.getFileList(userid);
    }

}
