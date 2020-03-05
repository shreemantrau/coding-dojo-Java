import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import javax.swing.plaf.synth.SynthSplitPaneUI;

import java.util.*;

class PuzzleJava{
    
    public int[] sum_greter_than(int[] arr){
        ArrayList<Integer>list=new ArrayList<>();
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(arr[i]>10) list.add(arr[i]);
        }

        int[] new_arr= new int[list.size()];
        for(int i=0;i<list.size();i++){
            new_arr[i]=list.get(i);
        }
        System.out.println("The sum of the array is "+sum);
        return new_arr;
    }

    public String[] shuffle(String[]arr){
        List<String>list=Arrays.asList(arr);
        ArrayList<String>list2=new ArrayList<>();
        Collections.shuffle(list);
        System.out.println("-----------------------Printing form the method after the shuffle!!!!!!!!-----------------------");
        for(String s: list) {
            System.out.println(s);
            if(s.length()>5) list2.add(s);   
        }
        String[] new_arr= new String[list2.size()];
        for(int i=0;i<list2.size();i++) new_arr[i]=list2.get(i);  
        return new_arr;
        
    }
    
    public void alphaShuffule(char[] arr){
        ArrayList<Character> list = new ArrayList<>();
        for(int i=0;i<26;i++){
            list.add(arr[i]);
        }
        Collections.shuffle(list);
        System.out.println("-----------------------||||||||||----------------------- ");
        // list.add(0, 'a');
        System.out.println("First Element: "+ list.get(0)+" Last Element: "+ list.get(list.size()-1));
        if(list.get(0) == 'a'){
            System.out.println("Have you noticed, that the first character after shufelling is a vowel?!");
        }
        else if(list.get(0) == 'e'){
            System.out.println("Have you noticed, that the first character after shufelling is a vowel?!");
        }
        else if(list.get(0) == 'i'){
            System.out.println("Have you noticed, that the first character after shufelling is a vowel?!");
        }

        else if(list.get(0) == 'o'){
            System.out.println("Have you noticed, that the first character after shufelling is a vowel?!");
        }

        else if(list.get(0) == 'u'){
            System.out.println("Have you noticed, that the first character after shufelling is a vowel?!");
        }
    } 
    
    
    public static void main(String[] args){
       
        int []arr={3,5,1,2,7,9,8,13,25,32};
        PuzzleJava pj = new PuzzleJava();
        int [] new_arr; 
        new_arr=pj.sum_greter_than(arr);
        for(Integer i: new_arr) System.out.println(i);
       
        ///------------------------------------------------------------------------
       
        String[] names={ "Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
        String[] names2=pj.shuffle(names);
        System.out.println("-----------------------After add names whose size is greater than 4 -----------------------");
        for (String s : names2) System.out.println(s);
        
        //---------------------------------------------------------------------

        char[] alphabets=new char [26];
        int j=0;
        for ( char i='a';i<='z';i++){
            alphabets[j]=i;
            j++;
        }
        pj.alphaShuffule(alphabets);


         //---------------------------------------------------------------------


        // creating 10 random numbers
        System.out.println("--------------------------------------------------------------------------------------------");

        Random r = new Random();
        int []random_array=new int[10];
        System.out.println("Printing random values from 55-100");
        for(int i=0; i < 10; i++){
            random_array[i]=r.nextInt(100-55+1)+55;
            
            System.out.println(random_array[i]+" ");
        }


        //--------------------------------------------------------------------------

        // creating 10 random numbers sorting and siplaying max and min
        System.out.println("--------------------------------------------------------------------------------------------");

        
        int []random_array2=new int[10];
        System.out.println("Before sorting random values from 55-100");
        for(int i=0; i < 10; i++){
            random_array2[i]=r.nextInt(100-55+1)+55;
            System.out.print(random_array2[i]+" ");
        }

        Arrays.sort(random_array2);
        System.out.println("============After sorting==================");
        for(int num : random_array2){
            System.out.println(num+ " ");
        }

        System.out.println("Minimum number: "+ random_array2[0]+" Maximum Number: "+ random_array2[random_array2.length-1]);
        
        //------------------------------------------------------

        //creating random string generator
        String to_use="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        String random="";

        while(random.length()<5){
            random+=to_use.charAt(r.nextInt(52));
        }
        System.out.println("-----------------------Printing out the random string!!!!!!!!-----------------------");
        System.out.println("Random String generated is- "+random);

    
        //----------------------------------------------------------------------
        
        System.out.println("-----------------------Generating array with with 10 random string-----------------------");

        String[] random_string_array=new String[10];

        System.out.println("Array with 10 random strings looks like this - ");
        System.out.print("[ ");
        for(int i=0;i<10;i++){
            String random2="";
            while(random2.length()<5)
            {
                random2+= to_use.charAt(r.nextInt(52));
            }
            random_string_array[i]=random2;
            System.out.print(random_string_array[i]+" ");
        }
        System.out.print(" ]");
    
    }
}