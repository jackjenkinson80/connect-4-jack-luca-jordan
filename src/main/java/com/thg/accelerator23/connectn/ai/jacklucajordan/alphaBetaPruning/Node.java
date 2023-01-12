package com.thg.accelerator23.connectn.ai.jacklucajordan.alphaBetaPruning;

import com.thehutgroup.accelerator.connectn.player.*;
import com.thg.accelerator23.connectn.ai.jacklucajordan.analysis.BoardAnalyser;
import com.thg.accelerator23.connectn.ai.jacklucajordan.analysis.GameState;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;

public class Node {

    Board board;
    Counter counter;

    public Node(Board board, Counter counter) {
        this.board = board;
        this.counter = counter;
    }

    public Node(Node node, int moveIndex) {
        this.counter = node.counter.getOther();
        try {
            this.board = new Board(node.board, moveIndex, counter);
        } catch (InvalidMoveException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Integer> potentialMoves() {
        List<Integer> potentialMoves = new ArrayList<Integer>();

        int width = board.getConfig().getWidth();
        int height = board.getConfig().getHeight();

        for (int i = 0; i < width; i++) {
            Position moveIndex = new Position(i, height - 1);
            if (!board.hasCounterAtPosition(moveIndex)) {
                potentialMoves.add(i);
            }
        }
        return potentialMoves;
    }

    public Board getBoard() {
        return board;
    }

    public Counter getCounter() {
        return counter;
    }
}
