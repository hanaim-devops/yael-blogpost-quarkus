package org.acme.rest.json;

public class Customer {
    public String customerId;
    public String name;
    public String address;
    public String postalCode;
    public String city;
    public String telephoneNumber;
    public String emailAddress;

    public Customer() {
    }

    public Customer(String customerId, String name, String address, String postalCode, String city, String telephoneNumber, String emailAddress) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.telephoneNumber = telephoneNumber;
        this.emailAddress = emailAddress;
    }
}

