import java.util.*;//imports all java util
class Welcome{
  public static String welcome1 = "█░█░█ █▀▀ █░░ █▀▀ █▀█ █▀▄▀█ █▀▀   ▀█▀ █▀█   █▄▄ ▄▀█ ▀█▀ ▀█▀ █░░ █▀▀   █▀ █░█ █ █▀█ █▀ █";
  public static String welcome2 = "▀▄▀▄▀ ██▄ █▄▄ █▄▄ █▄█ █░▀░█ ██▄   ░█░ █▄█   █▄█ █▀█ ░█░ ░█░ █▄▄ ██▄   ▄█ █▀█ █ █▀▀ ▄█ ▄";
  public static Scanner scan = new Scanner(System.in);

  public static void slowPrint(String text, int time) {//uses delay to print characters one by one.
    for (int i = 0; i < text.length(); i++) {
      System.out.print(text.charAt(i));
      delay(time);
    }
  }// end of slow print with text

  
  public static void delay(int time) {//code for delay by ms
    try {
      Thread.sleep(time);
    } catch (InterruptedException e) {
    throw new RuntimeException(e);
    }
  }// end of delay

  
  public static void clearScreen() {  //code to clear the screen
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
  } //clearscreen methoed end

  
  public static void frame1(){//animation split into 2 frames this is frame 1
    System.out.println(welcome1 +"\n" + welcome2);
    System.out.println("\n");
    System.out.println("                                    ██ ");
    System.out.println("                                  ██████ ");
    System.out.println("                            ██████████████  ");
    System.out.println("                                ████    ██  ");
    System.out.println("                                      ████████");
    System.out.println("                                    ██████████████ ");
    System.out.println("                                  ████  ████████████ ");
    System.out.println("                                  ████  ██  ██████████ ");
    System.out.println("                                ██████  ██  ████████████ ");
    System.out.println("                                ██████  ████  ████████████   ");
    System.out.println("                                ████████  ██  ████████████  ");
    System.out.println("                              ▓▓████████  ██  ██████████████   ");
    System.out.println("                              ██████████  ██  ██████████████  ");
    System.out.println("                              ██████████  ██  ████████████████  ");
    System.out.println("                            ████████████  ██  ████████████████ ");
    System.out.println("                            ████████████  ██  ████████████████ ");
    System.out.println("                                    ██████████████            ▒▒▒▒▒▒  ");
    System.out.println("                                          ██        ▒▒▒▒▒▒▒▒▒▒████  ");
    System.out.println("                                    ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██████████████  ");
    System.out.println("      ▒▒            ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██████████████    ████    ██ ");
    System.out.println("            ▒▒        ██    ████    ████      ████    ██▒▒▒▒▒▒▒▒  ▒▒  ");
    System.out.println("    ▒▒                ████████████████████████▒▒▒▒▒▒▒▒▒▒████████          ▒▒      ");
    System.out.println("      ▒▒▒▒▒▒    ▒▒    ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████████████████        ▒▒   ");
    System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒            ▒▒▒▒████████████████▒▒▒▒▒▒██████████  ▒▒▒▒▒▒        ▒▒  ");
    System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒  ▒▒▒▒▒▒▒▒▒▒▒▒██████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████▒▒▒▒▒▒▒▒▒▒▒▒▒▒      ");
    System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
    System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
    System.out.println("\n\n\t\t\t\t\t\t\t (Press enter to continue)");
  }//end of frame1

  public static void frame2(){ //this is frame 2
      System.out.println(welcome1 +"\n" + welcome2);
      System.out.println("\n");
      System.out.println("                                 ████ ");
      System.out.println("                               █████████ ");
      System.out.println("                            ██████████████  ");
      System.out.println("                              ███    ██  ");
      System.out.println("                                      ████████");
      System.out.println("                                    ██████████████ ");
      System.out.println("                                  ████  ████████████ ");
      System.out.println("                                  ████  ██  ██████████ ");
      System.out.println("                                ██████  ██  ████████████ ");
      System.out.println("                                ██████  ████  ████████████   ");
      System.out.println("                                ████████  ██  ████████████  ");
      System.out.println("                              ▓▓████████  ██  ██████████████   ");
      System.out.println("                              ██████████  ██  ██████████████  ");
      System.out.println("                              ██████████  ██  ████████████████  ");
      System.out.println("                            ████████████  ██  ████████████████ ");
      System.out.println("                            ████████████  ██  ████████████████ ");
      System.out.println("                                    ██████████████            ▒▒▒▒▒▒  ");
      System.out.println("                                          ██        ▒▒▒▒▒▒▒▒▒▒████  ");
      System.out.println("                                    ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██████████████  ▒▒▒▒");
      System.out.println("                    ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██████████████    ████    ██ ");
      System.out.println("                      ██    ████    ████      ████    ██▒▒▒▒▒▒▒▒  ▒▒  ▒▒          ▒▒");
      System.out.println("    ▒▒            ▒▒  ████████████████████████▒▒▒▒▒▒▒▒▒▒████████          ▒▒  ▒▒ ");
      System.out.println("      ▒▒▒▒▒▒    ▒▒▒▒  ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████████████████        ▒▒   ▒▒  ▒▒");
      System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒  ▒▒▒▒▒▒▒▒▒▒▒▒▒▒████████████████▒▒▒▒▒▒██████████  ▒▒▒▒▒▒        ▒▒▒▒");
      System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████▒▒▒▒▒▒▒▒▒▒▒▒▒▒   ▒▒▒▒");
      System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
      System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
      System.out.println("\n\n\t\t\t\t\t\t\t (Press enter to continue)");
  }//end of frame2

  
  public static void resizeWindow(){//prompts the user to resize the consol window
      //asks to resize console window
    clearScreen();
    System.out.println("Please resize the console window to fullscreen.\nNOTE: This game is designed for the size of replit console.\n\t\t (Press enter to continue)");
    String scanForIfConsoleResize = scan.nextLine();
    clearScreen();
  }//end of resize window

  
  public static void welcomePrint(){//main print including the frames which displays the start screen of the game
    slowPrint(welcome1, 4);//text print welcome sign on given interval
    System.out.println();
    slowPrint(welcome2, 3);
    delay(10);//delay
    //frames of the boat moving printing out the whole screen again each time (ship ascii art)
    for(int x = 0; x<17; x++){
      frame1();
      if(x == 16){
        break;
      }
      clearScreen();
      frame2();
      clearScreen();
    }//end of for loop for the moving boat
    
    String ifEnter = scan.nextLine();//scans for input then clears
    clearScreen();
  }//end of welcomePrint

  
  public static void guideAndRules(){//the rules for which the game follows
    slowPrint("The game works as follows:\n\n\n• The player(you) will be asked the place down 5 ships on a 10x10 grid. You will be asked to place down a Carrier(occupies 5 spaces), a Battleship(occupies 4 spaces), a Cruiser(occupies 3 spaces), a Submarine(occupies 3 spaces), and a Destroyer(occupies 2 spaces). \nREMEMBER: Ships may not overlap each other!\n\n•The player(you) will be asked to guess the cordinates of the randomly placed ships on the computers grid(your opponent)\n\n•The game will end when one person has lost all 5 ships.\n\nOorah, and may you conquer with honor and emerge victorious!\n\t\t\t  (Press enter to continue)", 1);

    String ifEnter = scan.nextLine();//scans for input then clears
    clearScreen();
  }//end of guideAndRules method
}