package menu;

import java.util.Scanner;
import VirtualKeyRepository.VirtualKeyRepository;

//Menu that performs operations on project-wide scope file collection
public class FileOperationsMenu{

    //For concision, the print statement is done by reference instead of directly
    private static void displayMenuOptions(){
        System.out.println("\nYou have entered the virtual repository editor.\n"
        +"Please choose one of the following options\n"
        +"(1) Add a file to the virtual repository\n"
        +"(2) Search for a file from the virtual repository\n"
        +"(3) Remove a file from the virtual repository\n"
        +"(4) Return to main menu");
    }

    //menu loop that repeats until user enters exit key
    public static void menuLoop(){
        Scanner sc = new Scanner(System.in);
        while(true){
            displayMenuOptions();
            boolean successful = false;
            int selection = -1;
            while(!successful){
                try{
                    selection = sc.nextInt();
                    sc.nextLine();
                }
                catch(Exception e){
                    System.out.println("\nPlease input a number. Do not include any character other than the number next to the action you wish to perform.");
                    sc.nextLine();
                    continue;
                }

                //select action based on user input
                switch(selection){

                    //Handles add function
                    case 1:
                    System.out.println("\nPlease enter the name of the file you wish to add to the virtual repository:");
                    String fileToAdd = sc.nextLine();
                    successful = true;
                    VirtualKeyRepository.getVirtualKeyRepository().addFile(fileToAdd);
                    break;

                    //Handles search function
                    case 2:
                    System.out.println("\nPlease input the name of the file you would like to search from the list (finds partial matches as well as complete matches and accepts regex notation)");
                    String fileToSearch = sc.nextLine();
                    successful = true;
                    VirtualKeyRepository.getVirtualKeyRepository().searchFileByName(fileToSearch);
                    break;

                    //handles delete operation
                    case 3:
                    System.out.println("\nPlease input the name of the file you would like to remove from the virtual repository");
                    String fileToDelete = sc.nextLine();
                    successful = true;
                    if(VirtualKeyRepository.getVirtualKeyRepository().deleteByFileName(fileToDelete)){
                        System.out.println("File successfully deleted");
                    }
                    break;

                    //exits to main execution context
                    case 4:
                    System.out.println("\nExiting to main menu...\n");
                    return;

                    //asks user for valid input if not a menu option
                    default:
                    System.out.println("\nYou input a number, but it did not correspond to an action. \n"
                    +"Please input a number corresponding to one of the listed actions.");
                }
            }
        }
    }
}