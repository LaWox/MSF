public class Main {
    public static boolean DEBUG = true;
    public static String FILENAME = "graph.txt";

    public static TestGraph test = null;


    public static void main(String[] args) {
        Graph.createGraph();
        test = new TestGraph(FILENAME);
        for (int j = 0; j < 20; j++) {
            MSF.runMSF();
        }
        System.out.println("#OK: "+ test.countOK +" #NOT OK: "+ test.countNOT+" ratio ok/#runs: " + (float)(test.countOK)/20);
    }



}