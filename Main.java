import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("tasks.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));

        Scanner scan = new Scanner(System.in);

        String text;
        int chose;

        do {
            Scanner fileScan = new Scanner(file);

            System.out.println("What you want to do?");
            System.out.println("1. Add task");
            System.out.println("2. Show tasks");
            System.out.println("9. Exit");
            chose = scan.nextInt();
            scan.nextLine();

            switch (chose) {
                case 1 -> {
                    do {
                        System.out.println("Put here your task: ");
                        text = scan.nextLine();

                        writer.write(text + "\n");
                    } while (!text.isBlank());
                    writer.close();
                }
                case 2 -> {
                    System.out.println("Your tasks");
                    while (fileScan.hasNext()) {
                        String data = fileScan.nextLine();
                        System.out.println(data);
                    }
                    fileScan.close();
                }
            }
        } while (chose != 9);
    }
}