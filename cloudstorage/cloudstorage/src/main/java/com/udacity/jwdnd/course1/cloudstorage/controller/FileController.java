package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.FileService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
public class FileController {

    private FileService fileService;
    private UserService userService;

    public FileController(FileService fileService, UserService userService) {
        this.fileService = fileService;
        this.userService = userService;
    }

    @PostMapping("/uploadFile")
    public String submit(@RequestParam("file") MultipartFile file, Authentication authentication, Model model) throws IOException {
        String username = authentication.getName();
        User user = userService.getUser(username);
        if (user!=null){
            int fileId = this.fileService.saveFile(file, user.getUserId());
        }
        return "redirect:/home";
    }

    @GetMapping("/deleteFile/{fileId}")
    public String deleteFile(@PathVariable int fileId, Authentication authentication, RedirectAttributes redirectAttributes){
        String username = authentication.getName();
        User user = userService.getUser(username);

        try {
            if (user != null){
                fileService.deleteFile(fileId);
                redirectAttributes.addAttribute("success", true);
                redirectAttributes.addAttribute("message", "Your file is deleted!");
            }
        } catch (Exception e){
            redirectAttributes.addAttribute("error", true);
            redirectAttributes.addAttribute("message", "File deleting error!");
        }
        return "redirect:/home";
    }

}
