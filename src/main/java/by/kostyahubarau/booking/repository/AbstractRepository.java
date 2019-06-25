package by.kostyahubarau.booking.repository;

import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.function.Function;

@AllArgsConstructor
abstract class AbstractRepository {

    private final SessionFactory sessionFactory;

    <R> R withSession(Function<Session, R> closure) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        R result = closure.apply(session);
        session.getTransaction().commit();
        session.close();
        return result;
    }

}
