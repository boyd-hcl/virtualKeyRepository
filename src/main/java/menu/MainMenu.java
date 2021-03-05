package menu;

import java.util.Scanner;
import VirtualKeyRepository.VirtualKeyRepository;

public class MainMenu{

    private static void displayMenuOptions(){
        System.out.println("Main Menu\n"
        +"Please choose an action:\n"
        +"(1) Display tracked files\n"
        +"(2) Edit/search tracked file list\n"
        +"(3) Exit the application\n");
    }
    public static void menuLoop(){
        while(true){
            displayMenuOptions();
            boolean successful = false;  
            Scanner sc = new Scanner(System.in);
            while(!successful){
                try{
                    int choice = sc.nextInt();
                    switch(choice){
                        case 1:
                        System.out.println("Printing list of files in the virtual repository...");
                        VirtualKeyRepository.getVirtualKeyRepository().printAll();
                        System.out.println("List printed");
                        break;
                        case 2:
                        System.out.println("Entering repository operations menu");
                        sc.close();
                        FileOperationsMenu.menuLoop();
                        sc = new Scanner(System.in);
                        System.out.println("Returned to main context successfully");
                        break;
                        case 3:
                        sc.close();
                        return;
                        default:
                        System.out.println("Please input a number corresponding to one of the listed actions.");
                    }
                }
                catch(Exception e){
                    System.out.println("Please input the single digit corresponding with your desired action");
                }
            }
    
        }
    }
}
