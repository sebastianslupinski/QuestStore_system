import java.util.ArrayList;
import src.model;


public class WalletModel {

    private ArrayList<Artefact> artefacts = new ArrayList();

    private int balance;
    private int totalEarned;
    private int id;
    private int lastID = 0;

    public void WalletModel(int balance, int totalEarned, ArrayList<Artefact> artefacts, int id) {
        this.balance = balance;
        this.totalEarned = totalEarned;
        this.artefacts = artefacts;
        this.id = lastID++;
    }

    public void WalletModel(int balance, int totalEarned, ArrayList<Artefact> artefacts) {
        this.balance = balance;
        this.totalEarned = totalEarned;
        this.artefacts = artefacts;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int newBalance) {
        this.balance = newBalance;
    }

    public int getTotalEarned() {
        return this.totalEarned;
    }

    public void setTotalEarned(int newTotalEarned) {
        this.totalEarned = newTotalEarned;
    }

    public ArrayList<Artefact> getArtefacts() {
        return this.Artefact;
    }

    public String toString(){
        return String.format("ID: %s\nBalance: %s | Total Earned: %s", id, balance, totalEarned);
    }
}
