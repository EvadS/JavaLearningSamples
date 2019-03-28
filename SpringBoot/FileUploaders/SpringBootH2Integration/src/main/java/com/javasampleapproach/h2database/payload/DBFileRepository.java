package com.javasampleapproach.h2database.payload;


import com.javasampleapproach.h2database.model.DBFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DBFileRepository extends JpaRepository<DBFile, String> {

    DBFile findById(String fileId);
}