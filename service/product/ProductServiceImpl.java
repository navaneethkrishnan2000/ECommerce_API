package com.ekart.easy_connect.service.product;

import com.ekart.easy_connect.dto.ProductDto;
import com.ekart.easy_connect.model.Category;
import com.ekart.easy_connect.model.Product;
import com.ekart.easy_connect.request.AddProductRequest;
import com.ekart.easy_connect.request.ProductUpdateRequest;

import java.util.List;

public interface ProductServiceImpl {

    Product addProduct(AddProductRequest request);
    Product getProductById(Long id);
    void deleteProductById(Long id);
    Product updateProduct(ProductUpdateRequest product, Long productId);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByBrand(String brand);
    List<Product> getProductsByCategoryAndBrand(String category, String brand);
    List<Product> getProductsByName(String name);
    List<Product> getProductsByBrandAndName(String brand, String name);
    Long countProductsByBrandAndName(String brand, String name);

    List<ProductDto> getConvertedProducts(List<Product> products);

    ProductDto convertToDto(Product product);
}
