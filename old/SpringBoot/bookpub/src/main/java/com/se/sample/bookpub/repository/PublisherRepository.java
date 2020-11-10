package com.se.sample.bookpub.repository;


import com.se.sample.bookpub.entity.Publisher;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource
@RepositoryRestResource(collectionResourceRel = "writers", path = "writers")
public interface PublisherRepository extends PagingAndSortingRepository<Publisher, Long> {
}