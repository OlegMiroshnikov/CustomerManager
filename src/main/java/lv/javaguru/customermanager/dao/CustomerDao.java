package lv.javaguru.customermanager.dao;

import lv.javaguru.customermanager.model.Customer;

import java.util.List;

public interface CustomerDao {
    public void addCustomer(Customer customer);

    public void updateCustomer(Customer customer);

    public void removeCustomer(int id);

    public Customer getCustomerById(int id);

    public List<Customer> listCustomers();
}
