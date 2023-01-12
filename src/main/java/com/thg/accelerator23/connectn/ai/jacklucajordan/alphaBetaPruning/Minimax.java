package com.thg.accelerator23.connectn.ai.jacklucajordan.alphaBetaPruning;

import com.thehutgroup.accelerator.connectn.player.Board;
import com.thehutgroup.accelerator.connectn.player.Counter;
import com.thehutgroup.accelerator.connectn.player.InvalidMoveException;
import com.thehutgroup.accelerator.connectn.player.Position;
import com.thg.accelerator23.connectn.ai.jacklucajordan.analysis.BoardAnalyser;
import com.thg.accelerator23.connectn.ai.jacklucajordan.analysis.GameState;

import java.util.ArrayList;
import java.util.List;

public abstract class Minimax {

    private static int evalOfPosition(Node node, int depth) {
        BoardAnalyser boardAnalyser = new BoardAnalyser(node.board.getConfig());
        GameState gameState = boardAnalyser.calculateGameState(node.board);

        if (gameState.isWin()) {
            if (gameState.getWinner() == Counter.O) {
                return 100 - depth;
            } else {
                return depth - 100;
            }
        } else {
            return 0;
        }
    }

    public static List<Integer> minimax(Node node, boolean isMaxPlayer, int alpha, int beta, int depth) {
        System.out.println("run minimax");
        BoardAnalyser boardAnalyser = new BoardAnalyser(node.board.getConfig());
        GameState gameState = boardAnalyser.calculateGameState(node.board);

        List<Integer> valueAndMove = new ArrayList<Integer>();
        List<Integer> bestValueAndMove = new ArrayList<Integer>();
        List<Integer> potentialMoves = node.potentialMoves();

        bestValueAndMove.add(0);
        bestValueAndMove.add(0);
        int value;

        if (gameState.isEnd() || depth == 5) {
            if (isMaxPlayer) {
                bestValueAndMove.set(0, Strategies.strategyHub(node.getBoard(),
                        node.getCounter()));

            } else {
                bestValueAndMove.set(0, -Strategies.strategyHub(node.getBoard(),
                        node.getCounter()));
            }

            bestValueAndMove.set(1, -1);

            return bestValueAndMove;

        } else if (isMaxPlayer) {

            int maxValue = -1000;

            for (int i = 0; i < potentialMoves.size(); i++) {
                int potentialMove = potentialMoves.get(i);
                Node childNode = new Node(node, potentialMove);
                System.out.println(potentialMove);
                valueAndMove = minimax(childNode, false, alpha, beta, depth + 1);
                value = valueAndMove.get(0);

                alpha = Math.max(value, alpha);

                if (value > maxValue) {
                    bestValueAndMove.set(0, valueAndMove.get(0));
                    bestValueAndMove.set(1, potentialMove);

                    maxValue = value;
                }

                if (value >= beta) {
                    break;
                }
            }
            System.out.println("at depth " + depth + " i chose move at position " + bestValueAndMove.get(1)
                    + " weight of move is " + bestValueAndMove.get(0));
            return bestValueAndMove;

        } else {
            int minValue = 1000;

            for (int i = 0; i < potentialMoves.size(); i++) {

                int potentialMove = potentialMoves.get(i);

                Node childNode = new Node(node, potentialMove);
                valueAndMove = minimax(childNode, true, alpha, beta, depth + 1);
                value = valueAndMove.get(0);
                System.out.println(potentialMove);
                beta = Math.min(value, beta);

                if (value < minValue) {
                    bestValueAndMove.set(0, valueAndMove.get(0));
                    bestValueAndMove.set(1, potentialMove);

                    minValue = value;
                }

                if (value <= alpha) {
                    break;
                }
            }
            System.out.println("at depth " + depth + " i chose move at position " + bestValueAndMove.get(1)
                    + " weight of move is " + bestValueAndMove.get(0));
            return bestValueAndMove;
        }
    }
}
