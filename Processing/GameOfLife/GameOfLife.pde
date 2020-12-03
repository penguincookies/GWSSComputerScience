/*
 * Game Of Life
 * ICS4U.2020.Q1
 */

// CONSTANTS
static final int DIMENSIONS = 20;
static final boolean CELL_DEAD = false;
static final boolean CELL_ALIVE = true;
static final double POPULATION_DENSITY = 0.2;  // 40%

// GLOBAL VARIABLES
int cellWidth;
int offset;
int neighborCount;
boolean[][] data;
boolean[][] nextGen;

/* SETUP */
void setup() {

  // WINDOWS SIZE
  size( 610, 610 );

  // GAME OF LIFE GRID SIZE
  println( "Grid Size: " + DIMENSIONS + "x" + DIMENSIONS );

  // BACKGROUND
  background( #B2CBFF );

  // FRAME RATE
  frameRate( 2 );

  // RECT MODE; Top Left Corner
  rectMode(CORNER);

  // STORKE COLOR
  stroke( 255 );

  // CELL DIMENSIONS
  cellWidth = (int) ( (width-2*offset) / DIMENSIONS );
  println( "Grid Size: " + DIMENSIONS + "x" + DIMENSIONS );

  offset = ( width - ( cellWidth * DIMENSIONS) ) / 2 ;

  // CELL DATA
  data = new boolean[DIMENSIONS][DIMENSIONS];
  nextGen = new boolean[DIMENSIONS][DIMENSIONS];

  // PLACE RANDOM CELLS
  //placeRandomCells( (int) ( POPULATION_DENSITY * DIMENSIONS * DIMENSIONS ) );
  // placeGlider(2, 2);
  placePentadecathlon(5, 9);

  // DRAW CELLS
  drawCells();
}


/* DRAW */
void draw() {

  // NEXT GENERATION
  nextGeneration();

  data = nextGen;
  nextGen = new boolean[DIMENSIONS][DIMENSIONS];
  
  // DRAW CELLS
  drawCells();
}

/*
 * TODO:  GAME OF LIFE LOGIC; Next Generation
 */
void nextGeneration() {

  //I IS THE CURRENT ROW
  //J IS THE CURRENT COLUMN
  for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[i].length; j++) {
          neighborCount = countNeigh(data, i, j);
          //System.out.print(neighborCount);
          nextGen[i][j] = updateStatus(data[i][j]);
      }
  }

  //data[0][0] = CELL_ALIVE;
  
  
} // END nextGeneration()

/*
 * TODO:  COUNT NEIGHBOURS
 */
int countNeigh( boolean[][] data, int row, int column ) {
  int n = 0;
  for (int i = row-1; i <= row+1; i++) {
    for (int j = column-1; j <= column+1; j++) {
        if (validIndex(i, j, data) && !(i == row && j == column)) {
            if (data[i][j]) {
                n++;
            }
        }
    }
}

  return n;
} // END countNeigh()

boolean validIndex(int row, int column, boolean[][] oldGen) {
  if (0 <= row && row < oldGen[0].length) {
      if (0 <= column && column < oldGen.length) {
          return true;
      }
      else {
          return false;
      }
  }
  else {
      return false;
  }
}

boolean updateStatus(boolean cell) {
    if (cell == true) {
        if ((neighborCount == 2) || (neighborCount == 3)) {
            return true;
        }
        else {
            return false;
        }
    }
    else {
        if (neighborCount == 3){
            return true;
        }
        else {
            return false;
        }
    }
}

/*
 * TODO:  PLACE RANDOM CELLS @ START OF GAME
 */
void placeRandomCells( int startCells ) {
  //TRUE IS ALIVE
  if (startCells > (data.length * data[0].length) / 2) {
      for (int i = 0; i < data.length; i++) {
          for (int j = 0; j < data[i].length; j++) {
            data[i][j] = true;
          }
      }
      for (int i = 0; i < ((data.length*data[0].length) - startCells); i++) {
          data [(int)(Math.random()*data.length)][(int)(Math.random()*data[0].length)] = false;
      }
  }
  else {
      for (int i = 0; i < startCells; i++) {
          data [(int)(Math.random()*data.length)][(int)(Math.random()*data[0].length)] = true;
      }
  }
  //return oldGen;
} 

void placeGlider(int row, int column) {
  for(int i = column-1; i <= column+1; i++) {
    data[row+1][i] = true;
  }
  data[row][column+1] = true;
  data[row-1][column] = true;
}

void placePentadecathlon(int row, int column) {
  for (int i = row; i <= row + 7; i++) {
    for (int j = column; j <= column + 2; j++) {
      data[i][j] = true; 
    }
  }
  data[row+1][column+1] = false;
  data[row+6][column+1] = false;
}

/* 
 * DRAW CELLS based on their state; ALIVE - Green, DEAD/EMPTY - White
 */
void drawCells( ) {
  for ( int row = 0; row < data.length; row++ ) {
    for ( int col = 0; col < data[row].length; col++ ) {
      if ( data[row][col] == CELL_ALIVE ) {
        fill( #37FC1F );
      } else {
        fill( 255 );
      }
      rect( offset + col*cellWidth, offset + row*cellWidth, cellWidth, cellWidth );
    }
  }
} // END drawCells()

/* 
 * FILL ALL CELLS with ONE state; ALIVE & DEAD
 */
void fillCells( boolean state ) {
  for ( int row = 0; row < data.length; row++ ) {
    for ( int col = 0; col < data[row].length; col++ ) {
      data[row][col] = state;
    }
  }
} // END fillCells()
