package tech.codegrill.springbootmasterclassamigoscode.customer;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tech.codegrill.springbootmasterclassamigoscode.exception.NotFoundException;

import java.util.List;
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepo) {

        this.customerRepository = customerRepo;
    }
    public List<Customer> getCustomers() {

        return customerRepository.findAll();
    }
     public Customer getCustomer(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer with ID "+ id +" not found"));
     }
}
