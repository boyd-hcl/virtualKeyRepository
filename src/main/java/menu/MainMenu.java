package menu;

import java.util.Scanner;
import VirtualKeyRepository.VirtualKeyRepository;

public class MainMenu{

    private static void displayMenuOptions(){
        System.out.println("\nMain Menu\n"
        +"Please choose an action:\n"
        +"(1) Display tracked files\n"
        +"(2) Edit/search tracked file list\n"
        +"(3) Exit the application\n");
    }
    public static void menuLoop(){
        Scanner sc = new Scanner(System.in);
        while(true){
            displayMenuOptions();
            boolean successful = false;  
            int choice = -1;
            while(!successful){
                try{
                    choice = sc.nextInt();
                    String temp = sc.nextLine();
                }catch(Exception e){
                    System.out.println("\nPlease input the single digit corresponding with your desired action\n");
                    String temp = sc.nextLine();
                    continue;
                }
                switch(choice){
                    case 1:
                    System.out.println("\nPrinting list of files in the virtual repository...");
                    VirtualKeyRepository.getVirtualKeyRepository().printAll();
                    System.out.println("\nList printed");
                    successful = true;
                    break;
                    case 2:
                    System.out.println("Entering repository operations menu");
                    FileOperationsMenu.menuLoop();
                    System.out.println("\nReturned to main context successfully");
                    successful = true;
                    break;
                    case 3:
                    System.out.println("\nExiting program...");
                    successful = true;
                    return;
                    default:
                    System.out.println("\nPlease input a number corresponding to one of the listed actions.\n");
                    successful = true;
                }
            }
        }
    }
}
