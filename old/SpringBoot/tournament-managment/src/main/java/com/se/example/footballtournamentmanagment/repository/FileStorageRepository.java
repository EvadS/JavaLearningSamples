package com.se.example.footballtournamentmanagment.repository;

import com.se.example.footballtournamentmanagment.entity.FileStorage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FileStorageRepository extends PagingAndSortingRepository<FileStorage, String> {

}
