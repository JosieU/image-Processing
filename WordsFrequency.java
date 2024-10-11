import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class WordsFrequency {
    public static void main(String [] args){
        HashMap<String, Integer> hashMap = new HashMap<>();
        int count = 0;      
        String starting = "Java is great, and Java is powerful. Java is fun, fun is Java!";
        String split [] = starting.split(" ", 14);
        for(String i : split){
            for(String j: split){
                if(j.equals(i)){
                    count++;
                     hashMap.put(i, count);
            }

        }
        count = 0;
    }
    //System.out.println(Collections.sort(hashMap));


    }
    
}
