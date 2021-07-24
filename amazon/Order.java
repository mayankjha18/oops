package oops.amazon;

public class Order {
    private String orderId;
    private String customerId;
    private String itemId;

    public Order(String orderId, String customerId, String itemId) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.itemId = itemId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString()
    {
        return (itemId + "-"+customerId);
    }
}
