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
    public void MiniMaxTest3(){
        int width = 5;
        int height = 5;

        Counter[][] counters = new Counter[width][height];

        counters[0][0] = Counter.O;
        counters[0][1] = Counter.O;
        counters[0][2] = Counter.O;


        Board board = new Board(counters, new GameConfig(width, height, 4));
        Node node = new Node(board, Counter.X);


        int move = Minimax.minimax(node, true, -1000, 1000).get(1);

        assertEquals(2, move);

    }
}
