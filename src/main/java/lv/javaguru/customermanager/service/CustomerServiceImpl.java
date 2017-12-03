package lv.javaguru.customermanager.service;

import lv.javaguru.customermanager.dao.CustomerDao;
import lv.javaguru.customermanager.model.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    @Transactional
    public void addCustomer(Customer customer) {
        this.customerDao.addCustomer(customer);
    }

    @Override
    @Transactional
    public void updateCustomer(Customer customer) {
        this.customerDao.updateCustomer(customer);
    }

    @Override
    @Transactional
    public void removeCustomer(int id) {
        this.customerDao.removeCustomer(id);
    }

    @Override
    @Transactional
    public Customer getCustomerById(int id) {
        return this.customerDao.getCustomerById(id);
    }

    @Override
    @Transactional
    public List<Customer> listCustomers() {
        return this.customerDao.listCustomers();
    }
}
