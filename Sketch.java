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

  int cellSelected = 0; // The amount of cells selected
  int rowSelected = 0; // The amount of cells selected in a row
  int columnSelected = 0; // The amount of cells selected in a column
  int continueSelected = 0; // The amount of cells selected continuously in a row

  
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

     // Test single cell
    //intGrid[1][5] = 1;
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {

     // Nested for loop to put value into the rows and columns
    for (int intRow = 0; intRow < ROW_COUNT; intRow++) {
      for (int intColumn = 0; intColumn < COLUMN_COUNT; intColumn++) {
        if (intGrid[intRow][intColumn] == 1) { // if the point in the array is equal 1
          fill(0, 255, 0); // green
          noStroke();
          rect(intRow * (CELL_WIDTH + MARGIN) + MARGIN, intColumn * (CELL_HEIGHT + MARGIN) + MARGIN, CELL_WIDTH, CELL_HEIGHT);
        }
        else {
          fill(255); // white
          noStroke();
          rect(intRow * (CELL_WIDTH + MARGIN) + MARGIN, intColumn * (CELL_HEIGHT + MARGIN) + MARGIN, CELL_WIDTH, CELL_HEIGHT);
        }

      }
    }
    
  }

  public void mousePressed() {

     // Nested for loop to put value into the rows and columns
    for (int intRow = 0; intRow < ROW_COUNT; intRow++) {
      for (int intColumn = 0; intColumn < COLUMN_COUNT; intColumn++) {
        if ((mouseX > intRow * (CELL_WIDTH + MARGIN) + MARGIN && mouseX < intRow * (CELL_WIDTH + MARGIN) + MARGIN + CELL_WIDTH) && (mouseY > intColumn * (CELL_HEIGHT + MARGIN) + MARGIN && mouseY < intColumn * (CELL_HEIGHT + MARGIN) + MARGIN + CELL_HEIGHT)) {
           // Output statement for the click coordinates and grid coordinates
          System.out.println("Click coords: (" + mouseX + ", " + mouseY + ") ; Grid coords: (row:" + (intColumn+1) + ", column:" + (intRow+1) + ")");

          if (intRow == 0 && intColumn == 0) { // Top left
            if (intGrid[intRow][intColumn] == 0) { // Main block
              intGrid[intRow][intColumn] = 1; // if the cell isnt selected itll be selected
              cellSelected++; // adds one to the cell counter
            }
            else if (intGrid[intRow][intColumn] == 1) {
              intGrid[intRow][intColumn] = 0; // if the cell is selected itll be unselected
              cellSelected--; // subtracts one to the cell counter
            }

            if (intGrid[intRow+1][intColumn] == 0) { // Right block
              intGrid[intRow+1][intColumn] = 1;
              cellSelected++; // adds one to the cell counter
            }
            else if (intGrid[intRow+1][intColumn] == 1) {
              intGrid[intRow+1][intColumn] = 0;
              cellSelected--; // subtracts one to the cell counter
            }

            if (intGrid[intRow][intColumn+1] == 0) { // Bottom block
              intGrid[intRow][intColumn+1] = 1;
              cellSelected++; // adds one to the cell counter
            }
            else if (intGrid[intRow][intColumn+1] == 1) {
              intGrid[intRow][intColumn+1] = 0;
              cellSelected--; // subtracts one to the cell counter
            }
            
          }
          else if (intRow == (ROW_COUNT-1) && intColumn == 0) { // Top right
            if (intGrid[intRow][intColumn] == 0) { // Main block
              intGrid[intRow][intColumn] = 1; // if the cell isnt selected itll be selected
              cellSelected++; // adds one to the cell counter
            }
            else if (intGrid[intRow][intColumn] == 1) {
              intGrid[intRow][intColumn] = 0; // if the cell is selected itll be unselected
              cellSelected--; // subtracts one to the cell counter
            }

            if (intGrid[intRow-1][intColumn] == 0) { // Left block
              intGrid[intRow-1][intColumn] = 1;
              cellSelected++; // adds one to the cell counter
            }
            else if (intGrid[intRow-1][intColumn] == 1) {
              intGrid[intRow-1][intColumn] = 0;
              cellSelected--; // subtracts one to the cell counter
            }

            if (intGrid[intRow][intColumn+1] == 0) { // Bottom block
              intGrid[intRow][intColumn+1] = 1;
              cellSelected++; // adds one to the cell counter
            }
            else if (intGrid[intRow][intColumn+1] == 1) {
              intGrid[intRow][intColumn+1] = 0;
              cellSelected--; // subtracts one to the cell counter
            }
            
          }
          else if (intRow == 0 && intColumn == (COLUMN_COUNT-1)) { // Bottom left
            if (intGrid[intRow][intColumn] == 0) { // Main block
              intGrid[intRow][intColumn] = 1; // if the cell isnt selected itll be selected
              cellSelected++; // adds one to the cell counter
            }
            else if (intGrid[intRow][intColumn] == 1) {
              intGrid[intRow][intColumn] = 0; // if the cell is selected itll be unselected
              cellSelected--; // subtracts one to the cell counter
            }
            
            if (intGrid[intRow+1][intColumn] == 0) { // Right block
              intGrid[intRow+1][intColumn] = 1;
              cellSelected++; // adds one to the cell counter
            }
            else if (intGrid[intRow+1][intColumn] == 1) {
              intGrid[intRow+1][intColumn] = 0;
              cellSelected--; // subtracts one to the cell counter
            }
  
            if (intGrid[intRow][intColumn-1] == 0) { // Top block
              intGrid[intRow][intColumn-1] = 1;
              cellSelected++; // adds one to the cell counter
            }
            else if (intGrid[intRow][intColumn-1] == 1) {
              intGrid[intRow][intColumn-1] = 0;
              cellSelected--; // subtracts one to the cell counter
            }
            
          }
          else if (intRow == (ROW_COUNT-1) && intColumn == (COLUMN_COUNT-1)) { // Bottom right
            if (intGrid[intRow][intColumn] == 0) { // Main block
              intGrid[intRow][intColumn] = 1; // if the cell isnt selected itll be selected
              cellSelected++; // adds one to the cell counter
            }
            else if (intGrid[intRow][intColumn] == 1) {
              intGrid[intRow][intColumn] = 0; // if the cell is selected itll be unselected
              cellSelected--; // subtracts one to the cell counter
            }
            
            if (intGrid[intRow-1][intColumn] == 0) { // Left block
              intGrid[intRow-1][intColumn] = 1;
              cellSelected++; // adds one to the cell counter
            }
            else if (intGrid[intRow-1][intColumn] == 1) {
              intGrid[intRow-1][intColumn] = 0;
              cellSelected--; // subtracts one to the cell counter
            }
  
            if (intGrid[intRow][intColumn-1] == 0) { // Top block
              intGrid[intRow][intColumn-1] = 1;
              cellSelected++; // adds one to the cell counter
            }
            else if (intGrid[intRow][intColumn-1] == 1) {
              intGrid[intRow][intColumn-1] = 0;
              cellSelected--; // subtracts one to the cell counter
            }
            
          }
          else if (intColumn == 0) {
            if (intGrid[intRow][intColumn] == 0) { // Main block
              intGrid[intRow][intColumn] = 1; // if the cell isnt selected itll be selected
              cellSelected++; // adds one to the cell counter
            }
            else if (intGrid[intRow][intColumn] == 1) {
              intGrid[intRow][intColumn] = 0; // if the cell is selected itll be unselected
              cellSelected--; // subtracts one to the cell counter
            }
            
            if (intGrid[intRow+1][intColumn] == 0) { // Right block
              intGrid[intRow+1][intColumn] = 1;
              cellSelected++; // adds one to the cell counter
            }
            else if (intGrid[intRow+1][intColumn] == 1) {
              intGrid[intRow+1][intColumn] = 0;
              cellSelected--; // subtracts one to the cell counter
            }
            
            if (intGrid[intRow-1][intColumn] == 0) { // Left block
              intGrid[intRow-1][intColumn] = 1;
              cellSelected++; // adds one to the cell counter
            }
            else if (intGrid[intRow-1][intColumn] == 1) {
              intGrid[intRow-1][intColumn] = 0;
              cellSelected--; // subtracts one to the cell counter
            }
  
            if (intGrid[intRow][intColumn+1] == 0) { // Bottom block
              intGrid[intRow][intColumn+1] = 1;
              cellSelected++; // adds one to the cell counter
            }
            else if (intGrid[intRow][intColumn+1] == 1) {
              intGrid[intRow][intColumn+1] = 0;
              cellSelected--; // subtracts one to the cell counter
            }
            
          }
          else if (intColumn == (COLUMN_COUNT-1)) {
            if (intGrid[intRow][intColumn] == 0) { // Main block
              intGrid[intRow][intColumn] = 1; // if the cell isnt selected itll be selected
              cellSelected++; // adds one to the cell counter
            }
            else if (intGrid[intRow][intColumn] == 1) {
              intGrid[intRow][intColumn] = 0; // if the cell is selected itll be unselected
              cellSelected--; // subtracts one to the cell counter
            }
            
            if (intGrid[intRow+1][intColumn] == 0) { // Right block
              intGrid[intRow+1][intColumn] = 1;
              cellSelected++; // adds one to the cell counter
            }
            else if (intGrid[intRow+1][intColumn] == 1) {
              intGrid[intRow+1][intColumn] = 0;
              cellSelected--; // subtracts one to the cell counter
            }
            
            if (intGrid[intRow-1][intColumn] == 0) { // Left block
              intGrid[intRow-1][intColumn] = 1;
              cellSelected++; // adds one to the cell counter
            }
            else if (intGrid[intRow-1][intColumn] == 1) {
              intGrid[intRow-1][intColumn] = 0;
              cellSelected--; // subtracts one to the cell counter
            }
  
            if (intGrid[intRow][intColumn-1] == 0) { // Top block
              intGrid[intRow][intColumn-1] = 1;
              cellSelected++; // adds one to the cell counter
            }
            else if (intGrid[intRow][intColumn-1] == 1) {
              intGrid[intRow][intColumn-1] = 0;
              cellSelected--; // subtracts one to the cell counter
            }
            
          }
          else if (intRow == 0) {
            if (intGrid[intRow][intColumn] == 0) { // Main block
              intGrid[intRow][intColumn] = 1; // if the cell isnt selected itll be selected
              cellSelected++; // adds one to the cell counter
            }
            else if (intGrid[intRow][intColumn] == 1) {
              intGrid[intRow][intColumn] = 0; // if the cell is selected itll be unselected
              cellSelected--; // subtracts one to the cell counter
            }
            
            if (intGrid[intRow+1][intColumn] == 0) { // Right block
              intGrid[intRow+1][intColumn] = 1;
              cellSelected++; // adds one to the cell counter
            }
            else if (intGrid[intRow+1][intColumn] == 1) {
              intGrid[intRow+1][intColumn] = 0;
              cellSelected--; // subtracts one to the cell counter
            }
  
            if (intGrid[intRow][intColumn+1] == 0) { // Bottom block
              intGrid[intRow][intColumn+1] = 1;
              cellSelected++; // adds one to the cell counter
            }
            else if (intGrid[intRow][intColumn+1] == 1) {
              intGrid[intRow][intColumn+1] = 0;
              cellSelected--; // subtracts one to the cell counter
            }
  
            if (intGrid[intRow][intColumn-1] == 0) { // Top block
              intGrid[intRow][intColumn-1] = 1;
              cellSelected++; // adds one to the cell counter
            }
            else if (intGrid[intRow][intColumn-1] == 1) {
              intGrid[intRow][intColumn-1] = 0;
              cellSelected--; // subtracts one to the cell counter
            }
            
          }
          else if (intRow == (ROW_COUNT-1)) {
            if (intGrid[intRow][intColumn] == 0) { // Main block
              intGrid[intRow][intColumn] = 1; // if the cell isnt selected itll be selected
              cellSelected++; // adds one to the cell counter
            }
            else if (intGrid[intRow][intColumn] == 1) {
              intGrid[intRow][intColumn] = 0; // if the cell is selected itll be unselected
              cellSelected--; // subtracts one to the cell counter
            }
            
            if (intGrid[intRow-1][intColumn] == 0) { // Left block
              intGrid[intRow-1][intColumn] = 1;
              cellSelected++; // adds one to the cell counter
            }
            else if (intGrid[intRow-1][intColumn] == 1) {
              intGrid[intRow-1][intColumn] = 0;
              cellSelected--; // subtracts one to the cell counter
            }
  
            if (intGrid[intRow][intColumn+1] == 0) { // Bottom block
              intGrid[intRow][intColumn+1] = 1;
              cellSelected++; // adds one to the cell counter
            }
            else if (intGrid[intRow][intColumn+1] == 1) {
              intGrid[intRow][intColumn+1] = 0;
              cellSelected--; // subtracts one to the cell counter
            }
  
            if (intGrid[intRow][intColumn-1] == 0) { // Top block
              intGrid[intRow][intColumn-1] = 1;
              cellSelected++; // adds one to the cell counter
            }
            else if (intGrid[intRow][intColumn-1] == 1) {
              intGrid[intRow][intColumn-1] = 0;
              cellSelected--; // subtracts one to the cell counter
            }
          }
          else { // Anywhere else
            if (intGrid[intRow][intColumn] == 0) { // Main block
              intGrid[intRow][intColumn] = 1; // if the cell isnt selected itll be selected
              cellSelected++; // adds one to the cell counter
            }
            else if (intGrid[intRow][intColumn] == 1) {
              intGrid[intRow][intColumn] = 0; // if the cell is selected itll be unselected
              cellSelected--; // subtracts one to the cell counter
            }
            
            if (intGrid[intRow+1][intColumn] == 0) { // Right block
              intGrid[intRow+1][intColumn] = 1;
              cellSelected++; // adds one to the cell counter
            }
            else if (intGrid[intRow+1][intColumn] == 1) {
              intGrid[intRow+1][intColumn] = 0;
              cellSelected--; // subtracts one to the cell counter
            }
            
            if (intGrid[intRow-1][intColumn] == 0) { // Left block
              intGrid[intRow-1][intColumn] = 1;
              cellSelected++; // adds one to the cell counter
            }
            else if (intGrid[intRow-1][intColumn] == 1) {
              intGrid[intRow-1][intColumn] = 0;
              cellSelected--; // subtracts one to the cell counter
            }
  
            if (intGrid[intRow][intColumn+1] == 0) { // Bottom block
              intGrid[intRow][intColumn+1] = 1;
              cellSelected++; // adds one to the cell counter
            }
            else if (intGrid[intRow][intColumn+1] == 1) {
              intGrid[intRow][intColumn+1] = 0;
              cellSelected--; // subtracts one to the cell counter
            }
  
            if (intGrid[intRow][intColumn-1] == 0) { // Top block
              intGrid[intRow][intColumn-1] = 1;
              cellSelected++; // adds one to the cell counter
            }
            else if (intGrid[intRow][intColumn-1] == 1) {
              intGrid[intRow][intColumn-1] = 0;
              cellSelected--; // subtracts one to the cell counter
            }
          }
          

           // Output of the cells selected
          System.out.println("Total of " + cellSelected + " cells are selected.");
          System.out.println("");
        }
        
      }
    }

     // The amount of cells selected in a row
    for (int intRow = 0; intRow < ROW_COUNT; intRow++) {
      for (int intColumn = 0; intColumn < COLUMN_COUNT; intColumn++) {

         // Adds to rowSelected when theres a point on intGrid that equals to 1
        if (intGrid[intRow][intColumn] == 1) {
          rowSelected++;
        }

         // Scans for patterns
        if (intColumn < COLUMN_COUNT-1 && intGrid[intRow][intColumn] == 1 && intGrid[intRow][intColumn+1] == 1) {
          continueSelected++;
        }
        else if (intColumn > 0 && intColumn < COLUMN_COUNT && intGrid[intRow][intColumn-1] == 1 && intGrid[intRow][intColumn] == 1 && intColumn == COLUMN_COUNT-1) {
          continueSelected++;
        }
        else if (intColumn > 0 && intColumn < COLUMN_COUNT && intGrid[intRow][intColumn-1] == 1 && intGrid[intRow][intColumn] == 1 && intGrid[intRow][intColumn+1] == 1 && intColumn < COLUMN_COUNT-1) {
          continueSelected++;
        }
        
      }

       // prints the number of continuous cell when condition is true
      if (continueSelected > 0 && rowSelected > 2) {
        System.out.println("There are " + (continueSelected+1) + " continuous cells are selected in column " + (intRow+1) + ".");
      }
      
      System.out.println("Total of " + rowSelected + " cells are selected in column " + (intRow+1) + ".");

       // Resets the variables
      continueSelected = 0;
      rowSelected = 0;
    }
    
    System.out.println("");

     // The amount of cells selected in a column
    for (int intColumn = 0; intColumn < COLUMN_COUNT; intColumn++) {
      for (int intRow = 0; intRow < ROW_COUNT; intRow++) {

         // Adds to columnSelected when theres a point on intGrid that equals to 1
        if (intGrid[intRow][intColumn] == 1) {
          columnSelected++;
        }
        
      }
      
      System.out.println("Total of " + columnSelected + " cells are selected in row " + (intColumn+1) + ".");

       // Resets the variables
      columnSelected = 0;
    }

     // Spaces out the outputs
    System.out.println("");
    
  }
  
}
