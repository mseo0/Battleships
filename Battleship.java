import java.util.*;//imports all java util

class Battleship {
  public static String[][] playerGrid = new String[10][10];
  public static String[][] computerGrid = new String[10][10];
  public static String[][] computerGridPlayerView = new String[10][10];
  public static int rows = 10;
  public static int cols = 10;
  public static int numOfPlayerShips;
  public static int numOfComputerShips;
  public static Scanner scan = new Scanner(System.in);
  public static String ifEnter;
  public static ArrayList<Coordinate> listOfCord = new ArrayList<Coordinate>();

  public static void createGrid() {
    for (int r = 0; r < playerGrid.length; r++) {//for loop to initiate all the strings in computerGrid and playerGrid to ⬛
      for (int c = 0; c < playerGrid[0].length; c++) {
        playerGrid[r][c] = "⬛";
        computerGrid[r][c] = "⬛";
        computerGridPlayerView[r][c] = "⬛";
      }
    }
  } //end of createGrid

  public static void placePlayerShip() {
    //asks the user to press enter to strt placing ships
    slowPrint("Time to place your ships!", 5);
    System.out.print("\n(Press enter to begin)");
    ifEnter = scan.nextLine();
    clearScreen();

    
    int boatNum = 0;
    int shiplength = 0;
    //while loop for going through each ship and placing them on the grid
    while (true) {
      printPlayerGrid();
      System.out.println("-----------------------");

      //initiating the shiplength each time each iteration was successful
      if (boatNum == 0) {
        slowPrint("Time to place your Carrier(occupies 5 spaces)\n", 3);
        shiplength = 5;
      } else if (boatNum == 1) {
        slowPrint("Time to place your Battleship(occupies 4 spaces)\n", 3);
        shiplength = 4;
      } else if (boatNum == 2) {
        slowPrint("Time to place your Cruiser(occupies 3 spaces)\n", 3);
        shiplength = 3;
      } else if (boatNum == 3) {
        slowPrint("Time to place your Submarine(occupies 3 spaces)\n", 3);
        shiplength = 3;
      } else if (boatNum == 4) {
        slowPrint("Time to place your Destroyer(occupies 2 spaces)\n", 3);
        shiplength = 2;
      } else if (boatNum == 5) {
        clearScreen();
        System.out.println("Great you have placed all your ships!\n\nThis is your final grid:");
        System.out.println("-----------------------");
        printPlayerGrid();
        System.out.println("-----------------------");
        System.out.println("(Press 'enter' to continue)");
        ifEnter = scan.nextLine();
        break;
      }

      //continually asks user to input a valid x coordinate
      System.out.print("\n\nWhich x coordinate? ");
      int playerCol = 0;
      while (true) {
        if (scan.hasNextInt()) {
          playerCol = scan.nextInt();
          scan.nextLine();
          break;
        } else {
          System.out.println("Invalid input. Please try again.");
          scan.nextLine();
          System.out.print("Which x coordinate? ");
        }
      }

      //continually asks the user to inpput a valid y coordinate
      System.out.print("\nWhich y coordinate? ");
      int playerRow = 0;
      while (true) {
        if (scan.hasNextInt()) {
          playerRow = scan.nextInt();
          scan.nextLine();
          break;
        } else {
          System.out.println("Invalid input. Please try again.");
          scan.nextLine();
          System.out.print("Which y coordinate? ");
        }
      }

      
      //if statemnt to see if the coordinate is in the range of the grid and see if their is no ship on that selected spot
      if ((playerRow >= 1 && playerRow <= rows) && (playerCol >= 1 && playerCol <= cols) && playerGrid[playerRow - 1][playerCol - 1].equals("⬛")) {
        boolean validPlacement = false;

        //continuous while loop until it marks that the ship is not a valid placement
        while (!validPlacement) {
          System.out.println("\nPlace it horizontally (h) or vertically (v)?");
          String horOrVer = scan.nextLine();

          //if the user asks to place the ship horizontaly
          if (horOrVer.equalsIgnoreCase("horizontal") || horOrVer.equalsIgnoreCase("h")) {
            // Dividing the grid in half so that there is no indexOutOfBounds error
            // If less than or equal to 5, face right; if more than 5, face left
            if (playerCol <= 5) {
              int endCol = Math.min(playerCol + shiplength, cols);
              boolean overlap = false; // Flag to check for ship overlapping

              for (int x = playerCol; x < endCol; x++) {//checks the grid to see if the boat is overlapping by seeing if the boat is on a 🟨
                if (playerGrid[playerRow - 1][x - 1].equals("🟨")) {
                  overlap = true;
                  break;
                }
              }

              if (overlap) {//if it is overlapping then it asks the user to enter new coordinates then it goes back to the beggining to check if it is overlapping again.
                System.out.println("Invalid input, ships are overlapping. Enter new coordinates.");
                System.out.print("\n\nWhich x coordinate? ");
                playerCol = 0;
                while (true) {
                  if (scan.hasNextInt()) {
                    playerCol = scan.nextInt();
                    scan.nextLine();
                    break;
                  } else {
                    System.out.println("Invalid input. Please try again.");
                    scan.nextLine();
                    System.out.print("Which x coordinate? ");
                  }
                }
                System.out.print("\nWhich y coordinate? ");
                playerRow = 0;
                while (true) {
                  if (scan.hasNextInt()) {
                    playerRow = scan.nextInt();
                    scan.nextLine();
                    break;
                  } else {
                    System.out.println("Invalid input. Please try again.");
                    scan.nextLine();
                    System.out.print("Which y coordinate? ");
                  }
                }
                continue; //Go back to the beginning of the while loop
              }

              for (int x = playerCol; x < endCol; x++) {//once it is not overlapping a for loop places all the squares that are to become the ship
                playerGrid[playerRow - 1][x - 1] = "🟨";
              }
              boatNum++;
            } else if (playerCol > 5 && playerCol + shiplength - 1 >= 1) {//checks if the ship is in range and is ont he other side of the grid
              int startCol = Math.max(playerCol - shiplength, 1);
              boolean overlap = false; //boolean check saying it is not overlapping

              for (int x = playerCol; x > startCol; x--) {//checks the grid to see if the boat is overlapping by seeing if the boat is on a 🟨
                if (playerGrid[playerRow - 1][x - 1].equals("🟨")) {
                  overlap = true;
                  break;
                }
              }

              //if it is overlapping then it asks the user to enter new coordinates then it goes back to the beggining to check if it is overlapping again.
              if (overlap) {
                System.out.println("Invalid input, ships are overlapping. Enter new coordinates.");
                System.out.print("\n\nWhich x coordinate? ");
                playerCol = 0;
                while (true) {
                  if (scan.hasNextInt()) {
                    playerCol = scan.nextInt();
                    scan.nextLine();
                    break;
                  } else {
                    System.out.println("Invalid input. Please try again.");
                    scan.nextLine();
                    System.out.print("Which x coordinate? ");
                  }
                }
                System.out.print("\nWhich y coordinate? ");
                playerRow = 0;
                while (true) {
                  if (scan.hasNextInt()) {
                    playerRow = scan.nextInt();
                    scan.nextLine();
                    break;
                  } else {
                    System.out.println("Invalid input. Please try again.");
                    scan.nextLine();
                    System.out.print("Which y coordinate? ");
                  }
                }
                continue; //Go back to the beginning of the while loop
              }

              //once it is not overlapping a for loop places all the squares that are to become the ship
              for (int x = playerCol; x > startCol; x--) {
                playerGrid[playerRow - 1][x - 1] = "🟨";
              }
              boatNum++;
            }

            validPlacement = true;//allows the while loop to stop
          } 

            
          else if (horOrVer.equalsIgnoreCase("vertical") || horOrVer.equalsIgnoreCase("v")) {//checks if inputted verical
            // Dividing the grid in half so that there is no indexOutOfBounds error
            // If less than or equal to 5, face down; if more than 5, face up
            if (playerRow <= 5) {//chekcs if the rows are less than 5
              int endRow = Math.min(playerRow + shiplength, rows);
              boolean overlap = false;

              for (int x = playerRow; x < endRow; x++) {
                if (playerGrid[x - 1][playerCol - 1].equals("🟨")) {
                  overlap = true;
                  break;
                }
              }

              //if it is overlapping then it asks the user to enter new coordinates then it goes back to the beggining to check if it is overlapping again.
              if (overlap) {
                System.out.println("Invalid input, ships are overlapping. Enter new coordinates.");
                System.out.print("\n\nWhich x coordinate? ");
                playerCol = 0;
                while (true) {
                  if (scan.hasNextInt()) {
                    playerCol = scan.nextInt();
                    scan.nextLine();
                    break;
                  } else {
                    System.out.println("Invalid input. Please try again.");
                    scan.nextLine();
                    System.out.print("Which x coordinate? ");
                  }
                }
                System.out.print("\nWhich y coordinate? ");
                playerRow = 0;
                while (true) {
                  if (scan.hasNextInt()) {
                    playerRow = scan.nextInt();
                    scan.nextLine();
                    break;
                  } else {
                    System.out.println("Invalid input. Please try again.");
                    scan.nextLine();
                    System.out.print("Which y coordinate? ");
                  }
                }
                continue;
              }

              //initiates the grid with the ship if not overlapping
              for (int x = playerRow; x < endRow; x++) {
                playerGrid[x - 1][playerCol - 1] = "🟨";
              }
              boatNum++;
              
            } else if (playerRow > 5) {//checks if the rows are above 5
              int startRow = Math.max(playerRow - shiplength, 1);
              boolean overlap = false; //flag to check for ship overlapping

              //for loops to check if there is an overlap
              for (int x = playerRow; x > startRow; x--) {
                if (playerGrid[x - 1][playerCol - 1].equals("🟨")) {
                  overlap = true;
                  break;
                }
              }

              //if it is overlapping then it asks the user to enter new coordinates then it goes back to the beggining to check if it is overlapping again.
              if (overlap) {
                System.out.println("Invalid input, ships are overlapping. Enter new coordinates.");
                System.out.print("\n\nWhich x coordinate? ");
                playerCol = 0;
                while (true) {
                  if (scan.hasNextInt()) {
                    playerCol = scan.nextInt();
                    scan.nextLine();
                    break;
                  } else {
                    System.out.println("Invalid input. Please try again.");
                    scan.nextLine();
                    System.out.print("Which x coordinate? ");
                  }
                }
                System.out.print("\nWhich y coordinate? ");
                playerRow = 0;
                while (true) {
                  if (scan.hasNextInt()) {
                    playerRow = scan.nextInt();
                    scan.nextLine();
                    break;
                  } else {
                    System.out.println("Invalid input. Please try again.");
                    scan.nextLine();
                    System.out.print("Which y coordinate? ");
                  }
                }
                continue; // Go back to the beginning of the while loop
              }

              //initiates the grid with the ship if not overlapping
              for (int x = playerRow; x > startRow; x--) {
                playerGrid[x - 1][playerCol - 1] = "🟨";
              }
              boatNum++;
            }

            validPlacement = true;//sets the placement as valid so that it breaks the while
          } else {
            System.out.println("Invalid input. Please enter 'h' for horizontal or 'v' for vertical.");
            System.out.println("Place it horizontally (h) or vertically (v)?");
          }
        } //end of while loop to place ship
      } else {
        System.out.println("\nInvalid input. Press try again.");
      }

      //asks the user to press enter to reload the screen with the new grid which its code to print the grid is at the top
      System.out.print("\nPress 'enter' to reload your grid.");
      ifEnter = scan.nextLine();
      clearScreen();
    }

  } //end of placPlayerShip

