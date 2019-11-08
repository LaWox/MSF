import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class TestGraph{

    static ArrayList<String> nodes = new ArrayList<>();

    public TestGraph(){
        //String filepath;
        //ArrayList<String> nodes = new ArrayList<>();

    }

    public static void readFile(String filepath){
        File file = new File(filepath);
        try{
        Scanner input = new Scanner(file);
        nodes.add(input.next());

        while(input.hasNext()){
            nodes.add(input.next());
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

    public static String getNode(int index){
        int arrIndx=index + 1;
        return nodes.get(arrIndx);
    }



    public static void main (String[] args){

    }
}