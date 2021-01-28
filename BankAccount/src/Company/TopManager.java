package Company;

import java.util.Scanner;

public class TopManager extends Operator

{
    public TopManager()
    {
        fixPrice = 100000 - 30000 * Math.random();
        monthSalary = getMonthSalary();
    }


    @Override
    public double getMonthSalary() {
        if (income > 10000000) {
            monthSalary = fixPrice + fixPrice * 1.5;
        } else {
            monthSalary = fixPrice;
        }
        return monthSalary;

    }
}