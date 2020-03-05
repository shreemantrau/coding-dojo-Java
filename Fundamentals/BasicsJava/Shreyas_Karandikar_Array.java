// all the methods work fine uncomment to run them






import java.util.*;
class Array {
    public void maxVal(int[]arr)
    {
        // Arrays.sort(arr);
        // System.out.println(arr[arr.length-1]);
        int max=arr[0];
        for(int x:arr)
        {
            if (x>max) max=x;
        }
        System.out.println(max);
    
    }
    
    public void avg(int[]arr)
    {
        // Arrays.sort(arr);
        // System.out.println(arr[arr.length-1]);
        int sum=0;
        for(int x:arr)
        {
            sum+=x;
        }
        double avg= sum/arr.length; 
        System.out.println(avg);
    
    }




// all the methods work fine uncomment thme in main to run them


    public void oddArray(int[] arr){
        int [] odd_array;

        if(arr.length%2==0){ 
        
            odd_array=new int[arr.length/2];
        
        }
        
        else
        {
            odd_array=new int[1+(arr.length/2)];
        }

        for(int i =0, j=0; i<arr.length;i+=2)
        {
            odd_array[j]=arr[i];
            System.out.println(odd_array[j]);
            j++;
        }
    }


    public int greater_than(int[]arr,int x){
        int count=0;
        for(int a : arr)
        {
            if(a>x) count++;
        }
        return a;
    }


// all the methods work fine uncomment thme in main to run them    

    public void square_ele(int[]arr){
        for(int i=0;i<arr.length;i++){
            arr[i]*=arr[i];
            System.out.println(arr[i]);
        }
    }

    public void removeNegativeEle(int[]arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0) arr[i]=0;
        }
    }

    public double[] max_min_avg(int[] arr){
        double max=arr[0];
        double min=arr[0];
        double[] new_array=new double[3];
        double sum=0;
        for(int i=0;i<arr.length;i++){
            if(min > arr[i])min=arr[i];
            if(max < arr[i])max=arr[i];
            sum+=arr[i];
        }
        new_array[0]=max;
        new_array[1]=min;
        new_array[2]=sum/arr.length;
        return new_array;
    }
    
    public void shift(int []arr){
        for(int i=1;i<arr.length;i++){
            arr[i-1]=arr[i];
        }
        arr[arr.length-1]=0;
    }

// all the methods work fine uncomment thme in main to run them


    public static void main(String[] args) {
        // for (int i = 1; i < 256; i++) {
        //     System.out.print(i);
        // }
        System.out.println("--------------------------------------------------------------------------------------");
        // int sum=0;
        // for( int i=0;i<256;i++ ){
        //     sum+=i;
        //     System.out.println("New Number: "+i+" Sum: "+sum);
        // }


        int [] x= {1,2,3,4,5,6,7,8,9,10,11};
        int []y={23,342,-21,23,-23,213};
        // for(int a:x) System.out.print(a+" ");
        
        Array array=new Array();
        // array.maxVal(x);
        // array.avg(x);
        // array.oddArray(x);
        // int max=arr.greater_than(x,4);
        // System.out.println(max);
        // array.square_ele(x);
        // array.removeNegativeEle(y);
        // for(int w:y) System.out.println(w);
        // double [] ans=new double [3];
        // ans=array.max_min_avg(y);
        // for(Double l : ans) System.out.println(l);
        int k[]={1,5,10,-2};
        array.shift(k);
        for(Integer n : k)System.out.println(n);
        

        // all the methods work fine uncomment thme in main to run them
    }
}