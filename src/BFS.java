import java.util.*;

public class BFS{

    static Scanner sc;
    static HashMap<Integer, Boolean> visited = new HashMap<>();
    static HashMap<Integer, String> nodes = new HashMap<>();
    static Queue<Integer> queue = new LinkedList<>();
    static int curentNode;



    
    static public int search(int index, int maxHops, int weight, Scanner s){
        sc = s;
        int len = 0;

        visited = new HashMap<>();
        queue = new LinkedList<>();

        queue.add(index);

        while(len <= maxHops){
            if(queue.size() != 0){
                curentNode = queue.remove();   
                len += 1;
                if (Main.DEBUG) {
                    String neighbourData = Main.test.getNode(curentNode);
                    handleNeighbours(neighbourData, weight);
                } else {
                    getNeighbours(curentNode, weight);
                }             
            }
            // if empty we've explored the subgraph
            else{
                return 1;
            }
        }
        // we didn't explore the subgraph
        return 0;
    }

    //Kattis comm
    static private void getNeighbours(int index, int maxWeight){
        int nodeIndex; // index of of start node
        int noNodes;  // no of neighbours

        // send data to Kattis
        System.out.println(index);

        noNodes = sc.nextInt();
        
        // add nodes that have  correct weight to the array
        for(int i = 0; i < noNodes; i++){
            nodeIndex = sc.nextInt();

            int w = sc.nextInt();
            if(visited.get(nodeIndex) == null){ 
                visited.put(curentNode, true); 
                if(w <= maxWeight){
                    queue.add(nodeIndex);
                }
            }
        }
    }

    static private void handleNeighbours(String str, int weight){
        //ArrayList<Integer> nodes = new ArrayList<>();

        String[] strList = str.split(" ");
        Integer noNodes = Integer.valueOf(strList[0]);
        //System.out.println("noNodes: " + noNodes);

        for(int i = 0; i < noNodes*2; i+=2){
            //System.out.println("i: " + i);
            int nodeIndex = Integer.valueOf(strList[i+1]);
            if(Integer.valueOf(strList[i+2]) <= weight){
                queue.add(nodeIndex);
            }
        }
        //return nodes;
    }

    public static void main(String[] args){
    }
}