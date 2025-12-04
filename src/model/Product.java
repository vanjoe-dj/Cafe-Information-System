package model;

/**
 * Product model that matches AddProductFrame and Se.java expectations.
 * Fields: id, name, price, image (byte[])
 */
public class Product {

    private int id;
    private String name;
    private double price;
    private byte[] image;

    public Product() {}

    public Product(int id, String name, double price, byte[] image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public Product(String name, double price, byte[] image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }

    // id
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    // name
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    // price
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    // image bytes
    public byte[] getImage() { return image; }
    public void setImage(byte[] image) { this.image = image; }
}
