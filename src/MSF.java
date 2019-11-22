import java.util.Random;
import java.util.Scanner;

public class MSF {
    static int W;
    static int N;
    static double approx;
    static int s;
    static Random random = new Random();
    static double SCONST = 1.3;
    static Scanner sc = new Scanner(System.in);
    static int trees = 0;
    
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
        double output = 0;
        for (int i = 1; i < W; i++) {
            output += capproxConnectedComps(i);
        }
        approxNumTrees();
        return output + (N - (trees * W));
    }

    public static void approxNumTrees() {
        int index;
        for (int i = 0; i < s; i++) {
            index = random.nextInt(N);
            int X = chooseX();
            trees += BFS.search(index, X, W, sc);
        }
        trees = 1 + ((N/s) * trees);
        System.err.println(trees);
    }
    

    public static double capproxConnectedComps (int whight) {
        double output = 0;
        int index;
        for (int i = 0; i < s; i++) {
            index = random.nextInt(N);
            int X = chooseX();
            output += BFS.search(index, X, whight, sc);
        }
        return (((N)/ (s)) * output);
    } 

    static void chooseS() {
        s = (int) Math.ceil(SCONST * (1/ (Math.pow(approx, 2))));

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