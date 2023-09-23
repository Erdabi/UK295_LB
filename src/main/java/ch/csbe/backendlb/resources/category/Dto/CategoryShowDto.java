package ch.csbe.backendlb.resources.category.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Data Transfer Object (DTO) for displaying a category.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO for displaying a category")
public class CategoryShowDto {

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
     * Name of the category.
     */
    @NotNull
    @Schema(description = "Name of the category")
    private String name;
}
