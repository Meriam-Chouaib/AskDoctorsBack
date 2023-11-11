package com.project.askdoctor.controllers;

import com.project.askdoctor.Exception.ApiRequestException;
import com.project.askdoctor.Exception.ResourceNotFoundException;
import com.project.askdoctor.entity.Article;
import com.project.askdoctor.helper.ApiResponse;
import com.project.askdoctor.services.ArticleService;
import com.project.askdoctor.entity.Article;
import com.project.askdoctor.helper.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/articles/")
public class ArticleController {

  @Autowired
 private ArticleService articleService;

 //**** Add Article ****/

    @PostMapping("save")
    public ApiResponse saveArticle(@RequestBody Article article) {
       return articleService.saveArticle(article);
    }
 /**** get all Articles ****/
 @CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
   @GetMapping("list")
   public ApiResponse getAll() {

     return articleService.getAll();
   }

    /**** Delete Article ****/
   @GetMapping("delete/{id}")
   public ApiResponse deleteArticle(@PathVariable("id") int id) {
      return articleService.deleteById(id);
   }

   /***** Get article by id ******/

    @GetMapping("{id}")
    public ApiResponse getArticleById(@PathVariable int id) {
       return articleService.getArticle(id);
    }

    /****** Update Article *****/
    @PutMapping("update/{id}")
    public int updateArticle(@PathVariable int id,
                                           @Valid @RequestBody Article articleDetails) throws ResourceNotFoundException {
        return id;
        //        return articleService.updateArticle(id,articleDetails);
      
    }


    /******get Article with keyword */
//    @GetMapping("{keyword}")
//    public ApiResponse getArticleWithKeyword(@PathVariable("keyword") String keyword) {
//       return articleService.getArticleWithKeyword(keyword);
//    }
 

}
