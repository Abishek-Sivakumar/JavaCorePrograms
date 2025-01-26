import java.util.Objects;

//class Game{
//    private final String name;
//    private final int releaseDate;
//
//    public Game(String name, int releaseDate) {
//        this.name = name;
//        this.releaseDate = releaseDate;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getReleaseDate() {
//        return releaseDate;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (o == null || getClass() != o.getClass()) return false;
//        Game game = (Game) o;
//        return releaseDate == game.releaseDate && Objects.equals(name, game.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, releaseDate);
//    }
//}

record Game(String name,int year){
    public Game{
        //ALL the above lines of code can be replaced by the record class also include toString method
        //EXACTLY LIKE ABOVE CODE
        //record class cannot be extended but can be implemeneted
        //All the variables in the record class must be declared static
        if(name=="Elden Ring DLC"){
            throw new IllegalArgumentException("DLC is not a separate game");
        }
    }
}

public class RecordClass {
    public static void main(String[] args) {
        Game g1 = new Game("Elden Ring",2022);
        Game g2 = new Game("Elden Ring",2022);
        Game g3 = new Game("Elden Ring DLC",2024);
        System.out.println(g1.equals(g2));
        System.out.println(g3);

    }
}
