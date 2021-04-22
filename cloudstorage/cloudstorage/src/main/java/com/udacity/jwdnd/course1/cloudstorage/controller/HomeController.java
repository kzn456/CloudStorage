package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.FileUploadService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class HomeController {

    private FileUploadService fileUploadService;
    private UserService userService;

    public HomeController(FileUploadService fileUploadService, UserService userService){
        this.fileUploadService = fileUploadService;
        this.userService = userService;
    }

    @GetMapping("/home")
    public String homeView(Authentication authentication, Model model) {
        String username = authentication.getName();
        User user = userService.getUser(username);
        if (user!=null){
            model.addAttribute("fileList", this.fileUploadService.getFileList(user.getUserId()));
        }
        return "home";
    }

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file, Authentication authentication, Model model) throws IOException {
        String username = authentication.getName();
        User user = userService.getUser(username);
        if (user!=null){
           int fileId = this.fileUploadService.saveFile(file, user.getUserId());
        }
        return "redirect:home";
    }

}
