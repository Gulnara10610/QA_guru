public class Basket {

    private static int count = 0;
    private String items = "";
    private int totalPrice = 0;
    private  double totalWeight = 0;
    private int limit;

    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;

    }

    public static int getCount() {

        return count;
    }

    public static void increaseCount(int count) {

        Basket.count = Basket.count + count;
    }

    public void add(String name, int price) {
        add(name, price, 1);
        items = items + "\n" + name + "-" + price;
        totalPrice = totalPrice + price;

        totalWeight = totalWeight;

    }

    public void add(String name, int price, int count) {
        add(name, price, count, 1);
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +
                count + " шт. - " + price;
        totalPrice = totalPrice + count * price;
        totalWeight = totalWeight;
    }

    public void  add(String name, int price, int count, double weight){
        items = items + "\n" + name + " - " + price + " руб." + "\n" + "Стоимость - " +  count + " руб." + "\n" + "Вес - " + weight + " кг";
        totalPrice = totalPrice + price;

        if (weight >0) {
            totalWeight = totalWeight + weight;
        } else
        totalWeight = totalWeight;


    }

    public void clear() {
        items = "";
        totalPrice = 0;
    }

    public int getTotalPrice() {

        return totalPrice;
    }
    public double getTotalWeight(){

        return  totalWeight ;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);

        }
    }
}