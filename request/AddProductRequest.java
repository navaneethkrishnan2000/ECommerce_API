/*
 * why we created this class ?
 *
 * It is not advisable or it is not good practice to work with the model class directly.
 * Because, Product.class is the direct table of our database, and it is holding different properties.
 * So the best way to work with the Product is to create a copy of the model class
 */

package com.ekart.easy_connect.request;

import com.ekart.easy_connect.model.Category;
import lombok.Data;

import java.math.BigDecimal;

@Data // this annotation generated the getters and the setters.it is not advisable to use in entity class, because it is not safe
public class AddProductRequest {
    private Long id;
    private String name;
    private String brand;
    private BigDecimal price;
    private int inventory;
    private String description;
    private Category category;

}
