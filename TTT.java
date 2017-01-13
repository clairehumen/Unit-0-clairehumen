package com.company;

import java.util.Scanner;

public class Board {

    public static void main(String[] args) {
        Board board = new Board();
        while ( board.isGameOn() )
        {
            board.getEntry();
        }
        System.out.println("Your winner is: " + board.getWinnerIs());
        board.drawBoard();
        System.out.println("=============================================================");
        System.out.println("GAME OVER.");
        System.out.println("=============================================================");

    }
    private String[] board = new String[]{"1","2","3","4","5","6","7","8","9"} ;

    public static String X = "X" ;
    public static String O = "O" ;

    private String currentInput = X ;
    private String winnerIs = "NO ONE" ;

    public Board()
    {
        super();
    }

    private boolean isBoardFull()
    {
        for ( int i = 0 ; i < board.length ; i++ )
        {
            if ( ! board[i].equals(X) && ! board[i].equals(O) )
            {
                return false ;
            }
        }
        return true ;
    }

    public boolean isGameOn()
    {
        if ( isBoardFull() )
        {
            return false ;
        }

        boolean gameOn = true ;

        gameOn = isWinning(0,1,2) ? false : gameOn ;
        gameOn = isWinning(3,4,5) ? false : gameOn ;
        gameOn = isWinning(6,7,8) ? false : gameOn ;

        gameOn = isWinning(0,4,7) ? false : gameOn ;
        gameOn = isWinning(2,4,6) ? false : gameOn ;

        gameOn = isWinning(0,3,6) ? false : gameOn ;
        gameOn = isWinning(1,4,7) ? false : gameOn ;
        gameOn = isWinning(2,5,8) ? false : gameOn ;

        return gameOn ;
    }

    private boolean isWinning(int a, int b, int c )
    {
        boolean winning = board[a].equals(board[b]) && board[b].equals(board[c]) ;
        if ( winning )
        {
            winnerIs = board[a] ;
        }
        return winning ;
    }


    public void getEntry()
    {
        Scanner keyboard = new Scanner(System.in);
        drawBoard();
        System.out.print("Enter square number 1-9 for " + currentInput + ":" );
        String entry = keyboard.nextLine().trim().toLowerCase() ;
        boolean goodInput = false ;

        for ( int i = 0 ; i < board.length ; i++ )
        {
            if ( board[i].equals(entry) )
            {
                board[i] = currentInput ;
                currentInput = currentInput.equals(X) ? O : X ;
                goodInput = true ;
            }
        }

        if ( ! goodInput )
        {
            System.out.println("That was a baaaaaad entry");
        }
    }

    public void drawBoard()
    {
        StringBuffer sb = new StringBuffer();
        String newline = "\n" ;
        sb.append("-------");
        sb.append(newline);
        for ( int i = 0 ; i < board.length ; i+=3)
        {
            sb.append("|" + board[i] + "|" + board[i+1] + "|" + board[i+2] + "|") ;
            sb.append(newline) ;
            sb.append("-------");
            sb.append(newline) ;
        }

        System.out.println(sb.toString());
    }

    public String getWinnerIs() {
        return winnerIs;
    }

    public void setWinnerIs(String winnerIs) {
        this.winnerIs = winnerIs;
    }



}