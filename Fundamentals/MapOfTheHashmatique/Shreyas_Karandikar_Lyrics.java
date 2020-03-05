import java.util.*;

public class Lyrics{
    public static void main(String [] args) {
        Map<String,String> map = new HashMap<>();
        map.put("Enter the Sandman","Sing your prayer little one.....");
        map.put("One","Darkness imprisioning me all I see absolute horror");
        map.put("Unforgiven 2","...and the dorr cracks open and there's no sun shining through");
        map.put("Turn the page","On a long and lonesome highway...");

        System.out.println("Here is one of the songs in the map: "+map.get("Turn the page"));
        System.out.println( "---------------------------------------------------");
        System.out.println("Printing all the keys");
        for (String key: map.keySet()){
            System.out.println(key+": "+map.get(key));
        }
    }
}