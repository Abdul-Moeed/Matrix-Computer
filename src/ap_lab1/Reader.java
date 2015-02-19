package ap_lab1;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 
 * @author Abdul Moeed
 */
public class Reader {
    
    //class attributes
    int total_lines; //lines in file
    String expression;  //expression(if any)
    ArrayList<Character> operations; //operations derived from expression(if any)
    ArrayList<String> matrices; //lines or matrices present in file
    
    /*file reader for automated unit tests.
    Does not get any expression just data*/
    public void read_file_auto(String path) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(path);
        String line;
        //get each line
        try (BufferedReader buffer = new BufferedReader(fr)) {
            total_lines = 0;
            matrices = new ArrayList<String>();
            
            while( (line = buffer.readLine()) != null){
                matrices.add(line);
                total_lines++;
            }
        }
    }
    
    /*file reader for manual unit testing.
    Gets expression in first line of file*/
    public void read_file_user(String path) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(path);
        String line;
        //get each line
        try (BufferedReader buffer = new BufferedReader(fr)) {
            total_lines = 0;
            matrices = new ArrayList<String>();         
            expression = buffer.readLine(); //add expression
    
            while( (line = buffer.readLine()) != null){
                matrices.add(line); //add to matrix list
                total_lines++;
            }
        }
    }
    
}
