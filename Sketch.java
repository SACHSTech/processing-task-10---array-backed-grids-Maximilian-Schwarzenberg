import processing.core.PApplet;

public class Sketch extends PApplet {

  int CELL_WIDTH = 20; // The width of a single cell in the grid
  int CELL_HEIGHT = 20; // The height of a single cell in the grid
  int MARGIN = 5; // The margin between the grid

  int ROW_COUNT = 10; // The amount of squares in a row (x-axis)
  int COLUMN_COUNT = 10; // The amount of squares in a column (y-axis)
  
  int SCREEN_WIDTH = (CELL_WIDTH + MARGIN) * ROW_COUNT + MARGIN; // Calculates the width of the screen
  int SCREEN_HEIGHT = (CELL_HEIGHT + MARGIN) * COLUMN_COUNT + MARGIN; // Calculates the height of the screen

  int[][] intGrid = new int [ROW_COUNT][COLUMN_COUNT];

  
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
    // put your size call here
    size(SCREEN_WIDTH, SCREEN_HEIGHT);

    /*
    for (int CellX = MARGIN + (CELL_WIDTH/2); intRow < (ROW_COUNT * (CELL_WIDTH + MARGIN)); CellX += MARGIN + (CELL_WIDTH/2)) {
      System.out.println("CellX: " + CellX);
    }
    */
    
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(0);

    intGrid[1][5] = 1;

    
    for (int intGridRow = MARGIN + (CELL_WIDTH/2); intGridRow < (ROW_COUNT * (CELL_WIDTH + MARGIN)); intGridRow += MARGIN + (CELL_WIDTH/2)) {
      for (int intGridColumn = MARGIN + (CELL_HEIGHT/2); intGridColumn < (COLUMN_COUNT * (CELL_HEIGHT + MARGIN)); intGridColumn += MARGIN + (CELL_HEIGHT/2)) {
        /*
        //System.out.println("intGridRow: " + intGridRow);
        //System.out.println("intGridColumn: " + intGridColumn);

        
        if (mouseX >= intArGridRow[intGridRow]-10 && mouseX <= intArGridRow[intGridRow]+10) {
          System.out.println("working: " + intArGridRow[intGridRow]);
        }
        */
        
        
      }
    }
    
    
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
	  int intX = 0;
    int intY = 0;

    for (int intRow = 0; intRow < (ROW_COUNT * (CELL_WIDTH + MARGIN)); intRow+=CELL_WIDTH + MARGIN) {
      for (int intColumn = 0; intColumn < (COLUMN_COUNT * (CELL_HEIGHT + MARGIN)); intColumn+=CELL_HEIGHT + MARGIN) {
        intX = MARGIN + intRow;
        intY = MARGIN + intColumn;
  
        fill(255);
        noStroke();
        rect(intX, intY, CELL_WIDTH, CELL_HEIGHT);
      }
    }
    
  }

  public void mousePressed(){

    System.out.println("Click coords: (" + mouseX + ", " + mouseY + ") ; Grid coords: (row:" + mouseX + ", column:" + mouseY + ")");
    
  }
  
}
