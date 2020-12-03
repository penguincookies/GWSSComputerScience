void setup() {
  size (800, 700 );
  //translate(400, 400);
  fill ( 75, 204, 57 );
  
  triangleRecursion(400, 0, 0, 700, 800, 700, 7);
}

void triangleRecursion(int x1, int y1, int x2, int y2, int x3, int y3,int counter) {
  if (counter > 0) {
    triangle(x1, y1, x2, y2, x3, y3);
    
    int a1 = (x1+x2)/2;
    int b1 = (y1+y2)/2;
    int a2 = (x1+x3)/2;
    int b2 = (y1+y3)/2;
    int a3 = (x2+x3)/2;
    int b3 = (y2+y3)/2;
    
    counter--;
    triangleRecursion(x1, y1, a1, b1, a2, b2, counter);
    triangleRecursion(a1, b1, x2, y2, a3, b3, counter);
    triangleRecursion(a2, b2, a3, b3, x3, y3, counter);
  }
}
