package menu;

import java.util.Scanner;
import VirtualKeyRepository.VirtualKeyRepository;

public class FileOperationsMenu{
    private static void displayMenuOptions(){
        System.out.println("\nYou have entered the virtual repository editor.\n"
        +"Please choose one of the following options\n"
        +"(1) Add a file to the virtual repository\n"
        +"(2) Search for a file from the virtual repository\n"
        +"(3) Remove a file from the virtual repository\n"
        +"(4) Return to main menu");
    }

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
                    System.out.println("Please input a number. Do not include any character other than the number next to the action you wish to perform.");
                    sc.nextLine();
                    continue;
                }
                switch(selection){
                    case 1:
                    System.out.println("\nPlease enter the name of the file you wish to add to the virtual repository:");
                    String fileToAdd = sc.nextLine();
                    successful = true;
                    VirtualKeyRepository.getVirtualKeyRepository().addFile(fileToAdd);
                    break;
                    case 2:
                    System.out.println("\nPlease input the name of the file you would like to search from the list (finds partial matches as well as complete matches and accepts regex notation)");
                    String fileToSearch = sc.nextLine();
                    successful = true;
                    VirtualKeyRepository.getVirtualKeyRepository().searchFileByName(fileToSearch);
                    break;
                    case 3:
                    System.out.println("\nPlease input the name of the file you would like to remove from the virtual repository");
                    String fileToDelete = sc.nextLine();
                    successful = true;
                    VirtualKeyRepository.getVirtualKeyRepository().deleteByFileName(fileToDelete);
                    break;
                    case 4:
                    System.out.println("\nExiting to main menu...\n");
                    return;
                    default:
                    System.out.println("You input a number, but it did not correspond to an action. \n"
                    +"Please input a number corresponding to one of the listed actions.");
                }
            }
        }
    }
}