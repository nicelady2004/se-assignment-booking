package by.kostyahubarau.booking;

import by.kostyahubarau.booking.model.Accommodation;
import by.kostyahubarau.booking.model.Room;
import by.kostyahubarau.booking.repository.AccommodationRepository;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;

public class Application extends javafx.application.Application {

    public static final SessionFactory SESSION_FACTORY = new Configuration().configure().buildSessionFactory();

    @SuppressWarnings("unchecked")
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/main.fxml"));

        TableView<Accommodation> accommodations = (TableView<Accommodation>) root.lookup("#accommodations");
        accommodations.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("housingCategory"));
        accommodations.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("address"));
        accommodations.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("town"));
        accommodations.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("county"));
        accommodations.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("country"));
        accommodations.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("phone"));
        accommodations.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("manager"));
        accommodations.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("zipCode"));

        TableView<Room> rooms = (TableView<Room>) root.lookup("#rooms");
        rooms.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("roomType"));
        rooms.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("price"));

        accommodations.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue != null) {
                rooms.getItems().clear();
                rooms.getItems().addAll(newValue.getRooms());
            }
        });

        accommodations.getItems().addAll(AccommodationRepository.INSTANCE.loadAll());

        Scene scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        SESSION_FACTORY.close();
    }

    public static void main(String[] args) {
        launch();
    }

}
