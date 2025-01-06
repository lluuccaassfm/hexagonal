package com.lucas.hexagonal.application.core.usecase;

import com.lucas.hexagonal.application.core.domain.Customer;
import com.lucas.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.lucas.hexagonal.application.ports.out.FindAddressByZipCodeOutpuPort;
import com.lucas.hexagonal.application.ports.out.InsertCustomerOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutpuPort findAddressByZipCodeOutpuPort;

    private final InsertCustomerOutputPort insertCustomerOutputPort;

    public InsertCustomerUseCase(
            FindAddressByZipCodeOutpuPort findAddressByZipCodeOutpuPort,
            InsertCustomerOutputPort insertCustomerOutputPort
    ) {
        this.findAddressByZipCodeOutpuPort = findAddressByZipCodeOutpuPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        var address = findAddressByZipCodeOutpuPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
    }
}
