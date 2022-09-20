package tech.codegrill.springbootmasterclassamigoscode.customer;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerService {
    private final CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }
    public List<Customer> getCustomers() {

        return customerRepo.getCustomers();
    }
     public Customer getCustomer(Long id) {
        return customerRepo.getCustomers()
                .stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Customer with ID "+ id +" not found"));
     }
}
