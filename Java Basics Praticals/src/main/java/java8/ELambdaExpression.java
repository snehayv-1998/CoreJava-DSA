package java8;


    /*
    -To bring the functional programing into java this is used
    -it is a anonymous function(nameless,not having return type,access modifier)
     example:
       - ()-> {System.out.println("hi")}
       - (a,b)-> System.out.println("hi");
       - (int a,int b)-> System.out.println("hi");
     - functional interface : Interface with single abstract method
      -it is used to invoke lambda function
      -it can have any number of default and static method but 1 abstract method
      -@FunctionalInterface
      Example:
      Runnable it has run()
      Comparable hs compareTo()
      Comparator has compare()
      ActionListener has actionPerformed()
      Callable has call()

     */
    @FunctionalInterface
    interface A{
        public void m1();
        public static void m2(){
            System.out.println("Inside m2");
        }
        public default void m3() {
            System.out.println("Inside m3");
        }
    }
    @FunctionalInterface
    interface B extends A{

        public void m1();//valid because we have override parent class m1 method so single abstract method will be there.
        /*public void m2();//in valid because we have already m1 abstract method in parent class.*/
    }
    public class ELambdaExpression {
        public static void main(String[] args) {
            B b = ()-> System.out.println("I don't need a separate implementation class");
            b.m1();
            b.m3();
        }
    }
