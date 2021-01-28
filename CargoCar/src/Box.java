public class Box
{
    public static int numberBox;
    public Box()
    {
        numberBox++;
    }

    public void fillBox()
    {
        if(numberBox <= Main.boxCount)
        {
            System.out.println("          Ящик №: " + numberBox);
        }

    }
}
