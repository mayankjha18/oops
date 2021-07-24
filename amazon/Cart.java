package oops.amazon;

import java.util.List;

public class Cart {
    private String cartId;
    private List<Item> items;
    private Customer customer;

    public Cart(String cartId, List<Item> items, Customer customer) {
        this.cartId = cartId;
        this.items = items;
        this.customer = customer;
    }

    public String getCartId() {
        return cartId;
    }

    public List<Item> getItems() {
        return items;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString()
    {
        return (customer.getUserName()+ " "+ items);
    }
}
