package src.view;


public class StudentView extends ViewAbstract {

    public void displayWallet(String studentName, String studentWallet) {
        System.out.println("Student's name: " + studentName);
        System.out.println("Wallet: " + studentWallet);
    }

    public void displayQuestBook(String questBook) {
        System.out.println("QuestBook: " + questBook);
    }

    public void displayQuest(String questToDisplay) {
        System.out.println("Quest: " + questToDisplay);
    }
}
