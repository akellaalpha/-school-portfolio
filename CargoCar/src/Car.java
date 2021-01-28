public class Car
{
    public static int maxCountContainer;
    public static int numberCar = 0;

    public Car()
    {
        numberCar++;
    }

    public void fillCar()
    {
        System.out.println("Грузовик: " + numberCar);
        for(int i = 0; i < maxCountContainer; i++)
        {
            Container container = new Container();
            container.fillContainer();
        }
    }
}
