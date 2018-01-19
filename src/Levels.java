import src.view.*;
import src.controller.InputController;


public class Levels {

  private AdminView view = new AdminView();
  private InputController input = new InputController();

  public ArrayList<int> amountsOfCoinsForLevels = new ArrayList();
  public ArrayList<String> namesOfLevels = new ArrayList();

  private final int MIN_LEVEL = 2;
  private final int MAX_LEVEL = 9;

  public void Levels() {
    amountsOfCoinsForLevels.add(0); // yes, level 0 exits!
    amountsOfCoinsForLevels.add("Noobcooler"); // name for level 0
  }

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

  public void addLevels() {
    int numberOfLevels = this.setNumberOfLevels();
    int oneIndex = 1;
    for(int actualLevel = 1; x <= numberOfLevels; x++) {
      this.setNameOfLevel(actualLevel);
      this.setAmountOfCoinsForLevel(actualLevel, coinsOfLevels[actualLevel - oneIndex]);
    }
  }

  public void setAmountOfCoinsForLevel(int level, int minAmountOfCoins) {
    boolean amountOfCoinsNotChosen = true;
    while(amountOfCoinsNotChosen) {
      int amountOfCoins = input.getNumber("Enter an amount of coins for level "+level+". More then "+minAmountOfCoins+" coins.");
      if(amountOfCoins <= minAmountOfCoins) {
        view.displayText("Amount of coins is not correct. Try again.");
        continue;
      amountOfCoinsNotChosen = false;
      }
    }
    amountsOfCoinsForLevels.add(amountOfCoins);
  }

  public void setNameOfLevel(int level) {
    view.displayText("Enter a name of level number "+level+".");
    String levelsName = input.getString();
    namesOfLevels.add(levelsName);
  }

  public String getLevel(totalEarned) {
    int levelCounter = 0;
    int numberOfLevels = amountsOfCoinsForLevels.length;
    for(int i = 0; i < numberOfLevels; i++) {
      if(amountsOfCoinsForLevels[i] < totalEarned) {
        count++;
      }
    }
    return namesOfLevels[levelCounter];
  }
}
