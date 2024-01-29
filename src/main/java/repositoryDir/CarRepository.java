package repositoryDir;

import io.spring.guides.gs_producing_web_service.Car;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CarRepository {
    //private static final List<Car> cars = new ArrayList<>();
    private static final Map<Integer, Car> carsMap = new HashMap<>();

    @PostConstruct
    public void initData(){
        Car audi = new Car();
        audi.setId(1);
        audi.setModel("A8");
        audi.setMarkId(1);
        audi.setPrice(40000);
        audi.setModelYear(2007);
        carsMap.put(1,audi);

        Car bmw = new Car();
        bmw.setId(2);
        bmw.setModel("7");
        bmw.setMarkId(2);
        bmw.setPrice(40000);
        bmw.setModelYear(2007);
        carsMap.put(2,bmw);

        Car renault = new Car();
        renault.setId(3);
        renault.setModel("5");
        renault.setMarkId(3);
        renault.setPrice(8000);
        renault.setModelYear(1984);
        carsMap.put(3,renault);
    }


    public Car findCar(int id){
        //Assert.notNull();
        Car c = carsMap.get(id);
        return c;
    }


}
