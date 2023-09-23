package ch.csbe.backendlb.resources.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repository interface for interacting with Category entities in the database.
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    /**
     * Find categories by their name.
     *
     * @param name The name of the categories to search for.
     * @return A list of Category entities with matching names.
     */
    List<Category> findProductsByName(String name);

    /**
     * Find a category by its name.
     *
     * @param name The name of the category to search for.
     * @return The Category entity with the matching name, or null if not found.
     */
    @Query("SELECT c FROM Category c WHERE c.name = ?1")
    Category findCategoryByTitle(String name);

    /**
     * Find a category by its ID.
     *
     * @param id The ID of the category to search for.
     * @return The Category entity with the matching ID, or null if not found.
     */
    @Query("SELECT c FROM Category c WHERE c.id = ?1")
    Category findCategoryById(long id);
}
