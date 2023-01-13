package com.thg.accelerator23.connectn.ai.jacklucajordan;

import com.thehutgroup.accelerator.connectn.player.*;
import com.thg.accelerator23.connectn.ai.jacklucajordan.alphaBetaPruning.Node;

import com.thg.accelerator23.connectn.ai.jacklucajordan.alphaBetaPruning.Minimax;

public class HansNeimannsLittleSecret extends Player {

  boolean isMaxPlayer;

  public HansNeimannsLittleSecret(Counter counter) {

    super(counter, HansNeimannsLittleSecret.class.getName());

    this.isMaxPlayer = (this.getCounter() == Counter.O);

  }

  @Override
  public int makeMove(Board board) {

    Node node = new Node(board, this.getCounter());

    return Minimax.minimax(node, isMaxPlayer, -1000000000, 1000000000, 0).get(1);
  }
}
