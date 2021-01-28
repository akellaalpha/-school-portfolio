public class Loader
{
    public static void main(String[] args)
    {
        Cat snow = new Cat();
        System.out.println("Создали кошку");
        System.out.println("Количество живых кошек: " + snow.getCount());
        while (snow.getWeight() > Cat.MIN_WEIGHT)
        {
            snow.meow();
        }
        System.out.println();
        System.out.println("Смерть в результате истощения от мяуканья.");
        System.out.println("Количество живых кошек: " + snow.getCount());
        System.out.println("\n========================================================================\n");

        Cat pes = new Cat();
        System.out.println("Создали кошку.");
        System.out.println("Количество живых кошек: " + snow.getCount());
        while (pes.getWeight() > Cat.MIN_WEIGHT)
        {
            System.out.print("Кот Пес ");
            pes.gotoToilet();
        }
        System.out.println("Умерла от дезентирии.");
        System.out.println("Количество живых кошек: " + snow.getCount());
        System.out.println("\n========================================================================\n");

        Cat gargantua = new Cat();
        gargantua.setName("Gargantua");
        gargantua.setCatColor(CatColor.RED);
        System.out.println("Создали кошку.");
        System.out.println("Количество живых кошек: " + snow.getCount());
        while (gargantua.getWeight() < Cat.MAX_WEIGHT)
        {
            gargantua.feed(30 + 100 * Math.random());
        }
        System.out.println("Вес кошки Gargantua: " + gargantua.getWeight());
        System.out.println("Gargantua съел: " + gargantua.foodWeight());
        System.out.println("Взрыв в результате переедания.");
        System.out.println("Количество живых кошек: " + snow.getCount());
        System.out.println("\n========================================================================\n");

        Cat lucky = new Cat();
        lucky.setName("Lucky");
        lucky.setCatColor(CatColor.BLACK);
        System.out.println("Создали черную кошку Счастливчика.");
        System.out.println("Количество живых кошек: " + snow.getCount());
        System.out.println("\n========================================================================\n");

        Cat pushock = new Cat(10000);
        System.out.println("Создали слишком жирную кошку.");
        System.out.println("Cостояние кошки Pushock: " + pushock.getStatus());
        System.out.println("Количество живых кошек: " + snow.getCount());
        System.out.println("\n========================================================================\n");

        Cat newy = lucky.newCat();
        System.out.println("Создали кошку через метод через конструктор с заданным весом.");
        System.out.println("Состояние созданной кошки Newy: " + newy.getStatus());
        System.out.println("Количество живых кошек: " + snow.getCount());
        System.out.println("\n========================================================================\n");

        System.out.println("Цвет кошки Luсky: " + lucky.getCatColor());
        System.out.println("Вес кошки Lucky: " + lucky.getWeight());
        Cat copyr = lucky.copyCat();
        System.out.println("Cостояние скопированной кошки Copyr: " + copyr.getStatus());
        System.out.println("Количество живых кошек: " + snow.getCount());
        System.out.println("\n========================================================================\n");

        Cat looser = gargantua.copyCat();
        System.out.println("Cостояние скопированной кошки Looser: " + looser.getStatus());
        System.out.println("Количество живых кошек: " + snow.getCount());
        System.out.println("\n========================================================================\n");



    }





}






