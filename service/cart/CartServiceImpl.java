package com.ekart.easy_connect.service.cart;

import com.ekart.easy_connect.model.Cart;
import com.ekart.easy_connect.model.User;

import java.math.BigDecimal;

public interface CartServiceImpl {
    Cart getCart(Long id);
    void clearCart(Long id);
    BigDecimal getTotalPrice(Long id);

    Cart initializeNewCart(User user);

    Cart getCartByUserId(Long userId);
}
