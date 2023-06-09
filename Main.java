class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
  }
}import java.util.*;//imports all java util
class Main {
  
  public static void main(String[] args) {
    
    Welcome welcome = new Welcome();//allows to acess welcome class methods
    Battleship ship = new Battleship();//allows access to battlship class methods

    welcome.resizeWindow();//asks user to resize window

    welcome.welcomePrint();//welcome print animation(welcome to Battlships!)

    welcome.guideAndRules();//gives the rules and guides of how the game works
    
    ship.createGrid();//creates each grid with ⬛ in a 10x10
    
    ship.placePlayerShip();//asks the user to place the ships "Time to place the ships"

    ship.initiateComputerGrid();//random numbers are generated to make the computer place thier ships
    
    ship.computerInitiateMessage();//displays/ animation that the computer is placing their ships to make the game feel more realistic

    ship.initiatelistOfCord();//makes a list of cord that the computer uses to make better guesses

    ship.battle();//continuously ask the user to enter cordinates and computer and player take turns the one with all their ships lost loses. Displays a victory or deafeat ascii art
  }//end of main method

}//end of class main