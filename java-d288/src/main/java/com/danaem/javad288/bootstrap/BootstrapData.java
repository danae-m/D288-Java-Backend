package com.danaem.javad288.bootstrap;

import com.danaem.javad288.dao.CustomerRepository;
import com.danaem.javad288.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

  private final CustomerRepository customerRepository ;

  public BootstrapData(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository ;
  }

  @Override
  public void run(String... args) throws Exception {

    Customer customer1 = new Customer("Adam", "Baker", "123 Street Avenue", "1234567890", "12345", 6L);
    customerRepository.save(customer1) ;

    Customer customer2 = new Customer("Corina", "Debbs", "456 Avenue Road", "2345678901", "23456", 11L);
    customerRepository.save(customer2) ;

    Customer customer3 = new Customer("Eleanor", "Ferrara", "789 Road Lane", "3456789012", "34512", 16L);
    customerRepository.save(customer3) ;

    Customer customer4 = new Customer("Gary", "Heidecker", "135 Lane Parkway", "4567890123", "45123", 21L);
    customerRepository.save(customer4) ;

    Customer customer5 = new Customer("Ian", "Justice", "246 Parkway Street", "5678901234", "51234", 26L);
    customerRepository.save(customer5) ;

  }
}
