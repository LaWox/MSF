import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;
import java.util.Vector;

public class Graph {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static double approx = 1.1;
    static int W;

    static String FILENAME = "graph.txt";
    static int[] Nspan = {100000, 120000};
    static int[] Wspan = {1, 3};

    static Random rand = new Random();

    static StringBuilder[] graph;

    static int weight = 0;

    static Vector<Integer> inSet = new Vector<Integer>();
    static Vector<Integer> outSet = new Vector<Integer>();

    public static void main(String[] args) {
       createGraph();
    }

    public static void createGraph() {
        init();
        int n = 0;
        while (!outSet.isEmpty() || n == 50000) {
            addEdge();
            n++;
        }
        renderGraph();
        outputGraph();
    }

    public static void initSets() {
        inSet.add(0);
        graph[0] = new StringBuilder();
        for (int i = 1; i < N; i++) {
            graph[i] = new StringBuilder();
            outSet.add(i);
        }
    }

    public static void init() {
        N = Nspan[0] + rand.nextInt(Nspan[1] - Nspan[0]);
        W = Wspan[0] + rand.nextInt(Wspan[1] - Wspan[0]);

        graph = new StringBuilder[N];

        sb.append(N + " " + approx + " " + W + "\n");
        initSets();
    }

    public static void addEdge() {
        int edgeWeight = 1 + rand.nextInt(W);
        weight += edgeWeight;

        int inIndex = rand.nextInt(inSet.size());
        int outIndex = rand.nextInt(outSet.size());

        int inNode = inSet.elementAt(inIndex);
        int outNode = outSet.elementAt(outIndex);

        graph[inNode].append(" " + outNode + " " + edgeWeight);
        graph[outNode].append(" " + inNode + " " + edgeWeight);

        inSet.add(outNode);
        outSet.remove(outIndex);
    }

    static void renderGraph() {
        for (StringBuilder strB : graph) {
            String[] strList= strB.toString().split(" ");
            int length = (strList.length - 1) / 2;
            sb.append(length + strB.toString() + "\n");
        }
        sb.append(weight);
    }

    static void outputGraph() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME, false));
            writer.append(sb.toString());
            writer.close();
            System.out.println(weight);
        } catch(Exception e) {
            System.out.println("ERROR: e");
        }
    }
}