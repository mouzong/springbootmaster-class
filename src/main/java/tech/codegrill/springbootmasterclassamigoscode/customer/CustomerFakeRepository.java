package tech.codegrill.springbootmasterclassamigoscode.customer;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component(value = "fake")
public class CustomerFakeRepository implements CustomerRepo{
    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L, "Andreas Fefe", "password", "email@email.com"),
                new Customer(2L, "Yvan TIENTCHEU", "password", "email@email.com"),
                new Customer(3L, "Junior EMVANA", "password", "email@email.com")
        );
    }
}
