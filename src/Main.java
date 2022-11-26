import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void i(int[][] rotatedColors, int SIZE, int[][] colors, int numb) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (numb == 90) {
                    rotatedColors[i][j] = colors[SIZE - 1 - j][i];
                } else if (numb == 180) {
                    rotatedColors[i][j] = colors[SIZE - 1 - i][SIZE - 1 - j];
                } else if (numb == 270) {
                    rotatedColors[i][j] = colors[j][SIZE - 1 - i];
                } else {
                    System.out.println("не корректный ввод");
                    return;
                }
                System.out.format("%4d", rotatedColors[i][j]);
            }
            System.out.println();
        }
        System.out.println("поворот " + numb + " градусов");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int SIZE = 8;
        int[][] colors = new int[SIZE][SIZE];
        int[][] rotatedColors = new int[SIZE][SIZE];
        System.out.println("у вас есть матрица");
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                colors[i][j] = random.nextInt(256);
            }
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.format("%4d", colors[i][j]);
            }
            System.out.println();
        }
        while (true) {
            System.out.println();
            System.out.println("введи команду из допустимх или end");
            System.out.println("поворот на 90 градусов");
            System.out.println("поворот на 180 градусов");
            System.out.println("поворот на 270 градусов");

            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            } else {
                int numb = Integer.parseInt(input);
                i(rotatedColors, SIZE, colors, numb);
            }
        }
    }
}

