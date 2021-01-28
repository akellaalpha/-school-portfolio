public class Container
{
    public static int maxCountBox;
    public static int numberContainer;

    public Container()
    {
        numberContainer++;
    }

    public void fillContainer()
    {
        if(Box.numberBox < Main.boxCount)
        {
        System.out.println("   Контейнер: " + numberContainer);
           for(int i = 0; i < maxCountBox; i++)
           {
            Box box = new Box();
            box.fillBox();
           }
        }
        /*else
            { System.out.println(" Больше ящиков в контейнере №: " + numberContainer + " нет");

            }*/
    }
}



