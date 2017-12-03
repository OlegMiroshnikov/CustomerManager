package lv.javaguru.customermanager.dao;

import lv.javaguru.customermanager.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {
    private static final Logger logger = LoggerFactory.getLogger(CustomerDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addCustomer(Customer customer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(customer);
        logger.info("Customer successfully saved. Customer details: " + customer);
    }

    @Override
    public void  updateCustomer(Customer customer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(customer);
        logger.info("Customer successfully update. Customer details: " + customer);
    }

    @Override
    public void removeCustomer(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Customer customer = (Customer) session.load(Customer.class, new Integer(id));
        if(customer !=null){
            session.delete(customer);
        }
        logger.info("Customer successfully removed. Customer details: " + customer);
    }

    @Override
    public Customer getCustomerById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Customer customer = (Customer) session.load(Customer.class, new Integer(id));
        logger.info("Customer successfully loaded. Customer details: " + customer);
        return customer;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Customer> listCustomers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Customer> customerList = session.createQuery("from Customer").list();
        for(Customer customer : customerList){
            logger.info("Customer list: " + customer);
        }
        return customerList;
    }
}
