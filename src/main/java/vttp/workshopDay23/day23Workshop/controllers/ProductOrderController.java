package vttp.workshopDay23.day23Workshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vttp.workshopDay23.day23Workshop.models.ProductOrder;
import vttp.workshopDay23.day23Workshop.repositories.OrdersRepository;

@Controller
@RequestMapping(path="/order")
public class ProductOrderController {

    @Autowired
    private OrdersRepository ordersRepo;

    @GetMapping(path="/total/{id}")
    public String getOrdersByOrderId(@RequestParam Integer id, Model model) {

        System.out.println(id);
        List<ProductOrder> orders = ordersRepo.getOrdersByOrderId(id);
        // System.out.println("TEST>>>>>>" + orders.get(0).getId());
        if (orders.size()<=0) {
            String error= "Oops! There were no orders with the order ID: %d\n".formatted(id);
            model.addAttribute("error", error);
        }

        model.addAttribute("orders", orders);
        return "orders";
        
    }

    
}
