package model;

public class Address {
    public Address() {
    }

    private String street = "3901 Old Seward Hwy Suite 101";
    private String city = "Anchorage";
    private String zip = "99503";
    private String state = "AK";

    public String getStreet() {
        return street;
    }

    public void setStreet(String address) {
        this.street = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
