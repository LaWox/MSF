public class Main {
    public static boolean DEBUG = false;
    public static String FILENAME = "graph.txt";

    public static TestGraph test = null;


    public static void main(String[] args) {
        Graph.createGraph();
        if (DEBUG) {
            test = new TestGraph(FILENAME);
        }
        MSF.runMSF();
    }



}