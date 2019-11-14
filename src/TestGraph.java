import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class TestGraph{

    public int countOK;
    public int countNOT;
    
    ArrayList<String> nodes = new ArrayList<>();
        

    public TestGraph(String filepath){
        this.nodes = new ArrayList<>();
        countNOT=0;
        countOK=0;
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
            input.close(); 
        } catch (FileNotFoundException e){
            //System.out.println("Wrong file path");
            return;
        }

    }

    public String getParameters(){
        return this.nodes.get(0);

    }

    public String evalAwnser(double awnser) {
        StringBuilder sb = new StringBuilder();
        int w = Integer.valueOf(nodes.get(nodes.size() - 2));
        int noTrees = Integer.valueOf(nodes.get(nodes.size() - 1));
        double approx = Float.valueOf(nodes.get(0).split(" ")[1]);

        sb.append("Awnsewr: " + awnser + " W: " + w + " no. Trees: " + noTrees);


        if (awnser >= w * (2-approx) && awnser <= w * approx) {
            //sb.append(" OK!");
            countOK++;
        } else {
            //sb.append(" NOT OK! :(");
            countNOT++;
        }
        sb.append(" " + awnser/w);

        return "";
    }

    public String getNode(int index){
        int arrIndx=index + 1;
        return this.nodes.get(arrIndx);
    }



    public static void main (String[] args){

    }
}