package ch.csbe.backendlb.resources.category;

import ch.csbe.backendlb.resources.category.Dto.CategoryUpdateDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.mapstruct.MappingTarget;

import java.util.List;

/**
 * Entity class representing a category.
 */
@Entity
@Getter
@Setter
public class Category {

    /**
     * Unique identification number of the category.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * Activity status of the category.
     * The column is defined as TINYINT in the database.
     */
    @Column(columnDefinition="TINYINT")
    private int active;

    /**
     * Name of the category.
     * The column is defined as a VARCHAR with a maximum length of 255 characters.
     */
    @Column(columnDefinition="varchar(255)")
    private String name;
}
