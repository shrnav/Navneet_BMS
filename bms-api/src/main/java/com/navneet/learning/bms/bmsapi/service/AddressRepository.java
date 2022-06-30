package com.navneet.learning.bms.bmsapi.service;

import com.navneet.learning.bms.bmsapi.entity.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
