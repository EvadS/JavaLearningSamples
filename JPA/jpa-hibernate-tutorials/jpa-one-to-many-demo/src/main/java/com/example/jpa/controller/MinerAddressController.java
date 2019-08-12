package com.example.jpa.controller;

import com.example.jpa.exception.ResourceNotFoundException;
import com.example.jpa.model.MinerAddress;
import com.example.jpa.repository.MinerAddressRepository;
import com.example.jpa.repository.NodeAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class MinerAddressController {

    @Autowired
    private MinerAddressRepository commentRepository;

    @Autowired
    private NodeAddressRepository nodeAddressRepository;

    @GetMapping("/posts/{postId}/comments")
    public Page<MinerAddress> getAllCommentsByPostId(@PathVariable (value = "postId") Long postId,
                                                     Pageable pageable) {
        return commentRepository.findByNodeAddress(postId, pageable);
    }

    @PostMapping("/posts/{postId}/comments")
    public MinerAddress createComment(@PathVariable (value = "postId") Long postId,
                                      @Valid @RequestBody MinerAddress minerAddress) {
        return nodeAddressRepository.findById(postId).map(post -> {
            minerAddress.setNodeAddress(post);
            return commentRepository.save(minerAddress);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }

    @PutMapping("/posts/{postId}/comments/{commentId}")
    public MinerAddress updateComment(@PathVariable (value = "postId") Long postId,
                                      @PathVariable (value = "commentId") Long commentId,
                                      @Valid @RequestBody MinerAddress minerAddressRequest) {
        if(!nodeAddressRepository.existsById(postId)) {
            throw new ResourceNotFoundException("PostId " + postId + " not found");
        }

        return commentRepository.findById(commentId).map(minerAddress -> {
            minerAddress.setVrs(minerAddressRequest.getVrs());
            return commentRepository.save(minerAddress);
        }).orElseThrow(() -> new ResourceNotFoundException("CommentId " + commentId + "not found"));
    }

    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable (value = "postId") Long postId,
                              @PathVariable (value = "commentId") Long commentId) {
        return commentRepository.findByIdAndNodeAddress(commentId, postId).map(minerAddress -> {
            commentRepository.delete(minerAddress);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("MinerAddress not found with id " + commentId + " and postId " + postId));
    }
}
