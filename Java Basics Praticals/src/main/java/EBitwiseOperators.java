import java.io.IOException;

public class EBitwiseOperators {
  /*
    Bitwise operators are used to performing manipulation of individual bits of a number.
    They can be used with any of the integral types (char, short, int, etc).
    AND : &
    OR : |
    XOR : ^
    Complement : ~
    Left shift : <<
    Right shift : >>
    truth table:
    A	B	A|B	A&B	A^B	~A
    0	0	0	0	0	1
    1	0	1	0	1	0
    0	1	1	0	1	1
    1	1	1	1	0	0
    Observation:
    * Anything anded with 1 returns the same number
    * a^1 = ~a
    * a^0 = a
    * a^a = 0

     */

    public static void main(String args[]) throws IOException {
       /*  Scanner scanner = new Scanner(System.in);
        int input1 = scanner.nextInt();
        int input2 = scanner.nextInt();
        String operator = scanner.next();*/
        System.out.println(bitwiseOperation(1,"|",2));

        System.out.println(complimentAndShiftOperation(1,"~"));
    }

    private static int bitwiseOperation(int input1, String operator, int input2) throws IOException {
        /*
        Example:
        AND:a = 5 = 0101 (In Binary)
            b = 7 = 0111 (In Binary)
            0101
          & 0111
           ________
            0101  = 5 (In decimal)
         */
        switch (operator){
            case "&" : return input1 & input2;
            case "|" : return input1 | input2;
            case "^" : return input1 ^ input2;
            default:  throw new IOException( "Invalid operator");
        }
    }


    private static int complimentAndShiftOperation(int input1, String operator) throws IOException {
        /*
        Ex:
        a = 5 = 101 (In Binary)
        a<<1 = 1010
        a>>1 = 0101
         */
        switch (operator){
            case "~" : return ~input1 ;
            case "<<" : return input1<<1;
            case ">>" : return input1>>1;
            default:  throw new IOException( "Invalid operator");
        }
    }


}
