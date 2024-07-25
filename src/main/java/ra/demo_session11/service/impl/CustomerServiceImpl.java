package ra.demo_session11.service.impl;

import ra.demo_session11.model.Customer;
import ra.demo_session11.repository.impl.CustomerRepositoryImpl;
import ra.demo_session11.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public List<Customer> findAll() {
        return new CustomerRepositoryImpl().findAll();
    }

    @Override
    public Customer findById(Integer cusId) {
        return new CustomerRepositoryImpl().findById(cusId);
    }

    @Override
    public boolean save(Customer cus) {
        return new CustomerRepositoryImpl().save(cus);
    }

    @Override
    public boolean update(Customer cus) {
        return new CustomerRepositoryImpl().update(cus);
    }

    @Override
    public boolean delete(Integer cusId) {
        return new CustomerRepositoryImpl().delete(cusId);
    }

    @Override
    public List<Customer> findByName(String name) {
        return new CustomerRepositoryImpl().findByName(name);
    }
}
