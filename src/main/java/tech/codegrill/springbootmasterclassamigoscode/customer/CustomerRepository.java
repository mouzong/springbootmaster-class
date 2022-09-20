package tech.codegrill.springbootmasterclassamigoscode.customer;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class CustomerRepository implements CustomerRepo{
    // TODO Connect to DB later
    @Override
    public List<Customer> getCustomers() {
        return Collections.singletonList(
                new Customer(1L, "TODO add a customer here over", "testPassword", "personal@email.com")
        );
    }
}
