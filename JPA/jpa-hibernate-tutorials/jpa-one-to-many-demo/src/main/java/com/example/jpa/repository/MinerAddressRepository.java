package com.example.jpa.repository;

import com.example.jpa.model.MinerAddress;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by rajeevkumarsingh on 21/11/17.
 */
@Repository
public interface MinerAddressRepository extends JpaRepository<MinerAddress, Long> {
    Page<MinerAddress> findByNodeAddress(Long postId, Pageable pageable);
    Optional<MinerAddress> findByIdAndNodeAddress (Long id, Long postId);
}
