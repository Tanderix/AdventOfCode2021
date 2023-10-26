import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;

public class day05part1{
    public static void main(String[] args){
        int gridSize = 999;

        try {
            File input = new File("day05.txt");
            Scanner myReader = new Scanner(input);

            String[] line;
            String[] start;
            String[] finish;
            int startX;
            int startY;
            int finishX;
            int finishY;
            int[][] grid = new int[gridSize][gridSize];

            //Parse input
            while(myReader.hasNextLine()){
                line = myReader.nextLine().split(" -> ");
                start = line[0].split(",");
                finish = line[1].split(",");
                startX = Integer.parseInt(start[0]);
                startY = Integer.parseInt(start[1]);
                finishX = Integer.parseInt(finish[0]);
                finishY = Integer.parseInt(finish[1]);

                if(startX == finishX){
                    //Have to draw vertical
                    if(startY < finishY){
                        for(int y=startY; y<=finishY; y++){
                            grid[y][startX] = grid[y][startX] + 1;
                        }   
                    }else{
                        for(int y=finishY; y<=startY; y++){
                            grid[y][startX] = grid[y][startX] + 1;
                        }                         
                    }

                }else if(startY == finishY){
                    //Have to draw horizontal
                    if(startX < finishX){
                        for(int y=startX; y<=finishX; y++){
                            grid[startY][y] = grid[startY][y] + 1;
                        }
                    }else{
                        for(int y=finishX; y<=startX; y++){
                            grid[startY][y] = grid[startY][y] + 1;
                        }
                    }
                }
            }

            int sum = 0;
            for(int i=0; i<gridSize; i++){
                for(int j=0; j<gridSize; j++){
                    if(grid[i][j] > 1){
                        sum++;
                    }
                }
            }

            //printGrid(grid, gridSize);

            System.out.println("Part 1: " + sum);
         
        
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void printGrid(int[][] grid, int gridSize){
        //Print grid
        for(int i=0; i<gridSize; i++){
            for(int j=0; j<gridSize; j++){
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }   
    }
}