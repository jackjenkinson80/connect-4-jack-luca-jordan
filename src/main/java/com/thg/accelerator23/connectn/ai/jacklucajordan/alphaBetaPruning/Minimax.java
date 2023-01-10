package com.thg.accelerator23.connectn.ai.jacklucajordan.alphaBetaPruning;

import com.thehutgroup.accelerator.connectn.player.Board;
import com.thehutgroup.accelerator.connectn.player.Counter;
import com.thehutgroup.accelerator.connectn.player.GameConfig;
import com.thehutgroup.accelerator.connectn.player.Position;
import com.thg.accelerator23.connectn.ai.jacklucajordan.analysis.BoardAnalyser;
import com.thg.accelerator23.connectn.ai.jacklucajordan.analysis.GameState;

import java.util.ArrayList;
import java.util.List;

public abstract class Minimax {



    private static int evalOfPosition(GameState gameState){

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


    public static int run(Node currentNode, boolean isMaxPlayer){

        if (currentNode.getGameState().isEnd()){
            return evalOfPosition(currentNode.getGameState());
        }


        if (isMaxPlayer){
            int maxEval = -100;

            for (int i = 0; i < currentNode.getChildNodes().size(); i ++){
                Node childNode = currentNode.getChildNodes().get(i);
                int evaluation = run(childNode, false);
                maxEval = Math.max(maxEval, evaluation);
            }
            return maxEval;


        } else {
            int minEval = 100;

            for (int i = 0; i < currentNode.getChildNodes().size(); i ++){
                Node childNode = currentNode.getChildNodes().get(i);
                int evaluation = run(childNode, true);
                minEval = Math.max(minEval, evaluation);
            }
            return minEval;
        }
    }




}
