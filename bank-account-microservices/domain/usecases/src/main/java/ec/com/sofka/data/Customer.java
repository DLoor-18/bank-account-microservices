package ec.com.sofka.data;

public class Customer {
    private String name;
    private String gender;
    private Integer age;
    private String identifyCard;
    private String address;
    private String phone;
    private Long customerId;
    private String password;
    private Boolean status;

    public Customer() {
    }

    public Customer(String name, String gender, Integer age, String identifyCard, String address, String phone, Long customerId, String password, Boolean status) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.identifyCard = identifyCard;
        this.address = address;
        this.phone = phone;
        this.customerId = customerId;
        this.password = password;
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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}