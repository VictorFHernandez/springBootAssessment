package com.codeup.springbootassessment.daos;


import com.codeup.springbootassessment.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderRepository, Long> {

    Order findAllById(long id);
    Order findAllByEmail(String email);
    Order findAllByTotal_price(double total_price);
}
