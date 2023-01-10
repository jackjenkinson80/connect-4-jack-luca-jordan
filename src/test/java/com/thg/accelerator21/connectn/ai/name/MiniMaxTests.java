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
    public void MiniMaxTest2() {
        Counter[][] counters = new Counter[10][8];

        counters[4][0] = Counter.X;
        counters[4][1] = Counter.O;
        counters[4][2] = Counter.O;
        counters[4][3] = Counter.X;
        counters[4][4] = Counter.O;

        Board board = new Board(counters, new GameConfig(10, 8, 4));
        System.out.println("made");
        Node node = new Node(board, Counter.X);
        System.out.println("made");

        int move = Minimax.run(node, false, -10, 10)[1];
        assertEquals(6, move);
    }
}
