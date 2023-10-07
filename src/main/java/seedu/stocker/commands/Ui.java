package seedu.stocker.commands;

import java.util.Scanner;

public class Ui {

    public Ui(){

    }

    DrugList drugList = new DrugList();

    public void UiBegin(){
        Scanner input = new Scanner(System.in);
        String instruction = input.next();

        switch (instruction){
        case "help":
            System.out.println("Here are a list of possible commands");
            System.out.println("1. add - Add a drug into the system");
            System.out.println("2. delete - Remove a drug from the system");
            System.out.println("3. list - List all current drugs in the system");
            System.out.println("4. find - Find a specific drug in the system");
            System.out.println("5. help - List all available commands");

            System.out.println("\n");

            System.out.println("Here is the formatting for the commands");

            System.out.println("For add:");
            System.out.println("add /n <drug name> /d <expiry date> /q <quantity>" + "\n");

            System.out.println("For delete:");
            System.out.println("delete /n <drug name>" + "\n");

            System.out.println("For list:");
            System.out.println("list" + "\n");

            System.out.println("For find:");
            System.out.println("find <keyword>" + "\n");

            System.out.println("For help:");
            System.out.println("help");
            
        default:
            instruction = input.next();







        }
    }


}
