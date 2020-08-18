package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.javawebinar.topjava.model.AbstractBaseEntity.START_SEQ;

public class MealTestData {

    public static final int NOT_FOUND = 10;
    public static final int MEAL_ID = START_SEQ + 2;
    public static final int MEAL_ADMIN_ID = START_SEQ + 9;

    public static final Meal MEAL1 = new Meal(MEAL_ID, LocalDateTime.of(2020, Month.AUGUST, 30, 10, 0), "breakfast", 500);
    public static final Meal MEAL2 = new Meal(MEAL_ID + 1, LocalDateTime.of(2020, Month.AUGUST, 30, 20, 0), "dinner", 1000);
    public static final Meal MEAL_ADMIN = new Meal(MEAL_ADMIN_ID, LocalDateTime.of(2020, Month.AUGUST, 30, 10, 0), "breakfast", 500);
    public static final Meal MEAL_ADMIN_2 = new Meal(MEAL_ADMIN_ID + 1, LocalDateTime.of(2020, Month.AUGUST, 30, 20, 0), "dinner", 1000);

    public static final List<Meal> MEALS = Arrays.asList(MEAL1, MEAL2, MEAL_ADMIN, MEAL_ADMIN_2);

    public static Meal getNew() {
        return new Meal(null, LocalDateTime.of(2020, Month.AUGUST, 17, 16, 0), "lunch", 650);
    }

    public static Meal getUpdated() {
        return new Meal(MEAL_ID, MEAL1.getDateTime(), "lunch", 700);
    }

    public static void assertMatch(Meal actual, Meal expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected);
    }

    public static void assertMatch(Iterable<Meal> actual, Meal... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Meal> actual, Iterable<Meal> expected) {
        assertThat(actual).usingFieldByFieldElementComparator().isEqualTo(expected);
    }
}
