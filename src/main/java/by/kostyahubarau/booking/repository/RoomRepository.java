package by.kostyahubarau.booking.repository;

import by.kostyahubarau.booking.Application;
import by.kostyahubarau.booking.model.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class RoomRepository extends AbstractRepository {

    public static final RoomRepository INSTANCE = new RoomRepository(Application.SESSION_FACTORY);

    private RoomRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Room> loadAll() {
        return withSession(this::loadAllInternal);
    }

    @SuppressWarnings("unchecked")
    private List<Room> loadAllInternal(Session session) {
        return session.createQuery("SELECT room FROM by.kostyahubarau.booking.model.Room room").list();
    }

}
