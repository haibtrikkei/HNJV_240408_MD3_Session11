package ra.demo_session11.repository.impl;

import ra.demo_session11.model.Customer;
import ra.demo_session11.model.CustomerData;
import ra.demo_session11.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public List<Customer> findAll() {
        return CustomerData.listCus;
    }

    @Override
    public Customer findById(Integer cusId) {
        for(Customer c : CustomerData.listCus){
            if(c.getId()==cusId)
                return c;
        }
        return null;
    }

    @Override
    public boolean save(Customer cus) {
        return CustomerData.listCus.add(cus);
    }

    @Override
    public boolean update(Customer cus) {
        for(Customer c : CustomerData.listCus){
            if(c.getId()==cus.getId())
                c.setFullName(cus.getFullName());
                c.setAddress(cus.getAddress());
                c.setBirthday(cus.getBirthday());
                c.setEmail(cus.getEmail());
                c.setGender(cus.getGender());
                c.setPhone(cus.getPhone());
                c.setStatus(cus.getStatus());
                return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer cusId) {
        return CustomerData.listCus.remove(findById(cusId));
    }

    @Override
    public List<Customer> findByName(String name) {
        List<Customer> listResult = new ArrayList<>();

        for(Customer c : CustomerData.listCus){
            if(c.getFullName().toLowerCase().contains(name.toLowerCase())){
                listResult.add(c);
            }
        }
        return listResult;
    }
}
