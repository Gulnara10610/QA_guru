package practice;

import java.util.Scanner;

public class TrucksAndContainers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //получение количество коробок от пользователя
        int boxes = scanner.nextInt();

        // TODO: вывести в консоль коробки разложенные по грузовикам и контейнерам
        // пример вывода при вводе 2
        // для отступа используйте табуляцию - \t

        /*
        Грузовик: 1
            Контейнер: 1
                Ящик: 1
                Ящик: 2
        Необходимо:
        грузовиков - 1 шт.
        контейнеров - 1 шт.
        */

        int minCountBoxForContainer = 27;
        int minCountForTruck = 12;
        int countContainer = 0;
        int countTruck = 0;


        countContainer = boxes / minCountBoxForContainer + (boxes % minCountBoxForContainer
                == 0 ? 0 : 1);


        countTruck = countContainer / minCountForTruck + (countContainer % minCountForTruck
                == 0 ? 0 : 1);


        for (int i = 1; i <= countTruck; i++) {
            System.out.println("Грузовик: " + i );

            for (int a = 1; a <= countContainer; a++) {
                System.out.println( "\t" + "Контейнер : " + a );
            }
            for (int b = 1; b <= boxes; b++){
                System.out.println("\t" + "\t" + "Ящик : " + b);
            }


        }

        System.out.println("Необходимо : " + "\n" + "\n" + "грузовиков" + countTruck + "\n" + "контейнеров" + countContainer);


    }
}