package ec.com.sofka.data;

public class CustomerResponse {
    private Long customerId;
    private String name;

    public CustomerResponse() {
    }

    public CustomerResponse(Long customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }
}
