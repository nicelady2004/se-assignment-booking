package by.kostyahubarau.booking.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "accommodations")
@Data
public class Accommodation {

    @Id
    private Long id;

    @Column(name = "housing_category")
    private String housingCategory;

    private String address;

    private String town;

    private String county;

    private String country;

    private String phone;

    private String manager;

    private String manager2;

    @Column(name = "zipcode")
    private String zipCode;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "accommodation_id")
    private Set<Room> rooms;

}