  public static void initiateComputerGrid() {
  Random rand = new Random(); //creates a random object
  int boatNum = 0;
  int shiplength = 0;

    //while loop for going through each ship and placing them on the grid
  while (true) {
//initiating the shiplength each time each iteration was successful
     if (boatNum == 0) {
      shiplength = 5;
    } else if (boatNum == 1) {
      shiplength = 4;
    } else if (boatNum == 2) {
      shiplength = 3;
    } else if (boatNum == 3) {
      shiplength = 3;
    } else if (boatNum == 4) {
      shiplength = 2;
    } else if (boatNum == 5) {
      break;
    }

    //gets random col and rows
    int computerCol = rand.nextInt(10) + 1;
    int computerRow = rand.nextInt(10) + 1;

    //if statemnt to see if the coordinate is in the range of the grid and see if their is no ship on that selected spot
    if ((computerRow >= 1 && computerRow <= rows) && (computerCol >= 1 && computerCol <= cols) && computerGrid[computerRow - 1][computerCol - 1].equals("⬛")) {
      boolean validPlacement = false;//flag taht placement is not valid by default

    //
      while (!validPlacement) {
        //chooses horz or vert by choosing 1 or 2
        String horOrVer = "";
        int chooseHorOrVer = (int)(Math.random() * 2 + 1);
        if (chooseHorOrVer == 1)
          horOrVer = "h";
        if (chooseHorOrVer == 2)
          horOrVer = "v";

        if (horOrVer.equalsIgnoreCase("horizontal") || horOrVer.equalsIgnoreCase("h")) {
         // Dividing the grid in half so that there is no indexOutOfBounds error
         // If less than or equal to 5, face right; if more than 5, face left
         if (computerCol <= 5) {
           int endCol = Math.min(computerCol + shiplength, cols);
           boolean overlap = false; //flag to check for ship overlapping

           for (int x = computerCol; x < endCol; x++) {//for loops to check if there is an overlap
             if (computerGrid[computerRow - 1][x - 1].equals("🟨")) {
               overlap = true;
               break;
             }
           }

           if (overlap) {//generates new numbers for cols and row sicne there is an overlap
             computerCol = rand.nextInt(10) + 1;
             computerRow = rand.nextInt(10) + 1;
             continue; //Go back to the beginning of the while loop
           }
            //initiates the grid with the ship if not overlapping
           for (int x = computerCol; x < endCol; x++) {
             computerGrid[computerRow - 1][x - 1] = "🟨";
           }
           boatNum++;//increase boat num to move onto the next boat
         } else if (computerCol > 5 && computerCol + shiplength - 1 >= 1) {//checks the if te other half of the grid
           int startCol = Math.max(computerCol - shiplength, 1);
           boolean overlap = false; //flag to check for ship overlapping

           //for loops to check if there is an overlap
           for (int x = computerCol; x > startCol; x--) {
             if (computerGrid[computerRow - 1][x - 1].equals("🟨")) {
               overlap = true;
               break;
             }
           }
           //generates new numbers for cols and row sicne there is an overlap
           if (overlap) {
             computerCol = rand.nextInt(10) + 1;
             computerRow = rand.nextInt(10) + 1;
             continue; //Go back to the beginning of the while loop
           }
            //initiates the grid with the ship if not overlapping
           for (int x = computerCol; x > startCol; x--) {
             computerGrid[computerRow - 1][x - 1] = "🟨";
           }
           boatNum++;
         }

         validPlacement = true;
       } else if (horOrVer.equalsIgnoreCase("vertical") || horOrVer.equalsIgnoreCase("v")) {//checks if vertical
          // Dividing the grid in half so that there is no indexOutOfBounds error
          // If less than or equal to 5, face down; if more than 5, face up
          if (computerRow <= 5) {
            int endRow = Math.min(computerRow + shiplength, rows);
            boolean overlap = false; //flag to check for ship overlapping

            //for loops to check if there is an overlap
            for (int x = computerRow; x < endRow; x++) {
              if (computerGrid[x - 1][computerCol - 1].equals("🟨")) {
                overlap = true;
                break;
              }
            }

            //generates new numbers for cols and row sicne there is an overlap
            if (overlap) {
              computerCol = rand.nextInt(10) + 1;
              computerRow = rand.nextInt(10) + 1;
              continue; //Go back to the beginning of the while loop
            }

            //initiates the grid with the ship if not overlapping
            for (int x = computerRow; x < endRow; x++) {
              computerGrid[x - 1][computerCol - 1] = "🟨";
            }
            boatNum++;
          } else if (computerRow > 5) {//checks if the row is greatert than 5
            int startRow = Math.max(computerRow - shiplength, 1);
            boolean overlap = false; //flag to check for ship overlapping

            //for loops to check if there is an overlap
            for (int x = computerRow; x > startRow; x--) {
              if (computerGrid[x - 1][computerCol - 1].equals("🟨")) {
                overlap = true;
                break;
              }
            }

            //generates new numbers for cols and row sicne there is an overlap
            if (overlap) {
              computerCol = rand.nextInt(10) + 1;
              computerRow = rand.nextInt(10) + 1;
              continue; //Go back to the beginning of the while loop
            }

            //initiates the grid with the ship if not overlapping
            for (int x = computerRow; x > startRow; x--) {
              computerGrid[x - 1][computerCol - 1] = "🟨";
            }
            boatNum++;
          }

          validPlacement = true;//sets the placement as valid so it stops the while loop and moves on
        } 
      } //end of main if to place ship
    }
    } //end of while
  } //end of initiateComputerGrid

