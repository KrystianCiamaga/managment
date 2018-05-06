package pl.sdacademy.hibernate.management.model;


import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;

@Entity
@Table(name="student_db")
public class Student {

    //TODO: 3 Zaimplementować Encję Student(id, firstName, lastName, section, pesel), dodać odpowiednie adnotacje

    // TODO: 3a Zaimplementować service wraz z następującymi metodami:
    // findById, findAll, findById, findByPESEL, create, update, delete, findAllByAddressCountry, findAllByUniversityName

    // TODO: 3b Stworzyć test sprawdzający powyższe metody

    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    @Column(name="student_id")
    private int id;

    private String firstName;
    private String lastName;
    private String section;


    @OneToOne
    @JoinColumn(name = "home_address_id")
    private Address address;

    @Column(nullable = false,unique = true)
    private String pesel;


    public Student(String firstName, String lastName, String section, String pesel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.section = section;
        this.pesel = pesel;
    }

    public Student(String firstName, String lastName, String section, Address address, String pesel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.section = section;
        this.address = address;
        this.pesel = pesel;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", section='" + section + '\'' +
                ", pesel='" + pesel + '\'' +
                '}';
    }


}
