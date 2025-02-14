package ec.com.sofka.entity;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person {
    private String name;

    private String gender;

    private Integer age;

    private String identifyCard;

    private String address;

    private String phone;

    public Person() {
    }

    public Person(String name, String gender, Integer age, String identifyCard, String address, String phone) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.identifyCard = identifyCard;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIdentifyCard() {
        return identifyCard;
    }

    public void setIdentifyCard(String identifyCard) {
        this.identifyCard = identifyCard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}