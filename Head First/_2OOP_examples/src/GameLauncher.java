public class GameLauncher {
    public static void main(String[] args) {
        GuessGame game = new GuessGame();
        game.startGame();
    }   
}

class GuessGame {
    Player p1;
    Player p2;
    Player p3;

    void startGame() {
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();

        int guessp1 = 0;
        int guessp2 = 0;
        int guessp3 = 0;

        boolean p1isRight = false;
        boolean p2isRight = false;
        boolean p3isRight = false;

        int targetNumber = (int) (Math.random() * 10);
        System.out.println("I'm thinking of a number between" + 
        " 0 and 9...");

        while (true) {
            System.out.println("Number to guess is " + targetNumber);
            p1.guess();
            p2.guess();
            p3.guess();

            guessp1 = p1.number;
            System.out.println("Player one guessed " + guessp1);

            guessp2 = p2.number;
            System.out.println("Player two guessed " + guessp2);

            guessp3 = p3.number;
            System.out.println("Player three guessed " + guessp3);

            if (guessp1 == targetNumber) {
                p1isRight = true;
            }

            if (guessp2 == targetNumber) {
                p2isRight = true;
            }

            if (guessp3 == targetNumber) {
                p3isRight = true;
            }

            if (p1isRight || p2isRight || p3isRight) {
                System.out.println("We have a winner!");
                System.out.println("Did Player one get it right? " + p1isRight);
                System.out.println("Did Player two get it right? " + p2isRight);
                System.out.println("Did Player three get it right? " + p3isRight);
                System.out.println("Game is over.");
                break;
            }
            else {
                // we must keep going because nobody got it right
                System.out.println("Players will have to try again.");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
            }
        }

    }
}

class Player {
    int number = 0;     // where the guess goes

    void guess() {
        number = (int) (Math.random() * 10);
        System.out.println("I'm guessing " + number);
    }
}
