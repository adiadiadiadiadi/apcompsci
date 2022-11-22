import java.util.Scanner;
public class Game {
    private int pieces;
    private Player p1;
    private Player p2;
    private Player currentPlayer;
    private Scanner sc = new Scanner(System.in);

    //Sets up the game with a random amount of pieces between 10 and 50
    //Sets up the players so they can be accessed
    public Game(Player p1, Player p2){
        pieces = (int) (Math.random() * 41) + 10; //Completed: Grab a random value between 10 and 50 
        this.p1 = p1;
        this.p2 = p2;
    }

    //Allows a player to take a specific amount of pieces.
    //Adds the amount of pieces taken to the user's score.
    public int takePiece() {
        System.out.println("There are "+ pieces+" remaining!");
        System.out.println("It is your turn, " + currentPlayer.getName());
        int take;
        take = pieces;
       //Completed: Grab the user amount of pieces and repeat if it not allowed.
        
        while (!isLegal(take)){
            Scanner sc = new Scanner(System.in);
            System.out.println("How many pieces would you like to take?");
            take = sc.nextInt();
        }
        pieces -= take; //Completed: Adjust the pieces
        

        System.out.println("There are "+ pieces+" remaining!");
        System.out.println("-----------------------");
        return take;
    }

    public Player getNextPlayer(){
    // Completed Changes which players turn it is and returns the current player.
    if (currentPlayer.equals(p1)) {
        currentPlayer = p2;
    }
    else if (currentPlayer.equals(p2)) {
        currentPlayer = p1;
    }
        return currentPlayer;
    }

    //Completed: Checks whether or not the user's requested move is allowed or not.
    public boolean isLegal(int x){
        if (x <= (pieces/2) || x == 1) {
            return true;
        }
        else {
            return false;
        }
    }


    //DO NOT CHANGE
    public boolean isComplete(){

        if (pieces == 0){ return true;}
        return false;
    }

    //DO NOT CHANGE
    public void setFirstPlayer(Player p){
        currentPlayer = p;
    }
}
