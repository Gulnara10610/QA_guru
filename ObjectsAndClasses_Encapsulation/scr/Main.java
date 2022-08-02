import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Elevator elevator = new Elevator(-3, 26);
        while (true) {
            System.out.println("Введите номер этажа : ");
            int floor = new Scanner(System.in).nextInt();
            elevator.move(floor);
        }

        Dimensions dimensions = new Dimensions(89, 9,87);

        Cargo cargo = new Cargo(dimensions, 56, "Санкт-Петербург, Невский пр. д 76", true, "456677", false, dimensions);
        System.out.println("Информация о грузе : " + "\n"
                + "Вес" + cargo.getWeight() + "\n"
                + "Адрес доставки" + cargo.getDeliveryAddress() + "\n"
                + "Можно переворачивать" + cargo.isPropertyIsFlip() + "\n"
                + "Регистрационный номер" + cargo.getRegistrationNumber() + "\n"
                + "Хрупкость" + cargo.isPropertyIsFlip() + "\n"
                + "Обьем груза" + cargo.getDimensions());


    }





}

