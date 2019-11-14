import java.util.Random;
import java.util.Scanner;

public class MSF {
    static int W;
    static int N;
    static double approx;
    static int s;
    static Random random = new Random();
    static double SCONST = 1;
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        Main.DEBUG = false;
        runMSF();
    }

    public static void runMSF() {
        if (Main.DEBUG) {
            TestInit();
            chooseS();
            System.out.println(Main.test.evalAwnser(approxMSTweight()));
        } else {
            kattisInint();
            chooseS();
            System.out.println("end " + approxMSTweight());
        }
        sc.close();
    }

    public static void kattisInint() {  
        N = sc.nextInt();
        approx = Float.valueOf(sc.next()) - 1;
        W = sc.nextInt(); 
    }

    public static void TestInit() {
        String[] par = Main.test.getParameters().split(" ");
        N = Integer.valueOf(par[0]);
        approx = Float.valueOf(par[1]) -1;
        W = Integer.valueOf(par[2]);
    }

    public static double approxMSTweight() {
        double output = N - W;
        for (int i = 1; i < W; i++) {
            output += capproxConnectedComps(i);
        }
        return output;
    }

    public static double capproxConnectedComps (int whight) {
        double output = 0;
        int t = 0;
        int index;
        for (int i = 0; i < s; i++) {
            index = random.nextInt(N);
            int X = chooseX();
            int res = BFS.search(index, X, whight, sc);
            if (res == -1) {
                t += 1;
                output += 1;
            } else {
                output += res;
            }

            
        }
        return ((N/s) * output) - ((N/s) * t);
    } 

    static void chooseS() {
        s = (int) Math.ceil(SCONST  * (1/ (Math.pow(approx, 2))));

    }

    public static int chooseX() {
        double rand;
        while (true) {
            rand = random.nextDouble();
            if (rand != 0) {
                break;
            } 
        }
        return  (int) Math.floor(1/ rand);
    }
}