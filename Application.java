import src.controller.*;

public class Application{
  public static void main(String[] args) {
    System.out.println("app");
    RootController rootApplication = new RootController();
    rootApplication.startApplication();
  }
}
