package com.thg.accelerator23.connectn.ai.jacklucajordan.alphaBetaPruning;
import com.thehutgroup.accelerator.connectn.player.*;
import com.thg.accelerator23.connectn.ai.jacklucajordan.analysis.BoardAnalyser;
import com.thg.accelerator23.connectn.ai.jacklucajordan.analysis.GameState;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private int nodeValue;
    private List<Node> childNodes;
    private Board board;
    private GameState gameState;
    private Counter counter;


    public Node(Board board, Counter counter){

        this.board = board;
        this.counter = counter;

        GameConfig config = board.getConfig();
        BoardAnalyser boardAnalyser = new BoardAnalyser(config);

        this.gameState = boardAnalyser.calculateGameState(board);

        this.childNodes = new ArrayList<Node>();

    }


    public void findChildNodes() throws InvalidMoveException {
        Counter childCounter;
        if (counter == Counter.X){
            childCounter = Counter.O;
        } else {
            childCounter = Counter.X;
        }
        for (int i = 0; i < 10; i++){
            if (!board.hasCounterAtPosition( new Position(i,7))){
                Board childBoard = new Board(board, i, childCounter);
                childNodes.add(new Node(childBoard, childCounter));
            }
        }
    }

    public List<Integer> findPotentialMoves(){
        List<Integer> potentialMoves = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++){
            if (!board.hasCounterAtPosition( new Position(i,7))){
                potentialMoves.add(i);
            }
        }
        return potentialMoves;
    }


    public List<Node> getChildNodes(){
        return childNodes;
    }

    public GameState getGameState(){
        return gameState;
    }

}
