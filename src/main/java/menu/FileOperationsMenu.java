package menu;

import java.util.Scanner;
import VirtualKeyRepository;

public class FileOperationsMenu implements Menu{
    private static void displayMenuOptions(){
        System.out.println("You have entered the virtual repository editor.\n"
        +"Please choose one of the following options"
        +"(1) Add a file to the virtual repository"
        +"(2) Search for a file from the virtual repository"
        +"(3) Remove a file from the virtual repository"
        +"(4) Return to main menu");
    }

    public void execute(){
        displayMenuOptions();
        while(true){
            boolean successful = false;
            Scanner sc = new Scanner(System.in);
            int selection = -1;
            while(!successful){
                try{
                    selection = sc.nextInt();
                }
                catch(exception e){
                    System.out.println("Please input a number. Do not include any character other than the number next to the action you wish to perform.");
                    String temp = sc.nextLine();
                    continue;
                }
                switch(selection){
                    case 1:
                    System.out.println("Please enter the name of the file you wish to add to the virtual repository:");
                    String input = sc.nextLine();
                    successful = true;
                    break;
                    case 2:
                    System.out.println("Please input the name of the file you would like to search from the list (finds partial matches and accepts regex notation)");
                    successful = true;
                    break;
                    case 3:
                    System.out.println("Please input the name of the file you would like to remove from the virtual repository");
                    successful = true;
                    break;
                    case 4:
                    successful = true;
                    return;
                    default:
                    System.out.println("You input a number, but it did not correspond to an action. \n"
                    +"Please input a number corresponding to one of the listed actions.");
                }
            }
        }
    }
}