package core;

public class KickScooter extends core.Car
{
    public KickScooter()
    {
        name = "Самокат";
        numberWheels =  2 + (int) (2*Math.random());
        maxSpeed = (int) (10 + 20 * Math.random());
    }
}
