package java;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.File;

public class FileList{
    private ArrayList<String> files;
    FileList(){
        files = new ArrayList<File>();
    }

    //searches file by regular expression defined by user
    //This will allow the user to request partial matches as well as 
    public void searchFileByName(String regex){

        System.out.println("Here is a list of files that match your search. If no files appear, none matched your search:");
        try{
            Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            files.toStream().filter(file -> pattern.matcher(file).find()).forEach(file -> System.out.println(file + "\n"));
        }
        catch(PatternSyntaxException e){
            System.out.println("The expression you entered was invalid.\n"
            +"Please check that any special characters in your expression are escaped using \\ if you intend for them to be a literal.");
        }
        catch(Exception e){
            System.out.println("An unexpected error occurred :( Please try again.\n");
        }
    }

    public void printAll(){
        files.sort((string1, string2) -> string1.compareTo(string2) < 0);
        files.toStream().map(file -> file.getName()).forEach(System.out::println);
    }

    public boolean deleteByFileName(String filename){
        for(File file:files){
            if(file.getName().equals(filename)){
                files.remove(file);
                return true;
            }
        }
        return false;
    }

    public boolean addFile(String filename){
        File temp = new File(filename);
        if(temp.exists()){
            if(!files.toStream().filter(file -> file.getName().equals(filename)).isEmpty()){
                files.add(fileName);
            }
            else{
                System.out.println("File is already a part of the virtual repository.");
            }
        }
        else{
            System.out.println("The file name / path you have entered does not exist. \n"
            +"Please try again and ensure that you have the file name entered correctly.");
        }
    }
}