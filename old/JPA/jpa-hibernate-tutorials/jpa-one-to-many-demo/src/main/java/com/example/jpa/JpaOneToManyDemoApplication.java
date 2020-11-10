package com.example.jpa;

import com.example.jpa.model.MinerAddress;
import com.example.jpa.repository.MinerAddressRepository;
import com.example.jpa.repository.NodeAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JpaOneToManyDemoApplication implements CommandLineRunner {

	@Autowired
	private MinerAddressRepository minerAddressRepository;

	@Autowired
	private NodeAddressRepository nodeAddressRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaOneToManyDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		MinerAddress minerAddress1 = new MinerAddress();
		minerAddress1.setVrs("vrs");
		minerAddress1.setAddress("address");

		minerAddressRepository.save(minerAddress1);

	}
}
