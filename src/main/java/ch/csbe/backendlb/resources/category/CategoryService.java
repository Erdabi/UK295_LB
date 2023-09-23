package ch.csbe.backendlb.resources.category;

import ch.csbe.backendlb.resources.category.Dto.CategoryCreateDto;
import ch.csbe.backendlb.resources.category.Dto.CategoryDetailDto;
import ch.csbe.backendlb.resources.category.Dto.CategoryShowDto;
import ch.csbe.backendlb.resources.category.Dto.CategoryUpdateDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing category-related operations.
 */
public interface CategoryService {

    /**
     * Create a new category.
     *
     * @param category The CategoryCreateDto representing the category to be created.
     * @return The created CategoryShowDto.
     */
    CategoryShowDto create(CategoryCreateDto category);

    /**
     * Get a category by its ID.
     *
     * @param id The ID of the category to retrieve.
     * @return The CategoryDetailDto for the specified category, or null if not found.
     */
    CategoryDetailDto getById(Long id);

    /**
     * Get a list of all categories.
     *
     * @return A list of CategoryShowDto objects representing categories.
     */
    List<CategoryShowDto> getAll();

    /**
     * Update a category by its ID.
     *
     * @param id                The ID of the category to update.
     * @param categoryUpdateDto The CategoryUpdateDto containing updated data.
     * @return The updated CategoryDetailDto for the category, or null if not found.
     */
    CategoryDetailDto update(Long id, CategoryUpdateDto categoryUpdateDto);

    /**
     * Delete a category by its ID.
     *
     * @param id The ID of the category to delete.
     */
    void delete(Long id);
}
