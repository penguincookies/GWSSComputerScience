void setup() {
  size ( 600, 600 );
  noStroke();
  background(random(256), random(256), random(256));
  
  //Instead of hard coding the triangle points, define 3 constants
  //The x and y coordinates of the lower left point of the base triangle(iteration 0)
  //The side length of the equalateral triangle
  final float LOWER_LEFT_X = 100;
  final float LOWER_LEFT_Y = 400;
  final float SIDE_LENGTH = 400;
  //COUNTER IS HOW MANY TIMES YOU WANT THE SNOWFLAKE TO ITERATE
  final int COUNTER = 7;
  
  //ORDER OF COORDINATES IS TOP POINT, LOWER LEFT POINT, LOWER RIGHT POINT
  kochSnowflake(LOWER_LEFT_X+(SIDE_LENGTH/2), LOWER_LEFT_Y-(sqrt(pow(SIDE_LENGTH,2) - pow(SIDE_LENGTH/2,2))),
                LOWER_LEFT_X, LOWER_LEFT_Y,
                LOWER_LEFT_X+SIDE_LENGTH, LOWER_LEFT_Y,
                COUNTER);
}

void kochSnowflake(float x1, float y1, float x2, float y2, float x3, float y3,int counter) {
  if (counter > 0) {
    counter--;
    
    //COMMENTED ELLIPSES ARE FROM ME TRYING TO FIND THE POINTS OF A TRIANGLE 
    //THEY'RE USEFUL FOR DEBUGGING SO I'M KEEPING THEM IN
    //THE FLOATS ARE THE BASE POINTS FOR SUBSEQUENT SMALLER TRIANGLES ON A
    //LARGER TRIANGLE'S SIDES
    
    float ax = (x2-x1)/3;
    float ay = (y2-y1)/3;
    
    ////ellipse (x1+ax*2, y1+ay*2, 15, 15);
    //ellipse (x2, y1+ay, 15, 15);
    ///ellipse (x1+ax, y1+ay, 15, 15);
    
    float bx = (x1-x3)/3;
    float by = (y1-y3)/3;
    
    //ellipse (x3+bx, y3+by, 15, 15);
    ///ellipse (x3+bx*2, y3+by*2, 15, 15);
    //ellipse (x3, y3+by*2, 15, 15);
    
    float cx = (x3-x2)/3;
    float cy = (y3-y2)/3;
    float cy1 = (y2-y1)/3;
    
    ////ellipse (x2+cx, y2+cy, 15, 15);
    //ellipse (x2+cx*2, y2+cy*2, 15, 15);
    //ellipse (x1, y2+y1/2.2, 15, 15);
    
    //BIGGEST TRIANGLE THAT THESE METHODS FORM ON ITERATION 1
    
    //LEFT TOP TRIANGLE
    kochSnowflake(x1+ax*2, y1+ay*2, x2, y1+ay, x1+ax, y1+ay, counter);
    //RIGHT TOP TRIANGLE
    kochSnowflake(x3+bx, y3+by, x3+bx*2, y3+by*2, x3, y3+by*2, counter);
    //BOTTOM TRIANGLE
    kochSnowflake(x1, y2+cy1, x2+cx, y2+cy, x2+cx*2, y2+cy*2, counter);
    //TOP TRIANGLE(COVERED BY ITERATION 0 TRIANGLE)
    kochSnowflake(x1, y1, x3+bx*2, y3+by*2, x1+ax, y1+ay, counter);
    //LEFT BOTTOM TRIANGLE(COVERED BY ITERATION 0 TRIANGLE)
    kochSnowflake(x1+ax*2, y1+ay*2, x2+cx, y2+cy, x2, y2, counter);
    //RIGHT BOTTOM TRIANGLE(COVERED BY ITERATION 0 TRIANGLE)
    kochSnowflake(x3+bx, y3+by, x2+cx*2, y2+cy*2, x3, y3, counter);
    
    //GIVES THE TRIANGLES A RANDOM COLOR
    fill (random(256), random(256), random(256));
    //DRAWS THE TRANGLE AT THE END SO THE BIGGEST IS DRAWN LAST
    triangle(x1, y1, x2, y2, x3, y3);
    
  }
}
