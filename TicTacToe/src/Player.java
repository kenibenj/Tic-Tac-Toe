public class Player {

    private int team;
    private String name;
    private int moveNumber;
    private boolean isAI;

    public int getTeam() {
        return this.team;
    }

    public void setTeam(int team) {
        this.team = team;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoveNumber(){
        return this.moveNumber;
    }

    public void setMoveNumber(int moveNumber){
        this.moveNumber = moveNumber;
    }

    public void setAI(boolean isAI){
        this.isAI = isAI;
    }

    public boolean getAI(){
        return this.isAI;
    }
}
