import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        //Asks the user to input their name for the player
        System.out.println("What is player1's name?: ");
        Player p1 = new Player(sc.nextLine()); //Completed: Create Player 1

        //Asks the user to input their name for the player.
        System.out.println("What is player2's name?: ");
        Player p2 = new Player(sc.nextLine()); //Completed: Create Player 2

        String again = "Literally any string";
        Player currentPlayer;
        
        //Runs the game
        while (!again.equals("q")){
            Game game = new Game(p1, p2); //Completed: Generates the game
            //Completed: Set the a random player as the current player
            double rand = Math.random();
            if (rand < 0.5) {
                currentPlayer = p1;
            }
            else {
                currentPlayer = p2;
            }
            p1.resetScore();
            p2.resetScore();
            
            game.setFirstPlayer(currentPlayer);
            //This is the loop in which the game will be played
            while(!game.isComplete()){
               currentPlayer.adjustScore(game.takePiece());
               currentPlayer = game.getNextPlayer();
            }
            System.out.println(currentPlayer.getName()+ " Won!!");
            System.out.println(p1.getName() +" had removed "+ p1.getScore()+" pieces!");
            System.out.println(p2.getName() +" had removed "+ p2.getScore()+" pieces!");
            System.out.println("------------------------------------------");
            System.out.println("Enter q to quit, enter anything else to play again.");
            again = sc.nextLine();
        }
        System.out.println("Thank you for playing!");
    }
}
