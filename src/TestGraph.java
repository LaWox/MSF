import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class TestGraph{
    
    ArrayList<String> nodes = new ArrayList<>();
        

    public TestGraph(String filepath){
        this.nodes = new ArrayList<>();
        readFile(filepath, nodes);
    }

    public void readFile(String filepath, ArrayList<String> nodes){
        File file = new File(filepath);
        try{
        Scanner input = new Scanner(file);
        nodes.add(input.nextLine());

        while(input.hasNext()){
            nodes.add(input.nextLine());
        }
        input.close(); }

        catch (FileNotFoundException e){
            System.out.println("Wrong file path");
            return;
        }

    }

    public static String getParameters(){
        return nodes.get(0));
    }

    public String getNode(int index){
        int arrIndx=index + 1;
        return this.nodes.get(arrIndx);
    }



    public static void main (String[] args){

    }
}