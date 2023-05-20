package guru.springframework.spring6restmvc.controllers;

import guru.springframework.spring6restmvc.model.CustomerDTO;
import guru.springframework.spring6restmvc.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController()
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PutMapping("{customerId}")

    public ResponseEntity updateCustomerById(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDTO customer) {
        CustomerDTO updatedCustomer = customerService.updateCustomerById(customerId, customer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    @PostMapping
//  @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity handlePost(@RequestBody CustomerDTO customer) {
        CustomerDTO customerSaved = customerService.saveNewCustomer(customer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer" + customerSaved.getId());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<CustomerDTO> listCustomer() {
        return customerService.listCustomers();
    }

    @RequestMapping("{customerId}")
    public CustomerDTO getCustomerById(@PathVariable("customerId") UUID customerId) {
        return customerService.getCustomerById(customerId);
    }
}
