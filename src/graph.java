import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;
import java.util.Vector;

public class Graph {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static double approx = 1.05;
    static int W;

    static String FILENAME = "graph.txt";
    static double[] Nspan = {100000, 100000+1};
    static int[] Wspan = {4, 5};
    static int[] TreesSpan = {0, 50000};
    static int noTrees;

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
        while (!outSet.isEmpty()) {
            addEdge();
        }
        renderGraph();
        outputGraph();
    }

    public static void initSets() {
        for (int i = 0; i < N; i++) {
            graph[i] = new StringBuilder();
            outSet.add(i);
        }
        noTrees = TreesSpan[0] + rand.nextInt(TreesSpan[1] - TreesSpan[0]);
        for (int i = 0; i < noTrees; i++) {
            int outIndex = rand.nextInt(outSet.size());
            int outNode = outSet.elementAt(outIndex);
            addToInSet(outNode, outIndex);
        }


    }

    public static void init() {
        int i = (int) (Nspan[1] - Nspan[0]);
        N = (int) Nspan[0] + rand.nextInt(i);
        W = Wspan[0] + rand.nextInt(Wspan[1] - Wspan[0]);

        graph = new StringBuilder[N];

        sb.append(N + " " + approx + " " + W + "\n");
        initSets();
    }

    public static void addToInSet(int outNode, int outIndex) {
        inSet.add(outNode);
        outSet.remove(outIndex);
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

        addToInSet(outNode, outIndex);
    }

    static void renderGraph() {
        for (StringBuilder strB : graph) {
            String[] strList= strB.toString().split(" ");
            int length = (strList.length - 1) / 2;
            sb.append(length + strB.toString() + "\n");
        }
        sb.append(weight + "\n");
        sb.append(noTrees);

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