package main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Jama.Matrix;
import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Mateo
 */
public class HeuristicFunctions {
    public static int x1(Integer[] puzzle){
        int count = 0;
        for(int i=0;i<puzzle.length;i++){
            if((puzzle[i]-1)!=i){
                count++;
            }
        }
        if (puzzle[8]==0){
            count--;
        }
        return count;
    }
    
    public static int x2(Integer[] puzzle){
        int count;
        if (puzzle[0] == 0 || puzzle[2] == 0 || 
                puzzle[6] == 0 || puzzle[8] == 0) {
            count = 10;
        } else if (puzzle[1]==0||puzzle[3]==0||puzzle[5]==0||puzzle[7]==0){
            count = 9;
        } else {
            count = 8;
        }
        Integer[][] offHorPairs = {{1,2},{2,3},{4,5},{5,6},{7,8}};
        Integer[][] offVerPairs = {{1,4},{2,5},{3,6},{4,7},{5,8}};
        for(int i=0; i<(puzzle.length-1);i++){
            if (i != 2 && i != 5 && puzzle[i] != 0 && puzzle[i+1] != 0) {
                for (Integer[] offHorPair : offHorPairs) {
                    if ((Objects.equals(puzzle[i], offHorPair[0]))
                            && (Objects.equals(puzzle[i + 1], offHorPair[1]))) {
                        count--;
                    } else if ((Objects.equals(puzzle[i + 1], offHorPair[0]))
                            && (Objects.equals(puzzle[i], offHorPair[1]))) {
                        count--;
                    }
                }
            }
        }
        for (int i = 0; i < (puzzle.length - 3); i++) {
            if (puzzle[i] != 0 && puzzle[i + 3] != 0) {
                for (Integer[] offVerPair : offVerPairs) {
                    if ((Objects.equals(puzzle[i], offVerPair[0]))
                            && (Objects.equals(puzzle[i + 3], offVerPair[1]))) {
                        count--;
                    } else if ((Objects.equals(puzzle[i + 3], offVerPair[0]))
                            && (Objects.equals(puzzle[i], offVerPair[1]))) {
                        count--;
                    }
                }
            }
        }
        return count;
    }
    
    public static Double manhattanDist(Integer[] puzzle){
        Double dist = 0.;
        for(int i=0;i<puzzle.length;i++){
            if(puzzle[i]!=0){
                int horDist = abs((puzzle[i]-1)%3-i%3);
                int verDist = abs((puzzle[i]-1)/3-i/3);
                dist+=(horDist+verDist);
            }
        }
        return dist;
    }
    
    public static double[] calculateRegression(
            ArrayList<Integer[]> initStates, ArrayList<Integer> costs) {
        double[] betas = new double[3];
        if (initStates.size() != costs.size()) {
            return null;
        }
        double[][] xArray = new double[initStates.size()][3];
        double[] yArray = new double[costs.size()];
        double x1;
        double x2;
        
        for (int i = 0; i < initStates.size(); i++) {
            x1 = (double) HeuristicFunctions.x1(initStates.get(i));
            x2 = (double) HeuristicFunctions.x2(initStates.get(i));
            xArray[i][0] = 1;
            xArray[i][1] = x1;
            xArray[i][2] = x2;
        }
        
        for (int i = 0 ; i<yArray.length ; i++){
            yArray[i] = costs.get(i);
        }
        
        Matrix X = new Matrix(xArray);
        Matrix Y = new Matrix(yArray, yArray.length);
        Matrix XT = X.transpose();
        
        Matrix BETA = (XT.times(X)).inverse().times(XT).times(Y);
        double[][] BETAArray = BETA.getArrayCopy();
        for(int i=0;i<3;i++){
            betas[i] = BETAArray[i][0];
        }
        
        return betas;
    }
}
