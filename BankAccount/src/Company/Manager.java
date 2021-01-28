package Company;

import com.sun.tools.javac.Main;

import java.util.Scanner;

public class Manager extends Operator
{
    public Manager()
    {

        fixPrice = Math.random();
        monthSalary = getMonthSalary();
    }

    // 50000 + income/200 * Math.random() * 0.05;
    @Override
    public double getMonthSalary() {

        return fixPrice * (income / 200) * 1.05;
    }
}
