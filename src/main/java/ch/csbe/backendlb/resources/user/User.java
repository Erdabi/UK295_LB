package ch.csbe.backendlb.resources.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(columnDefinition="varchar(255)")
    private String username;
    @Column(columnDefinition="varchar(255)")
    private String password;
    @Column(columnDefinition="varchar(255)")
    private String firstname;
    @Column(columnDefinition="varchar(255)")
    private String lastname;
    @Column(columnDefinition="varchar(255)")
    private String email;
    @Column(columnDefinition="DATE")
    private Date birthday;
    @Column(columnDefinition="varchar(255)")
    private String streetName;
    @Column(columnDefinition="varchar(255)")
    private String streetNr;
    @Column(columnDefinition="varchar(10)")
    private String zipCode;
    @Column(columnDefinition="varchar(255)")
    private String city;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getfirstname() {
        return firstname;
    }

    public void setfirstname(String surname) {
        this.firstname = surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNr() {
        return streetNr;
    }

    public void setStreetNr(String streetNr) {
        this.streetNr = streetNr;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
