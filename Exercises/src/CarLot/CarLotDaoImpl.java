package CarLot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarLotDaoImpl {
    private Map<String, Car> cars = new HashMap<>();

    public void addCar(String VIN, Car car) {
        cars.put(VIN, car);
    }
    public Car getCar(String VIN) {
        return cars.get(VIN);
    }
    public Car removeCar(String VIN) {
        return cars.remove(VIN);
    }
    public void editCar(String VIN, Car car) {
        cars.put(VIN, car);
    }
    public List<Car> getCars() {
        return new ArrayList<>(cars.values());
    }
}
