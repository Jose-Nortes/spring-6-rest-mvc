package guru.springframework.spring6restmvc.services;


import guru.springframework.spring6restmvc.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    List<Customer> listCustomers();

    Customer getCustomerById(UUID id);

    Customer saveNewCustomer(Customer customer);

    Customer updateCustomerById(UUID customerId, Customer customer);

    void deleteCustomerById(UUID customerId);

    void updateCustomerPatchById(UUID customerId, Customer customer);
}
