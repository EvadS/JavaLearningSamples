package com.soap.box.address.repos;

import com.soap.box.address.entity.MinerAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MinerAddressRepo extends JpaRepository<MinerAddress, Integer> {

    List<MinerAddress> findByAddress(String minerAddress);
}
