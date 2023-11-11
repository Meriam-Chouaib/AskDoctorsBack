package com.project.askdoctor.controllers;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.askdoctor.helper.ApiResponse;
import com.project.askdoctor.services.CommentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/comments/{idUser}/article/{idArticle}/")
public class CommentController {
    
    @Autowired
    private CommentService commentService;

    @PostMapping("save")
    public ApiResponse AddComm(@PathVariable("idArticle") int idArticle,@PathVariable("idUser") int idUser,@Valid @RequestBody String subject) { 
         
       return commentService.AddCommentToArticle(idArticle,idUser,subject);
       
    }

     /**** get all Comments ****/
   @GetMapping("list")
   public ApiResponse getAll() {
        return commentService.getAll();
   }

    @GetMapping("hello")
    public String helloworld(@RequestBody String name,@PathVariable("idArticle") int idArticle, @PathVariable("idUser") int idUser) {
        return "hello"+name+"user:"+idUser+"idArticle: "+idArticle;
    }
}