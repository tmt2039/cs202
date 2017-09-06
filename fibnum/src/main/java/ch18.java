public class ch18 {
    private static int x=0;
    static void reverseDisplay(String value){
        x++;
        if (x == value.length())
            System.out.print(value.charAt(0));
        else {
            System.out.print(value.charAt(value.length() - x));
            reverseDisplay(value);
        }
    }
}