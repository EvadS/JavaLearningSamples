package com.sample.jpa.repository.bidirectional;


import com.sample.jpa.bidirectional.model.Post2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository2 extends JpaRepository<Post2, Long> {

}