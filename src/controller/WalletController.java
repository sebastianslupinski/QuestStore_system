package src.controller;

import src.view.*;


public class WalletController {
    private WalletModel wallet = new WalletModel();
    private StudentView view;

    public WalletController(WalletModel wallet, StudentView view) {
        this.wallet = wallet;
        this.view = view;
    }

}
