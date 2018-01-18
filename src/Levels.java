import src.view.*;
import src.controller.InputController;


public class Levels {

  private AdminView view = new AdminView();
  private InputController input = new InputController();

  public int[] totalLevels = {0};
  protected int MIN_LEVEL = 2;
  protected int MAX_LEVEL = 9;

  public int setNumberOfLevels() {
    boolean numberOfLevelsNotChosen = true;
    while(numberOfLevelsNotChosen) {
      int numberOfLevels = input.getNumber("How many levels do you want to create? (maximum: "+MAX_LEVEL+")\n");
      if(numberOfLevels < MIN_LEVEL && numberOfLevels > MAX_LEVEL) {
        view.displayText("Number of levels is not correct. Try again.");
        continue;
      numberOfLevelsNotChosen = false;
      }
    }
    return numberOfLevels;
  }

  public void setAllLevels() {
    int numberOfLevels = this.setNumberOfLevels();
    int oneIndex = 1;
    for(int actualLevel = 1; x <= numberOfLevels; x++) {
      this.setCoinsAmountForLevel(actualLevel, totalLevels[actualLevel - oneIndex]);
    }
  }

  public void setAmountOfCoinsForLevel(int level, int minAmountOfCoins) {
    boolean amountOfCoinsNotChosen = true;
    while(amountOfCoinsNotChosen) {
      int amountOfCoins = input.getNumber("Enter an amount of coins for level "+level+". More then "+minAmountOfCoins);
      if(amountOfCoins <= minAmountOfCoins) {
        view.displayText("Amount of coins is not correct. Try again.");
        continue;
      amountOfCoinsNotChosen = false;
      }
    }
    levels.add(amountOfCoins);
  }
}
