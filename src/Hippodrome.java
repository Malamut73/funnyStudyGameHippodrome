import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    private List<Horse> horses;
    public static Hippodrome game;

    public static void main(String[] args) {

        game = new Hippodrome(new ArrayList<>());

        Horse pony = new Horse("Pony", 3, 0);
        Horse ia = new Horse("Ia", 3, 0);
        Horse hidalgo = new Horse("Hidalgo", 3, 0);

        game.getHorses().add(pony);
        game.getHorses().add(ia);
        game.getHorses().add(hidalgo);

        game.run();
        game.printWinner();
    }

    public Horse getWinner(){
        Horse horseResult = game.getHorses().get(0);
        for (Horse horse :
                game.getHorses()) {
            if (horseResult.getDistance() < horse.getDistance()){
                horseResult = horse;
            }
        }
        return horseResult;
    }
    public void printWinner(){
        System.out.printf("Winner is %s!", getWinner().getName());
    }
    public void run(){
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void move(){
        for (Horse horse :
                game.getHorses()) {
            horse.move();
        }
    }
    public void print(){
        for (Horse horse :
                game.getHorses()) {
            horse.print();
        }
//        for (int i = 0; i < 10; i++) {
//            System.out.println();
//        }
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }
}
