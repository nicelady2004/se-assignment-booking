package by.kostyahubarau.booking.repository;

import by.kostyahubarau.booking.Application;
import by.kostyahubarau.booking.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CustomerRepository extends AbstractRepository {

    public static final CustomerRepository INSTANCE = new CustomerRepository(Application.SESSION_FACTORY);

    private CustomerRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Customer> loadAll() {
        return withSession(this::loadAllInternal);
    }

    @SuppressWarnings("unchecked")
    private List<Customer> loadAllInternal(Session session) {
        return session.createQuery("SELECT customer FROM by.kostyahubarau.booking.model.Customer customer").list();
    }

}
