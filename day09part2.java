import java.io.*;
import java.util.*;

public class day09part2{
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
            ArrayList<Integer> basins = new ArrayList<Integer>();
            

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
                        System.out.println("r: " + r + ", c: " + c + ", " + area[r][c]);
                        //Check basins
                        basins.add(checkBasins(area, r, c));
                    }
                }
            }
            Collections.sort(basins);
            Collections.reverse(basins);
            System.out.println("Part 2: " + (basins.get(0) * basins.get(1) * basins.get(2)));
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

    public static int checkBasins(int[][] myarea, int i, int j){
        int sum = 0;
        Low point;
        ArrayList<Low> toVisit = new ArrayList<Low>();
        ArrayList<Low> visited = new ArrayList<Low>();
        toVisit.add(new Low(i,j));

        while(toVisit.size() > 0) {
            Low low = toVisit.get(0);
            if(!myContains(low, visited)){
                int row = low.r;
                int col = low.c;
                int up = low.r-1;
                int down = low.r+1;
                int left = low.c-1;
                int right = low.c+1;
                if(up >= 0 && myarea[up][col] > myarea[up+1][col] && myarea[up][col] != 9){
                    point = new Low(up, col);
                    if(!myContains(point, toVisit)){
                        toVisit.add(point);
                    }
                }
                if(left>=0 && myarea[row][left] > myarea[row][left+1] && myarea[row][left] != 9){
                    point = new Low(row, left);
                    if(!myContains(point, toVisit)){
                        toVisit.add(point);
                    }
                }
                if(down < ROWS && myarea[down][col] > myarea[down-1][col] && myarea[down][col] != 9){
                    point = new Low(down, col);
                    if(!myContains(point, toVisit)){
                        toVisit.add(point);
                    }
                }
                if(right < COLS && myarea[row][right] > myarea[row][right-1] && myarea[row][right] != 9){
                    point = new Low(row, right);
                    if(!myContains(point, toVisit)){
                        toVisit.add(point);
                    }
                }
                sum++;
                visited.add(low);
            }

            toVisit.remove(low);

        }
        return sum;
    }

    public static boolean myContains(Low p, ArrayList<Low> list){
        for(int i=0; i<list.size(); i++){
            if(p.r == list.get(i).r && p.c == list.get(i).c){
                return true;
            }
        }
        return false;
    }

    static class Low{
        public int r;
        public int c;

        public Low(int a, int b){
            r = a;
            c = b;
        }
    }
}