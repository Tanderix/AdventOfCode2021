import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;

public class day07part1{
    public static void main(String[] args){

        try {
            File input = new File("day07.txt");
            Scanner myReader = new Scanner(input);
            
            String[] line;
            int[] pos;
            int sum = 0;
            int leastfuel = Integer.MAX_VALUE;

            //Parse input
            while(myReader.hasNextLine()){
                line = myReader.nextLine().split(",");
                pos = new int[line.length];
                for (int i = 0; i < line.length; i++) {
                    pos[i] = Integer.parseInt(line[i]);
                }

                //Get max
                int max = -1;
                for (int i = 0; i < pos.length; i++) {
                    if(pos[i] > max){
                        max = pos[i];
                    }
                }

                //Update
                for(int j = 0; j<max; j++){
                    for (int i = 0; i < pos.length; i++) {
                        sum = sum + Math.abs(pos[i] - j);
                    }
                    if(sum < leastfuel){
                        leastfuel = sum; 
                    }
                    sum = 0;    
                } 
            }       

            System.out.println("Part 1: " + leastfuel);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}