public class Ghost extends PacmanCharacter {
  
  //CONSTANTS
  final static color BLUE = #34ebde;
  final static color RED = #db0909;
  final static color ORANGE = #f07d0a;
  
  //CONSTRUCTORS
  public Ghost() {
    this(DEFAULT_X, DEFAULT_Y, DEFAULT_SIZE, "grey");
    println("G() No parameters");
  }
  public Ghost( String colour ) {
    this(DEFAULT_X, DEFAULT_Y, DEFAULT_SIZE, colour);
    println("G() Only colour");
  }
  public Ghost(int x, int y) {
    this(x, y, DEFAULT_SIZE, "grey");
    println("G() Only coordinates");
  }
  public Ghost(int x, int y, int size, String colour){
    super(x, y, size);
    if (colour == "blue"){
      this.colour = BLUE;
    }
    else if (colour == "orange"){
      this.colour = ORANGE;
    }
    else if (colour == "red"){
      this.colour = RED;
    }
    else {
      println("no color");
    }
    println("G() Constructor called");
  }
  
  //DEPENDING ON WHAT DIRECTION HE'S FACING, HIS EYES WILL BE SLIGHTLY DIFFERENT
  public void illustrate() {
    rectMode(CENTER);
    fill(this.colour);
    rect (this.xLoc, this.yLoc, this.sizeFactor, this.sizeFactor/2);
    ellipse(this.xLoc, this.yLoc-(this.sizeFactor/4), this.sizeFactor, this.sizeFactor);
    ellipse(this.xLoc-(this.sizeFactor/3), this.yLoc+(this.sizeFactor/4), this.sizeFactor/3, this.sizeFactor/3);
    ellipse(this.xLoc, this.yLoc+(this.sizeFactor/4), this.sizeFactor/3, this.sizeFactor/3);
    ellipse(this.xLoc+(this.sizeFactor/3), this.yLoc+(this.sizeFactor/4), this.sizeFactor/3, this.sizeFactor/3);
    //EYES
    switch (this.direction) {
      case FACING_LEFT:
        fill(#ffffff);
        ellipse(this.xLoc-(this.sizeFactor/3), this.yLoc-(this.sizeFactor/4), this.sizeFactor/3, this.sizeFactor/2);
        ellipse(this.xLoc+(this.sizeFactor/5), this.yLoc-(this.sizeFactor/4), this.sizeFactor/3, this.sizeFactor/2);
        fill(#0c212b);
        ellipse(this.xLoc-(this.sizeFactor/2.5), this.yLoc-(this.sizeFactor/4), this.sizeFactor/6, this.sizeFactor/4);
        ellipse(this.xLoc+(this.sizeFactor/8), this.yLoc-(this.sizeFactor/4), this.sizeFactor/6, this.sizeFactor/4);
        break;
      case FACING_RIGHT:
        fill(#ffffff);
        ellipse(this.xLoc-(this.sizeFactor/5), this.yLoc-(this.sizeFactor/4), this.sizeFactor/3, this.sizeFactor/2);
        ellipse(this.xLoc+(this.sizeFactor/3), this.yLoc-(this.sizeFactor/4), this.sizeFactor/3, this.sizeFactor/2);
        fill(#0c212b);
        ellipse(this.xLoc-(this.sizeFactor/8), this.yLoc-(this.sizeFactor/4), this.sizeFactor/6, this.sizeFactor/4);
        ellipse(this.xLoc+(this.sizeFactor/2.5), this.yLoc-(this.sizeFactor/4), this.sizeFactor/6, this.sizeFactor/4);
        break;
      case FACING_UP:
        fill(#ffffff);
        ellipse(this.xLoc-(this.sizeFactor/4), this.yLoc-(this.sizeFactor/3), this.sizeFactor/3, this.sizeFactor/2);
        ellipse(this.xLoc+(this.sizeFactor/4), this.yLoc-(this.sizeFactor/3), this.sizeFactor/3, this.sizeFactor/2);
        fill(#0c212b);
        ellipse(this.xLoc-(this.sizeFactor/4), this.yLoc-(this.sizeFactor/2.5), this.sizeFactor/6, this.sizeFactor/4);
        ellipse(this.xLoc+(this.sizeFactor/4), this.yLoc-(this.sizeFactor/2.5), this.sizeFactor/6, this.sizeFactor/4);
        break;
      case FACING_DOWN:
        fill(#ffffff);
        ellipse(this.xLoc-(this.sizeFactor/4), this.yLoc-(this.sizeFactor/5), this.sizeFactor/3, this.sizeFactor/2);
        ellipse(this.xLoc+(this.sizeFactor/4), this.yLoc-(this.sizeFactor/5), this.sizeFactor/3, this.sizeFactor/2);
        fill(#0c212b);
        ellipse(this.xLoc-(this.sizeFactor/4), this.yLoc-(this.sizeFactor/8), this.sizeFactor/6, this.sizeFactor/4);
        ellipse(this.xLoc+(this.sizeFactor/4), this.yLoc-(this.sizeFactor/8), this.sizeFactor/6, this.sizeFactor/4);
        break;
    }
  }
}
