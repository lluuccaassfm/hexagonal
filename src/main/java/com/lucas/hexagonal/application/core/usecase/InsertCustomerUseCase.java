package com.lucas.hexagonal.application.core.usecase;

import com.lucas.hexagonal.application.core.domain.Customer;
import com.lucas.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.lucas.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.lucas.hexagonal.application.ports.out.InsertCustomerOutputPort;
import com.lucas.hexagonal.application.ports.out.SendCpfForvalidationOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final InsertCustomerOutputPort insertCustomerOutputPort;

    private final SendCpfForvalidationOutputPort sendCpfForvalidationOutputPort;

    public InsertCustomerUseCase(
            FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
            InsertCustomerOutputPort insertCustomerOutputPort,
            SendCpfForvalidationOutputPort sendCpfForvalidationOutputPort
    ) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.sendCpfForvalidationOutputPort = sendCpfForvalidationOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
    }
}
