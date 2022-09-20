package tech.codegrill.springbootmasterclassamigoscode.customer;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "all")
    public List<Customer> getCustomers(){

        return customerService.getCustomers();
    }

    @GetMapping(path = "{customerId}")
    public Customer getCustomer(@PathVariable("customerId") Long id){

        return customerService.getCustomer(id);

    }

    @PostMapping
    void createNewCustomer(@Valid @RequestBody Customer customer){
        System.out.println("POST REQUEST ....");
        System.out.println(customer);
    }

    @PutMapping
    void updateCustomer(@RequestBody Customer customer){
        System.out.println("PUT REQUEST ....");
        System.out.println(customer);
    }
    @DeleteMapping(path = "{customerId}")
    void deleteCustomer(@PathVariable("customerId") Long id){
        System.out.println("DELETE REQUEST for Customer with ID = "+ id);
    }
}
