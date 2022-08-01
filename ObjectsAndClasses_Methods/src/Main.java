public class Main {
    public static void main(String[] args) {
        Basket vasyaBasket = new Basket();
        vasyaBasket.add("Вода", 6, 8, 10);
        vasyaBasket.add("Яйца ", 5,89,8);


        Basket petyaBasket = new Basket();
        petyaBasket.add("Пила",67,5, 9);
        petyaBasket.add("Бочка", 67,2, 678);


        Basket mashaBasket = new Basket();
        mashaBasket.add("milk", 6, 1, 900);
        mashaBasket.add("bread", 6, 1, 50);
        mashaBasket.add("butter", 3);

        vasyaBasket.print("Корзина Васи:");
        System.out.println("Общий вес " +  vasyaBasket.getTotalWeight());
        petyaBasket.print("Корзина Пети:");
        System.out.println("Общая стоимость - " + petyaBasket.getTotalPrice() + "Общий вес " + petyaBasket.getTotalWeight());
        mashaBasket.print("Корзина Маши : ");
        System.out.println("Общая стоимость - " + mashaBasket.getTotalPrice() + "Общий вес " +  mashaBasket.getTotalWeight());




        Arifmetic arifmetic = new Arifmetic(10,2);

        System.out.println(arifmetic.sum());
        System.out.println(arifmetic.maxNumber());
        System.out.println(arifmetic.multiplication());







    }
}
