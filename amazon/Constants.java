package oops.amazon;

public class Constants {

    public enum ProductCategory {
        Electronics,
        Fashion,
        HomeandKitchen,
        Furniture,
        Sports,
        Books,
        Software
    }

    public enum Brand
    {
        Lloyd("Lloyd",""),
        Bajaj("Bajaj", ""),
        Khetan("Khetan", ""),
        Adidas("Adidas", ""),
        Puma("Puma", ""),
        Reebok("Reebok", ""),
        Nike("Nike", ""),
        IPhone("IPhone", "");

        private String brand;
        private String description;

        Brand(String brand, String description)
        {
            this.brand = brand;
            this.description = description;
        }

        public String getBrand() {
            return brand;
        }

        public String getDescription() {
            return description;
        }
    }

    public enum ShipmentStatus
    {
        AwaitingConfirmation,
        Confirmed,
        Dispatched,
        OutForDelivery,
        Delivered,
    }

}
