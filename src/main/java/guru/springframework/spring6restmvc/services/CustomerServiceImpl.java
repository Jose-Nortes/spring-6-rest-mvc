package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.CustomerDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final Map<UUID, CustomerDTO> customerMap;

    public CustomerServiceImpl() {
        this.customerMap = new HashMap<>();

        CustomerDTO customer1 = CustomerDTO.builder()
                .id(UUID.randomUUID())
                .customerName("Francis O'Donell")
                .version("12434")
                .created(LocalDateTime.now())
                .lastModified(LocalDateTime.now())
                .build();

        CustomerDTO customer2 = CustomerDTO.builder()
                .id(UUID.randomUUID())
                .customerName("Daniel Bloom")
                .version("12423")
                .created(LocalDateTime.now())
                .lastModified(LocalDateTime.now())
                .build();

        CustomerDTO customer3 = CustomerDTO.builder()
                .id(UUID.randomUUID())
                .customerName("Cyntia Barns")
                .version("42123")
                .created(LocalDateTime.now())
                .lastModified(LocalDateTime.now())
                .build();

        customerMap.put(customer1.getId(), customer1);
        customerMap.put(customer2.getId(), customer2);
        customerMap.put(customer3.getId(), customer3);

    }

    @Override
    public List<CustomerDTO> listCustomers() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public CustomerDTO getCustomerById(UUID id) {
        return customerMap.get(id);
    }

    @Override
    public CustomerDTO saveNewCustomer(CustomerDTO customer) {

        CustomerDTO customerSaved = CustomerDTO.builder()
                .id(UUID.randomUUID())
                .customerName(customer.getCustomerName())
                .version(customer.getVersion())
                .created(LocalDateTime.now())
                .lastModified(LocalDateTime.now())
                .build();

        customerMap.put(customerSaved.getId(), customerSaved);

        return customerSaved;
    }

    @Override
    public CustomerDTO updateCustomerById(UUID customerId, CustomerDTO customer) {
        CustomerDTO customerUpdated = customerMap.get(customerId);
        customerUpdated.setCustomerName(customer.getCustomerName());
        customerUpdated.setVersion(customer.getVersion());
        customerUpdated.setLastModified(LocalDateTime.now());

        return null;
    }
}
