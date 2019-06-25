package by.kostyahubarau.booking.repository;

import by.kostyahubarau.booking.Application;
import by.kostyahubarau.booking.model.Accommodation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class AccommodationRepository extends AbstractRepository {

    public static final AccommodationRepository INSTANCE = new AccommodationRepository(Application.SESSION_FACTORY);

    private AccommodationRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Accommodation> loadAll() {
        return withSession(this::loadAllInternal);
    }

    @SuppressWarnings("unchecked")
    private List<Accommodation> loadAllInternal(Session session) {
        return session.createQuery("SELECT accomodation FROM by.kostyahubarau.booking.model.Accommodation accomodation").list();
    }

}
