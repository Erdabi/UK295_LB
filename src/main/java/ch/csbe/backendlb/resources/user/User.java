package ch.csbe.backendlb.resources.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Represents a user in the application.
 */
@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * The username of the user.
     */
    @Column(columnDefinition = "varchar(255)")
    private String username;

    /**
     * The password of the user.
     */
    @Column(columnDefinition = "varchar(255)")
    private String password;

    /**
     * The first name of the user.
     */
    @Column(columnDefinition = "varchar(255)")
    private String firstname;

    /**
     * The last name of the user.
     */
    @Column(columnDefinition = "varchar(255)")
    private String lastname;

    /**
     * The email address of the user.
     */
    @Column(columnDefinition = "varchar(255)")
    private String email;

    /**
     * The birthday of the user.
     */
    @Column(columnDefinition = "DATE")
    private Date birthday;

    /**
     * The street name of the user.
     */
    @Column(columnDefinition = "varchar(255)")
    private String streetName;

    /**
     * The street number of the user.
     */
    @Column(columnDefinition = "varchar(255)")
    private String streetNr;

    /**
     * The ZIP code of the user's location.
     */
    @Column(columnDefinition = "varchar(10)")
    private String zipCode;

    /**
     * The city where the user is located.
     */
    @Column(columnDefinition = "varchar(255)")
    private String city;

    /**
     * Gets the unique identification number of the user.
     *
     * @return The unique identification number.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identification number of the user.
     *
     * @param id The unique identification number.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the username of the user.
     *
     * @return The username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     *
     * @param username The username.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password of the user.
     *
     * @return The password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password The password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the first name of the user.
     *
     * @return The first name.
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets the first name of the user.
     *
     * @param firstname The first name.
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Gets the last name of the user.
     *
     * @return The last name.
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets the last name of the user.
     *
     * @param lastname The last name.
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Gets the email address of the user.
     *
     * @return The email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the user.
     *
     * @param email The email address.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the birthday of the user.
     *
     * @return The birthday.
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * Sets the birthday of the user.
     *
     * @param birthday The birthday.
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * Gets the street name of the user.
     *
     * @return The street name.
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Sets the street name of the user.
     *
     * @param streetName The street name.
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     * Gets the street number of the user.
     *
     * @return The street number.
     */
    public String getStreetNr() {
        return streetNr;
    }

    /**
     * Sets the street number of the user.
     *
     * @param streetNr The street number.
     */
    public void setStreetNr(String streetNr) {
        this.streetNr = streetNr;
    }

    /**
     * Gets the ZIP code of the user's location.
     *
     * @return The ZIP code.
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Sets the ZIP code of the user's location.
     *
     * @param zipCode The ZIP code.
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Gets the city where the user is located.
     *
     * @return The city name.
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city where the user is located.
     *
     * @param city The city name.
     */
    public void setCity(String city) {
        this.city = city;
    }
}
