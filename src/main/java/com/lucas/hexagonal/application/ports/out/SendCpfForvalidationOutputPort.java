package com.lucas.hexagonal.application.ports.out;

public interface SendCpfForvalidationOutputPort {

    void send(String cpf);

}
