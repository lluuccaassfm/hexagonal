package com.lucas.hexagonal.application.ports.out;

import com.lucas.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutpuPort {

    Address find(String zipCode);

}
