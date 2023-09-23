package ch.csbe.backendlb.resources.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the ProductService interface for managing products.
 */
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Retrieve a list of all products.
     *
     * @return A list of all products.
     */
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    /**
     * Retrieve a product by its ID.
     *
     * @param id The ID of the product to retrieve.
     * @return The product with the specified ID, or null if not found.
     */
    public Product getById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.orElse(null);
    }

    /**
     * Create a new product.
     *
     * @param product The product to create.
     * @return The created product.
     */
    public Product create(Product product) {
        return productRepository.save(product);
    }

    /**
     * Update an existing product by its ID.
     *
     * @param id      The ID of the product to update.
     * @param product The updated product data.
     * @return The updated product, or null if the product with the given ID does not exist.
     */
    public Product update(Long id, Product product) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product existingProduct = productOptional.get();
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setCategory(product.getCategory());
            return productRepository.save(existingProduct);
        }
        return null;
    }

    /**
     * Delete a product by its ID.
     *
     * @param id The ID of the product to delete.
     * @throws ResourceNotFoundException If the product with the given ID does not exist.
     */
    public void deleteById(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Product with the id " + id + " could not be found!");
        }
    }
}
