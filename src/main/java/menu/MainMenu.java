package menu;

import java.util.Scanner;
import VirtualKeyRepository.VirtualKeyRepository;

//Main menu for Virtual key repository project
public class MainMenu{

    //Displays menu options. Called to print separately for concision
    private static void displayMenuOptions(){
        System.out.println("\nMain Menu\n"
        +"Please choose an action:\n"
        +"(1) Display tracked files\n"
        +"(2) Edit/search tracked file list\n"
        +"(3) Exit the application\n");
    }

    //Asks user for input until the user asks to exit the application
    public static void menuLoop(){
        Scanner sc = new Scanner(System.in);
        while(true){
            displayMenuOptions();
            boolean successful = false;  
            int choice = -1;

            //Asks user for input until there is a successful entry
            while(!successful){

                //Asks user for input until user enters a numeric value
                try{
                    choice = sc.nextInt();
                    String temp = sc.nextLine();
                }catch(Exception e){
                    System.out.println("\nPlease input the single digit corresponding with your desired action\n");
                    String temp = sc.nextLine();
                    continue;
                }

                //Chooses functionality based on input
                switch(choice){

                    //Prints repository file list
                    case 1:
                    System.out.println("\nPrinting list of files in the virtual repository...");
                    VirtualKeyRepository.getVirtualKeyRepository().printAll();
                    System.out.println("\nList printed");
                    successful = true;
                    break;

                    //Enters menu
                    case 2:
                    System.out.println("\nEntering repository operations menu");
                    FileOperationsMenu.menuLoop();
                    System.out.println("\nReturned to main context successfully");
                    successful = true;
                    break;

                    //Exits program
                    case 3:
                    System.out.println("\nExiting program...");
                    successful = true;
                    return;

                    //Asks for valid selection
                    default:
                    System.out.println("\nPlease input a number corresponding to one of the listed actions.\n");
                    successful = true;
                }
            }
        }
    }
}
