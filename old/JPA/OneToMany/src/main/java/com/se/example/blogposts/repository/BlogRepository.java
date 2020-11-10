package com.se.example.blogposts.repository;


import com.se.example.blogposts.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<com.se.example.blogposts.entity.Blog, Integer> {

    List<Blog> findByTitleContainingOrContentContaining(String text, String textAgain);

}