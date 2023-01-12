package com.thg.accelerator23.connectn.ai.jacklucajordan.alphaBetaPruning;

import java.util.ArrayList;

import com.thehutgroup.accelerator.connectn.player.Board;
import com.thehutgroup.accelerator.connectn.player.Counter;
import com.thehutgroup.accelerator.connectn.player.Position;
import com.thg.accelerator23.connectn.ai.jacklucajordan.analysis.GameState;

public class Strategies {

    public static int strategyHub(Board board, Counter nodeCounter) {
        return checkRowsOfFour(board, nodeCounter);

    }

    private static int checkRowsOfFour(Board board, Counter counterThatDeterminesPositiveCounter) {
        int evalSum = 0;
        for (int column = 0; column < board.getConfig().getWidth(); column++) {
            for (int row = 0; row < board.getConfig().getHeight(); row++) {
                Position originPositionForQuandruplets = new Position(column, row);
                if (column <= board.getConfig().getWidth() - 3) {
                    evalSum += checkCountersForHorizontal(board, counterThatDeterminesPositiveCounter,
                            originPositionForQuandruplets);
                }
                // verticals
                if (row < board.getConfig().getHeight() - 3) {
                    evalSum += checkCountersForVertical(board, counterThatDeterminesPositiveCounter,
                            originPositionForQuandruplets);
                }
                if (column < board.getConfig().getWidth() - 3 && row < board.getConfig().getHeight() - 3) {
                    evalSum += checkCountersForLeftToRightDiagonal(board, counterThatDeterminesPositiveCounter,
                            originPositionForQuandruplets);
                }
                if (column > 3 && row < board.getConfig().getHeight() - 3) {
                    evalSum += checkCountersForRightToLeftDiagonal(board, counterThatDeterminesPositiveCounter,
                            originPositionForQuandruplets);
                }

            }

        }
        return evalSum;

    }

    private static int checkFour(Board board, Counter targetCounter, Position[] positions) {
        int posSum = 0;
        boolean hasTargetCounter = false;
        boolean hasOppositeCounter = false;
        for (int i = 0; i < positions.length; i++) {
            if (board.getCounterAtPosition(positions[i]) != null) {

                if (board.getCounterAtPosition(positions[i]).equals(targetCounter)) {
                    hasTargetCounter = true;
                    posSum++;
                }
                if (board.getCounterAtPosition(positions[i]).equals(targetCounter.getOther())) {
                    hasOppositeCounter = true;
                    posSum--;
                }
                if (hasTargetCounter && hasOppositeCounter) {
                    return 0;
                }
            } else {

            }

        }
        return posSum;
    }

    private static int checkCountersForHorizontal(Board board,
            Counter targetcounterThatDeterminesPositiveCounterCounter, Position orginCounter) {
        int xOfOriginCounter = orginCounter.getX();
        int yOfOriginCounter = orginCounter.getY();

        Position p1 = new Position(xOfOriginCounter + 1, yOfOriginCounter);

        Position p2 = new Position(xOfOriginCounter + 2, yOfOriginCounter);

        Position p3 = new Position(xOfOriginCounter + 3, yOfOriginCounter);
        Position[] positionlist = new Position[] { orginCounter, p1, p2, p3 };
        int result = checkFour(board, targetcounterThatDeterminesPositiveCounterCounter, positionlist);

        return result;
    }

    private static int checkCountersForVertical(Board board, Counter targetCounterThatDeterminesPositiveCounterCounter,
            Position orginCounter) {
        int xOfOriginCounter = orginCounter.getX();
        int yOfOriginCounter = orginCounter.getY();
        Position p1 = new Position(xOfOriginCounter, yOfOriginCounter + 1);

        Position p2 = new Position(xOfOriginCounter, yOfOriginCounter + 2);

        Position p3 = new Position(xOfOriginCounter, yOfOriginCounter + 3);
        Position[] positionlist = new Position[] { orginCounter, p1, p2, p3 };
        int result = checkFour(board, targetCounterThatDeterminesPositiveCounterCounter, positionlist);
        return result;

    }

    private static int checkCountersForLeftToRightDiagonal(Board board,
            Counter targetCounterThatDeterminesPositiveCounterCounter, Position orginCounter) {
        int xOfOriginCounter = orginCounter.getX();
        int yOfOriginCounter = orginCounter.getY();
        Position p1 = new Position(xOfOriginCounter + 1, yOfOriginCounter + 1);

        Position p2 = new Position(xOfOriginCounter + 2, yOfOriginCounter + 2);

        Position p3 = new Position(xOfOriginCounter + 3, yOfOriginCounter + 3);
        Position[] positionlist = new Position[] { orginCounter, p1, p2, p3 };
        int result = checkFour(board, targetCounterThatDeterminesPositiveCounterCounter, positionlist);
        return result;

    }

    private static int checkCountersForRightToLeftDiagonal(Board board,
            Counter targetCounterThatDeterminesPositiveCounterCounter, Position orginCounter) {
        int xOfOriginCounter = orginCounter.getX();
        int yOfOriginCounter = orginCounter.getY();
        Position p1 = new Position(xOfOriginCounter - 1, yOfOriginCounter - 1);

        Position p2 = new Position(xOfOriginCounter - 2, yOfOriginCounter - 2);

        Position p3 = new Position(xOfOriginCounter - 3, yOfOriginCounter - 3);
        Position[] positionlist = new Position[] { orginCounter, p1, p2, p3 };
        int result = checkFour(board, targetCounterThatDeterminesPositiveCounterCounter, positionlist);
        return result;

    }

}