import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Helper(n);
    }

    private static void Helper(int n) {
        int count = 90;
        int start = 1;
        String res = "";
        // System.out.print((count * 1.0 - (count-1)*count/2.0)/count);
        while ((count * 1.0 - (count-1)*count/2.0)/count < start*1.0){
            for (int i = 0; i <= n / count; i++) {
                if (count * i + (count-1) * count /2.0 == n) {
                    System.out.print("[");
                    res += "[";
                    for (int j =i; j <= i+count-1; j++){
                        if (j==i+count-1){
                            System.out.println(j+"]");
                            res += Integer.toString(j) + "]";
                            break;
                        }
                        System.out.print(j+", ");
                        res += Integer.toString(j) + ", ";

                    }
                    // System.out.print("]");
                    // System.out.println("");
                }
            }
            count -= 1;
        }
        res = new StringBuffer(res).reverse().toString();
        // System.out.print(res);

    }
}
