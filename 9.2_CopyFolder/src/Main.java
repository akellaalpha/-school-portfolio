import java.io.*;
import java.nio.file.*;
import java.sql.SQLOutput;
import java.util.*;

import java.io.File;
import java.nio.file.Files;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class Main
{
    static Scanner scanner = new Scanner(System.in);
    static String path = "C:/Users/USER/Desktop/Test";
    static String copyPath = "C:/Users/USER/Desktop/copyTest";
    static int index;
    static File originFile;
    static File copyDirectory;



    public static void main(String[] args)
    {
        System.out.println("Введите путь к фаилу или папке который вы хотите скопировать \n" +
                "Если это фаил, не забудте в конце поставить расширение через точку, хотя вы и сами все знаете))): ");
        path = scanner.nextLine();
        originFile = new File(path);
        if (originFile.exists()) {
            System.out.println("Введите путь к папке куда вы хотите вставить скопированный элемент: ");
            copyPath = scanner.nextLine();
            copyDirectory = new File(copyPath);
            if (copyDirectory.isDirectory()) {
                String[] pathEnd = path.split("[\\\\/]");
                String lastAnd = pathEnd[pathEnd.length - 1];
                String lastString1 = "/";
                String lastString2 = "\\";
                index = path.lastIndexOf(lastString1);
                if (index < 0) {
                    index = path.lastIndexOf(lastString2);
                }
                if (originFile.isDirectory()) {
                    File writer = new File(copyPath + "/" + lastAnd);
                    writer.mkdir();
                    recursionCopy();
                } else {
                    File copied = new File(copyPath + "/" + lastAnd);
                    try(FileInputStream fileIn = new FileInputStream(originFile);
                        FileOutputStream fileOut = new FileOutputStream(copied)) {

                        //Files.copy(originFile.toPath(), copied.toPath(), StandardCopyOption.REPLACE_EXISTING);

                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = fileIn.read(buffer)) > 0) {
                            fileOut.write(buffer, 0, length);
                        }
                    }
                        catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                System.out.println("Готово.");

            } else System.out.println("Каталога куда вы хотите скопировать не существует.");
        } else System.out.println("Файл или каталог который вы хотите скопировать не существует.");
    }

        static void recursionCopy ()
        {
            File[] listFolder = originFile.listFiles();

            for (File file : listFolder) {

                String pathЕnd = file.getAbsolutePath().substring(index);
                String replacePathEnd = pathЕnd.replace("\\", "/");

                if (file.isDirectory()) {
                    File writer = new File(copyPath + replacePathEnd);
                    writer.mkdir();
                    originFile = new File(String.valueOf(file));
                    recursionCopy();
                } else
                    {
                        File copied = new File(copyPath + replacePathEnd);
                        try(FileInputStream fileIn = new FileInputStream(file);
                        FileOutputStream fileOut = new FileOutputStream(copied))
                        {

                        //Files.copy(file.toPath(),copied.toPath(),StandardCopyOption.REPLACE_EXISTING);

                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = fileIn.read(buffer)) > 0) {
                            fileOut.write(buffer, 0, length);
                        }

                        }
                        catch (IOException e) {
                        e.printStackTrace();
                        }
                    }
            }
        }
}


