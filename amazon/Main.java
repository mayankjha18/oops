package oops.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static int sequenceGenerator = 100;
    private static Map<Seller,List<Product>> inventory = new HashMap<>();
    private static List<Cart> cartList = new ArrayList<>();
    private static List<Order> orderList = new ArrayList<>();
    public static void main(String args[])
    {
        //Restricting rating??

        //Seller login - provide userid and password - we have seller object
        Seller seller1 = new Seller("SL_100");
        seller1.setUserName("Cloudtail");
        seller1.setAddress("Bangalore");

        Seller seller2 = new Seller("SL_101");
        seller2.setUserName("Magadh Enterprise");
        seller2.setAddress("Patna");

        // it should come from db - mapping b/w seller and product
        List<Product> productList1 = new ArrayList<>();
        productList1.add(new Product("P_100", Constants.ProductCategory.Fashion, 1899, "T-Shirt", "White, Cotton",
                Constants.Brand.Nike, null, 10));
        productList1.add(new Product("P_101", Constants.ProductCategory.Fashion, 999, "Shirt", "Black, Cotton",
                Constants.Brand.Puma, null, 12));
        productList1.add(new Product("P_102", Constants.ProductCategory.Fashion, 1299, "Shirt", "Blue, Cotton",
                Constants.Brand.Reebok, null, 5));
        inventory.put(seller1, productList1);

        List<Product> productList2 = new ArrayList<>();

        productList2.add(new Product("P_103", Constants.ProductCategory.Fashion, 1799, "T-Shirt", "White, Cotton",
                Constants.Brand.Nike, null, 17));
        productList2.add(new Product("P_104", Constants.ProductCategory.Fashion, 2099, "Shirt", "Black, Cotton",
                Constants.Brand.Adidas, null, 26));
        productList2.add(new Product("P_105", Constants.ProductCategory.Fashion, 2999, "Shirt", "Blue, Cotton",
                Constants.Brand.Adidas, null, 33));
        productList2.add(new Product("P_106", Constants.ProductCategory.Electronics, 50099, "Iphone11", "Black",
                Constants.Brand.IPhone, null, 9));
        productList2.add(new Product("P_107", Constants.ProductCategory.Electronics, 71099, "Iphone12", "Luna Grey",
                Constants.Brand.IPhone, null, 18));
        inventory.put(seller2, productList2);


        //USer login and we get User object
        Customer customer1 = new Customer("CUS_100");
        customer1.setUserName("Mayank");
        List<Product> searchList1 = searchByCategory(Constants.ProductCategory.Fashion);
        List<Product> searchList2 = searchBySeller(seller2);
        System.out.println("******************Printing search results for user ******************");
        System.out.println(searchList1);
        System.out.println(searchList2);


        //User adds to cart - two products
        addToCart(searchList1.get(0), 3, customer1);
        addToCart(searchList2.get(0), 1, customer1);

        //remove product from the cart
        addToCart(searchList1.get(0), -1, customer1);

        System.out.println("******************Printing Cartlist results for user ******************");
        System.out.println(cartList);


        System.out.println("******************Checking cart status to see the updated value ******************");
        System.out.println(searchList1);
        System.out.println(searchList2);


        //Checkout - Place order
        checkout(customer1);

        System.out.println("******************Checking cart status to see the updated value ******************");
        System.out.println(searchList1);
        System.out.println(searchList2);


        //numeric values for orderid and itemid is same
        System.out.println("******************Checking order table status******************");
        System.out.println(orderList);

//      cancelOrder(String orderId);





    }

    private static List<Product> searchByCategory(Constants.ProductCategory productCategory)
    {
        List<Product> products = new ArrayList<>();
        for(Seller seller : inventory.keySet())
        {
           for(Product product: inventory.get(seller))
           {
               if(productCategory.equals(product.getProductCategory()))
               {
                   products.add(product);
               }
           }
        }
        return products;
    }

    private static List<Product> searchBySeller(Seller seller)
    {
        return inventory.get(seller);
    }

    private static void addToCart(Product product, int quantity, Customer customer)
    {
        //Remove selected quantity from inventory
        //Add item to cart
        Item item = new Item("IT_"+product.getProductId().substring(2), product.getProductId(), quantity);
        for(Cart cart : cartList)
        {
            if(cart.getCustomer().equals(customer))
            {
                List<Item> items = cart.getItems();
                items.add(item);
                return;
            }
        }
        List<Item> itemList = new ArrayList<>();
        itemList.add(item);
        sequenceGenerator++;
        cartList.add(new Cart("CART_"+(sequenceGenerator), itemList, customer));
    }

    private static void checkout(Customer customer)
    {
        List<Item> itemList = getItem(customer.getCustomerId());
        for(Item item: itemList)
        {
            sequenceGenerator++;
            Order order = new Order("ORD_" + (sequenceGenerator ), customer.getCustomerId(), item.getItemId());
            orderList.add(order);
        }

        //Remove products from inventory
        removeProducts(itemList);
    }

    private static void removeProducts(List<Item> itemList)
    {
        for(Seller seller: inventory.keySet())
        {
            for(Product product: inventory.get(seller))
            {
                for(Item item : itemList)
                {
                    if(product.getProductId().equals(item.getProductId()))
                    {
                        int quantity = product.getQuantity() - item.getQuantity();
                        if(quantity>0)
                        {
                            product.setQuantity(product.getQuantity() - item.getQuantity());
                        }
                        else
                        {
                            inventory.get(seller).remove(product);
                        }
                    }
                }
            }
        }


    }

    private static List<Item> getItem(String customerId)
    {
        for(Cart cart: cartList)
        {
            if(cart.getCustomer().getCustomerId().equals(customerId))
            {
                return cart.getItems();
            }
        }

        return null;
    }
}
