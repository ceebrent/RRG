
/**
 * Write a description of class RestaurantGenerator here.
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

public class RestaurantGenerator
{
    public static void displayRestaurant(String randomR) throws Exception
    {
        try{
        Desktop d = Desktop.getDesktop();
        d.browse(new URI(String.format("%s",randomR)));
        //System.out.println(randomR);
        }
        catch(IOException e){
            e.printStackTrace();
            }
    }
  
    public static int randomNumber(){
        Random rand = new Random();
        
        int random = rand.nextInt(20) + 0;
        return random;
    }
    
    public ArrayList<String> getURL(){
        ArrayList<String> store = new ArrayList<String>();
        int i = 0;
        while(i < 11){
            store.add("http://www.yelp.com/search?find_loc=Ann+Arbor,+MI,+USA&start="+i+"&cflt=food");
            i = i + 10;
        }
        return store;
    }
    
    public void printURL(ArrayList<String> store){
        for (int i = 0; i < store.size(); i++){
            System.out.println(store.get(i));
        }
    }
    
    public ArrayList<String> listCombiner(){
        ArrayList<String> storedURLs = getURL();
        ArrayList<String> links = new ArrayList<String>();
        for (String urls : storedURLs){
         links.addAll(linkFinder(urls));
        }
    return links;
    
}
    
    public ArrayList<String> linkFinder(String url){
        ArrayList<String> store = new ArrayList<String>();
        try{
            Document doc = Jsoup.connect(url).get();
            Elements links = doc.getElementsByAttributeValueContaining("href", "/biz");
            for (Element biz : links){
                if (biz.hasClass("biz-name")){
                    //System.out.println(biz.attr("abs:href"));
                    store.add(biz.attr("abs:href"));
                }
            }
        }
        catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());}
        return store;
    }
}