package com.lucas.hexagonal.adapters.out;

import com.lucas.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.lucas.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.lucas.hexagonal.application.core.domain.Address;
import com.lucas.hexagonal.application.ports.out.FindAddressByZipCodeOutpuPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutpuPort {

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
        var addressResponse = findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }
}
