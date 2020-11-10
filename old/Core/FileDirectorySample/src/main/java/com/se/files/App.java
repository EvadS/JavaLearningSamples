package com.se.files;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {

    private static final String RootFolder = "node";
    private static final String SourceFolder = "cordApp";
    private static final String DestinationFolder = "storage";

    public static void main(String[] args) {

        // создаем объект File для каталога
        File sourceDirectory = new File(RootFolder + "/" + SourceFolder);
        File destinationDirectory = new File(RootFolder + "/" + DestinationFolder);

        sourceDirectory.mkdirs();

        if (destinationDirectory.exists() && destinationDirectory.isDirectory()) {
            //clear
            clearDirectory(destinationDirectory);
        } else if (!destinationDirectory.exists()) {
            destinationDirectory.mkdirs();
        }


        initialize(sourceDirectory.getName());

        String copiedFileName1 = "1.jar";
        String copiedFileName2 = "3.jar";
        String copiedFileName4 = "4.jar";

        List<String> copierdFiles = new ArrayList<>();
        copierdFiles.add(copiedFileName1);
        copierdFiles.add(copiedFileName2);

        try {
            copyFiles(copierdFiles);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        String dirFrom = RootFolder + "/" + SourceFolder;
        String dirTo = RootFolder + "/" + DestinationFolder;


        try {
            copyFile(copiedFileName4, dirFrom, dirTo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("Hello World!");
    }

    private static void initialize(String sourceDirectory) {
        List<String> filesNameList = new ArrayList<>();

        filesNameList.add(RootFolder + "/" + sourceDirectory + "/" + "1.jar");
        filesNameList.add(RootFolder + "/" + sourceDirectory + "/" + "2.jar");
        filesNameList.add(RootFolder + "/" + sourceDirectory + "/" + "3.jar");
        filesNameList.add(RootFolder + "/" + sourceDirectory + "/" + "4.jar");

        for (String fileName : filesNameList) {
            File file = new File(fileName);

            try {
                file.createNewFile();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private  void clearDirectory(File dir) {
        for (File file : dir.listFiles())
            if (!file.isDirectory())
                file.delete();
    }


    private static void copyFiles(List<String> files) throws IOException {
        File dirFrom = new File(RootFolder + "/" + SourceFolder);
        File dirTo = new File(RootFolder + "/" + DestinationFolder);

        for (String fileName : files) {
            //Определяем файл
            File file = new File(dirFrom + "/" + fileName);

            if (!file.exists()) {
                throw new FileNotFoundException(file.getName());
            }


            Files.copy(file.toPath(),
                    (new File(dirTo + "/" + file.getName())).toPath(),
                    StandardCopyOption.REPLACE_EXISTING);
        }
    }

    private  void copyFile(String fileName, String dirFrom, String dirTo) throws IOException {
         File file = new File(dirFrom + "/" + fileName);

        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }

        Files.copy(file.toPath(), (new File(dirTo + "/" + file.getName())).toPath(),
                StandardCopyOption.REPLACE_EXISTING);

    }

    public static void copyFiles(File from, File to) throws IOException {

    }

    public void listFilesForFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                System.out.println(fileEntry.getName());
            }
        }
    }


    private static String text = "This new text \nThis new text2\nThis new text3\nThis new text4\n";
    private static String fileName = "C://blog/a.txt";

    public static void write(String fileName, String text) {
        //Определяем файл
        File file = new File(fileName);

        try {
            //проверяем, что если файл не существует то создаем его
            if (!file.exists()) {
                file.createNewFile();
            }

            //PrintWriter обеспечит возможности записи в файл
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                //Записываем текст у файл
                out.print(text);
            } finally {
                //После чего мы должны закрыть файл
                //Иначе файл не запишется
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static String read(String fileName) throws FileNotFoundException {
        //Этот спец. объект для построения строки
        StringBuilder sb = new StringBuilder();

        exists(fileName);

        try {
            //Объект для чтения файла в буфер
            File file = null;
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                //В цикле построчно считываем файл
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                //Также не забываем закрыть файл
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Возвращаем полученный текст с файла
        return sb.toString();
    }

    public static void delete(String nameFile) throws FileNotFoundException {
        exists(nameFile);
        new File(nameFile).delete();
    }


    private static void exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }
    }
}
