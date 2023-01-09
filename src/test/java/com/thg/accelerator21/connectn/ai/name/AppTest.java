package com.thg.accelerator21.connectn.ai.name;

import com.thehutgroup.accelerator.connectn.player.*;
import com.thg.accelerator23.connectn.ai.jacklucajordan.BoardAnalyser;
import com.thg.accelerator23.connectn.ai.jacklucajordan.HansNeimannsLittleSecret;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {
  Board board = new Board(new GameConfig(10, 8, 4));
  @Test
  public void hasCounterAtPositionTest() throws InvalidMoveException {

    for (int i = 0; i < 8; i++){
      board = new Board(board, 0, Counter.X);
    }
    assertTrue(BoardAnalyser.columnFull(0, board));
    for (int i = 1; i < 8; i++){
      assertFalse(BoardAnalyser.columnFull(i, board));
    }
  }



  @Test
  public void shouldAnswerWithTrue() {
    HansNeimannsLittleSecret bot = new HansNeimannsLittleSecret(Counter.X);
    bot.makeMove(board);
    assertTrue(true);
  }

}
