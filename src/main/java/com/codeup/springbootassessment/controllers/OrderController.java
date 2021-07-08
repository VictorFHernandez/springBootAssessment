package com.codeup.springbootassessment.controllers;

import com.codeup.springbootassessment.daos.OrderRepository;
import com.codeup.springbootassessment.models.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrderController {
    private OrderRepository orderDao;

    public OrderController(OrderRepository orderDao){
        this.orderDao = orderDao;
    }

    @GetMapping("/orders/create")
    @ResponseBody
    public String showCreateOrderForm(Model model){
        model.addAttribute("order", new Order());
        return "orders/create";
    }

//    @PostMapping("/orders/create")
//    public String createOrder(@ModelAttribute Order order){
//        order.setId(order.getId());
//
//    }

//    @GetMapping("/orders/{id}"){
//
//}

//    @GetMapping("/orders/{id}/update"){
//
//}

//    @PostMapping("/orders/{id}/update"){
//
//    }

    @PostMapping("/orders/{id}/delete")
    public String ddeleteOrder(@PathVariable long id){
        orderDao.deleteById(id);
        return "redirect:/orders";
    }

}
