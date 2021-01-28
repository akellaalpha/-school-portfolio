import Company.Company;
import Company.Operator;
import Company.Manager;
import Company.TopManager;
import jdk.swing.interop.SwingInterOpUtils;
import org.w3c.dom.ls.LSOutput;

import java.util.Collections;
import java.util.Scanner;

public class Main
{
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args)
    {
        Company orion = new Company(8000000 + 4000000 * Math.random(), "Orion");
        Company leo = new Company(8000000 + 4000000 * Math.random(), "Leo");
        for ( String command = "noExit" ;!command.equals("EXIT") ; )
        {

            System.out.print
                    ("========================================\n " +
                            "Введите пожалуйста команду: \n" +
                            "========================================\n " +
                            "ORION    ------ Меню компании Орион \n " +
                            "LEO      ------ Меню компании Лев \n " +
                            "EXIT     ------ Выход  \n" +
                            "========================================\n: ");
            command = scanner.nextLine();
            if (command.equals("ORION"))
            {
            companyOperations(orion);
            }
            if (command.equals("LEO"))
            companyOperations(leo);
        }
    }

    public static void companyOperations(Company company)
    {

        for ( String command0 = "noExit" ;!command0.equals("EXIT") ; )
        {
            System.out.print
                    ("========================================\n " +
                            "Вы находитесь в меню компании: " + company.getName() + "\n " +
                            "Введите пожалуйста команду: \n" +
                            "========================================\n " +
                            "OPER    ------ Нанять одного или несколько операторов \n " +
                            "MEN     ------ Нанять одного или несколько менеджеров \n " +
                            "TOPMEN  ------ Нанять одного или несколько топменеджеров \n " +
                            "FIRE    ------ Уволить одного сотрудника \n " +
                            "FIRE50  ------ Уволить 50% сотрудников рандомно \n " +
                            "SAL     ------ Узнать зарплату сотрудника \n " +
                            "INCOM   ------ Узнать доход компании \n " +
                            "LIST    ------ Получить количество сотрудников \n " +
                            "TOP     ------ Сотрудники с самой высокой зарплатой по убыванию \n " +
                            "LOW     ------ Сотрудники с самой низкой зарплатой по возрастанию\n " +
                            "EXIT    ------ Выход  \n" +
                            "========================================\n: ");
            command0 = scanner.nextLine();
            Scanner scanner = new Scanner(System.in);

            if (command0.equals("OPER"))
            {
                System.out.print("Введите сколько сотрудников нанять: ");
                int command1 = scanner.nextInt();
                for (int i = 0; i < command1; i++)
                {
                    company.hire(new Operator());
                }
            }
            if (command0.equals("MEN")) {
                System.out.print("Введите сколько сотрудников нанять: ");
                int command1 = scanner.nextInt();
                for (int i = 0; i < command1; i++)
                {
                    company.hire(new Manager());
                }
            }
            if (command0.equals("TOPMEN")) {
                System.out.print("Введите сколько сотрудников нанять: ");
                int command1 = scanner.nextInt();
                for (int i = 0; i < command1; i++)
                {
                    company.hire(new TopManager());
                }
            }
            if (command0.equals("FIRE"))
            {
                System.out.print("Введите номер сотрудника которого хотите уволить: ");
                int command1 = scanner.nextInt();
                company.fire(command1);
            }
            if (command0.equals("FIRE50"))
            {
                company.fireFifty();
            }
            if (command0.equals("SAL"))
            {
                System.out.print("Введите номер сотрудника зарплату которого хотите узнать: ");
                int command1 = scanner.nextInt();
                company.monthSalary(command1);
            }
            if (command0.equals("TOP"))
            {
                System.out.println("Введите количество сотрудников: ");
                int count = scanner.nextInt();
                company.getTopSalaryStaff(count);
            }
            if (command0.equals("LOW"))
            {
                System.out.println("Введите количество сотрудников: ");
                int count = scanner.nextInt();
                company.getLowestSalaryStaff(count);
            }
            if (command0.equals("INCOM"))
            {
                System.out.print("Доход компании составляет: ");
                System.out.printf("%.2f", company.getIncome());
                System.out.print(" руб. \n");
            }
            if (command0.equals("LIST"))
            {
                System.out.println("Количество сотрудников в компании: " + company.getlistSize());
            }
        }
    }
}
