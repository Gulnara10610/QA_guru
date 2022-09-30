package practice;

import java.util.Scanner;

public class TrucksAndContainers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //получение количество коробок от пользователя
        int boxes = scanner.nextInt();
        int boxInContainer = 27;
        int containerForTruck = 12;
        int countContainer = 0;
        int countTruck = 0;
        if (boxes >= 0) {
            for (int i = 1; i <= boxes; i++) {
                if (i % (containerForTruck * boxInContainer) == 1) {
                    countTruck++;
                    System.out.println("Грузовик: " + countTruck);
                }
                if (i % boxInContainer == 1) {
                    countContainer++;
                    System.out.println("\t\tКонтейнер: " + countContainer);
                }
                System.out.println("\t\tЯщик: " + i);
            }
        }


        System.out.println("Необходимо : " + System.lineSeparator() +
                "\nгрузовиков" + countTruck +
                "\n" + "контейнеров" + countContainer + "шт");


    }
}