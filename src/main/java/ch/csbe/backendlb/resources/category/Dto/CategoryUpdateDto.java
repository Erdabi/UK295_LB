package ch.csbe.backendlb.resources.category.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Data Transfer Object (DTO) for updating a category.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO for updating a category")
public class CategoryUpdateDto {

    /**
     * Unique identification number of the category.
     */
    @NotNull
    @Schema(description = "Unique identification number of the category")
    private Long id;

    /**
     * Activity status of the category.
     */
    @Schema(description = "Activity status of the category")
    private int active;

    /**
     * New name for the category.
     */
    @NotNull
    @Schema(description = "New name for the category")
    private String name;
}
