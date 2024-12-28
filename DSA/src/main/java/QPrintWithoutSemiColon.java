public class QPrintWithoutSemiColon {
    public static void main(String[] args) {
        if(System.out.printf("Hello World!!\n") == null){}
        //or
        while (System.out.printf("Hello World!!\n") == null){}
    }
}
