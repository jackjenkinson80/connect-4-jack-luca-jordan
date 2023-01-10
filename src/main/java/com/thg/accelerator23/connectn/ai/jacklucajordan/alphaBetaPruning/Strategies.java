package com.thg.accelerator23.connectn.ai.jacklucajordan.alphaBetaPruning;

import com.thehutgroup.accelerator.connectn.player.Board;
import com.thehutgroup.accelerator.connectn.player.Counter;
import com.thg.accelerator23.connectn.ai.jacklucajordan.analysis.GameState;

public class Strategies {

    public static int strategyHub(GameState gameState, Board board) {
        return checkWinCondition(gameState);

    }

    private static int checkWinCondition(GameState gameState) {
        if (gameState.isWin()) {
            if (gameState.getWinner() == Counter.O) {
                return 100;
            } else {
                return -100;
            }
        } else {
            return 0;
        }

    }

    private static int checkForTriplets(Board board) {
        return 1;
    }

    private static int checkForDuplets(Board board) {
        return 1;
    }

    private static int checkForForks(Board board) {
        return 1;
    }
}
