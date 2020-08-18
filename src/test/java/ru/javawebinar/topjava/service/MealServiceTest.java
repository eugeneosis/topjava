package ru.javawebinar.topjava.service;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.javawebinar.topjava.repository.MealRepository;

import static ru.javawebinar.topjava.MealTestData.MEAL_ADMIN_ID;
import static ru.javawebinar.topjava.MealTestData.MEAL_ID;


@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class MealServiceTest {

    static {

        SLF4JBridgeHandler.install();
    }

    @Autowired
    private MealService service;

    @Autowired
    private MealRepository repository;


    public void get() {
    }

    @Test
    public void delete() {
        service.delete(MEAL_ID, MEAL_ADMIN_ID);
        Assert.assertNull(repository.get(MEAL_ID, MEAL_ADMIN_ID));
    }

    @Test
    public void getBetweenInclusive() {
    }

    @Test
    public void getAll() {
    }

    public void testUpdate() {
    }

    @Test
    public void create() {
    }
}