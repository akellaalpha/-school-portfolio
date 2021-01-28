import java.util.Scanner;

public class Cat
{
    public static final int EYES_COUNT = 2;
    public static final double MIN_WEIGHT = 1000.0;
    public static final double MAX_WEIGHT = 9000.0;
    private double amountWeight;
    private double originWeight;
    private double weight;
    private boolean life;
    public static int count = 0;
    private CatColor color;
    public String name;


    public Cat()
    {
        life = true;
        amountWeight = 0;
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        count++;
    }

    public Cat(double weight)
    {
        this();
        this.weight = weight;
        delCount();
    }

    public Cat copyCat()
    {
        Cat caty = new Cat();
        caty.setWeight(getWeight());
        caty.setName(getName());
        caty.setCatColor(getCatColor());
        caty.setStatus();
        if (!life){
            delCount();
            System.out.println("По вашей просьбе мертвый кот скопирован");
        }
        System.out.println("Кошка " + caty.getName() + " скопирована, вес копии " + caty.getWeight() + ", цвет копии: " + caty.getCatColor());
        return caty;
    }

    public Cat newCat()
    {
        Cat newys = new Cat(2000);
        newys.delCount();
        newys.getStatus();
        System.out.println("Создана кошка " + "Newy" + " она весит: " + newys.getWeight());
        return newys;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public String setStatus()
    {
        return getStatus();
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    public void setCatColor(CatColor color)
    {
        this.color = color;
    }

    public CatColor getCatColor()
    {
        return color;
    }

    public int getCount()
    {
        return Math.max(count, 0);
    }

    public Double getWeight()
    {
        return weight;
    }

    public Double foodWeight()
    {
        return amountWeight;
    }

    private void delCount()
    {
        if(weight < MIN_WEIGHT || weight > MAX_WEIGHT)
        {count--;}
    }

    public void meow()
    {
        if (life) {
            weight = weight - 1;
            System.out.print("Meow ");
            delCount();
            getStatus();
        }
        else {

            System.out.println("Мертвые не мяукают"); }

    }

    public void feed(Double amount)
    {
        if (life)
        {
            weight = weight + amount;
            amountWeight = amountWeight + amount;
            delCount();
            getStatus();
        }
        else {
            System.out.println("Мертвые не едят");}

    }

    public void drink(Double amount)
    {
        if (life) {
            weight = weight + amount;
            amountWeight = amountWeight + amount;
            delCount();
            getStatus();
        }
        else {System.out.println("Мертвые не пьют");}

    }

    public void gotoToilet()
    {
        if(life) {
            weight = weight - (30 + 100 * Math.random());
            System.out.println("сходил(а) в туалет, вес животного составляет: " + weight);
            delCount();
            getStatus();

        }
        else {System.out.println("Мертвые не гадят");}

    }

    public  String getStatus()
    {
        if(weight < MIN_WEIGHT) {
            life = false;
            return "DEAD";
        }
        else if(weight > MAX_WEIGHT) {
            life = false;
            return "EXPLODED";
        }
        else if(weight > originWeight) {
            return "SLEEPING";
        }
        else {
            return "PLAYING";
        }
    }
}