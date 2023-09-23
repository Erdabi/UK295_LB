package ch.csbe.backendlb.resources.category;

import ch.csbe.backendlb.resources.category.Dto.CategoryCreateDto;
import ch.csbe.backendlb.resources.category.Dto.CategoryShowDto;
import ch.csbe.backendlb.resources.category.Dto.CategoryDetailDto;
import ch.csbe.backendlb.resources.category.Dto.CategoryUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the CategoryService interface for managing category-related operations.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    /**
     * Constructor to initialize the CategoryServiceImpl with a CategoryMapper.
     *
     * @param categoryMapper The CategoryMapper for mapping between entities and DTOs.
     */
    public CategoryServiceImpl(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    /**
     * Get a list of all categories.
     *
     * @return A list of CategoryShowDto objects representing categories.
     */
    public List<CategoryShowDto> getAll() {
        List<Category> categories = this.categoryRepository.findAll();
        return categories.stream().map(categoryMapper::toShowDto).collect(Collectors.toList());
    }

    /**
     * Create a new category.
     *
     * @param categoryCreateDto The CategoryCreateDto representing the category to be created.
     * @return The created CategoryShowDto.
     */
    public CategoryShowDto create(CategoryCreateDto categoryCreateDto) {
        Category categoryToSave = categoryMapper.fromCreateDto(categoryCreateDto);
        Category savedCategory = this.categoryRepository.save(categoryToSave);
        return categoryMapper.toShowDto(savedCategory);
    }

    /**
     * Get a category by its ID.
     *
     * @param id The ID of the category to retrieve.
     * @return The CategoryDetailDto for the specified category, or null if not found.
     */
    public CategoryDetailDto getById(Long id) {
        Category category = this.categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category with the id " + id + " could not be found!"));
        return categoryMapper.toDetailDto(category);
    }

    /**
     * Update a category by its ID.
     *
     * @param id                The ID of the category to update.
     * @param categoryUpdateDto The CategoryUpdateDto containing updated data.
     * @return The updated CategoryDetailDto for the category, or null if not found.
     */
    public CategoryDetailDto update(Long id, CategoryUpdateDto categoryUpdateDto) {
        Category category = this.categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category with the id " + id + " could not be found!"));
        categoryMapper.updateFromCategoryUpdateDto(categoryUpdateDto, category);
        Category updatedCategory = categoryRepository.save(category);
        return categoryMapper.toDetailDto(updatedCategory);
    }

    /**
     * Delete a category by its ID.
     *
     * @param id The ID of the category to delete.
     */
    public void delete(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Category with the id " + id + " could not be found!");
        }
    }

    /**
     * Check if a category exists by its ID.
     *
     * @param id The ID of the category to check.
     * @return True if the category exists; otherwise, false.
     */
    public boolean categoryExistsById(Long id) {
        return categoryRepository.existsById(id);
    }
}
