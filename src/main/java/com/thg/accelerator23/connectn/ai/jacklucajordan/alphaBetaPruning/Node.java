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

    private int boardHeight;
    private int boardWidth;


    public Node(Board board, Counter counter){

        this.board = board;
        this.counter = counter;

        GameConfig config = board.getConfig();
        BoardAnalyser boardAnalyser = new BoardAnalyser(config);

        this.gameState = boardAnalyser.calculateGameState(board);

        this.childNodes = new ArrayList<Node>();

        boardHeight = board.getConfig().getHeight();
        boardWidth = board.getConfig().getWidth();

    }

    public Node(Node node, int moveIndex){
        try {
            this.board = new Board(node.board, moveIndex, node.getCounter());
        } catch (InvalidMoveException e) {
            throw new RuntimeException(e);
        }

        if (counter == Counter.X){
            this.counter = Counter.O;
        } else {
            this.counter = Counter.X;
        }

        GameConfig config = board.getConfig();
        BoardAnalyser boardAnalyser = new BoardAnalyser(config);

        this.gameState = boardAnalyser.calculateGameState(board);

        this.childNodes = new ArrayList<Node>();

        boardHeight = board.getConfig().getHeight();
        boardWidth = board.getConfig().getWidth();
    }


    public void findChildNodes() throws InvalidMoveException {
        Counter childCounter;
        if (counter == Counter.X){
            childCounter = Counter.O;
        } else {
            childCounter = Counter.X;
        }
        for (int i = 0; i < boardWidth; i++){
            if (!board.hasCounterAtPosition( new Position(i,boardHeight - 1 ))){
                Board childBoard = new Board(board, i, counter);
                childNodes.add(new Node(childBoard, childCounter));
            }
        }
    }



    public List<Integer> findPotentialMoves(){
        List<Integer> potentialMoves = new ArrayList<Integer>();

        for (int i = 0; i < boardWidth; i++){
            if (!board.hasCounterAtPosition( new Position(i,boardHeight - 1))){
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

    public Counter getCounter(){ return counter;}


}
