public class ETypeCasting {
    public static void main(String[] args) {
        float f= 200;//output: 200.0

        int i = (int) 200.0;//output:200
        byte a = (byte) 257;//output: 257%256 = 1

        //automatic type promotion in expressions
        byte b = 70;
        byte c = 30;
        int res = b * c /100; //output:21 --since c*b is large to store in byte it is automatically cast to int and then divide by 100

        //byte d = 100*2; // this gives error because 100*2 >256 so byte can cannot hold it

        int e = 'A'; //output: unicode value of A
        System.out.println("\n\n unicode value of A :"+e+"\n 'A' : "+'A'+"\n\n");

       //when we perform certain operations then the data type of result will be the type of greatest among all
        byte bytes = 42;
        char chars='a';
        short shorts = 1024;
        int ints = 50000;
        float floats = 5.67f;
        double doubles= 0.1234;
        double result = (floats * bytes) + (ints / chars) - (doubles * shorts);
       // float + int - double = double
        System.out.println((floats + bytes) + " " + (ints / chars) + " " + (doubles * shorts));
        System.out.println(result);

        int z= 5;
        int x = 2;
        double r1 =  z/x; //2.0
        double r2 = (double) z/x; //2.5
        System.out.println("R1 :"+r1+" R2: "+r2);
    }

}
