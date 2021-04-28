package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.CredentialService;
import com.udacity.jwdnd.course1.cloudstorage.services.FileService;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private FileService fileService;
    private UserService userService;
    private NoteService noteService;
    private CredentialService credentialService;

    public HomeController(FileService fileService, UserService userService, NoteService noteService, CredentialService credentialService){
        this.fileService = fileService;
        this.userService = userService;
        this.noteService = noteService;
        this.credentialService = credentialService;
    }

    @GetMapping("/home")
    public String homeView(Authentication authentication, Model model) {
        String username = authentication.getName();
        User user = userService.getUser(username);
        if (user!=null){
            model.addAttribute("fileList", this.fileService.getFileList(user.getUserId()));
            model.addAttribute("noteList", this.noteService.getNoteListbyUser(user.getUserId()));
            model.addAttribute("credentialList", this.credentialService.getCredEncListbyUser(user.getUserId()));
        }

        return "home";
    }





}
