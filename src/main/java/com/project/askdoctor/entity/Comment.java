package com.project.askdoctor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name="comment")
@Entity

public class Comment {
    @Column(name="id_comment")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @Column(name="subject_comment")
    private String subject;

    @Column(name="date_comment")
    private LocalDate date;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

 
    public int getId() {
        return id;
    }

   /*  @ManyToOne(
        fetch = FetchType.LAZY
)
 @JoinColumn(name = "id_article", nullable = false)
    private int id_article;
@ManyToOne(targetEntity = Article.class)
private Integer id_article;*/

@ManyToOne
@JoinColumn(name="id_article", nullable=false)
private Article article;
   

    /*public Integer getId_article() {
        return id_article;
    }

    public void setId_article(Integer id_article) {
        this.id_article = id_article;
    }*/

   /* @ManyToOne(
        fetch = FetchType.LAZY
)
    @JoinColumn(name = "id_user", nullable = false)
    private int id_user;*/

    @ManyToOne(targetEntity = User.class)
    private User user;

    /*public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }*/
/*
       public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_comment", referencedColumnName = "id_article", insertable = false, updatable = false)

    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    public Article article;*/

}