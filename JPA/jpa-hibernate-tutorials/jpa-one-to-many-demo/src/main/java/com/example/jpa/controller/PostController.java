package com.example.jpa.controller;

import com.example.jpa.exception.ResourceNotFoundException;
import com.example.jpa.model.NodeAddress;
import com.example.jpa.repository.NodeAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PostController {

    @Autowired
    private NodeAddressRepository nodeAddressRepository;

    @GetMapping("/posts")
    public Page<NodeAddress> getAllPosts(Pageable pageable) {
        return nodeAddressRepository.findAll(pageable);
    }

    @PostMapping("/posts")
    public NodeAddress createPost(@Valid @RequestBody NodeAddress nodeAddress) {
        return nodeAddressRepository.save(nodeAddress);
    }

    @PutMapping("/posts/{postId}")
    public NodeAddress updatePost(@PathVariable Long postId, @Valid @RequestBody NodeAddress nodeAddressRequest) {
        return nodeAddressRepository.findById(postId).map(nodeAddress -> {
            nodeAddress.setTitle(nodeAddressRequest.getTitle());
            nodeAddress.setDescription(nodeAddressRequest.getDescription());
            nodeAddress.setContent(nodeAddressRequest.getContent());
            return nodeAddressRepository.save(nodeAddress);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }


    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Long postId) {
        return nodeAddressRepository.findById(postId).map(nodeAddress -> {
            nodeAddressRepository.delete(nodeAddress);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }

}
