import java.util.ArrayList;
import java.util.Scanner;

public class BFS{

    // bfs search 
    static public boolean search(int index, int maxHops, int weight){
        int len = 0;
        ArrayList<Integer> queue = new ArrayList<>();
        queue.add(index);
        ArrayList<Integer> neighbours = new ArrayList<>();

        while(len < maxHops){
            if(queue.size() != 0){
                neighbours = getNeighbours(queue.get(0), weight);
                len += 1;
                for(Integer node: neighbours){
                    queue.add(node);
                }
            }
            // if empty we've explored the subgraph
            else{
                return true;
            }
        }
         
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
}