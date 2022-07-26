public class Main {
    public static void main(String[] args) {
        Basket vasyaBasket = new Basket();
        vasyaBasket.add("Молоко", 67, 8, 1000);
        vasyaBasket.add("Хлеб ", 5,4,890);


        Basket petyaBasket = new Basket();
        petyaBasket.add("Лопата",67);
        petyaBasket.add("Бочка", 67,2, 678);


        Basket mashaBasket = new Basket();
        mashaBasket.add("milk", 76, 1, 900);
        mashaBasket.add("bread", 6, 10, 50);
        mashaBasket.add("butter", 32, 4, 56);

        vasyaBasket.print("Корзина Васи:" );
        petyaBasket.print("Корзина Пети:");
        mashaBasket.print("Корзина Маши : ");


        Arifmetic arifmetic = new Arifmetic(10,2);

        System.out.println(arifmetic.sum());
        System.out.println(arifmetic.maxNumber());
        System.out.println(arifmetic.multiplication());







    }
}
