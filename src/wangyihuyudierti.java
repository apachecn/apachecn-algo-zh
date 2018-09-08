import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i=0; i<=n; i++){
            String s = sc.nextLine();
            // System.out.println(s);
            String[] xynum = s.split(" ");
            // System.out.println(xynum[0]);
            int x, y;
            try{
                x = Integer.parseInt(xynum[0]);
            }catch(NumberFormatException ex){ // handle your exception
                continue;
            }
            try{
                y = Integer.valueOf(xynum[1]);
            }catch(NumberFormatException ex){ // handle your exception
                continue;
            }
            // System.out.println((Helper(xynum[2].substring(0,2),x)));
            for (int j=1; j<xynum[2].length(); j++){
                if (Helper(xynum[2].substring(0,j),x) == Helper(xynum[2].substring(j,xynum[2].length()),y)){
                    System.out.println(Helper(xynum[2].substring(0,j),x));
                }
            }

            // System.out.println(Helper("111", 2));

            // System.out.println(s);
            // System.out.println(res);
        }
    }

    private static int Helper(String s, int k) {
        int res = 0;
        for (int i=s.length()-1;i>=0;i--){
            char chr = s.charAt(i);
            int tmp;
            if (chr == 'A') {
                tmp = 10;
            }else if(chr == 'B') {
                tmp = 11;
            }else if(chr == 'C') {
                tmp = 12;
            }else if(chr == 'D') {
                tmp = 13;
            }else if(chr == 'E') {
                tmp = 14;
            }else if(chr == 'F') {
                tmp = 15;
            }
            else{
                tmp = Integer.parseInt(Character.toString(chr));
            }

            // System.out.println("tmp"+tmp);
            res += tmp * Math.pow(k, s.length()-1-i);
            // System.out.println("res"+res);
        }
        return res;
    }
}
/*
1
ABCDE
 */
