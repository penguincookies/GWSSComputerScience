Pacman macman;

void setup() {
  size (800, 800);
  background(0);
  noStroke();
  
  macman = new Pacman();
}

void draw() {
  background(0);
  macman.illustrate();
  if (frameCount%15 == 0){
    macman.moveMouth();
    frameCount = 0;
  }
}

void keyPressed(){
  if (key == CODED) {
    if (keyCode == UP){
      macman.moveUp();
    }
    else if (keyCode == DOWN){
      macman.moveDown();
    }
    else if (keyCode == RIGHT){
      macman.moveRight();
    }
    else if (keyCode == LEFT){
      macman.moveLeft();
    }
  }
 }
