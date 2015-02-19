package ap_lab1;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Abdul Moeed
 */
public class Reader {
    
    int total_lines;
    String expression;
    ArrayList<String> matrices;
    
    public void read_file(String path) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(path);
        String line;
        
        try (BufferedReader buffer = new BufferedReader(fr)) {
            total_lines = 0;
            matrices = new ArrayList<String>();
            
            while( (line = buffer.readLine()) != null){
                matrices.add(line);
                total_lines++;
            }
        }
        //System.out.println("Lines: " + total_lines);
        //lines.size();
        //System.out.println("Array List size: " + lines.get(0));
    }
}
