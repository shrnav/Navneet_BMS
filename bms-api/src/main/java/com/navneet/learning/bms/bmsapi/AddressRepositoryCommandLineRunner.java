package com.navneet.learning.bms.bmsapi;

import com.navneet.learning.bms.bmsapi.entity.Address;
import com.navneet.learning.bms.bmsapi.service.AddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Slf4j
@Component
public class AddressRepositoryCommandLineRunner implements CommandLineRunner {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public void run(String... arg0) throws Exception {
        Address address = new Address("N-801, Gr Noida");
        addressRepository.save(address);
        log.info("New address is created : " + address);

        Optional<Address> userWithIdOne = addressRepository.findById(1L);
        log.info("Address is retrived : " + userWithIdOne);

    }
}
