package com.devcolibri.testing;

import com.devcolibri.crud.CarService;
import com.devcolibri.entity.Car;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarServiceTest {
    CarService service = new CarService();

    @Test
    public void testSaveRecord() throws Exception {
        //Создаем автомобиль для записи в БД
        Car car1 = new Car();
        car1.setName("BMW");
        car1.setCost(20000);
        car1.setReleaseDate(new Date());

        //Записали в БД
        Car car = service.add(car1);

        //Вывели записанную в БД запись
        System.out.println(car);
    }

    @Test
    public void testDeleteRecord() throws Exception {
        //Создаем автомобиль для записи в БД
        Car car1 = new Car();
        car1.setName("Ferrari");
        car1.setCost(100000);
        car1.setReleaseDate(new Date());

        //Записуем его в БД
        Car car = service.add(car1);

        //Удвлем его с БД
        service.delete(car.getId());
    }

    @Test
    public void testSelect() throws Exception {
        //Создаем автомобиль для записи в БД
        Car car1 = new Car();
        car1.setName("Citroen‎");
        car1.setCost(30000);
        car1.setReleaseDate(new Date());

        //Записываем в БД
        Car car = service.add(car1);

        //Получние с БД Citroen‎
        Car carFromDB = service.get(car.getId());
        System.out.println(carFromDB);
    }

    @Test
    public void testUpdate() throws Exception {
        //Создаем автомобиль для записи в БД
        Car car1 = new Car();
        car1.setName("Lambordshini");
        car1.setCost(5000000);
        car1.setReleaseDate(new Date());

        //Записываем в БД
        car1 = service.add(car1);

        car1.setCost(0);

        //Обновляем
        service.update(car1);

        //Получаем обновленую запись
        Car car2 = service.get(car1.getId());
        System.out.println(car2);
    }

    public void testGetAll(){
        //Создаем автомобиль для записи в БД
        Car car1 = new Car();
        car1.setName("Lexus");
        car1.setCost(300000);
        car1.setReleaseDate(new Date());

        //Создаем автомобиль для записи в БД
        Car car2 = new Car();
        car2.setName("Fiat");
        car2.setCost(20000);
        car2.setReleaseDate(new Date());

        //Создаем автомобиль для записи в БД
        Car car3 = new Car();
        car3.setName("Porsche");
        car3.setCost(458000);
        car3.setReleaseDate(new Date());

        //Сохраняем все авто
        service.add(car1);
        service.add(car2);
        service.add(car3);

        //Получаем все авто с БД
        List<Car> cars = service.getAll();

        //Выводим полученый список авто
        for(Car c : cars){
            System.out.println(c);
        }
    }
}
