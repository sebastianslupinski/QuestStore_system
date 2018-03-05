package controller;

import model.ArtefactModel;
import model.WalletModel;
import view.AbstractView;

import java.util.ArrayList;

public class ArtefactStoreController {

    private ArrayList<ArtefactModel> artefacts;
    private WalletModel wallet;

    public ArtefactStoreController(ArrayList<ArtefactModel> artefacts, WalletModel wallet) {
        this.artefacts = artefacts;
        this.wallet = wallet;
    }

    public void buyArtefact(WalletModel wallet) {
        Boolean done = false;
        while (!(done)) {
            int chosenArtefact = InputController.getNumber("Choose artefact: ");
            int price = artefacts.get(chosenArtefact).getPrice();
            ArtefactModel newArtefact = artefacts.get(chosenArtefact);
            if (wallet.getBalance() >= price) {
                addArtefactToList(artefacts.get(chosenArtefact));
                decreaseBalance(price);
                AbstractView.displayText("New artefact bought!");
                done = true;
            } else {
                AbstractView.displayText("Insufficient funds!");
                done = false;
            }
        }
    }

    private void decreaseBalance(int amount) {
        int newBalance = this.wallet.getBalance() - amount;
        this.wallet.setBalance(newBalance);
    }

    private void addArtefactToList(ArtefactModel newArtefact) {
        ArrayList<ArtefactModel> artefacts = this.wallet.getArtefacts();
        artefacts.add(newArtefact);
        this.wallet.setArtefacts(artefacts);
    }
}
