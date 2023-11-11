package com.project.askdoctor.services;

import java.util.List;

import com.project.askdoctor.helper.ApiResponse;
import com.project.askdoctor.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.askdoctor.entity.Article;
import com.project.askdoctor.entity.Comment;
import com.project.askdoctor.entity.User;
import com.project.askdoctor.helper.ApiResponse;
import com.project.askdoctor.repository.CommentRepository;
import java.time.LocalDate;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepo;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserService userService;
    
    public  ApiResponse AddCommentToArticle(int idArticle,int idUser,String subject) {

        Article article = (Article) articleService.getArticle(idArticle).getData();
        User user = (User) userService.deleteById((long) idUser).getData();
        List<Comment> comments = article.getComments();

        Comment comment = new Comment();
        //comment.setId_user(idUser);
      
       // comment.setId_article(idArticle);
        comment.setSubject(subject);
        LocalDate date =  LocalDate.now();
        comment.setDate(date);
        comments.add(comment);
        article.setComments(comments);

       // commentRepo.save(comment);
        
        return new ApiResponse(HttpStatus.OK.value(),article, 0, "the comment added successfully");

      /*  if(article != null && user != null){
      
        if (comment.getSubject() == null ) {
            //throw new ApiRequestException("Enter the values please!!");
            return new ApiResponse(HttpStatus.OK.value(),"", 1, "Enter the values please!!");
        }
        return new ApiResponse(HttpStatus.OK.value(), commentRepo.save(comment), null, "comment Added successfully!!");
      
    }else{
        return new ApiResponse(HttpStatus.OK.value(), "", null, "Check the user and the post if exists!!");
    }*/
    }

     /*********  get the list of articles  **********/

     public ApiResponse getAll() {
         return new ApiResponse(HttpStatus.OK.value(), commentRepo.findAll(),
                 null, "List of articles success!");
    }
    
}