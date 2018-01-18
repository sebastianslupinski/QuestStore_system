package src.models;

import src.controller.*;


public class TestQuest{

  public void createNewQuest(){
    System.out.println("asdasd");

    Quest quest = new Quest("aaaaaaa","aaaaaaaaaaaaaa",500,"B");
    System.out.println(quest.toString());


    System.out.println("Testowanie czy stworzy sie nowy quest");
    QuestController questController = new QuestController();
    questController.createQuest();
  }


}
