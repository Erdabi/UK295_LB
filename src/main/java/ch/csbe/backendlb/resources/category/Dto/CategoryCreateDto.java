package ch.csbe.backendlb.resources.category.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) for creating a category.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO for creating a category")
public class CategoryCreateDto {

    /**
     * Unique identification number of the category.
     */
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
    @Schema(description = "Name of the category")
    private String name;

    /**
     * Get the unique identification number of the category.
     *
     * @return The unique identification number of the category.
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the unique identification number of the category.
     *
     * @param id The unique identification number of the category.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the activity status of the category.
     *
     * @return The activity status of the category.
     */
    public int getActive() {
        return active;
    }

    /**
     * Set the activity status of the category.
     *
     * @param active The activity status of the category.
     */
    public void setActive(int active) {
        this.active = active;
    }

    /**
     * Get the name of the category.
     *
     * @return The name of the category.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the category.
     *
     * @param name The name of the category.
     */
    public void setName(String name) {
        this.name = name;
    }
}
