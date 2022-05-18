import processing.core.PApplet;

public class Sketch extends PApplet {

  int CELL_WIDTH = 20; // The width of a single cell in the grid
  int CELL_HEIGHT = 20; // The height of a single cell in the grid
  int MARGIN = 5; // The margin between the grid

  int ROW_COUNT = 10; // The amount of squares in a row (x-axis)
  int COLUMN_COUNT = 10; // The amount of squares in a column (y-axis)
  
  int SCREEN_WIDTH = (CELL_WIDTH + MARGIN) * ROW_COUNT + MARGIN; // Calculates the width of the screen
  int SCREEN_HEIGHT = (CELL_HEIGHT + MARGIN) * COLUMN_COUNT + MARGIN; // Calculates the height of the screen

  int[][] intGrid = new int [ROW_COUNT][COLUMN_COUNT]; // Array responsible for the coloring of the grid

  
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
    // put your size call here
    size(SCREEN_WIDTH, SCREEN_HEIGHT);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(0);
    
    //intGrid[1][5] = 1;   
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {

    for (int intRow = 0; intRow < ROW_COUNT; intRow++) {
      for (int intColumn = 0; intColumn < COLUMN_COUNT; intColumn++) {
        if (intGrid[intRow][intColumn] == 1) {
          fill(0, 255, 0);
          noStroke();
          rect(intRow * (CELL_WIDTH + MARGIN) + MARGIN, intColumn * (CELL_HEIGHT + MARGIN) + MARGIN, CELL_WIDTH, CELL_HEIGHT);
        }
        else {
          fill(255);
          noStroke();
          rect(intRow * (CELL_WIDTH + MARGIN) + MARGIN, intColumn * (CELL_HEIGHT + MARGIN) + MARGIN, CELL_WIDTH, CELL_HEIGHT);
        }
        
      }
    }
    
  }

  public void mousePressed(){

    for (int intRow = 0; intRow < ROW_COUNT; intRow++) {
      for (int intColumn = 0; intColumn < COLUMN_COUNT; intColumn++) {
        if ((mouseX > intRow * (CELL_WIDTH + MARGIN) + MARGIN && mouseX < intRow * (CELL_WIDTH + MARGIN) + MARGIN + CELL_WIDTH) && (mouseY > intColumn * (CELL_HEIGHT + MARGIN) + MARGIN && mouseY < intColumn * (CELL_HEIGHT + MARGIN) + MARGIN + CELL_HEIGHT)) {
          System.out.println("Click coords: (" + mouseX + ", " + mouseY + ") ; Grid coords: (row:" + (intRow+1) + ", column:" + (intColumn+1) + ")");

          if (intGrid[intRow][intColumn] == 0) {
            intGrid[intRow][intColumn] = 1;
          }
          else if (intGrid[intRow][intColumn] == 1) {
            intGrid[intRow][intColumn] = 0;
          }
          
        }
        
      }
    }

    
  }
  
}
