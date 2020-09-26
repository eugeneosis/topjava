package ru.javawebinar.topjava.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;

import java.time.LocalDateTime;

@Controller
@RequestMapping(value = "/meals")
public class JspMealController {

    MealService service;

    @Autowired
    public JspMealController(MealService service) {
        this.service = service;
    }

    @GetMapping("/")
    //Ведет в корень потому что в jsp есть вариант перехода на мэйн пэйдж
    public String root() {
        return "index";
    }

    @GetMapping("/meals")
    //Если нужны все милз - (показать все) очевидно что это ГЕТ
    public String getMeals(int userId, Model model) {
        model.addAttribute("meals", service.getAll(userId));
        return "/meals";
    }

    @GetMapping("/mealForm")
    public String createMeals(Model model, Meal meal, int userId) {
        model.addAttribute("meal", new Meal());
        service.create(new Meal(), userId);
        return "/mealForm";
    }

    @PostMapping("/mealForm")
    //Если нужно сохранить куда то (оно же из формы попадает в базу) это ПОСТ
    public String saveMeals(@ModelAttribute("save") Meal meal, int userId) {
        service.create(meal, userId);
        return "redirect:/meals";
    }

    @PostMapping("/mealForm")
    //Если нужно обновить что то в базе (оно же из формы попадает в базу) это ПОСТ
    public String updateMeals(@ModelAttribute("update") Meal meal, int userId) {
        service.update(meal, userId);
        return "redirect:/meals";
    }

    @GetMapping("/meals")
    ////Если нужно удалить что то в базе (оно же из формы попадает в базу) это ПОСТ
    public String deleteMeals(@ModelAttribute("delete") int id, int userId) {
        service.delete(id, userId);
        return "redirect:/meals";
    }
}
