package tech.codegrill.springbootmasterclassamigoscode.customer;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tech.codegrill.springbootmasterclassamigoscode.exception.ApiRequestException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v2/customers")
@AllArgsConstructor
public class CustomerControllerV2 {
    private final CustomerService customerService;

    @GetMapping(path = "all")
    public List<Customer> getCustomers() {

        return customerService.getCustomers();
    }

    @GetMapping(path = "{customerId}")
    public Customer getCustomer(@PathVariable("customerId") Long id) {
        return customerService.getCustomer(id);
    }

    /**
     * Get customer Exception using the controller advice
     *
     * @param id
     * @return
     */
    @GetMapping(path = "{customerId}/exception")
    public Customer getCustomerException(@PathVariable("customerId") Long id) {
        throw new ApiRequestException(
                "ApiRequestException for Customer " + id
        );
    }

    @PostMapping
    void createNewCustomer(@Valid @RequestBody Customer customer) {
        System.out.println("POST REQUEST ....");
        System.out.println(customer);
    }

    @PutMapping
    void updateCustomer(@RequestBody Customer customer) {
        System.out.println("PUT REQUEST ....");
        System.out.println(customer);
    }

    @DeleteMapping(path = "{customerId}")
    void deleteCustomer(@PathVariable("customerId") Long id) {
        System.out.println("DELETE REQUEST for Customer with ID = " + id);
    }
}
