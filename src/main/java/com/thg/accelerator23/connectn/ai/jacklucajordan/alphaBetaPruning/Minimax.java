package com.thg.accelerator23.connectn.ai.jacklucajordan.alphaBetaPruning;

import com.thehutgroup.accelerator.connectn.player.Board;
import com.thehutgroup.accelerator.connectn.player.Counter;
import com.thehutgroup.accelerator.connectn.player.InvalidMoveException;
import com.thg.accelerator23.connectn.ai.jacklucajordan.analysis.BoardAnalyser;
import com.thg.accelerator23.connectn.ai.jacklucajordan.analysis.GameState;

import java.util.ArrayList;
import java.util.List;


public abstract class Minimax {



    private static int evalOfPosition(Node node){
        BoardAnalyser boardAnalyser = new BoardAnalyser(node.board.getConfig());
        GameState gameState = boardAnalyser.calculateGameState(node.board);

        if (gameState.isWin()){
            if (gameState.getWinner() == Counter.O){
                return 1;
            } else {
                return -1;
            }
        } else {
            return 0;
        }
    }

    public static List<Integer> minimax(Node node, boolean isMaxPlayer, int alpha, int beta){
        System.out.println("run minimax");
        BoardAnalyser boardAnalyser = new BoardAnalyser(node.board.getConfig());
        GameState gameState = boardAnalyser.calculateGameState(node.board);

        List<Integer> valueAndMove = new ArrayList<Integer>();
        List<Integer> bestValueAndMove = new ArrayList<Integer>();
        List<Integer> potentialMoves = node.potentialMoves();


        bestValueAndMove.add(0);
        bestValueAndMove.add(0);
        int value;

        if (gameState.isEnd()){
            bestValueAndMove.add(evalOfPosition(node));
            bestValueAndMove.add(-1);
            System.out.println("endSize:");
            System.out.println(bestValueAndMove.size());
            return bestValueAndMove;

        } else if (isMaxPlayer){

            int maxValue = -100;

            for (int i = 0; i < potentialMoves.size(); i++) {
                int potentialMove = potentialMoves.get(i);
                Node childNode = new Node(node, potentialMove);
                valueAndMove = minimax(childNode, false, alpha, beta);
                value = valueAndMove.get(0);

                alpha = Math.max(value, alpha);

                if (value > maxValue) {
                    bestValueAndMove.set(0, valueAndMove.get(0));
                    bestValueAndMove.set(1, i);
                }

                if (value >= beta){
                    break;
                }
            }
            System.out.print("maxi: ");
            System.out.println(bestValueAndMove.size());
            return bestValueAndMove;


        } else {
            int minValue = 100;

            for (int i = 0; i < potentialMoves.size(); i++) {
                int potentialMove = potentialMoves.get(i);
                Node childNode = new Node(node, potentialMove);
                valueAndMove = minimax(childNode, true, alpha, beta);
                value = valueAndMove.get(0);

                beta = Math.min(value, beta);

                if (value < minValue) {
                    bestValueAndMove = valueAndMove;
                }

                if (value <= alpha){
                    break;
                }
            }
            System.out.print("mini: ");
            System.out.println(bestValueAndMove.size());
            return bestValueAndMove;
        }
    }
}
