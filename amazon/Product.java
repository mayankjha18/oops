package oops.amazon;

public class Product {
    private String productId;
    private Constants.ProductCategory productCategory;
    private double price;
    private String productName;
    private String porductDescription;
    private Constants.Brand brand;
    private Review review;
    private int quantity;

    public Product(String productId, Constants.ProductCategory productCategory, double price, String productName, String porductDescription, Constants.Brand brand, Review review, int quantity) {
        this.productId = productId;
        this.productCategory = productCategory;
        this.price = price;
        this.productName = productName;
        this.porductDescription = porductDescription;
        this.brand = brand;
        this.review = review;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Constants.ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Constants.ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPorductDescription() {
        return porductDescription;
    }

    public void setPorductDescription(String porductDescription) {
        this.porductDescription = porductDescription;
    }

    public Constants.Brand getBrand() {
        return brand;
    }

    public void setBrand(Constants.Brand brand) {
        this.brand = brand;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString()
    {
        return (productId+ " - "+ quantity);
    }
}
