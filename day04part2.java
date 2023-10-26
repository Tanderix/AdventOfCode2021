import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;

public class day04part2{
    public static void main(String[] args){
        try {

            File input = new File("day04.txt");
            Scanner myReader = new Scanner(input);

            String[] drawn = myReader.nextLine().split(",");
            List<Integer> drawnList = new ArrayList<Integer>();
            String[] row = new String[6];
            Integer[][] newboard = new Integer[6][6];
            List<Integer[][]> boards = new ArrayList<Integer[][]>();
            Integer currentNumber;
            List<Integer> currentDrawn = new ArrayList<Integer>();
            int timesWon = 0;
            int[] boardsWon = new int[101];

            //Input parsing
            for(int i=0; i< boardsWon.length; i++){
                boardsWon[i] = 0;
            }

            for(int i=0; i<drawn.length; i++){
                drawnList.add(Integer.parseInt(drawn[i]));
            }

            while (myReader.hasNextLine()) {    
                //Empty Line
                myReader.nextLine();

                //Get row by row
                newboard = new Integer[6][6];
                for(int i=0; i<5; i++){
                    row = myReader.nextLine().trim().split("\s+");
                    for(int j=0; j<5; j++){
                        newboard[i][j] = Integer.parseInt(row[j]);
                    }
                    newboard[i][5] = 0;
                }

                //Last control row
                for(int i=0; i<5;i++){
                    newboard[5][i] = 0;
                }

                boards.add(newboard);
            }

            //Draw new number
            for(int i=0; i<drawnList.size(); i++){
                currentNumber = drawnList.get(i);
                currentDrawn.add(currentNumber);

                //For all boards
                for(int j=0; j<boards.size();j++){
                    if(boardsWon[j] == 0){
                        Integer[][] currentBoard = boards.get(j);
                        //For each row
                        for(int k=0; k<5; k++){
                            //For each column
                            for(int l=0; l<5; l++){
                                if(currentBoard[k][l] == currentNumber){
                                    currentBoard[k][5] = currentBoard[k][5] + 1;
                                    currentBoard[5][l] = currentBoard[5][l] + 1;

                                    if((currentBoard[k][5] == 5 || currentBoard[5][l] == 5)){
                                        int sum = 0;
                                        int result = 0;
                                        for(int r=0; r<5; r++){
                                            for(int c=0; c<5; c++){
                                                if(!currentDrawn.contains(currentBoard[r][c])){
                                                    sum = sum + currentBoard[r][c];
                                                } 
                                            }
                                        }
                                        timesWon++;
                                        boardsWon[j] = 1;
                                        if(timesWon == boards.size()){
                                            result = sum * currentNumber;
                                            System.out.println("Part 2: " + result);
                                        }
                                    }
                                }   
                            }
                        }

                        boards.set(j, currentBoard);
                    }
                }
            }
        
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}