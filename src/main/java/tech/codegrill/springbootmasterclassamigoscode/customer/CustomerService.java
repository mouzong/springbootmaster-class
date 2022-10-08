package tech.codegrill.springbootmasterclassamigoscode.customer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tech.codegrill.springbootmasterclassamigoscode.exception.NotFoundException;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;



    public List<Customer> getCustomers() {
        log.info("Running the Service getCustomers Method");
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long id) {
        log.info("Getting the customers from the Service getCustomer() methode");
        return customerRepository.findById(id)
                .orElseThrow(() -> {
                    NotFoundException notFoundException = new NotFoundException("Customer with ID " + id + " not found");
                    log.error(" Error in getting Customer {}", id, notFoundException);
                    return notFoundException;
                });
    }
}
