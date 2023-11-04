import java.io.*;
import java.util.*;

public class day09part1{
    public static int ROWS = 100;
    public static int COLS = 100;
    public static void main(String[] args){

        try {
            File input = new File("day09.txt");
            Scanner myReader = new Scanner(input);
            
            String line;
            int[][] area = new int[ROWS][COLS];
            int i = 0;
            int sum = 0;

            //Parse input and fill matrix
            while(myReader.hasNextLine()){
                    line = myReader.nextLine();
                    System.out.println(line);
                    for (int j = 0; j < COLS; j++) {
                        area[i][j] = Character.getNumericValue(line.charAt(j));
                    }
                    i++;
            }

            //Check matrix for low points
            for (int r = 0; r < ROWS; r++) {
                for (int c = 0; c < COLS; c++) {
                    if(checkAdjacents(area, r, c)){
                        sum += (1 + area[r][c]);
                        System.out.println("r: " + r + ", c: " + c + ", " + area[r][c]);
                    }
                }
            }
            System.out.println("Part 1: " + sum);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static boolean checkAdjacents(int[][] myarea, int i, int j){
        int up = i-1;
        int down = i+1;
        int left = j-1;
        int right = j+1;
        if(up >= 0){ if(myarea[up][j] <= myarea[i][j]){ return false; }}
        if(down < ROWS){ if(myarea[down][j] <= myarea[i][j]){ return false; }}
        if(left >= 0){ if(myarea[i][left] <= myarea[i][j]){ return false; }}
        if(right < COLS){if(myarea[i][right] <= myarea[i][j]){ return false; }}
        return true;
    }
}