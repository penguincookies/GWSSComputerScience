/* Author: Jamie
 Date: March 09, 2020
 Ver : v1.1
 Description:  
 This is a simple animation demonstrating the concept
 of motion paralax. It includes a sun, birds, and other
 objects of nature. */

//VARIABLES
color a;
color b;
color c;
float birdX = 0;
float birdY = 0;

void setup(){
  size (800, 800);
  assignColor();
}

void draw (){
  noStroke();
  background();
  sun();
  cloud();
  middleMountain();
  sideMountains();
  grass();
  tree();
  birds(5);
}

//The background (sky) is blue
void background() {
  background ( 2, 209, 253 );
}

//Calls for a random color three times to assign to a, b, and c
void assignColor() {
  a = randomColor();
  b = randomColor();
  c = randomColor();
}

//Generates a random color
public color randomColor() {
 int red = (int) random(256); 
 int green = (int) random(256); 
 int blue = (int) random(256); 
 return color ( red, green, blue );
}

//Draws the sun
void sun() {
  pushMatrix();
  translate ((mouseX - width/2)*0.02, (mouseY - height/2)*0.02);
  fill ( 231, 242, 13 );
  ellipse ( width * 0.1, height * 0.1, width/8, width/8 );
  popMatrix();
}

void cloud() {
  pushMatrix();
  translate ((mouseX - width/2)*0.04, (mouseY - height/2)*0.04);
  fill (255);
  ellipse ( width * 0.75, height * 0.2, width/7, height/7 );
  ellipse ( width * 0.85, height * 0.2, width/5, height/7 );
  ellipse ( width * 0.8, height * 0.15, width/5, height/7 );
  popMatrix();
}

//Draws the middle mountain
void middleMountain () {
  pushMatrix();
  translate ((mouseX - width/2)*0.07, (mouseY - height/2)*0.07);
  //Middle
  fill (a);
  triangle ( width/2, height * 0.3, width * 0.2, height, width * 0.75, height);
  fill (255);
  triangle ( width/2, height * 0.3, width * 0.457, height*0.4, width * 0.536, height*0.4);
  popMatrix();
}

//Draws the left and right mountains
void sideMountains () {
  pushMatrix();
  translate ((mouseX - width/2)*0.12, (mouseY - height/2)*0.12);
  //Right
  fill (b);
  triangle ( width * 0.8, height * 0.45, width * 0.3, height, width * 1.3, height );
  //Left
  fill (c);
  triangle ( width * 0.25, height * 0.4, width * -0.2, height, width * 0.8, height );
  popMatrix();
}

//Draws the grass
void grass() {
  pushMatrix();
  translate ((mouseX - width/2)*0.23, (mouseY - height/2)*0.23);
  rectMode (CORNER);
  fill ( 67, 128, 0 );
  rect ( -width * 0.5, height * 0.8, width * 2, height * 0.5 );
  popMatrix();
}

//Draws the tree
void tree() {
  pushMatrix();
  translate ((mouseX - width/2)*0.23, (mouseY - height/2)*0.23);
  rectMode (CENTER);
  fill (128, 64, 0);
  rect ( width * 0.7, height * 0.8, width * 0.03, height * 0.2 );
  fill (54, 103, 24);
  ellipse ( width * 0.7, height * 0.7, width * 0.1, height * 0.15 );
  ellipse ( width * 0.72, height * 0.73, width * 0.1, height * 0.09 );
  ellipse ( width * 0.67, height * 0.72, width * 0.13, height * 0.10 );
  popMatrix();
}

public void birds(int birdNumber) {
  pushMatrix();
  stroke(0);
  strokeWeight(width/200.0);
  int birdOffsetX = width/20;
  int birdOffsetY = height/20;
  birdX = birdX + 2;
  while ( birdNumber > 0 ){ //Draws as many birds as was declared in the arguement, the offset from the lead bird increases bird by bird
    line ( birdX + birdOffsetX*birdNumber, height * 0.1 + birdOffsetY*birdNumber, birdX + height/40 + birdOffsetX*birdNumber, height * 0.09 + birdOffsetY*birdNumber );
    line ( birdX + birdOffsetX*birdNumber, height * 0.1 + birdOffsetY*birdNumber, birdX - height/40 + birdOffsetX*birdNumber, height * 0.09 + birdOffsetY*birdNumber );
    birdNumber--;
  }
  if ( birdX > width ) { //Teleports the birds back to the left of the screen if the topmost bird is offscreen
   birdX = -width*1.2; 
  }
  popMatrix();
}
