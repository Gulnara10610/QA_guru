public class Main {
    public static void main(String[] args) {
        Basket vasyaBasket = new Basket();
        vasyaBasket.add("Молоко", 67, 80);
        vasyaBasket.add("Хлеб ", 567,40,890);


        Basket petyaBasket = new Basket(400);
        petyaBasket.add("Лопата",67, 2);
        petyaBasket.add("Бочка", 67,2, 678);


        Basket mashaBasket = new Basket("Стол", 500);

        vasyaBasket.print("Корзина Васи:");
        petyaBasket.print("Корзина Пети:");
        mashaBasket.print("Корзина Маши : ");


        Arifmetic arifmetic = new Arifmetic(10,2);







    }
}
