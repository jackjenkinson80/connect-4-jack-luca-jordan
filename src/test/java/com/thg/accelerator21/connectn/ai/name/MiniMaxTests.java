package com.thg.accelerator21.connectn.ai.name;

import com.thehutgroup.accelerator.connectn.player.Board;
import com.thehutgroup.accelerator.connectn.player.Counter;
import com.thehutgroup.accelerator.connectn.player.GameConfig;
import com.thehutgroup.accelerator.connectn.player.InvalidMoveException;
import com.thg.accelerator23.connectn.ai.jacklucajordan.alphaBetaPruning.Minimax;
import com.thg.accelerator23.connectn.ai.jacklucajordan.alphaBetaPruning.Node;
import com.thg.accelerator23.connectn.ai.jacklucajordan.analysis.BoardAnalyser;
import com.thg.accelerator23.connectn.ai.jacklucajordan.analysis.GameState;
import org.junit.jupiter.api.Test;
import static com.thehutgroup.accelerator.connectn.player.Counter.O;
import static com.thehutgroup.accelerator.connectn.player.Counter.X;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class MiniMaxTests {
    private Counter[][] rotateBoard(Counter[][] board) {
        Counter[][] newBoard = new Counter[board[0].length][board.length];
        for (int i = 0; i < board[0].length; i++) {
            for (int j = board.length - 1; j >= 0; j--) {
                newBoard[i][j] = board[j][i];
            }
        }
        return newBoard;
    }

    @Test
    public void MiniMaxTest3() throws InvalidMoveException {
        int width = 10;
        int height = 8;

        Counter[][] counters = new Counter[height][width];
        counters[7] = new Counter[] { null, null, O, O, null, X, null, X, null, null };
        counters[6] = new Counter[] { null, null, X, X, null, X, null, O, null, null };
        counters[5] = new Counter[] { null, null, O, X, null, O, null, X, null, null };
        counters[4] = new Counter[] { null, null, O, O, O, X, X, O, null, null };
        counters[3] = new Counter[] { null, null, X, X, X, O, O, O, null, null };
        counters[2] = new Counter[] { null, null, X, O, O, X, X, X, null, null };
        counters[1] = new Counter[] { null, X, O, X, X, O, X, O, null, null };
        counters[0] = new Counter[] { O, X, O, O, X, O, X, O, O, null };
        counters = rotateBoard(counters);
        Board board = new Board(counters, new GameConfig(width, height, 4));
        Node node = new Node(board, Counter.X);

        List<Integer> list = Minimax.minimax(node, false, -1000, 1000, 0);
        System.out.println(list.get(0));
        assertEquals(0, list.get(1));

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

    @Test
    public void testmiddlecolumn() {
        int width = 10;
        int height = 8;
        Counter[][] counters = new Counter[width][height];
        counters[5][0] = Counter.X;
        counters[5][1] = Counter.O;
        counters[5][2] = Counter.X;
        counters[5][3] = Counter.O;
        counters[5][4] = Counter.X;
        counters[5][5] = Counter.O;
        counters[5][6] = Counter.O;
        counters[5][7] = Counter.O;
        counters[4][0] = Counter.X;
        counters[4][1] = Counter.X;
        Board board = new Board(counters, new GameConfig(width, height, 4));
        Node node = new Node(board, Counter.X);

        int move = Minimax.minimax(node, false, -1000, 1000, 0).get(1);

        assertEquals(3, move);

    }
}
