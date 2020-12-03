public class Pacman extends PacmanCharacter {
    
  //INSTANCE VARIABLES
  protected int lives;
  protected boolean mouthOpen = false;
  
  //CONTRUCTORS
  public Pacman() {
    super(200, 200, 100);
    this.lives = 3;
    this.colour = #ffde26;
    println("P() No parameters");
  }
  public Pacman(int x, int y) {
    super(x, y, 100);
    this.lives = 3;
    this.colour = #ffde26;
    println("P() Only coordinates");
  }
  public Pacman(int x, int y, int size){
    super(x, y, size);
    this.lives = 3;
    this.colour = #ffde26;
    println("P() Constructor called");
  }
  
  //GETTERS
  public int getLives() {
    return lives;
  }
  public boolean isMouthOpen() {
    return mouthOpen;
  }
  
  //SETTERS
  public void setLives(int lives) {
    this.lives = lives;
  }
  public void setMouthOpen(boolean mouthOpen) {
    this.mouthOpen = mouthOpen;
  }
  
  //MOVE MOUTH
  public void moveMouth() {
    this.mouthOpen = !this.mouthOpen;
  }
  
  //DEPENDING ON WHAT DIRECTION HE'S FACING, HIS MOUTH OPENS A DIFFERENT WAY
  public void illustrate() {
    //moveMouth();
    fill(this.colour);
    if (this.mouthOpen) {
      if (this.direction == FACING_LEFT) {
        arc(this.xLoc, this.yLoc, this.sizeFactor, this.sizeFactor, PI*1.25, PI*2.75);
      }
      else if (this.direction == FACING_RIGHT) {
        arc(this.xLoc, this.yLoc, this.sizeFactor, this.sizeFactor, PI*0.25, PI*1.75);
      }
      else if (this.direction == FACING_UP) {
        arc(this.xLoc, this.yLoc, this.sizeFactor, this.sizeFactor, PI*1.75, PI*3.25);
      }
      else {
        arc(this.xLoc, this.yLoc, this.sizeFactor, this.sizeFactor, PI*0.75, PI*2.25);
      }
    }
    else {
      ellipse(this.xLoc, this.yLoc, this.sizeFactor, this.sizeFactor);
    }
  }
}
