package com.thg.accelerator21.connectn.ai.name;

import com.thehutgroup.accelerator.connectn.player.Board;
import com.thehutgroup.accelerator.connectn.player.Counter;
import com.thehutgroup.accelerator.connectn.player.GameConfig;
import com.thg.accelerator23.connectn.ai.jacklucajordan.alphaBetaPruning.Minimax;
import com.thg.accelerator23.connectn.ai.jacklucajordan.alphaBetaPruning.Node;
import com.thg.accelerator23.connectn.ai.jacklucajordan.analysis.BoardAnalyser;
import com.thg.accelerator23.connectn.ai.jacklucajordan.analysis.GameState;
import org.junit.jupiter.api.Test;

import javax.sql.XAConnection;

import static org.junit.jupiter.api.Assertions.*;

public class MiniMaxTests {

    @Test
    public void MiniMaxTest3() {
        int width = 7;
        int height = 6;

        Counter[][] counters = new Counter[width][height];
        counters[0][0] = Counter.X;

        counters[1][0] = Counter.O;
        counters[1][1] = Counter.X;
        counters[1][2] = Counter.X;
        counters[1][3] = Counter.X;

        counters[2][0] = Counter.O;
        counters[2][1] = Counter.O;
        counters[2][2] = Counter.O;
        counters[2][2] = Counter.X;

        counters[3][0] = Counter.X;
        counters[3][1] = Counter.X;
        counters[3][2] = Counter.X;
        counters[3][3] = Counter.O;

        counters[4][0] = Counter.X;
        counters[4][1] = Counter.O;
        counters[4][2] = Counter.O;
        counters[4][3] = Counter.O;
        counters[4][4] = Counter.X;

        counters[5][0] = Counter.X;
        counters[5][1] = Counter.X;
        counters[5][2] = Counter.O;
        counters[5][3] = Counter.X;

        counters[6][0] = Counter.O;
        counters[6][1] = Counter.X;
        counters[6][2] = Counter.X;

        Board board = new Board(counters, new GameConfig(width, height, 4));
        Node node = new Node(board, Counter.O);

        int move = Minimax.minimax(node, false, -1000, 1000, 0).get(1);

        assertEquals(-1, move);

    }

    @Test
    public void isEndTest() {
        int width = 5;
        int height = 5;

        Counter[][] counters = new Counter[width][height];

        counters[0][0] = Counter.X;
        counters[0][1] = Counter.X;
        counters[0][2] = Counter.X;
        counters[0][3] = Counter.X;

        Board board = new Board(counters, new GameConfig(width, height, 4));
        BoardAnalyser boardAnalyser = new BoardAnalyser(board.getConfig());
        GameState gameState = boardAnalyser.calculateGameState(board);

        assertTrue(gameState.isEnd());
    }
}
