package com.example.ccsd_project.Mapper;

import com.example.ccsd_project.DTO.OrderDTO;
import com.example.ccsd_project.Model.OrderPackage.Order;

public class OrderMapper {
    public static OrderDTO mapToOrderDTO(Order order){
        return new OrderDTO(
            order.getId(),
            order.getUsername(),
            order.getEmail(),
            order.getPayment(),
            order.getAddress(),
            order.getTotal(),
            order.isDeliverable(),
            order.getCart(),
            order.getBookingTime()
        );
    }

    public static Order mapToOrder(OrderDTO orderDTO){
        return new Order(
            orderDTO.getEmail(),
            orderDTO.getUsername(),
            orderDTO.getPayment(),
            orderDTO.getAddress(),
            orderDTO.isDeliverable(),
            orderDTO.getBookingTime(),
            orderDTO.getCart()
        );
    }
}
