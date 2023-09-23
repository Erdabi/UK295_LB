package ch.csbe.backendlb.resources.category;

import ch.csbe.backendlb.resources.category.Dto.CategoryCreateDto;
import ch.csbe.backendlb.resources.category.Dto.CategoryDetailDto;
import ch.csbe.backendlb.resources.category.Dto.CategoryShowDto;
import ch.csbe.backendlb.resources.category.Dto.CategoryUpdateDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for managing category-related operations.
 */
@RestController
@RequestMapping("categories")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    /**
     * Get a list of all categories.
     *
     * @return A list of CategoryShowDto objects representing categories.
     */
    @GetMapping()
    @Operation(
            summary = "Get all categories",
            operationId = "getCategories",
            description = "Retrieve a list of all categories."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Categories found",
            content = @Content(schema = @Schema(implementation = CategoryShowDto.class))
    )
    public ResponseEntity<List<CategoryShowDto>> getCategories() {
        List<CategoryShowDto> categories = categoryService.getAll();
        if (!categories.isEmpty()) {
            return ResponseEntity.ok(categories);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    /**
     * Create a new category.
     *
     * @param categoryCreateDto The DTO representing the category to be created.
     * @return A response entity containing the created CategoryShowDto.
     */
    @PostMapping()
    @Operation(
            summary = "Create a new category",
            operationId = "createCategory",
            description = "Create a new category."
    )
    @ApiResponse(
            responseCode = "201",
            description = "Category created",
            content = @Content(schema = @Schema(implementation = CategoryShowDto.class))
    )
    @ApiResponse(
            responseCode = "400",
            description = "Invalid request"
    )
    public ResponseEntity<CategoryShowDto> createCategory(@RequestBody CategoryCreateDto categoryCreateDto) {
        if (isValidCategoryCreateDto(categoryCreateDto)) {
            CategoryShowDto createdCategory = categoryService.create(categoryCreateDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Check if the provided CategoryCreateDto is valid.
     *
     * @param categoryCreateDto The CategoryCreateDto to be validated.
     * @return True if the CategoryCreateDto is valid; otherwise, false.
     */
    private boolean isValidCategoryCreateDto(CategoryCreateDto categoryCreateDto) {
        if (categoryCreateDto == null) {
            return false;
        }
        if (categoryCreateDto.getName() == null || categoryCreateDto.getName().isEmpty()) {
            return false;
        }
        return true; // If all validations pass, the category is considered valid.
    }

    /**
     * Get a category by its ID.
     *
     * @param id The ID of the category to retrieve.
     * @return A response entity containing the CategoryDetailDto for the specified category.
     */
    @GetMapping("/{id}")
    @Operation(
            summary = "Get a category by its ID",
            operationId = "getCategoryById",
            description = "Retrieve a category by its ID."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Category found",
            content = @Content(schema = @Schema(implementation = CategoryDetailDto.class))
    )
    @ApiResponse(
            responseCode = "404",
            description = "Category not found"
    )
    public ResponseEntity<CategoryDetailDto> getCategoryById(
            @Parameter(description = "ID of the category") @PathVariable Long id) {
        CategoryDetailDto category = categoryService.getById(id);
        if (category != null) {
            return ResponseEntity.ok(category);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Update a category by its ID.
     *
     * @param id                The ID of the category to update.
     * @param categoryUpdateDto The DTO representing the updates to be applied to the category.
     * @return A response entity containing the updated CategoryDetailDto for the category.
     */
    @PutMapping("/{id}")
    @Operation(
            summary = "Update a category by its ID",
            operationId = "updateCategoryById",
            description = "Update a category by its ID."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Category updated",
            content = @Content(schema = @Schema(implementation = CategoryDetailDto.class))
    )
    @ApiResponse(
            responseCode = "404",
            description = "Category not found"
    )
    public ResponseEntity<CategoryDetailDto> updateCategoryById(
            @Parameter(description = "ID of the category") @PathVariable Long id,
            @RequestBody CategoryUpdateDto categoryUpdateDto) {
        CategoryDetailDto updatedCategory = categoryService.update(id, categoryUpdateDto);
        if (updatedCategory != null) {
            return ResponseEntity.ok(updatedCategory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Delete a category by its ID.
     *
     * @param id The ID of the category to delete.
     * @return A response entity indicating the success or failure of the delete operation.
     */
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete a category by its ID",
            operationId = "deleteCategoryById",
            description = "Delete a category by its ID."
    )
    @ApiResponse(
            responseCode = "204",
            description = "Category deleted"
    )
    @ApiResponse(
            responseCode = "404",
            description = "Category not found"
    )
    public ResponseEntity<Void> deleteCategoryById(
            @Parameter(description = "ID of the category to delete") @PathVariable Long id) {
        categoryService.delete(id);
        if (!categoryService.categoryExistsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
