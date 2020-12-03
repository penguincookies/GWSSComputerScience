public class MsPacman extends Pacman{
  
  //CONSTRUCTORS
  public MsPacman() {
    this(200, 200, 100);
    this.colour = #fa7171;
    println("MP() No parameters");
  }
  public MsPacman(int x, int y) {
    this(x, y, 100);
    this.colour = #fa7171;
    println("MP() Only coordinates");
  }
  public MsPacman(int x, int y, int size){
    super(x, y, size);
    this.colour = #fa7171;
    println("MP() Constructor called");
  }
}
