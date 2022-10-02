public class Elevator {
    private int currentFloor = 1;
    private int minFloor;
    private int maxFloor;


    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void moveDown() {
        currentFloor = currentFloor > minFloor ? currentFloor - 1 : currentFloor;

    }

    public void moveUp() {
        currentFloor =currentFloor < maxFloor ? currentFloor + 1 : currentFloor;
    }

    public void move(int floor) {
        int i;
        for(i = currentFloor; i < floor; i = i + 1){
            moveUp();
            System.out.println("Этаж - " + currentFloor);
            if(floor > maxFloor) {
                System.out.println("Введен неверный этаж");
                break;
            }
        }
        for (i = currentFloor; i > floor; i = i -1){
            moveDown();
            System.out.println("Этаж - " + currentFloor);
            if (floor < minFloor){
                System.out.println("Введен неверный этаж");
                break;
            }
        }



    }


}
