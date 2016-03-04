
/**
 * Write a description of class InWriteArrayList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.*;
public class InWriteArrayList{

    public static ArrayList<String> read(String fileName){
        fileName = "restaurants.txt";
        String line;
        ArrayList<String> aList = new ArrayList<String>();
        
        try{
            BufferedReader input = new BufferedReader(new FileReader(fileName));
            if(!input.ready()){
                throw new IOException();
            }
            while((line = input.readLine()) != null){
                aList.add(line);
            }
            input.close();
        }
        catch (IOException e){
            System.out.println(e);
        }
        //for (int i = 0; i < aList.size();i++){
          //  System.out.println(aList.get(i).toString());
        return aList;
        }
}

