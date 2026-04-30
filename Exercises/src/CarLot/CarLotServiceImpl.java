package CarLot;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class CarLotServiceImpl implements CarLotService {
    private CarLotDAO dao ;
    public CarLotServiceImpl(CarLotDAO dao) {
        this.dao = dao;
    }
    public Car getACar(String VIN) {
        return dao.getCar(VIN);
    }
    public List<Car> getAllCars() {
        return dao.getCars();
    }
    public List<Car> getCarsByColor(String color) {
        List<Car> result = new ArrayList<>();
        for (Car car : dao.getCars()) {
            if (car.getColor().equalsIgnoreCase(color)) {
                result.add(car);
            }
        }
        return result;
    }
    public List<Car> getCarsInBudget(BigDecimal maxPrice) {
        List<Car> result = new ArrayList<>();
        for (Car car : dao.getCars()) {
            if (maxPrice.compareTo(car.getPrice()) > 0) {
                result.add(car);
            }
        }
        return result;
    }
    public List<Car> getCarByMakeAndModel(String make, String model) {
        List<Car> result = new ArrayList<>();
        for (Car car : dao.getCars()) {
            if (car.getMake().equalsIgnoreCase(make) &&
                    car.getModel().equalsIgnoreCase(model)) {
                result.add(car);
            }
        }
        return result;
    }

    public BigDecimal discountCar(String VIN, BigDecimal percentDiscount)
            throws NoSuchCarException {

        Car car = dao.getCar(VIN);

        // No car found — throw NoSuchCarException
        if (car == null) {
            throw new NoSuchCarException("No car found with VIN: " + VIN);
        }

        // Calculate discount amount: price * (percent / 100)
        BigDecimal discountAmount = car.getPrice()
                .multiply(percentDiscount)
                .divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP);

        // Apply discount and update the car's price
        BigDecimal newPrice = car.getPrice().subtract(discountAmount);
        car.setPrice(newPrice);
        dao.editCar(VIN, car);

        return newPrice;
    }

    public CarKey sellCar(String VIN, BigDecimal cashPaid)
            throws NoSuchCarException, OverpaidPriceException, UnderpaidPriceException {

        Car car = dao.getCar(VIN);

        // No car found — throw NoSuchCarException
        if (car == null) {
            throw new NoSuchCarException("No car found with VIN: " + VIN);
        }

        BigDecimal price = car.getPrice();
        int comparison = cashPaid.compareTo(price);

        if (comparison > 0) {
            // Paid too much
            throw new OverpaidPriceException(
                    "Overpaid by " + cashPaid.subtract(price),
                    cashPaid.subtract(price));
        } else if (comparison < 0) {
            // Paid too little
            throw new UnderpaidPriceException(
                    "Underpaid by " + price.subtract(cashPaid),
                    price.subtract(cashPaid));
        }

        // Exact amount — remove car from lot and return its key
        dao.removeCar(VIN);
        return car.getKey();
    }
}
