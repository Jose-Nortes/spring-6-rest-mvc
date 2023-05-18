package guru.springframework.spring6restmvc.controllers;

import guru.springframework.spring6restmvc.model.Customer;
import guru.springframework.spring6restmvc.services.CustomerService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @RequestMapping
    public List<Customer> listCustomer() {
        return customerService.listCustomers();
    }

    @RequestMapping("{customerId}")
    public Customer getCustomerById(@PathParam("customerId") UUID customerId) {
        return customerService.getCustomerById(customerId);
    }
}
