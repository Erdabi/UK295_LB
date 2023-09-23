package ch.csbe.backendlb.resources.product.Dto;

import ch.csbe.backendlb.resources.category.Category;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * A data transfer object (DTO) for displaying the details of a product.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO for displaying the details of a product")
public class ProductDetailDto {

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
     * The name of the product.
     */
    @NotNull
    @Schema(description = "Name of the product")
    private String name;

    /**
     * The URL of the product image.
     */
    @Schema(description = "URL of the product image")
    private String image;

    /**
     * The description of the product.
     */
    @Schema(description = "Description of the product")
    private String description;

    /**
     * The price of the product.
     */
    @NotNull
    @Schema(description = "Price of the product")
    private Double price;

    /**
     * The stock quantity of the product.
     */
    @Schema(description = "Stock quantity of the product")
    private Integer stock;

    /**
     * The category of the product.
     */
    @Schema(description = "Category of the product")
    private Category category;
}
