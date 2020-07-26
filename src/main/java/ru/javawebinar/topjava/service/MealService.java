package ru.javawebinar.topjava.service;

import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.to.MealTo;

import java.util.Collection;

@Service
public class MealService {

    private final MealRepository repository;

    public MealService(MealRepository repository) {
        this.repository = repository;
    }
    public Meal create(Meal meal) {
        return repository.save(meal);
    }

    public boolean delete(Meal meal) {
        return repository.delete(meal.getId());
    }

    public Meal get(int id) {
        return repository.get(id);
    }

    public Collection<Meal> getAll() {
        return repository.getAll();
    }
}
