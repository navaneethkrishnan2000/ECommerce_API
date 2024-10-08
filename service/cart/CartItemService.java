package com.ekart.easy_connect.service.cart;

import com.ekart.easy_connect.exception.ResourceNotFoundException;
import com.ekart.easy_connect.model.Cart;
import com.ekart.easy_connect.model.CartItem;
import com.ekart.easy_connect.model.Product;
import com.ekart.easy_connect.repository.CartItemRepository;
import com.ekart.easy_connect.repository.CartRepository;
import com.ekart.easy_connect.service.product.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CartItemService implements CartItemServiceImpl{

    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;
    private final ProductServiceImpl productService;
    private final CartServiceImpl cartService;

    @Override
    public void addItemToCart(Long cartId, Long productId, int quantity) {

        //1. get the cart
        //2. get the product
        //3. check if the product is already in the cart
        //4. if yes, then increase the quantity with the requested quantity
        //5. if no, then initiate a new cartItem entry.

        Cart cart = cartService.getCart(cartId);

        Product product = productService.getProductById(productId);

        CartItem cartItem = cart.getCartItems().stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst().orElse(new CartItem());

        if (cartItem.getId() == null) {
            cartItem.setCart(cart);
            cartItem.setProduct(product);
            cartItem.setQuantity(quantity);
            cartItem.setUnitPrice(product.getPrice());
        } else {
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
        }

        cartItem.setTotalPrice();
        cart.addItem(cartItem);

        cartItemRepository.save(cartItem);
        cartRepository.save(cart);
    }

    @Override
    public void removeItemFromCart(Long cartId, Long productId) {

        Cart cart = cartService.getCart(cartId);
        CartItem cartItemToRemove = getCartItem(cartId, productId);

        cart.removeItem(cartItemToRemove);

        cartRepository.save(cart);
    }

    @Override
    public void updateItemQuantity(Long cartId, Long productId, int quantity) {
        Cart cart = cartService.getCart(cartId);
        cart.getCartItems()
                .stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst()
                .ifPresent(item -> {
                    item.setQuantity(quantity);
                    item.setUnitPrice(item.getProduct().getPrice());
                    item.setTotalPrice();
                });

        BigDecimal totalAmount = cart.getCartItems()
                .stream().map(CartItem :: getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        
        cart.setTotalAmount(totalAmount);
        cartRepository.save(cart);
    }

    @Override
    public CartItem getCartItem(Long cartId, Long productId) {
        Cart cart = cartService.getCart(cartId);
        return cart.getCartItems()
                .stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst().orElseThrow(() -> new ResourceNotFoundException("Product/Item Not Found!"));
    }
}
