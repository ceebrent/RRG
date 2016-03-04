
/**
 * Write a description of class OutwriteArrayList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import org.jsoup.*;
import org.jsoup.nodes.*;
import java.io.*;
import org.jsoup.helper.*;
import org.jsoup.select.*;
import java.awt.Desktop;
import java.net.URI;

public class OutwriteArrayList
{
    public static ArrayList<String> Rewrite(ArrayList<String> aList) throws IOException{
    
        File fileName = new File("restaurants.txt");
        RestaurantGenerator rest = new RestaurantGenerator();
        
        
        try{
            FileWriter fw = new FileWriter(fileName);
            Writer output = new BufferedWriter(fw);
            int sz = aList.size();
            for (int i = 0; i < sz; i++){
                output.write(aList.get(i).toString() + "\n");
            }
            output.close();
        }
        catch (Exception e){
            System.out.println("Cannot open file");
        }
        return aList;
    }
        
}
