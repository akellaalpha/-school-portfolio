import java.util.Date;

public class Transaction
{
    private String name;
    private double income;
    private double consumption;
    //private Date workStart;

    public Transaction(String name, double income, double consumption)
    {
        this.name = name;
        this.income = income;
        this.consumption = consumption;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getConsumption() { return consumption; }

    public void setConsumption(double consumption) { this.consumption = consumption; }

    /*public Date getWorkStart() {
        return workStart;
    }

    public void setWorkStart(Date workStart) {
        this.workStart = workStart;
    }*/

    public String toString()
    {
        return name + " - " + consumption + " - " + income;
    }
} 