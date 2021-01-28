import java.util.Scanner;

public class Main
{

    public static int boxCount;
    public static int carsCount;
    public static int containerCount;

    public static void main(String[] args)
    {
        System.out.println("Введите число ящиков: ");
        Scanner scanner = new Scanner(System.in);
        boxCount = scanner.nextInt();

        Car.maxCountContainer = 12;
        Container.maxCountBox = 27;

        if(boxCount < 0)
        {
            System.out.println("Вы ввели отрицательно значение, попробуйте еще раз.");
        }

        else {
            if(boxCount % Container.maxCountBox == 0) {
                containerCount = boxCount / Container.maxCountBox;
            }
            else
            {
                containerCount = boxCount / Container.maxCountBox + 1;
            }

            if(containerCount % Car.maxCountContainer == 0)
            {
                carsCount = containerCount / Car.maxCountContainer;
            }
            else {carsCount = containerCount / Car.maxCountContainer + 1;}

            for (int i = 0; i < carsCount; i++) {
                Car car = new Car();
                car.fillCar();
            }

        }
    }
}


