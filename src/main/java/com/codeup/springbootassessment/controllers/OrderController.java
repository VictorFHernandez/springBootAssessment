package com.codeup.springbootassessment.controllers;

import com.codeup.springbootassessment.daos.OrderRepository;
import com.codeup.springbootassessment.models.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrderController {
    private final OrderRepository orderDao;

    public OrderController(OrderRepository orderDao){
        this.orderDao = orderDao;
    }

    @GetMapping("/orders/create")
    @ResponseBody
    public String showCreateOrderForm(Model model){
        model.addAttribute("order", new Order());
        return "/orders/create";
    }

    @PostMapping("/orders/create")
    public String createOrder(@PathVariable long id,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "total_price") double total_price
    ){
        Order order = orderDao.findAllById(id);
        order.setEmail(email);
        order.setTotal_price(total_price);
        return "/orders/create";
    }

    @GetMapping("/orders/{id}")
    public String ShowOneOrder(@PathVariable long id, Model model){
        model.addAttribute("singleOrder", orderDao.findAllById(id));
        return "/orders/show";
    }

    /* I've been trying to run the application and i keep getting the same error:
    Error starting ApplicationContext. To display the conditions report re-run your application with 'debug' enabled.
     2021-07-08 08:30:44.509 ERROR 4811 --- [main] o.s.boot.SpringApplication: Application run failed

     ** I can't see my progress because of this **
     */



    /* i need help knowing how to make Updates here */
//    @GetMapping("/orders/{id}/update")

//    @PostMapping("/orders/{id}/update")



    @PostMapping("/orders/{id}/delete")
    public String deleteOrder(@PathVariable long id){
        orderDao.deleteById(id);
        return "redirect:/orders/show";
    }

}
