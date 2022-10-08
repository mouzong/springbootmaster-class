package tech.codegrill.springbootmasterclassamigoscode.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerServiceTest {

    @Autowired
    private CustomerRepository customerRepository;

    private CustomerService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void getCustomers() {

        // Given
        Customer andreas = new Customer(
                1L,
                "Andreas",
                "admin",
                "andreas@codegrill.tech"
        );

        Customer yvan = new Customer(
                2L,
                "Yvan",
                "user",
                "yvan@codegrill.tech"
        );

        Customer junior = new Customer(
                3L,
                "Junior",
                "client",
                "junior@codegrill.tech"
        );

        customerRepository.saveAll(Arrays.asList(andreas, yvan, junior));

        // when
        List<Customer> testCustomers = underTest.getCustomers();

        // Then
        assertEquals(3, testCustomers.size());
    }

    @Test
    void getCustomer() {

        // Given
        Customer andreas = new Customer(
                1L,
                "Andreas",
                "admin",
                "andreas@codegrill.tech"
        );

        customerRepository.save(andreas);

        // When
        Customer testCustomer = underTest.getCustomer(1L);


        // Then
        assertEquals(1L, testCustomer.getId());
        assertEquals("Andreas", testCustomer.getName());
        assertEquals("admin", testCustomer.getPassword());
        assertEquals("andreas@codegrill.tech", testCustomer.getEmail());
    }
}