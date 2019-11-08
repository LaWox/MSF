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

        while(len < maxHops){
            if(queue.size() != 0){

                if(!visited.contains(queue.get(0))){

                    
                    TestGraph test = new TestGraph();
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
        int nodeIndex;

        // send data to Kattis
        System.out.println(index);

        // scan input from Kattis
        Scanner input = new Scanner(System.in);
        
        int noNodes = input.nextInt();
        ArrayList<Integer> nodes = new ArrayList<>();

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
        for(int i = 0; i < noNodes; i+=2){
            int nodeIndex = Integer.valueOf(strList[i+1]);
            if(Integer.valueOf(strList[i+1]) <= weight){
                nodes.add(nodeIndex);
            }
        }
        return nodes;
    }

    public static void main(String[] args){
        search(5, 3, 2);
    }
}