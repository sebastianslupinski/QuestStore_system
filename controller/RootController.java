package controller;
import view.*;

public class RootController{
  RootView rootView = new RootView();

  public void startApplication(){
    rootView.displayText("Weclome in QUESTSTORE");

  }
}
