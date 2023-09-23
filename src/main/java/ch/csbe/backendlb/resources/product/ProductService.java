package ch.csbe.backendlb.resources.product;

import java.util.List;

/**
 * Service interface for managing products.
 */
public interface ProductService {

    /**
     * Create a new product.
     *
     * @param product The product to create.
     * @return The created product.
     */
    Product create(Product product);

    /**
     * Get a product by its ID.
     *
     * @param id The ID of the product to retrieve.
     * @return The product with the specified ID.
     */
    Product getById(Long id);

    /**
     * Get a list of all products.
     *
     * @return A list of all products.
     */
    List<Product> getAll();

    /**
     * Update a product by its ID.
     *
     * @param id      The ID of the product to update.
     * @param product The updated product data.
     * @return The updated product.
     */
    Product update(Long id, Product product);

    /**
     * Delete a product by its ID.
     *
     * @param id The ID of the product to delete.
     */
    void deleteById(Long id);
}
