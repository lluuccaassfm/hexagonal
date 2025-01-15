package com.lucas.hexagonal.adapters.out;

import com.lucas.hexagonal.adapters.out.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdAdapter {

    @Autowired
    private CustomerRepository customerRepository;

    void delete(String id) {
        customerRepository.deleteById(id);
    }

}
