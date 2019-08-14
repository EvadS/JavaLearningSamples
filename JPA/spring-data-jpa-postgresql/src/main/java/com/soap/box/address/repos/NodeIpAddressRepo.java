package com.soap.box.address.repos;


import com.soap.box.address.entity.NodeAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NodeIpAddressRepo extends JpaRepository<NodeAddress, String> {
    //NodeAddress getByGuid(String guid);

}
