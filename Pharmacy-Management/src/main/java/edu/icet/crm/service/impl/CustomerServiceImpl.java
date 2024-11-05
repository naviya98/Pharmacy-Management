package edu.icet.crm.service.impl;

import edu.icet.crm.dto.Customer;
import edu.icet.crm.entity.CustomerEntity;
import edu.icet.crm.repository.CustomerRepository;
import edu.icet.crm.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    final CustomerRepository repository;
    final ModelMapper mapper;

    @Override
    public List<Customer> getCustomer() {
        List<Customer> customers =new ArrayList<>();
        repository.findAll().forEach(customer->{
            customers.add(mapper.map(customer, Customer.class));;
        });
        return customers;
    }

    @Override
    public void addCustomer(Customer customer) {
        repository.save(mapper.map(customer, CustomerEntity.class));
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Customer> searchByName(String name) {
        List<Customer> customers = new ArrayList<>();
        repository.findByName(name).forEach(entity->{customers.add(mapper.map(entity, Customer.class));});
        return customers;
    }

    @Override
    public List<Customer> searchByNic(String nic) {
        List<Customer> customers = new ArrayList<>();
        repository.findByNic(nic).forEach(entity->{customers.add(mapper.map(entity, Customer.class));});
        return customers;
    }

    @Override
    public List<Customer> searchByContact(String contact) {
        List<Customer> customers = new ArrayList<>();
        repository.findByContact(contact).forEach(entity->{customers.add(mapper.map(entity, Customer.class));});
        return customers;
    }
}
