public class Arifmetic {
    int a = 0;
    int b = 0;


    public Arifmetic(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int sum(int a, int b) {

        return a + b;
    }

    public int multiplication(int a, int b) {
        return a * b;
    }

    public int maxNumber(int a, int b) {
        if (a < b) {
            return b;

        } else {
            return a;
        }


    }

    public int minNumber(int a, int b) {
        if (a > b) {
            return b;
        } else if (a == b) {
            return a;

        } else {
            return a;
        }


    }
}