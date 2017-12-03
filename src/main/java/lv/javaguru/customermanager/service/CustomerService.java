package lv.javaguru.customermanager.service;

import lv.javaguru.customermanager.model.Customer;

import java.util.List;

public interface CustomerService {
    public void addCustomer(Customer customer);

    public void updateCustomer(Customer customer);

    public void removeCustomer(int id);

    public Customer getCustomerById(int id);

    public List<Customer> listCustomers();
}
