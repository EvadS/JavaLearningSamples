package com.sample.jpa;

import com.sample.jpa.bidirectional.model.Comment2;
import com.sample.jpa.bidirectional.model.Post2;
import com.sample.jpa.model.Comment;
import com.sample.jpa.model.Post;
import com.sample.jpa.repository.PostRepository;
import com.sample.jpa.repository.bidirectional.PostRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Set;

@SpringBootApplication
@EnableJpaAuditing
public class RelationApplication implements CommandLineRunner {

    @Autowired
    private PostRepository2 postRepository;

    public static void main(String[] args) {
        SpringApplication.run(RelationApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        // Create a Post
//        Post2 post = new Post2("post title_" + System.currentTimeMillis(), "post description", "post content");
//        postRepository.save(post);
//
//// Create Comments
//        Comment2 comment1 = new Comment2("Great Post!");
//        comment1.setPost(post);
//        Comment2 comment2 = new Comment2("Really helpful Post. Thanks a lot!");
//        comment2.setPost(post);
//
//// Add comments in the Post
//        post.getComments().add(comment1);
//        post.getComments().add(comment2);
//
//// Save Post and Comments via the Post entity
//        postRepository.save(post);
//
//
//        // Retrieve Post
//        Post2 postres = postRepository.findById(post.getId()).get();
//
//// Get all the comments
//        Set<Comment2> comments = post.getComments();
//
//        comments.forEach(item -> System.out.println(item));

        System.out.println("-------------------");

    }
}