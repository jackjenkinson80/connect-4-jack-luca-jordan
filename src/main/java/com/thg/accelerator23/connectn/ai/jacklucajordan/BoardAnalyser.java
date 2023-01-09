package com.thg.accelerator23.connectn.ai.jacklucajordan;
import com.thehutgroup.accelerator.connectn.player.Board;
import com.thehutgroup.accelerator.connectn.player.Position;

public abstract class BoardAnalyser {

    public static boolean columnFull(int columnIndex, Board board){
        return board.hasCounterAtPosition(new Position(columnIndex, 7));
    }


}
