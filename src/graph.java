import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;
import java.util.Vector;

public class Graph {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static double approx = 1.2;
    static int W;

    static String FILENAME = "graph.txt";
    static int[] Nspan = {10000, 12000};
    static int[] Wspan = {1, 10};

    static Random rand = new Random();

    static StringBuilder[] graph;

    static int weight = 0;

    static Vector<Integer> inSet = new Vector<Integer>();
    static Vector<Integer> outSet = new Vector<Integer>();

    public static void main(String[] args) {
        init();
        while (!outSet.isEmpty()) {
            addEdge();
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

        sb.append(N + "\n" + approx + "\n" + W + "\n");
        initSets();
    }

    public static void addEdge() {
        int inIndex = rand.nextInt(inSet.size());
        int outIndex = rand.nextInt(outSet.size());

        int inNode = inSet.elementAt(inIndex);
        int outNode = outSet.elementAt(outIndex);

        graph[inNode].append(" " + outNode);
        graph[outNode].append(" " + inNode);

        inSet.add(outNode);
        outSet.remove(outIndex);
    }

    static void renderGraph() {
        for (StringBuilder strB : graph) {
            String[] strList= strB.toString().split(" ");
            int length = strList.length - 1;
            sb.append(length + strB.toString() + "\n");
        }
    }

    static void outputGraph() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME, false));
            writer.append(sb.toString());
            writer.close();
        } catch(Exception e) {
            System.out.println("ERROR: e");
        }
    }
}