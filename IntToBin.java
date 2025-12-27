
public class IntToBin {

    public static void main(String[] args) {
       
        if (args.length > 0) {
            int x = Integer.parseInt(args[0]);
            System.out.println("Binary representation of " + x + " is: " + toBinary(x));
        } else {
            System.out.println("Please provide an integer as an argument.");
        }
    }

    public static String toBinary(int x) {
       
        if (x == 0) {
            return "0";
        }
        if (x == 1) {
            return "1";
        }
        
        return toBinary(x / 2) + (x % 2);
    }    
}