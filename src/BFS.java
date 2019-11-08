import java.util.ArrayList;
import java.util.Scanner;

public class BFS{

    // breadth firdt search 
    static public boolean search(int index, int maxHops, int weight){
        int len = 0;
        ArrayList<Integer> queue = new ArrayList<>();
        ArrayList<Integer> visited  = new ArrayList<>();
        
        queue.add(index);
        ArrayList<Integer> neighbours = new ArrayList<>();
        TestGraph test = new TestGraph("Graph1.txt");

        while(len < maxHops){
            if(queue.size() != 0){
                if(!visited.contains(queue.get(0))){

                    String neighbourData = test.getNode(queue.get(0));
                    neighbours = handleNeighbours(neighbourData, weight);
                    
                    //neighbours = getNeighbours(queue.get(0), weight);
                    len += 1;
                    visited.add(queue.get(0));

                    // add to neighbour array
                    for(Integer node: neighbours){
                        queue.add(node);
                    }
                }
                queue.remove(0);
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

        // scanner for input from Kattis
        Scanner input = new Scanner(System.in);

        // send data to Kattis
        System.out.println(index);

        noNodes = input.nextInt();

        // add nodes that have  correct weight to the array
        for(int i = 0; i < noNodes; i++){
            nodeIndex = input.nextInt();

            if(input.nextInt() <= maxWeight){
                nodes.add(nodeIndex);
            }
        }
        input.close();
        return nodes;
    }

    static private ArrayList<Integer> handleNeighbours(String str, int weight){
        ArrayList<Integer> nodes = new ArrayList<>();

        String[] strList = str.split(" ");
        Integer noNodes = Integer.valueOf(strList[0]);
        //System.out.println("noNodes: " + noNodes);

        for(int i = 0; i < noNodes*2; i+=2){
            //System.out.println("i: " + i);
            int nodeIndex = Integer.valueOf(strList[i+1]);
            if(Integer.valueOf(strList[i+2]) <= weight){
                //System.out.println("added node: " + nodeIndex);
                nodes.add(nodeIndex);
            }
        }
        return nodes;
    }

    public static void main(String[] args){
        search(0, 2, 2);
    }
}