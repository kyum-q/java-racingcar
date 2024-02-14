package model;

import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Car {
    private String name;
    private List<CarStatus> statuses;
    public Car(String name) {
        validateNullAndEmpty(name);
        validateNameLength(name);
        this.name = name;
        this.statuses = new ArrayList<>();
    }

    private void validateNullAndEmpty(String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public void forward(){
        statuses.add(CarStatus.FORWARD);
    }
    public void stop(){
        statuses.add(CarStatus.STOP);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(statuses, car.statuses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, statuses);
    }
}
