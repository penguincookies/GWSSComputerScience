Pacman wacman;
Ghost stinky;

void setup(){
  size (800, 800);
  background(0);
  noStroke();
  
  //wacman= new MsPacman(200, 600 );
  stinky = new Ghost();
}

void draw(){
  background(0);
  stinky.illustrate();
  delay (200);
  /*if (stinky.getyLoc() < 250){
    stinky.moveUp();
  }
  else {*/
    stinky.moveRight();
  //}
}
