package ch.csbe.backendlb.resources.category;

import ch.csbe.backendlb.resources.category.Dto.CategoryCreateDto;
import ch.csbe.backendlb.resources.category.Dto.CategoryDetailDto;
import ch.csbe.backendlb.resources.category.Dto.CategoryShowDto;
import ch.csbe.backendlb.resources.category.Dto.CategoryUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

/**
 * Mapper interface for converting between entity objects and DTOs for categories.
 */
@Mapper(
        componentModel = "spring"
)
public abstract class CategoryMapper {

    /**
     * Convert a Category entity to a CategoryShowDto.
     *
     * @param category The Category entity to convert.
     * @return The corresponding CategoryShowDto.
     */
    public abstract CategoryShowDto toShowDto(Category category);

    /**
     * Convert a CategoryCreateDto to a Category entity.
     *
     * @param categoryCreateDto The CategoryCreateDto to convert.
     * @return The corresponding Category entity.
     */
    public abstract Category fromCreateDto(CategoryCreateDto categoryCreateDto);

    /**
     * Convert a Category entity to a CategoryDetailDto.
     *
     * @param category The Category entity to convert.
     * @return The corresponding CategoryDetailDto.
     */
    public abstract CategoryDetailDto toDetailDto(Category category);

    /**
     * Update a Category entity using data from a CategoryUpdateDto.
     *
     * @param categoryUpdateDto The CategoryUpdateDto containing updated data.
     * @param category          The Category entity to update.
     */
    public abstract void updateFromCategoryUpdateDto(CategoryUpdateDto categoryUpdateDto, @MappingTarget Category category);
}
