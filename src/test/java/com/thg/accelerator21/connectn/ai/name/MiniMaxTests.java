package com.thg.accelerator21.connectn.ai.name;

import com.thehutgroup.accelerator.connectn.player.Board;
import com.thehutgroup.accelerator.connectn.player.Counter;
import com.thehutgroup.accelerator.connectn.player.GameConfig;
import com.thg.accelerator23.connectn.ai.jacklucajordan.alphaBetaPruning.Minimax;
import com.thg.accelerator23.connectn.ai.jacklucajordan.alphaBetaPruning.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MiniMaxTests {


    @Test
    public void MiniMaxTest1(){
        Counter[][] counters = new Counter[10][8];

        for(int i = 0; i < 10; i++){
            if (i % 2 == 0){
                counters[i][0] = Counter.X;
                counters[i][1] = Counter.X;
                counters[i][2] = Counter.X;
            } else {
                counters[i][0] = Counter.O;
                counters[i][1] = Counter.O;
                counters[i][2] = Counter.O;
            }
        }

        for(int i = 0; i < 10; i++){
            if (i % 2 == 1){
                counters[i][3] = Counter.X;
                counters[i][4] = Counter.X;
                counters[i][5] = Counter.X;
            } else {
                counters[i][3] = Counter.O;
                counters[i][4] = Counter.O;
                counters[i][5] = Counter.O;
            }
        }

        for(int i = 0; i < 10; i++){
            if (i % 2 == 0){
                counters[i][6] = Counter.X;
            } else {
                counters[i][6] = Counter.O;
            }
        }

        counters[0][7] = Counter.X;
        counters[1][7] = Counter.X;

        counters[3][7] = Counter.O;
        counters[4][7] = Counter.X;
        counters[5][7] = Counter.O;

        counters[7][7] = Counter.X;
        counters[8][7] = Counter.X;
        counters[9][7] = Counter.X;



        Board board = new Board(counters, new GameConfig(10, 8, 4));
        Node node = new Node(board, Counter.X);

        int move = Minimax.run(node, false, -10,10, 0)[1];
        assertEquals(6, move);
    }

    @Test
    public void IsEndTest(){
        Counter[][] counters = new Counter[10][8];

        counters[4][0] = Counter.X;
        counters[4][1] = Counter.X;
        counters[4][2] = Counter.X;
        counters[4][3] = Counter.X;

        Board board = new Board(counters, new GameConfig(10, 8, 4));
        Node node = new Node(board, Counter.X);

        assertTrue(node.getGameState().isEnd());
    }

//    @Test
//    public void MiniMaxTest2(){
//        Counter[][] counters = new Counter[10][8];
//
//        for(int i = 0; i < 10; i++){
//            if (i % 2 == 0){
//                counters[i][0] = Counter.X;
//                counters[i][1] = Counter.X;
//                counters[i][2] = Counter.X;
//            } else {
//                counters[i][0] = Counter.O;
//                counters[i][1] = Counter.O;
//                counters[i][2] = Counter.O;
//            }
//        }
//
//        for(int i = 0; i < 10; i++){
//            if (i % 2 == 1){
//                counters[i][3] = Counter.X;
//                counters[i][4] = Counter.X;
//                counters[i][5] = Counter.X;
//            } else {
//                counters[i][3] = Counter.O;
//                counters[i][4] = Counter.O;
//                counters[i][5] = Counter.O;
//            }
//        }
//
//
//        Board board = new Board(counters, new GameConfig(10, 8, 4));
//        Node node = new Node(board, Counter.X);
//
//        int move = Minimax.run(node, false, -10,10, 0)[1];
//        assertEquals(6, move);
//    }

    @Test
    public void MiniMaxTest3(){
        int width = 3;
        int height = 3;

        Counter[][] counters = new Counter[width][height];




        Board board = new Board(counters, new GameConfig(width, height, 3));
        Node node = new Node(board, Counter.X);

        int move = Minimax.run(node, false, -10,10, 0)[1];

        assertEquals(3, move);

    }
}
