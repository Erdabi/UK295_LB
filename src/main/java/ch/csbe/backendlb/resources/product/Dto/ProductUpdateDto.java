package ch.csbe.backendlb.resources.product.Dto;

import ch.csbe.backendlb.resources.category.Category;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * A data transfer object (DTO) for updating a product.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO for updating a product")
public class ProductUpdateDto {

    /**
     * The unique identification number of the product.
     */
    @NotNull
    @Schema(description = "Unique identification number of the product")
    private Long id;

    /**
     * The article number (SKU) of the product.
     */
    @Schema(description = "Article number (SKU) of the product")
    private String sku;

    /**
     * The new name of the product.
     */
    @NotNull
    @Schema(description = "New name of the product")
    private String name;

    /**
     * The URL of the new product image.
     */
    @Schema(description = "URL of the new product image")
    private String image;

    /**
     * The new description of the product.
     */
    @Schema(description = "New description of the product")
    private String description;

    /**
     * The new price of the product.
     */
    @NotNull
    @Schema(description = "New price of the product")
    private Double price;

    /**
     * The new stock quantity of the product.
     */
    @Schema(description = "New stock quantity of the product")
    private Integer stock;

    /**
     * The new category of the product.
     */
    @Schema(description = "New category of the product")
    private Category category;
}
