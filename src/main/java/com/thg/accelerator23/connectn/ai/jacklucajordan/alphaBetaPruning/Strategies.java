package com.thg.accelerator23.connectn.ai.jacklucajordan.alphaBetaPruning;

import com.thehutgroup.accelerator.connectn.player.Board;
import com.thehutgroup.accelerator.connectn.player.Counter;
import com.thehutgroup.accelerator.connectn.player.Position;
import com.thg.accelerator23.connectn.ai.jacklucajordan.analysis.GameState;

public class Strategies {

    public static int strategyHub(GameState gameState, Board board, Counter nodeCounter) {
        checkWinCondition(gameState);
        for (int i = 0; i < board.getConfig().getWidth(); i++) {
            for (int j = 0; j < board.getConfig().getHeight(); j++) {
                Position currentPositionOnBoard = new Position(i, j);
                Counter counterBeingParsedForEvaluation = board.getCounterAtPosition(currentPositionOnBoard);

            }
        }
        return checkWinCondition(gameState);

    }

    private static int checkWinCondition(GameState gameState) {
        if (gameState.isWin()) {
            return 100;
        } else
            return 0;

    }

    private static int moveInMiddleRowIfIsGoodMove(Board board, Counter targetCounter) {
        return 1;
    }

    private static int checkForTriplets(Board board, Counter targetCounter) {
        return 1;
    }

    private static int checkForDuplets(Board board, Counter targetCounter) {
        return 1;
    }

    private static int checkForForks(Board board, Counter targetCounter) {
        return 1;
    }

}
