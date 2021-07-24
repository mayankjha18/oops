package oops.amazon;

public class Item {
    private String itemId;
    private String productId;
    private int quantity;

    public Item(String itemId, String productId, int quantity) {
        this.itemId = itemId;
        this.productId = productId;
        this.quantity = quantity;
    }

    @Override
    public String toString()
    {
        return (productId + " - "+ quantity);
    }

    public String getItemId() {
        return itemId;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
}
