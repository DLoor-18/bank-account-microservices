package ec.com.sofka.data;

import java.io.Serializable;

public class CustomerResponseDTO implements Serializable {
    private Long customerId;
    private Boolean status;
    private String name;
    private String gender;
    private Integer age;
    private String identifyCard;
    private String address;
    private String phone;

    public CustomerResponseDTO() {
    }

    public CustomerResponseDTO(Long customerId, Boolean status, String name, String gender, Integer age, String identifyCard, String address, String phone) {
        this.customerId = customerId;
        this.status = status;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.identifyCard = identifyCard;
        this.address = address;
        this.phone = phone;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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