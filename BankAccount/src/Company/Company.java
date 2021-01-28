package Company;

import com.sun.tools.javac.Main;

import java.util.*;

public class Company
{
    Scanner scanner = new Scanner(System.in);

    public double income;
    public String name;
    public ArrayList<Employee> list = new ArrayList<>();

    public Company(double income, String name)
    {
        this.name = name;
        this.income = income;
    }

    public String getName()
    {
        return name;
    }

    //Получение дохода компании
    public double getIncome()
    {
        return income;
    }

    //Кол-во сотрудников
    public int getlistSize()
    {
        return list.size();
    }

    //Найм сотрудника
    public void hire(Operator e)
    {
        e.setIncome(income);
        list.add(e);
    }

    //Увольнение сотрудника
    public void fire(int command1)
    {

        if (command1 < list.size())
        {
            list.remove(command1);
        }
        else{
            System.out.println("Такого сотрудника не существует");
        }
    }

    //Увольнение 50%
    public void fireFifty()
    {
        int fifty = list.size()/2;
        for (int i = 0; i < fifty; i++)
        {
            int delIndex = (int) (Math.random() * list.size());
            list.remove(delIndex);
        }

    }

    //Сортировка
    public void sortList()
    {
        list.sort(Comparator.comparing(Employee::getMonthSalary));
    }

    //Зарплата сотрудника
    public void monthSalary(int command1)
    {
        sortList();
        if (command1 < list.size())
        {
            System.out.println(list.get(command1).getMonthSalary());
        }
        else{
            System.out.println("Такого сотрудника не существует");
        }

    }

    //Самые большие зарплаты
    public void getTopSalaryStaff(int count)
    {
        sortList();
        if (count <= list.size()) {
            Collections.reverse(list);
            List<Employee> topSalaryStaff = list.subList(0, count);
            for (Employee operator : topSalaryStaff) {
                System.out.println(operator.getMonthSalary());
            }
        }
        else {
            System.out.println("В компании не работает столько сотрудников.");
        }
    }

    //Самые маленькие зарплаты
    public void getLowestSalaryStaff(int count)
    {
        sortList();
        if (count <= list.size()) {
            List<Employee> topSalaryStaff = list.subList(0, count);
            for (Employee operator : topSalaryStaff) {
                System.out.println(operator.getMonthSalary());
            }
        }
        else {
            System.out.println("В компании не работает столько сотрудников.");
        }
    }
}

