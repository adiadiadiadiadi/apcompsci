public class Player {
    private int score = 0;
    private String name;

    //DO NOT CHANGE
    public Player(String name){
        this.name = name;
        System.out.println("-----------------------------");
    }

    //Completed
    public int getScore(){
        return score;
    }
    //Completed
    public String getName(){
        return name;
    }

    public void adjustScore(int x){
        score +=x;
    }

    public void resetScore(){
        score = 0;
    }
}
