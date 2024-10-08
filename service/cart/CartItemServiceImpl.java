package com.ekart.easy_connect.service.cart;

import com.ekart.easy_connect.model.Cart;
import com.ekart.easy_connect.model.CartItem;

import java.math.BigDecimal;

public interface CartItemServiceImpl {

    void addItemToCart(Long cartId, Long productId, int quantity);
    void removeItemFromCart(Long cartId, Long productId);
    void updateItemQuantity(Long cartId, Long productId, int quantity);

    CartItem getCartItem(Long cartId, Long productId);
}
