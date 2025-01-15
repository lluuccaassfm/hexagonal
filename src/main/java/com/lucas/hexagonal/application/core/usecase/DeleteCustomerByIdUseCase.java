package com.lucas.hexagonal.application.core.usecase;

import com.lucas.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.lucas.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;

public class DeleteCustomerByIdUseCase implements DeleteCustomerByIdOutputPort{

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    private final DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort;

    public DeleteCustomerByIdUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort,
                                     DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.deleteCustomerByIdOutputPort = deleteCustomerByIdOutputPort;
    }

    @Override
    public void delete(String id) {
        findCustomerByIdInputPort.find(id);
        deleteCustomerByIdOutputPort.delete(id);
    }

}
