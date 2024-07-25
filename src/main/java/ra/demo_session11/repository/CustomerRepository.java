package ra.demo_session11.repository;

import ra.demo_session11.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();
    Customer findById(Integer cusId);
    boolean save(Customer cus);
    boolean update(Customer cus);
    boolean delete(Integer cusId);
    List<Customer> findByName(String name);
}
