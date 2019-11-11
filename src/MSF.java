import java.util.Random;
import java.util.Scanner;

public class MSF {
    static int W;
    static int N;
    static float approx;
    static int s;
    static Random random = new Random();
    static double SCONST = 1;
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
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

    public static float approxMSTweight() {
        float output = N - W;
        for (int i = 1; i < W; i++) {
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
            if (BFS.search(index, X, whight, sc)) {
                output += 1;
            };
        }
        return (N/s) * output;
    } 

    static void chooseS() {
        //s = (int) Math.ceil(Math.pow(W, 3) * Math.log(N / Math.pow(approx, 2)));
        s = (int) Math.ceil(SCONST * (1/ (Math.pow(approx, 2))));
        //s = (int) Math.ceil(Math.log(N)/(Math.pow(approx, 2)));
        //s = 118896;
        System.out.println("approx: "+approx);
        System.out.println("s: "+s);
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