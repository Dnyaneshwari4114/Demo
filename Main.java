import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;

        Scanner sc = new Scanner(System.in);

        while (!gameOver) {
            printBoard(board);
            System.out.println("Player " + player + " Enter: ");
            int row = sc.nextInt();
            int col = sc.nextInt();

            if (board[row][col] == ' ') {
                board[row][col] = player; // place element

                if (haveWon(board, player)) {
                    gameOver = true;
                    System.out.println("Player " + player + " has won!");
                } else if (isBoardFull(board)) {
                    System.out.println("Board is full! No one is the Winner. Restart the Game. ");
                    resetBoard(board);
                    player = 'X';

                } else {
                    if (player == 'X') {
                        player = 'O';
                    } else {
                        player = 'X';
                    }
                }

            } else {
                System.out.println("Invalid Move. Try Again!");
            }
        }
        printBoard(board);
    }

    public static boolean haveWon(char[][] board, char player) {
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }
        for (int col = 0; col < board.length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }
        // diagonal
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    public static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");

            }
            System.out.println();
        }

    }

    public static boolean isBoardFull(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }

            }
        }

        return true;
    }

    public static void resetBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }

    }
}