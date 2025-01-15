package com.lucas.hexagonal.config;

import com.lucas.hexagonal.adapters.out.DeleteCustomerByIdAdapter;
import com.lucas.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.lucas.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.lucas.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase;
import com.lucas.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.lucas.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {

    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(FindCustomerByIdUseCase findCustomerByIdUseCase,
                                                               DeleteCustomerByIdAdapter deleteCustomerByIdAdapter){
        return new DeleteCustomerByIdUseCase(findCustomerByIdUseCase, deleteCustomerByIdAdapter);
    }
}