  public static void computerInitiateMessage(){
    //3 frames itterate 4 times
    for(int x = 0; x<5; x++){
    if(x == 4){
      System.out.print("Done!");
      delay(3000);
      break;
    }
      //three frames of loading
    System.out.print("Please wait. Computer is placing their ships.");
    delay(2000);
    clearScreen();
    System.out.print("Please wait. Computer is placing their ships..");
    delay(2000);
    clearScreen();
    System.out.print("Please wait. Computer is placing their ships...");
    delay(2000);
    clearScreen();
    }
    //asks the user to press enter to continue onto the battle
    System.out.println("Press 'enter' to continue.");
    clearScreen();
  }//animation telling that the computer is palcing their ships

  public static void battle(){
    //while loop until one person has lost all ships checked by the following if statments
    while(true){

      //goes throught the playerGrid to see if their are no ships
      int playerCount = 0;
      for(String[] row: playerGrid){
        for(String col: row){
          if(col.equals("🟨"))
            playerCount++;
        }
      }
      //prints out the defeat frame
      if(playerCount == 0){
        defeat();
        System.out.println("\nYour Grid:");
        System.out.println("-----------------------");
        printPlayerGrid();
        System.out.println("\nComputer Grid:");
        System.out.println("-----------------------");
        printComputerGrid();
        System.out.println("-----------------------");
        break;
      }

      //goes throught the computerGird to see if their are no ships
      int computerCount = 0;
      for(String[] row: computerGrid){
        for(String col: row){
          if(col.equals("🟨"))
             computerCount++;
        }
      }
      //prints out the victory frame
      if(computerCount == 0){
        victory();
        System.out.println("\nYour Grid:");
        System.out.println("-----------------------");
        printPlayerGrid();
        System.out.println("\nComputer Grid:");
        System.out.println("-----------------------");
        printComputerGrid();
        System.out.println("-----------------------");
        break;
      }

      //this section of code prints out the player grid and shows the key as well as the computerGrid without the ships so that the player know which coordinates they have placed
      System.out.println("This is your grid:");
      System.out.println("-----------------------");
      printPlayerGrid();
      System.out.println("-----------------------");
      System.out.println();
      System.out.println("This is your view of the Computer grid:");
      System.out.println("-----------------------");
      printcomputerGridPlayerView();
      System.out.println("NOTE:\t⬛ - Unmarked territory\t🟨 - Ship\t🟦 - Missed/Ocean\t🟥 - Hit target/ship");
      System.out.println("-----------------------");

      //calls playerTurn and computerTurn methods which prompt the user the place coordinates and computer randomly generates coordinates
      playerTurn();
      System.out.println("(Press 'enter' to continue to Computer's turn)");
      ifEnter = scan.nextLine();
      clearScreen();
      
      System.out.println("This is your grid:");
      System.out.println("-----------------------");
      printPlayerGrid();
      System.out.println("-----------------------");
      System.out.println();
      System.out.println("This is your view of the Computer grid:");
      System.out.println("-----------------------");
      printcomputerGridPlayerView();
      System.out.println("NOTE:\t⬛ - Unmarked territory\t🟨 - Ship\t🟦 - Missed/Ocean\t🟥 - Hit target/ship");
      System.out.println("-----------------------");
      
      computerTurn();

      //asks user to continues which clears the screen and the next round starts until oner person has lost all their ships
      System.out.println("(Press 'enter' to reload the grid)");
      ifEnter = scan.nextLine();
      clearScreen();
    }
  }//end of battle

