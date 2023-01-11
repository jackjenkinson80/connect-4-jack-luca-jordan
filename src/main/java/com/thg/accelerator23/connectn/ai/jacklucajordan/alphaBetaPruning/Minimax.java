package com.thg.accelerator23.connectn.ai.jacklucajordan.alphaBetaPruning;

import com.thehutgroup.accelerator.connectn.player.Board;
import com.thehutgroup.accelerator.connectn.player.Counter;
import com.thehutgroup.accelerator.connectn.player.InvalidMoveException;
import com.thg.accelerator23.connectn.ai.jacklucajordan.analysis.GameState;

import java.util.List;


public abstract class Minimax {



    private static int evalOfPosition(GameState gameState, int depth){

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


    public static int[] run(Node currentNode, boolean isMaxPlayer, int alpha, int beta, int depth){

        try {
            currentNode.findChildNodes();
        } catch (InvalidMoveException e) {
            throw new RuntimeException(e);
        }

        int[] evalAndMove = new int[2];

        List<Integer> potentialMoves = currentNode.findPotentialMoves();


        if (currentNode.getGameState().isEnd()){
            evalAndMove[0] = evalOfPosition(currentNode.getGameState(), depth);
            evalAndMove[1] = -1;
            return evalAndMove;
        }


        if (isMaxPlayer){
            int maxEval = -100;

            for (int i = 0; i < currentNode.getChildNodes().size(); i ++) {
                Node childNode = currentNode.getChildNodes().get(i);


                evalAndMove = run(childNode, false, alpha, beta, depth + 1);
                evalAndMove[1] = potentialMoves.get(i);
                maxEval = Math.max(maxEval, evalAndMove[0]);
                if (maxEval > beta) {
                    break;
                }
                alpha = Math.max(alpha, maxEval);
            }
            return evalAndMove;


        } else {
            int minEval = 100;

            for (int i = 0; i < currentNode.getChildNodes().size(); i ++){
                Node childNode = currentNode.getChildNodes().get(i);

                evalAndMove = run(childNode, true, alpha, beta, depth + 1);
                evalAndMove[1] = potentialMoves.get(i);
                minEval = Math.min(minEval, evalAndMove[0]);

                if (minEval < alpha){
                    break;
                }
                beta = Math.min(beta, minEval);
            }
            return evalAndMove;
        }
    }




}
