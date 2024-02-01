package Strings;

public class EString {
    public static void main(String[] args) {
        String a = "Hello"; //a(reference) will be created in stack memory and "Hello" (object) is created in String pool(a place within heap memory)
        String b = "Hello"; //b(reference) will be created in stack memory and it will point to same "Hello" (object) in String pool
        System.out.println(a==b); //true because both a and b are pointing to same object in string pool

        String c = new String("World"); //c(reference) will be in stack memory and "Hello" (object) is created outside String pool,in heap memory
        String d = new String("World"); //d(reference) will be in stack memory and "Hello" (object) is created outside String pool,in heap memory
        System.out.println(c == d); //false because both c and d are pointing to different object in heap
        System.out.println(c.equals(d));//true because both c and d has same value

        String e = new String("Hello").intern();//e(reference) will be created in stack memory and it will point to same "Hello" (object) in String pool
        System.out.println(e==a);//true

       /* String em = null;
        System.out.println(em.trim()); //error
      */

        String isdWithSpecialChar = "+1-245";
        String mobileNumberWithSpecialChar = "+1-2456990085411245";
        isdWithSpecialChar = isdWithSpecialChar.replaceAll("\\D","");
        mobileNumberWithSpecialChar = mobileNumberWithSpecialChar.replaceAll("\\D","");
        System.out.println("isdWithSpecialChar : "+isdWithSpecialChar);
        System.out.println("mobileNumberWithSpecialChar : "+mobileNumberWithSpecialChar);
        System.out.println("mobileNumberWithSpecialChar excluding isd : "+(mobileNumberWithSpecialChar.startsWith(isdWithSpecialChar)?mobileNumberWithSpecialChar.substring(isdWithSpecialChar.length()):mobileNumberWithSpecialChar));
        String str = "A man, a plan, a canal: Panama";
        System.out.println("A man, a plan, a canal: Panama : "+ str.replaceAll("\\W",""));
    }
}
