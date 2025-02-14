package ec.com.sofka.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "customers", uniqueConstraints = @UniqueConstraint(columnNames = "customer_id"))
public class CustomerEntity extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "status", nullable = false)
    private Boolean status;

    public CustomerEntity() {
    }

    public CustomerEntity(Long customerId, String password, Boolean status) {
        this.customerId = customerId;
        this.password = password;
        this.status = status;
    }

    public CustomerEntity(String name, String gender, Integer age, String identifyCard, String address, String phone, Long customerId, String password, Boolean status) {
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}