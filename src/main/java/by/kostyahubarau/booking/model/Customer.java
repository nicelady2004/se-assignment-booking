package by.kostyahubarau.booking.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
@Data
public class Customer {

    @Id
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    private String address;

    private String town;

    private String county;

    private String country;

    private String phone;

    private String phone2;

    @Column(name = "zipcode")
    private String zipCode;

}
