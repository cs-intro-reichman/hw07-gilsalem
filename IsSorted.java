public class IsSorted {

    public static void main(String[] args) {
  
        if (args.length > 0) {
            int[] arr = new int[args.length];
            for (int i = 0; i < args.length; i++) {
                arr[i] = Integer.parseInt(args[i]);
            }
            System.out.println(isSorted(arr));
        }
    }

   
    public static boolean isSorted(int[] a) {
      
        return isSorted(a, 0);
    }

  
    private static boolean isSorted(int[] a, int i) {

        if (i >= a.length - 1) {
            return true;
        }

     
        if (a[i] > a[i + 1]) {
            return false;
        }

        return isSorted(a, i + 1);
    }
}
