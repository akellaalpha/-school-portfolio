import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main
{
    private static final String staffFile = "data/movementList.csv";
    private static double allIncome;
    private static double allConsumption;


    public static void main(String[] args)
    {
        ArrayList<Transaction> staff = loadStaffFromFile();
        //staff.forEach(System.out::println);

        System.out.println("================================================\n");
        System.out.println("Сумма доходов: " + allIncome);
        System.out.println("Сумма расходов: " + allConsumption + "\n");

        sort(staff);
    }

    private static ArrayList<Transaction> loadStaffFromFile()
    {
        ArrayList<Transaction> staff = new ArrayList<>();
        try
        {
            String paymentAddress;
            List<String> lines = Files.readAllLines(Paths.get(staffFile));
            for(String line : lines)
            {
                if (line.contains("\""))
                    {
                    line = line.replace("\"","");
                    int numberLostComma = line.lastIndexOf(",");
                    line = line.substring(0,numberLostComma) + '.' + line.substring(numberLostComma + 1);
                    }

                String[] fragments = line.split(",");

                if (fragments[7].equals("Расход")) continue;

                double income = Double.parseDouble(fragments[6]);
                double consumption = Double.parseDouble(fragments[7]);

                paymentAddress = fragments[5].replaceAll("[0-9.+]|RUR|USD|MCC|EUR|  +","");

                allIncome = allIncome + income;
                allConsumption = allConsumption + consumption;

                staff.add(new Transaction ( paymentAddress, income, consumption ));

            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return staff;
    }

    private static void sort(ArrayList<Transaction> staff)
    {
        for (int i = 0; i < staff.size(); i++ )
        {
            for (int j = i + 1; j < staff.size(); j++ )
            {
                if ((staff.get(i).getName()).equals(staff.get(j).getName()))
                {
                    //staff.get(i).setIncome((staff.get(i).getIncome() + staff.get(j).getIncome()));
                    staff.get(i).setConsumption((staff.get(i).getConsumption() + staff.get(j).getConsumption()));
                    staff.remove(j);
                    j--;
                }
            }
            System.out.println("================================================");
            System.out.println(staff.get(i).getName()  + "\nРасход: " + staff.get(i).getConsumption());
        }
        System.out.println("================================================");
    }
}