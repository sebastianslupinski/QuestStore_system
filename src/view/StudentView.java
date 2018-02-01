package view;


public class StudentView extends AbstractView {

    public void displayStudentData(String studentDataToString, String walletToString) {
        System.out.println(studentDataToString);
        System.out.println(walletToString);
    }

    public void displayQuestBook(String questBook) {
        System.out.println("QuestBook: " + questBook);
    }

    public void displayQuest(String questToDisplay) {
        System.out.println("QuestModel: " + questToDisplay);
    }
}
