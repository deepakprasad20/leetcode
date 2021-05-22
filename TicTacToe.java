import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToe {
    public static char[][] arr = new char[3][3];
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Enter Player 1 name : ");
        String player1 = reader.readLine();
        System.out.println("Enter Player 2 name : ");
        String player2 = reader.readLine();
        System.out.println("X -> " + player1);
        System.out.println("O -> " + player2);

        for(int i  = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                arr[i][j] = '-';
            }
        }
        printArray(arr);
        boolean player1Flag = true;
        boolean player2Flag = false;
        int flag = Integer.MAX_VALUE;
        while(checkMoveLeft(arr) && !checkForWin(arr)){
            if(player1Flag){
                System.out.print(player1 + " turn : ");
                String entry = reader.readLine();
                flag =setEntryPosition(entry,'X');
                if(flag == 0){
                    continue;
                }
                printArray(arr);
                player1Flag = false;
                player2Flag =true;
            } else if(player2Flag){
                System.out.print(player2 + " turn : ");
                String entry = reader.readLine();
                flag = setEntryPosition(entry,'O');
                if(flag == 0){
                    continue;
                }
                printArray(arr);
                player1Flag = true;
                player2Flag =false;
            }
        }
        if(!player1Flag && flag != 0){
            System.out.println(player1 + " Won");
        } else if(!player2Flag && flag != 0){
            System.out.println(player2 + " Won");
        }
    }

    private static boolean checkForWin(char[][] arr) {
        //check for 1st row matched
        if((arr[0][0] == 'X' && arr[0][1] == 'X' && arr[0][2] == 'X') ||
                (arr[0][0] == 'O' && arr[0][1] == 'O' && arr[0][2] == 'O')){
            return true;
        }
        //check for 2nd row
        if((arr[1][0] == 'X' && arr[1][1] == 'X' && arr[1][2] == 'X') ||
                (arr[1][0] == 'O' && arr[1][1] == 'O' && arr[1][2] == 'O')){
            return true;
        }
        //check for 3rd row
        if((arr[2][0] == 'X' && arr[2][1] == 'X' && arr[2][2] == 'X') ||
                (arr[2][0] == 'O' && arr[2][1] == 'O' && arr[2][2] == 'O')){
            return true;
        }

        //check for 1st column matched
        if((arr[0][0] == 'X' && arr[1][0] == 'X' && arr[2][0] == 'X') ||
                (arr[0][0] == 'O' && arr[1][0] == 'O' && arr[2][0] == 'O')){
            return true;
        }
        //check for 2nd row
        if((arr[0][1] == 'X' && arr[1][1] == 'X' && arr[2][1] == 'X') ||
                (arr[0][1] == 'O' && arr[1][1] == 'O' && arr[2][1] == 'O')){
            return true;
        }
        //check for 3rd row
        if((arr[0][2] == 'X' && arr[1][2] == 'X' && arr[2][2] == 'X') ||
                (arr[0][2] == 'O' && arr[1][2] == 'O' && arr[2][2] == 'O')){
            return true;
        }

        //check for diagonal
        if((arr[0][2] == 'X' && arr[1][1] == 'X' && arr[2][0] == 'X') ||
                (arr[0][2] == 'O' && arr[1][1] == 'O' && arr[2][0] == 'O')){
            return true;
        }
        //check for 3rd row
        if((arr[0][0] == 'X' && arr[1][1] == 'X' && arr[2][2] == 'X') ||
                (arr[0][0] == 'O' && arr[1][1] == 'O' && arr[2][2] == 'O')){
            return true;
        }
        return false;
    }

    private static int setEntryPosition(String entry , char ent) {
        int row = Character.getNumericValue(entry.charAt(0));
        int col = Character.getNumericValue(entry.charAt(2));
        if(row < 0 || row > 2 || col < 0 || col > 2){
            System.out.println("Invalid Moves!");
            return 0;
        }
        for(int i  = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                if(i == row && j == col){
                    arr[i][j] = ent;
                }
            }
        }
        return 1;
    }

    private static boolean checkMoveLeft(char[][] arr) {
        for(int i  = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                if(arr[i][j] == '-'){
                 return true;
                }
            }
        }
        return false;
    }

    private static void printArray(char[][] arr) {
        for(int i  = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
