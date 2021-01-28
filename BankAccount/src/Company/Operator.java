package Company;

import java.util.Scanner;

public class Operator implements Employee {

    protected double fixPrice;
    protected double monthSalary;
    protected double income;
    public Operator()
    {
        monthSalary =  30000 - 5000 * Math.random();
    }

    public void setIncome(double incomeCompany)
    {
        this.income = incomeCompany;
    }



    public double getMonthSalary()
    {
        return monthSalary;
    }




}

