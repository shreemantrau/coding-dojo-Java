import java.util.*;

// import com.sun.corba.se.impl.io.TypeMismatchException;

class EHandling {

    public static void main(String[] args) {
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");

        for(int i = 0; i < myList.size(); i++) {
            try{
            
            Integer castedValue = (Integer) myList.get(i);
            System.out.println(castedValue);
            //throw new Exception();
        }
    catch (Exception e){
            System.out.println("Cannot print a non-integer value as an integer!");
        }
    }
    }
}