import java.util.Random;
import java.util.Scanner;

public class MSF {
    static int W;
    static int N;
    static float approx;
    static int s;
    static Random random = new Random();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        approx = sc.nextFloat();
        W = sc.nextInt();
        sc.close();
        chooseS();
        System.out.println("end " + approxMSTweight());
    }

    public static float approxMSTweight() {
        float output = N - W;
        for (int i = 1; i < W-1; i++) {
            output += capproxConnectedComps(i);
        }
        return output;
    }

    public static float capproxConnectedComps (int whight) {
        float output = 0;
        int index;
        for (int i = 0; i < s; i++) {
            index = random.nextInt(N);
            int X = chooseX();
            if (BFS.search(index, X, whight)) {
                output += 1;
            };
        }
        return output;
    } 

    static void chooseS() {
        s = 3;
    }

    public static int chooseX() {
        return 4;
    }
}