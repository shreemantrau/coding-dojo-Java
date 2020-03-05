class StringManipulatorTest{
    public static void main(String args[]){
        StringManipulator sm = new StringManipulator();
        String ans=sm.trimAndConcat("   Hello   ","     World       ");
        System.out.println(ans);
        //-----------------------------------------------------
        char c='o';
        Integer a=sm.getIndexOrNull("Coding", c);
        System.out.println(a);
        Integer b=sm.getIndexOrNull("Hello World", c);
        System.out.println(b);
        Integer C=sm.getIndexOrNull("Hi", c);
        System.out.println(C);
        //---------------------------------------------------------

        String word=sm.concatSubString("Hello",1,2,"World");
        System.out.println(word);
    }
}