  public static void initiatelistOfCord(){
    //for loop that goes through rows and collumns 1-10 making all possible coordinates and puttiung it int he arraylist
    for(int y = 1; y<=10; y++){
      for(int x = 1; x<=10; x++){
        Coordinate coordinate = new Coordinate(x,y);
        listOfCord.add(coordinate);
      }
    }
  }//end of initiatelistOfCord

  public static void computerTurn(){
    //removes a coord from the arralist so that the computer cannot use it again
    Coordinate foundCord = listOfCord.remove((int)(Math.random()*listOfCord.size()));

    //getters to get the cola and row
    int attackCol = foundCord.getXCord();
    int attackRow = foundCord.getYCord();

    
    //checks if the coord is not a ship
      if (playerGrid[attackRow - 1][attackCol - 1].equals("⬛")) {
      System.out.println("\nComputer missed the ship.");
      playerGrid[attackRow - 1][attackCol - 1] = "🟦";
    }// if the player attacks the ocean  

    //checks if the coord is a ship
    else if(playerGrid[attackRow - 1][attackCol - 1].equals("🟨")){
      System.out.println("\nComputer has hit a ship!");
      playerGrid[attackRow - 1][attackCol - 1] = "🟥";
    }//end of second else
  }//end of main while

  public static void playerTurn(){
    //while loop to continualy ask the user to enter a valid coordinate thjis is binded with the last 2 else statments
    while(true){
      //continually asks user to input a valid x coordinate
    System.out.print("\n\nWhich x coordinate? ");
      int attackCol = 0;
      while (true) {
        if (scan.hasNextInt()) {
          attackCol = scan.nextInt();
          scan.nextLine();
          break;
        } else {
          System.out.println("Invalid input. Please try again.");
          scan.nextLine();
          System.out.print("Which x coordinate? ");
        }
      }

      //continually asks the user to inpput a valid y coordinate
      System.out.print("\nWhich y coordinate? ");
      int attackRow = 0;
      while (true) {
        if (scan.hasNextInt()) {
          attackRow = scan.nextInt();
          scan.nextLine();
          break;
        } else {
          System.out.println("Invalid input. Please try again.");
          scan.nextLine();
          System.out.print("Which y coordinate? ");
        }
      }

      
    //checks if the coordinate is an unmarked place⬛ which replaces it with the ocean 🟦 also inititaes the playerview of the computer grid with 🟦 
    if ((attackRow >= 1 && attackRow <= rows) && (attackCol >= 1 && attackCol <= cols) && computerGrid[attackRow - 1][attackCol - 1].equals("⬛")) {
      System.out.println("\nYou have missed the target!");
      computerGrid[attackRow - 1][attackCol - 1] = "🟦";
      computerGridPlayerView[attackRow-1][attackCol-1] = "🟦";
      break;
    }// if the player attacks the ocean  

      //checks if the coordinate is a ship which replaces it with a marked ship or sunken part of the ship also inititaes the playerview of the computer grid with 🟥
    else if((attackRow >= 1 && attackRow <= rows) && (attackCol >= 1 && attackCol <= cols) && computerGrid[attackRow - 1][attackCol - 1].equals("🟨")){
      System.out.println("\nYou have hit the target!");
      computerGrid[attackRow - 1][attackCol - 1] = "🟥";
      computerGridPlayerView[attackRow-1][attackCol-1] = "🟥";
      break;
    }//end of second else

      //checks if the coordinate is already marked
    else if((attackRow >= 1 && attackRow <= rows) && (attackCol >= 1 && attackCol <= cols)){
      System.out.println("This territory is already marked. Press 'enter' try again.");
      ifEnter= scan.nextLine();
      clearScreen();
    }//end of last else
      
      //checks if the coordinate is outside the grid
    else{
      System.out.println("The cordinate is not inside the grid. Press 'enter' try again.");
      ifEnter= scan.nextLine();
      clearScreen();
    }
      
    }//end of main while
  }//end of computerTurn

