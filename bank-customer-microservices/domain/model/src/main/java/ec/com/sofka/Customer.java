package ec.com.sofka;

public class Customer extends Person {
    private Long customerId;
    private String password;
    private Boolean status;

    public Customer(Long customerId, String password, Boolean status) {
        this.customerId = customerId;
        this.password = password;
        this.status = status;
    }

    public Customer(String name, String gender, Integer age, String identifyCard, String address, String phone, Long customerId, String password, Boolean status) {
        super(name, gender, age, identifyCard, address, phone);
        this.customerId = customerId;
        this.password = password;
        this.status = status;
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