
/**
 * Write a description of class RestaurantSwap here.
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

public class RestaurantSwap
{
    public void main(String[] args){
        String restaurantFile = "restaurant.txt";
        String visitedRestaurantFile = "visited.txt";
        ArrayList<String> restaurantList = InWriteArrayList.read(restaurantFile);
        int random = RestaurantGenerator.randomNumber();
        String restToVisit = restaurantList.get(random);
        try{
            Write(restToVisit);
        }
        catch(IOException e){
               e.printStackTrace();
            }
        restaurantList.remove(restToVisit);
        try{
            OutwriteArrayList.Rewrite(restaurantList);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        try{
            RestaurantGenerator.displayRestaurant(restToVisit);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void Write(String restaurant)throws IOException{
        try{
            PrintWriter writeTest = new PrintWriter(new FileWriter("visited.txt",true));
            writeTest.println(restaurant);
            writeTest.close();
        }
        catch (IOException e){
            System.out.println(e);
        }
}
}