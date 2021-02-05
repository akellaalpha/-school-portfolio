import core.*;
import core.TransportFactory;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("""
                ========================================
                 Введите типы транспорта:\s
                ========================================
                 0    ------ Мотоцикл\s
                 1    ------ Самокат\s
                 2    ------ Автомобиль \s
                 3    ------ Автобус \s
                ========================================:\s""");

        Scanner scanner = new Scanner(System.in);
        String allTransportNumber = scanner.nextLine();

        allTransportNumber = allTransportNumber.replaceAll("[^0-9]", "");

        for
        (int i = 0; i < allTransportNumber.length(); i++)
        {
            Car car = TransportFactory.getNextCar(allTransportNumber.charAt(i));
            System.out.println(car);

        }
         /*
         //Если надо делить виды транспорта по пробелам и значение 2-х значные
         //здесь может быть что-то вроде:
         for (String transportNumber : allTransportNumber.split(" ")) {
            Car car = TransportFactory.getNextCar(transportNumber);
            System.out.println(car);
         //соответственно в методе getNextCar будет параметр типа String
         }*/

    }
}
