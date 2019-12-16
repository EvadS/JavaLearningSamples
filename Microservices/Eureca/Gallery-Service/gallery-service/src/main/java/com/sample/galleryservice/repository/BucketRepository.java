package com.sample.galleryservice.repository;



import com.sample.galleryservice.model.Bucket;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BucketRepository extends ReactiveMongoRepository<Bucket, String> {
}