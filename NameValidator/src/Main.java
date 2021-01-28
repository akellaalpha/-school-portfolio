import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        int wordCount;
        String surname;
        String name;
        String patronymic;
        String fio;
        String letter;

        do {
            do {
                System.out.print("Введите пожалуйста ФИО через пробел .\n Пример: Иванов Иван Иванович\n Ваше ФИО: ");
                Scanner scanner = new Scanner(System.in);
                fio = scanner.nextLine();
                wordCount = fio.split(" ").length;

                if (wordCount != 3) {
                    System.out.println("ФИО введено неправильно попробуйте еще раз");
                }
            }
            while (wordCount != 3);

            fio = fio.replaceAll("[^a-z|а-я|А-Я|A-Z| +|]", "");
            String[] division = fio.split(" +");

            for (int i = 0; i < division.length; i++) {
                if (i == 0) {
                    System.out.print("Фамилия: ");
                }
                if (i == 1) {
                    System.out.print("Имя: ");
                }
                if (i == 2) {
                    System.out.print("Отчество: ");
                }
                System.out.println(division[i]);
            }
            System.out.println("Все верно нажмите Y\n не верно нажмите любую букву: ");
            Scanner scanner = new Scanner(System.in);
            letter = scanner.nextLine();

        }
        while (!(letter.equals("Y") | letter.equals("y")));
        System.out.println("Всего хорошего!");

    }
}
