public class PacmanCharacter {
  
  //INSTANCE VARIABLES
  protected final int FACING_RIGHT = 1;
  protected final int FACING_LEFT = 2;
  protected final int FACING_UP = 3;
  protected final int FACING_DOWN = 4;
  protected final int SPEED = 3;
  protected int xLoc;
  protected int yLoc;
  protected int sizeFactor;
  protected int direction = FACING_RIGHT;
  protected color colour = #ffffff;
  protected boolean alive;
  
  //GETTERS
  public int getxLoc() {
    return xLoc;
  }
  public int getyLoc() {
    return yLoc;
  }
  public int getSizeFactor() {
    return sizeFactor;
  }
  public int getDirection() {
    return direction;
  }
  public color getColour() {
    return colour;
  }
  public boolean isAlive() {
    return alive;
  }
  
  //SETTERS
  public void setxLoc(int xLoc) {
    this.xLoc = xLoc;
  }
  public void setyLoc(int yLoc) {
    this.yLoc = yLoc;
  }
  public void setSizeFactor(int sizeFactor) {
    this.sizeFactor = sizeFactor;
  }
  public void setDirection(int direction) {
    this.direction = direction;
  }
  public void setColour(color colour) {
    this.colour = colour;
  }
  public void setAlive(boolean alive) {
    this.alive = alive;
  }
  
  //CONSTRUCTORS
  public PacmanCharacter() {
    this(200, 200, 100);
    println("PC() No parameters");
  }
  public PacmanCharacter(int x, int y) {
    this(x, y, 100);
    println("PC() Only coordinates");
  }
  public PacmanCharacter(int x, int y, int size){
    this.xLoc = x;
    this.yLoc = y;
    this.sizeFactor = size;
    this.alive = true;
    println("PC() Constructor called");
  }
  
  //DIRECTION CHANGE
  public void moveLeft() {
    this.xLoc = this.xLoc - SPEED;
    this.direction = FACING_LEFT;
  }
  public void moveRight() {
    this.xLoc = this.xLoc + SPEED;
    this.direction = FACING_RIGHT;
  }
  public void moveUp() {
    this.yLoc = this.yLoc - SPEED;
    this.direction = FACING_UP;
  }
  public void moveDown() {
    this.yLoc = this.yLoc + SPEED;
    this.direction = FACING_DOWN;
  }
}
