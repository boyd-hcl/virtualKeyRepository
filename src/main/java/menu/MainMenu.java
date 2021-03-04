package menu;

public class MainMenu implements Menu{

    private static void displayMenuOptions(){
        System.out.println("Main Menu\n"
        +"Please choose an action:\n"
        +"(1) Display tracked files\n"
        +"(2) Edit/search tracked file list\n"
        +"(3) Exit the application\n");
    }
    public static void menuLoop(int input){
        while(true){
            displayMenuOptions();
            boolean successful;  
            Scanner sc = new Scanner()  
            try{
                int choice = sc.nextInt();
                switch(choice){
                    case 1:
                    break;
                    case 2:
                    break;:
                    case 3:
                }
            }
            catch(InputMismatchException e){
                System.out.println("Please input the single digit corresponding with your desired action");
            }
    
        }
    }
}
