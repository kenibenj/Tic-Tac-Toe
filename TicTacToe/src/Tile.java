public class Tile {

    private int[] coordinate;
    private boolean isOccupied;
    private int team;
    private int index;

    public static int X = 0;
    public static int O = 1;


    Tile(int[] coordinate, boolean isOccupied, int index) {
        this.coordinate = coordinate;
        this.isOccupied = isOccupied;
        this.index = index;
        this.team = 2;
    }

    public int getIndex(){
        return this.index;
    }

    public int[] getCoordinate() {
        return coordinate;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    private void setIsOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public int getTeam(){
        return this.team;
    }

    public void setTeam(int team){
        this.team = team;
        this.setIsOccupied(true);
    }

    @Override
    public String toString(){
        if (isOccupied == false){
            return " ";
        }
        else{
            if(this.getTeam() == X){
                return "x";
            }
            if(this.getTeam() == O){
                return "o";
            }
        }
        return " ";
    }
}