  public static void printPlayerGrid() {

    //first row column directory
    System.out.print("  ");
    for (int x = 0; x < cols; x++)
      System.out.print(x + 1 + " ");
    System.out.println();

    //printsthe grid with number direcotry
    for (int r = 0; r < playerGrid.length; r++) {
      if (r == 9)
        System.out.print(r + 1);
      else
        System.out.print(r + 1 + " ");
      for (int c = 0; c < playerGrid[0].length; c++) {
        System.out.print(playerGrid[r][c]);
      }
      System.out.println();
    }

    //print bottom row num directory
    System.out.print("  ");
    for (int x = 0; x < cols; x++)
      System.out.print(x + 1 + " ");
    System.out.println();
  } //end of print player grid
  
  public static void printComputerGrid() {

    //first row column directory
    System.out.print("  ");
    for (int x = 0; x < cols; x++)
      System.out.print(x + 1 + " ");
    System.out.println();

    //printsthe grid with number direcotry
    for (int r = 0; r < computerGrid.length; r++) {
      if (r == 9)
        System.out.print(r + 1);
      else
        System.out.print(r + 1 + " ");
      for (int c = 0; c < computerGrid[0].length; c++) {
        System.out.print(computerGrid[r][c]);
      }
      System.out.println();
    }

    //print bottom row num directory
    System.out.print("  ");
    for (int x = 0; x < cols; x++)
      System.out.print(x + 1 + " ");
    System.out.println();
  } //end of print comp grid

