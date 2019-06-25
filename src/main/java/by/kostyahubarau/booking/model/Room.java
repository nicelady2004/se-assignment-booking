package by.kostyahubarau.booking.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "rooms")
@Data
public class Room {

    @Id
    @Column(name = "room_id")
    private Long id;

    @Column(name = "room_type")
    private String roomType;

    private BigDecimal price;

}
