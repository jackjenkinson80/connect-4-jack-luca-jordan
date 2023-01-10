package com.thg.accelerator23.connectn.ai.jacklucajordan;

import com.thehutgroup.accelerator.connectn.player.Board;
import com.thehutgroup.accelerator.connectn.player.Counter;
import com.thehutgroup.accelerator.connectn.player.GameConfig;
import com.thehutgroup.accelerator.connectn.player.Player;
import com.thg.accelerator23.connectn.analysis.BoardAnalyser;

public class HansNeimannsLittleSecret extends Player {

  public HansNeimannsLittleSecret(Counter counter) {
    super(counter, HansNeimannsLittleSecret.class.getName());
  }

  @Override
  public int makeMove(Board board) {

    GameConfig testconfig = new GameConfig(0, 0, 0);
    Board testBoard = new Board(testconfig);
    BoardAnalyser test = new BoardAnalyser(testconfig);
    test.calculateGameState(testBoard);
    return 4;
  }
}
