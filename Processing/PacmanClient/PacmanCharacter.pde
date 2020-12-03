public abstract class PacmanCharacter implements PacmanCharacterInterface{
  
  //CONSTANTS
  protected static final int FACING_RIGHT = 1;
  protected static final int FACING_LEFT = 2;
  protected static final int FACING_UP = 3;
  protected static final int FACING_DOWN = 4;
  protected static final int DEFAULT_X = 200;
  protected static final int DEFAULT_Y = 200;
  protected static final int DEFAULT_SIZE = 100;
  protected static final int SPEED = 2;
  //INSTANCE VARIABLES
  protected int xLoc;
  protected int yLoc;
  protected int sizeFactor;
  protected int direction = FACING_RIGHT;
  protected int lives;
  protected int colour = #777777;
  protected boolean alive;
  
  //GETTERS
  public int getxLoc() {
    return this.xLoc;
  }
  public int getyLoc() {
    return this.yLoc;
  }
  public int getSizeFactor() {
    return this.sizeFactor;
  }
  public int getDirection() {
    return this.direction;
  }
  public color getColour() {
    return this.colour;
  }
  public boolean isAlive() {
    return this.alive;
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
  public PacmanCharacter(int x, int y, int size){
    this.xLoc = x;
    this.yLoc = y;
    this.sizeFactor = size;
    this.alive = true;
    println("PC() Constructor called");
  }
  
  public abstract void illustrate();
  
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