  public static void printcomputerGridPlayerView(){
    //first row column directory
    System.out.print("  ");
    for (int x = 0; x < cols; x++)
      System.out.print(x + 1 + " ");
    System.out.println();

    //printsthe grid with number direcotry
    for (int r = 0; r < computerGridPlayerView.length; r++) {
      if (r == 9)
        System.out.print(r + 1);
      else
        System.out.print(r + 1 + " ");
      for (int c = 0; c < computerGridPlayerView[0].length; c++) {
        System.out.print(computerGridPlayerView[r][c]);
      }
      System.out.println();
    }

    //print bottom row num directory
    System.out.print("  ");
    for (int x = 0; x < cols; x++)
      System.out.print(x + 1 + " ");
    System.out.println();
    } //end of print comp grid
  //end of computerGridPlayerView

  public static void clearScreen() {//code to clear the screen
    System.out.print("\033[H\033[2J");
    System.out.flush();
  } //clearscreen method end

  public static void slowPrint(String text, int time) {//uses delay to print characters one by one.
    for (int i = 0; i < text.length(); i++) {
      System.out.print(text.charAt(i));
      delay(time);
    }
  } // end of slow print with text

  public static void delay(int time) {//code for delay by ms
    try {
      Thread.sleep(time);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  } // end of delay

  public static void defeat(){//defeat sign with text
    System.out.println();
    System.out.println("\t\t\t\t█▀▄ █▀▀ █▀▀ █▀▀ ▄▀█ ▀█▀");
    System.out.println("\t\t\t\t█▄▀ ██▄ █▀░ ██▄ █▀█ ░█░");
    System.out.println("\nMay the tides turn in your favor on your next endeavor at sea!"); 
  }//end of defeated sign 

  public static void victory(){//victory sign with text
    System.out.println();
    System.out.println("\t\t\t\t█░█ █ █▀▀ ▀█▀ █▀█ █▀█ █▄█");
    System.out.println("\t\t\t\t▀▄▀ █ █▄▄ ░█░ █▄█ █▀▄ ░█░");
    System.out.println("\nAnchors aweigh! Victory has been achieved on the open seas!"); 
  }//end of victory sign

//implement a checkIf ship sunk LATER by creating a new boat class to make a new boat everytime a boat is created on each grid
} //end of main