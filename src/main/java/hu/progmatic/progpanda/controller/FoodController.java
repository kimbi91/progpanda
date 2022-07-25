package hu.progmatic.progpanda.controller;


import hu.progmatic.progpanda.model.Drink;
import hu.progmatic.progpanda.model.Food;
import hu.progmatic.progpanda.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FoodController {

    @Autowired
    FoodService foodService;

    @PostMapping(value ={"/foods"})
    public String newDrink(Food food, Model model) {
        foodService.saveFood(food);
        return "redirect:/foods";
    }

    @GetMapping(value = {"/foods"})
    public String getFoods(Model model) {
        List<Food> foods = foodService.getAll();
        model.addAttribute("newFood", new Food());
        model.addAttribute("foods", foods);
        return "foods";
    }

    @GetMapping(value = {"/delivery"})
    public String getDelivery() {
        return "delivery";
    }
}
