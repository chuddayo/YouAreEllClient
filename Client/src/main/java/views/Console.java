package views;

import java.util.List;
import java.util.Scanner;

public class Console {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getStringInput(String prompt) {
        println(prompt);
        return scanner.nextLine();
    }

    public static void print(String output, Object... args) {
        System.out.printf(output, args);
    }

    public static void println(String output, Object... args) {
        print(output + "\n", args);
    }

    public static <E> void prettyPrint(E output) {
        Console.println(output.toString());
    }

    public static <E> void prettyListPrint(List<E> objectList) {
        for (E element : objectList) {
            Console.println(element.toString());
        }
    }
}
