import java.util.ArrayList;

public class Node{
    public int nodeIndex;
    public ArrayList<Node> adjNodes;

    public Node(int nodeIndex, ArrayList<Node> adjNodes){
        this.nodeIndex = nodeIndex;
        this.adjNodes = adjNodes;
    }

    public void addAdj(Node adjNode){
        this.adjNodes.add(adjNode);
    }
    
}
