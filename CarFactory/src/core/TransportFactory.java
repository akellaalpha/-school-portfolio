package core;

public class TransportFactory
{
    public static Car getNextCar(char transportNumber)
    {
        if (transportNumber == '0')
        {
            return new Motorbike();
        }
        if (transportNumber == '1')
        {
            return new KickScooter();
        }
        if (transportNumber == '2')
        {
            return new Car();
        }
        if (transportNumber == '3')
        {
            return new Bus();
        }
        else return new UnknownTransport();


    }
}
