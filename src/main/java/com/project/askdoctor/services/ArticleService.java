package com.project.askdoctor.services;

import com.project.askdoctor.entity.Article;
import com.project.askdoctor.entity.User;
import com.project.askdoctor.helper.ApiResponse;
import com.project.askdoctor.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.askdoctor.Exception.ApiRequestException;
import com.project.askdoctor.Exception.ResourceNotFoundException;


import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    
    @Autowired
    private ArticleRepository articleRepo;

    /*********  Add article  **********/

    public ApiResponse saveArticle(Article article) {

        if (article.getMessage() == null || article.getTitle() == null) {
            //throw new ApiRequestException("Enter the values please!!");
            return new ApiResponse(HttpStatus.OK.value(),"", 1, "Enter the values please!!");

        } else 
        return new ApiResponse(HttpStatus.OK.value(), articleRepo.save(article), null, "Article Added successfully!!");

    }

    
 /*********  get the list of articles  **********/

    public ApiResponse getAll() {
        if (!articleRepo.findAll().isEmpty())
            return new ApiResponse(HttpStatus.OK.value(), articleRepo.findAll(), null, "List of articles success!");

        else {

            return new ApiResponse(HttpStatus.BAD_REQUEST.value(), articleRepo.findAll(), 1, "oops cannot get the articles!");
        }


    }

    /*****************  get article by id ***************/

    public ApiResponse getArticle(Integer id) {
        Article article = articleRepo.findAll().stream()
                .filter(t -> id == (t.getId()))
                .findFirst()
                .orElse(null);
        Optional<Article> article4 = articleRepo.findById(id);
        if (article4 != null) {
            return new ApiResponse(HttpStatus.OK.value(), article4, null, "List of articles success!");

        } else return new ApiResponse(HttpStatus.BAD_REQUEST.value(), null, 1, "There is no article with this id!");

    }

        /*****************  update article  ***************/


    public ApiResponse updateArticle(int id, Article articleDetails) throws ResourceNotFoundException {
        Article article = (Article) getArticle(id).getData();
        System.out.println("ok");
        if (this.getArticle(id).getData() == null) {
            return new ApiResponse(HttpStatus.BAD_REQUEST.value(), null, 1, "There is no article with this id!");
        } else if (articleDetails.getMessage() == null || articleDetails.getTitle() == null) {
            return new ApiResponse(HttpStatus.BAD_REQUEST.value(), null, 1, "Enter the values please!");
        } else {
            article.setTitle(articleDetails.getTitle());
            article.setMessage(articleDetails.getMessage());
            article.setPicture(articleDetails.getPicture());

            return new ApiResponse(HttpStatus.OK.value(), saveArticle(article).getData(), null, "The article number "+id+" updated successfully :D");
        }
    }

        /*****************  delete article ***************/

    public ApiResponse deleteById(int id) throws ResourceNotFoundException {
        Article article = (Article) this.getArticle(id).getData();
        if (article != null) {
            articleRepo.deleteById(id);
            return new ApiResponse(HttpStatus.OK.value(), article, null, "the article number " + id + " deleted successfully!");
        } else {
            return new ApiResponse(HttpStatus.FOUND.value(), this.getAll().getData(), 1, "Failed to delete the article number " + id);

        }


    }

    public ApiResponse getArticleWithKeyword(String keyword) throws ResourceNotFoundException {

        return new ApiResponse(HttpStatus.OK.value(), articleRepo.findAll(), null, "the article number deleted successfully!");
        
        }
    


}
