package core;

public class Bus extends Car {
    public Bus()
    {
        name = "Автобус";
        numberWheels = 2 * (2 + (int) (2*Math.random()));
        maxSpeed = (int) (50 + 50 * Math.random());
    }
}
