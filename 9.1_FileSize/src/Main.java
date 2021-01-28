import java.io.File;
import java.nio.file.Files;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class Main
{
    static String path = "C:\\Java";
    static long memorySize = 0;

    static File file = new File(path);

    public static void main(String[] args)
    {
        if (file.exists())
        {
            recursionCalculationMemorySize();
            printMemorySize();
        }
        else System.out.println("Такого файла не существует.");
    }

    static void recursionCalculationMemorySize()
    {
        File[] listFolder = file.listFiles();

        if (listFolder != null) {
            for (File value : listFolder) {

                if (value.isDirectory()) {
                    file = new File(String.valueOf(value));
                    recursionCalculationMemorySize();
                } else {
                    memorySize += value.length();
                }
            }
        }
        else
        {
            memorySize += file.length();
        }
    }

    static void printMemorySize()
    {
        final int KB = 1024;
        final int MB = 1048576;
        final int GB = 1073741824;
        if (memorySize < KB)
        {
            System.out.println("Размер файла " + path + " : " + memorySize + " Байт");
        }
        else if (memorySize < MB)
        {
            System.out.println("Размер файла " + path + " : " + memorySize/KB + " кБайт");
        }
        else if (memorySize < GB)
        {
            System.out.println("Размер файла " + path + " : " + memorySize/MB + " мБайт");
        }
        else
        {
            memorySize = (long) (memorySize/(GB/100));
            double newMemorySize = (double) memorySize/100;
            System.out.println("Размер файла " + path + " : " + newMemorySize + " гБайт");
        }

    }
}
