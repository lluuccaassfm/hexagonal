package com.lucas.hexagonal.adapters.in.controller;

import com.lucas.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.lucas.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.lucas.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.lucas.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.lucas.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.lucas.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.lucas.hexagonal.application.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class InsertCustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {
        var customer = customerMapper.toCustomerResponse(findCustomerByIdInputPort.find(id));
        return ResponseEntity.ok(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable final String id, @Valid @RequestBody CustomerRequest customerRequest) {
        var customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerInputPort.update(customer, customerRequest.getZipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> delete(@PathVariable final String id) {
        deleteCustomerByIdInputPort.deletCustomerById(id);
        return ResponseEntity.noContent().build();
    }
}
