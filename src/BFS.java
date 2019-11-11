import java.util.*;

public class BFS{

    static Scanner sc;
    static HashMap<Integer, Boolean> visited = new HashMap<>();
    static Queue<Integer> queue = new LinkedList<>();

    // breadth firdt search 


    
    static public boolean search(int index, int maxHops, int weight, Scanner s){
        Boolean a = null;
        sc = s;
        int len = 0;
        
        visited = new HashMap<>();
        queue = new LinkedList<>();
        //ArrayList<Integer> queue = new ArrayList<>();
        //ArrayList<Integer> visited  = new ArrayList<>();
        
        queue.add(index);
        ArrayList<Integer> neighbours = new ArrayList<>();

        while(len <= maxHops){
            if(queue.size() != 0){
                int curentNode = queue.remove();
                if(visited.get(curentNode) == null){
                    
                    if (Main.DEBUG) {
                        String neighbourData = Main.test.getNode(curentNode);
                        handleNeighbours(neighbourData, weight);
                    }
                    else {
                        neighbours = getNeighbours(curentNode, weight);
                    }
                    len += 1;
                    visited.put(curentNode, true);

                     //add to neighbour array
                    for(Integer node: neighbours){
                        queue.add(node);
                    }
                }
            }
            // if empty we've explored the subgraph
            else{
                return true;
            }
        }
        
        // we didn't explore the subgraph
        return false;
    }

    //Kattis comm
    static private ArrayList<Integer> getNeighbours(int index, int maxWeight){
        int nodeIndex; // index of of start node
        int noNodes;  // no of neighbours
        ArrayList<Integer> nodes = new ArrayList<>();

        

        // send data to Kattis
        System.out.println(index);

        // scanner for input from Kattis
        //Scanner input = new Scanner(System.in);

        noNodes = sc.nextInt();
        

        // add nodes that have  correct weight to the array
        for(int i = 0; i < noNodes; i++){
            nodeIndex = sc.nextInt();

            int w = sc.nextInt();
            if(w <= maxWeight){
                nodes.add(nodeIndex);
            }
        }
        return nodes;
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
                //System.out.println("added node: " + nodeIndex);
                queue.add(nodeIndex);
            }
        }
        //return nodes;
    }

    public static void main(String[] args){
    }
}