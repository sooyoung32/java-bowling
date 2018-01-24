package bowling;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("플레이어 이름은? (3 english letters)? ");
        String playerName = scanner.next();
        getBoard(playerName);

        for (int i = 0; i < 10; i++) {
            System.out.print("    |");
        }

        String before = "";
        for (int i = 1; i <= 10; i++) {
            int pin = printBoard(scanner, playerName, i);
            if (pin == 10) {
                before += "  X |";
                System.out.print(before);
            }

            if (pin != 10) {
                String frameResult = " " + pin + "  |";
                System.out.print(before + frameResult);
                printEmpty(i);
                int secondPin = printBoard(scanner, playerName, i);
                if (pin + secondPin == 10) {
                    System.out.print(before += " " + pin + "|/|");
                } else {
                    System.out.print(before += " " + pin + "|" + secondPin + "|");
                }

            }
            printEmpty(i);

        }

    }

    private static void printEmpty(int i) {
        for (int j = 0; j < 10 - i; j++) {
            System.out.print("    |");
        }
    }

    private static int printBoard(Scanner scanner, String playerName, int i) {
        System.out.println();
        System.out.println(i + " 번 프레임 투구 : ");
        int pin = scanner.nextInt();
        getBoard(playerName);
        return pin;
    }

    private static void getBoard(String playerName) {
        String table = "| NAME |";
        for (int i = 1; i <= 10; i++) {
            if (i == 10) {
                table += " " + i + " |";
            } else {
                table += " 0" + i + " |";
            }

        }
        System.out.println(table);
        String result = "| " + playerName + " |";
        System.out.print(result);
    }
}
