package ec.com.sofka.data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CustomerUpdateRequestDTO {
    @NotNull(message = "customerId cant nulleable")
    private Long customerId;
    @NotNull(message = "password cant nulleable")
    @NotBlank(message = "password cant blank")
    private String password;
    @NotNull(message = "status cant nulleable")
    private Boolean status;
    @NotNull(message = "name cant nulleable")
    @NotBlank(message = "name cant blank")
    private String name;
    @NotNull(message = "gender cant nulleable")
    @NotBlank(message = "gender cant blank")
    private String gender;
    @NotNull(message = "age cant nulleable")
    private Integer age;
    @NotNull(message = "identifyCard cant nulleable")
    @NotBlank(message = "identifyCard cant blank")
    @Pattern(regexp = "^[0-9]+$", message = "Incorrect identifyCard format")
    @Size(min = 10, max = 10, message = "Incorrect identifyCard length")
    private String identifyCard;
    @NotNull(message = "address cant nulleable")
    @NotBlank(message = "address cant blank")
    private String address;
    @NotNull(message = "phone cant nulleable")
    @NotBlank(message = "phone cant blank")
    @Pattern(regexp = "^[0-9]+$", message = "Incorrect phone format")
    private String phone;

    public CustomerUpdateRequestDTO() {
    }

    public CustomerUpdateRequestDTO(Long customerId, String password, Boolean status, String name, String gender, Integer age, String identifyCard, String address, String phone) {
        this.customerId = customerId;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }

    public String getIdentifyCard() {
        return identifyCard;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}