package pl.sdacademy.hibernate.management.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity

public class Address {

    // TODO: 4 Zaimplementować Encję Address(id, street, city, country), oddaj odpowiednie adnotacje oraz relację 1:1 z encją Student

    // TODO: 4a Zaimplementować service wraz z następującymi metodami:
    // findById, create, update, delete

    // TODO: 4b Stworzyć test sprawdzający powyższe metody

    @Id
    @GeneratedValue
    private int id;


    private String street;
    private String city;
    private String country;



    public Address() {
    }

    public Address(String street, String city, String country, Student student) {
        this.street = street;
        this.city = city;
        this.country = country;
    }

    public Address(String street, String city, String country) {
        this.street = street;
        this.city = city;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }



    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + ", student=" +
                '}';
    }
}