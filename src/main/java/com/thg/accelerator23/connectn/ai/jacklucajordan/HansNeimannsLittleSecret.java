package com.thg.accelerator23.connectn.ai.jacklucajordan;


import com.thehutgroup.accelerator.connectn.player.Board;
import com.thehutgroup.accelerator.connectn.player.Counter;
import com.thehutgroup.accelerator.connectn.player.Player;
import java.util.Random;


public class HansNeimannsLittleSecret extends Player {

  public HansNeimannsLittleSecret(Counter counter) {
    super(counter, HansNeimannsLittleSecret.class.getName());
  }

  @Override
  public int makeMove(Board board) {
    //TODO: some crazy analysis
    //TODO: make sure said analysis uses less than 2G of heap and returns within 10 seconds on whichever machine is running it


    int randMoveIndex = new Random().nextInt(8);

    while (BoardAnalyser.columnFull(randMoveIndex, board)){
      randMoveIndex = new Random().nextInt(8);
    }
    
    return randMoveIndex;
  }
}
