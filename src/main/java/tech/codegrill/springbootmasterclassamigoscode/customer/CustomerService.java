package tech.codegrill.springbootmasterclassamigoscode.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tech.codegrill.springbootmasterclassamigoscode.exception.NotFoundException;

import java.util.List;

@Service
public class CustomerService {

    private final static Logger logger = LoggerFactory.getLogger(CustomerService.class);
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepo) {

        this.customerRepository = customerRepo;
    }

    public List<Customer> getCustomers() {
        logger.info("Running the Service getCustomers Method");
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long id) {
        logger.info("Getting the customers from the Service getCustomer() methode");
        return customerRepository.findById(id)
                .orElseThrow(() -> {
                    NotFoundException notFoundException = new NotFoundException("Customer with ID " + id + " not found");
                    logger.error(" Error in getting Customer {}", id, notFoundException);
                    return notFoundException;
                });
    }
}
