package com.lucas.hexagonal.adapters.in.consumer.message;

import com.lucas.hexagonal.adapters.out.client.response.AddressResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerMessage {

    private String id;

    private String name;

    private AddressResponse address;

    private String cpf;

    private Boolean isValidCpf;

    private String zipCode;

}
