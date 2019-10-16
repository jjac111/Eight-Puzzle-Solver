package main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author Mateo
 */
public class TransitionModel {
    public static ArrayList<Integer[]> children(Integer[] puzzle){
        ArrayList<Integer[]> children = new ArrayList<>();
        if(puzzle[0]==0){
            Integer[] child1 = puzzle.clone();
            child1[0] = child1[1];
            child1[1] = 0;
            children.add(child1);
            Integer[] child2 = puzzle.clone();
            child2[0] = child2[3];
            child2[3] = 0;
            children.add(child2);
        } else if (puzzle[2]==0){
            Integer[] child1 = puzzle.clone();
            child1[2] = child1[1];
            child1[1] = 0;
            children.add(child1);
            Integer[] child2 = puzzle.clone();
            child2[2] = child2[5];
            child2[5] = 0;
            children.add(child2);
        } else if (puzzle[6]==0){
            Integer[] child1 = puzzle.clone();
            child1[6] = child1[3];
            child1[3] = 0;
            children.add(child1);
            Integer[] child2 = puzzle.clone();
            child2[6] = child2[7];
            child2[7] = 0;
            children.add(child2);
        } else if (puzzle[8]==0){
            Integer[] child1 = puzzle.clone();
            child1[8] = child1[7];
            child1[7] = 0;
            children.add(child1);
            Integer[] child2 = puzzle.clone();
            child2[8] = child2[5];
            child2[5] = 0;
            children.add(child2);
        } else if (puzzle[1]==0){
            Integer[] child1 = puzzle.clone();
            child1[1] = child1[0];
            child1[0] = 0;
            children.add(child1);
            Integer[] child2 = puzzle.clone();
            child2[1] = child2[2];
            child2[2] = 0;
            children.add(child2);
            Integer[] child3 = puzzle.clone();
            child3[1] = child3[4];
            child3[4] = 0;
            children.add(child3);
        } else if (puzzle[3]==0){
            Integer[] child1 = puzzle.clone();
            child1[3] = child1[0];
            child1[0] = 0;
            children.add(child1);
            Integer[] child2 = puzzle.clone();
            child2[3] = child2[4];
            child2[4] = 0;
            children.add(child2);
            Integer[] child3 = puzzle.clone();
            child3[3] = child3[6];
            child3[6] = 0;
            children.add(child3);
        } else if (puzzle[5]==0){
            Integer[] child1 = puzzle.clone();
            child1[5] = child1[2];
            child1[2] = 0;
            children.add(child1);
            Integer[] child2 = puzzle.clone();
            child2[5] = child2[4];
            child2[4] = 0;
            children.add(child2);
            Integer[] child3 = puzzle.clone();
            child3[5] = child3[8];
            child3[8] = 0;
            children.add(child3);
        } else if (puzzle[7]==0){
            Integer[] child1 = puzzle.clone();
            child1[7] = child1[4];
            child1[4] = 0;
            children.add(child1);
            Integer[] child2 = puzzle.clone();
            child2[7] = child2[6];
            child2[6] = 0;
            children.add(child2);
            Integer[] child3 = puzzle.clone();
            child3[7] = child3[8];
            child3[8] = 0;
            children.add(child3);
        } else if (puzzle[4]==0){
            Integer[] child1 = puzzle.clone();
            child1[4] = child1[1];
            child1[1] = 0;
            children.add(child1);
            Integer[] child2 = puzzle.clone();
            child2[4] = child2[3];
            child2[3] = 0;
            children.add(child2);
            Integer[] child3 = puzzle.clone();
            child3[4] = child3[5];
            child3[5] = 0;
            children.add(child3);
            Integer[] child4 = puzzle.clone();
            child4[4] = child4[7];
            child4[7] = 0;
            children.add(child4);
        }
        return children;
    }
}
