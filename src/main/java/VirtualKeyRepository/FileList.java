package VirtualKeyRepository;

import java.util.*;
import java.util.regex.Pattern;
import java.io.File;

public class FileList{

    //Tracks list of files
    private ArrayList<String> files;
    FileList(){
        files = new ArrayList<String>();
    }

    //searches file by regular expression defined by user
    //This will allow the user to request partial matches 
    //as well as more complex expressions for advanced users
    public void searchFileByName(String regex){

        
        System.out.println("Here is a list of files that match your search. If no files appear, none matched your search:");
        try{
            Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            files.stream().filter(file -> pattern.matcher(file).find()).forEach(file -> System.out.println(file + "\n"));
        }
        catch(Exception e){
            System.out.println("The expression you entered was invalid.\n"
            +"Please check that any special characters in your expression are escaped using \\ if you intend for them to be a literal.");
        }
    }

    //Sorts list of files and prints
    public void printAll(){
        files.sort((string1, string2) -> string1.compareTo(string2));
        files.stream().forEach(System.out::println);
    }

    //Deletes file if present and returns a boolean based on the success of the operation
    public boolean deleteByFileName(String filename){
        for(String file:files){
            if(file.equals(filename)){
                files.remove(file);
                return true;
            }
        }
        return false;
    }

    //Adds file to file list
    //Prints error message if unsuccessful
    public boolean addFile(String filename){
        File temp = new File(filename);
        if(temp.exists()){
            if(files.stream().filter(file -> file.equals(filename)).findAny().orElse(null) == null){
                files.add(filename);
                return true;
            }
            else{
                System.out.println("\nFile is already a part of the virtual repository.");
            }
        }
        else{
            System.out.println("The file name / path you have entered does not exist. \n"
            +"Please try again and ensure that you have the file name entered correctly.");
        }
        return false;
    }
}