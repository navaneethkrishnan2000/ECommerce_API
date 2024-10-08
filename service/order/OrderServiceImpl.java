package com.ekart.easy_connect.service.order;

import com.ekart.easy_connect.dto.OrderDto;
import com.ekart.easy_connect.model.Order;

import java.util.List;

public interface OrderServiceImpl {

    Order placeOrder(Long userId);
    OrderDto getOrder(Long orderId);
    List<OrderDto> getUserOrders(Long userId);

    OrderDto convertToDto(Order order);
}
