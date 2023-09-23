package ch.csbe.backendlb.resources.product;

import ch.csbe.backendlb.resources.category.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a product in the application.
 */
@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * The article number (SKU) of the product.
     */
    @Column(columnDefinition = "varchar(100)")
    private String sku;

    /**
     * The name of the product.
     */
    @Column(columnDefinition = "varchar(500)")
    private String name;

    /**
     * The URL of the product image.
     */
    @Column(columnDefinition = "varchar(1000)")
    private String image;

    /**
     * The description of the product.
     */
    @Column(columnDefinition = "MEDIUMTEXT")
    private String description;

    /**
     * The price of the product.
     */
    @Column(columnDefinition = "FLOAT")
    private float price;

    /**
     * The stock quantity of the product.
     */
    @Column(columnDefinition = "INT")
    private int stock;

    /**
     * The category of the product.
     */
    @ManyToOne()
    private Category category;

    /**
     * Gets the unique identification number of the product.
     *
     * @return The unique identification number.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identification number of the product.
     *
     * @param id The unique identification number.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the article number (SKU) of the product.
     *
     * @return The article number (SKU).
     */
    public String getSku() {
        return sku;
    }

    /**
     * Sets the article number (SKU) of the product.
     *
     * @param sku The article number (SKU).
     */
    public void setSku(String sku) {
        this.sku = sku;
    }

    /**
     * Gets the name of the product.
     *
     * @return The name of the product.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the product.
     *
     * @param name The name of the product.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the URL of the product image.
     *
     * @return The URL of the product image.
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets the URL of the product image.
     *
     * @param image The URL of the product image.
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Gets the description of the product.
     *
     * @return The description of the product.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the product.
     *
     * @param description The description of the product.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the price of the product.
     *
     * @return The price of the product.
     */
    public float getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     *
     * @param price The price of the product.
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Gets the stock quantity of the product.
     *
     * @return The stock quantity of the product.
     */
    public int getStock() {
        return stock;
    }

    /**
     * Sets the stock quantity of the product.
     *
     * @param stock The stock quantity of the product.
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Gets the category of the product.
     *
     * @return The category of the product.
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Sets the category of the product.
     *
     * @param category The category of the product.
     */
    public void setCategory(Category category) {
        this.category = category;
    }
}
