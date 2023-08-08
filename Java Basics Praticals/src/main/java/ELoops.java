public class ELoops {
    /*
    1. for loop Syntax:
            for(initialize;condition;increment){
              body
            }

   2. for each:
       for (type variableName : arrayName) {
       }

   3. while:
        initialize;
        while(condition){
          body;
          increment;
        }

   4. do while:
           initialize;
           do {
             // code block to be executed
             increment;
           }
           while (condition);

     */
    public static void main(String[] args) {

        {
            System.out.println("\n\nIn side for loop block");
            for (int i = 0; i < 7; i++)
                System.out.print(i+" ");

            System.out.println("\n\nIn side break block");
                for (int i = 0; i < 7; i++) {
                    if (i == 4) {
                        break;
                    }
                    System.out.print(i + " ");
                }

            System.out.println("\n\nIn side continue block");
                for (int i = 0; i < 7; i++) {
                    if (i == 4) {
                        continue;
                    }
                    System.out.print(i+" ");
                }

        }
        {
            System.out.println("\n\nIn side for each block");
            String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
            for (String i : cars) {
                System.out.print(i+" ");
            }
        }
        {
            System.out.println("\n\nIn side while block");
            int i = 0;
            while (i < 7) {
                System.out.print(i+" ");
                i++;
            }
        }
        {
            System.out.println("\n\nIn side do while block");
            int i = 0;
            do {
                System.out.print(i+" ");
                i++;
            }
            while (i < 7);
        }
        System.out.println("\n\n");
    }
}
