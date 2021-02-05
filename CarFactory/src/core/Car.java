package core;

import java.util.Random;

public class Car
{
    public String name = "Автомобиль";
    public int maxSpeed = (int) (100 + 200 * Math.random());
    public int numberWheels = 4;
    String[] uniqueParameters = {"Умеет разговаривать", "Светится в темноте", "Работает на электричестве", "Без ГМО"};
    int rnd = new Random().nextInt(uniqueParameters.length);
    public String rndUniqueParameters = uniqueParameters[rnd];

    @Override
    public String toString()
    {
        return "\n=========================================\n" +
                "\n\tНаименование транспорта: " + name +
                "\n\tКоличество колес: " + numberWheels + " \n\tМаксимальная скорость: " + maxSpeed + " км/ч" + " \n\tУникальные характеристики: " + rndUniqueParameters ;
    }
}