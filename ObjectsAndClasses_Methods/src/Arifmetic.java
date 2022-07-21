public class Arifmetic {
    int a = 0;
    int b = 0;


    public Arifmetic(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int sum() {

        return a + b;
    }

    public int multiplication() {

        return a * b;
    }

    public int maxNumber() {
        if (a < b) {
            return b;

        } else {
            return a;
        }


    }

    public int minNumber() {
        if (a > b) {
            return b;
        } else if (a == b) {
            return a;

        } else {
            return a;
        }


    }
}