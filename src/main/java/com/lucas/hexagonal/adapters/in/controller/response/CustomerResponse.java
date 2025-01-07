package com.lucas.hexagonal.adapters.in.controller.response;

import com.lucas.hexagonal.adapters.out.client.response.AddressResponse;
import lombok.Data;

@Data
public class CustomerResponse {

    private String name;

    private AddressResponse address;

    private String cpf;

    private Boolean isValidCpf;

}
