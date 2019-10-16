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
public class HeuristicB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Integer[]> puzzles = 
                Fisher_Yates_Array_Shuffling.generatePuzzles();
        AStarManhattan asManhattan = new AStarManhattan();
        ArrayList<Integer[]> puzzles2 = 
                Fisher_Yates_Array_Shuffling.generatePuzzles();
        
        Integer[] endState = {1, 2, 3, 4, 5, 6, 7, 8, 0};
        Integer[] case1 = {1, 2, 3, 4, 6, 0, 7, 5, 8};
        Integer[] case2 = {4, 1, 2, 7, 6, 3, 0, 5, 8};
        Integer[] case3 = {4, 1, 2, 7, 6, 3, 5, 8, 0};
        //Main cases to study
        ArrayList<Integer[]> cases = new ArrayList<>();
        cases.add(case1);
        cases.add(case2);
        cases.add(case3);
        
        
        ArrayList<Integer[]> sol;
        ArrayList<ArrayList<Integer[]>> solutions = new ArrayList<>();
        for(int i=0;i<100;i++){
            Integer[] initState = puzzles.get(i);
            sol = asManhattan.search(initState, endState);
            solutions.add(sol);
            }
        
        ArrayList<Integer> y = new ArrayList<>();
        solutions.forEach((solution) -> {
            y.add(solution.size());
        });
        
        double[] betas = HeuristicFunctions.calculateRegression(puzzles, y);
        System.out.println("Betas found:");
        for(double beta : betas){
            System.out.println(beta);
        }
           
        AStarLearned asLearned = new AStarLearned(betas[0], betas[1], betas[2]);
        
        System.out.println("\n\nStatistics for 3 main cases:\n");
        System.out.println("\t\t(a)\t\t(b)");
        int i = 0;
        for(Integer[] _case: puzzles2){
            System.out.println("Case " + ++i);
            ArrayList<Integer[]> solA = asManhattan.search(_case, endState);
            ArrayList<Integer[]> solB = asLearned.search(_case, endState);
            System.out.println("Length\t\t" + solA.size() + "\t\t" + solB.size());
            System.out.println("Exp.Nodes\t" + asManhattan.expandedNodes + "\t\t" + asLearned.expandedNodes);
            System.out.println("Gen.Nodes\t" + asManhattan.generatedNodes + "\t\t" + asLearned.generatedNodes);
            System.out.println("Time Taken\t" + asManhattan.timeTaken + "\t\t" + asLearned.timeTaken);
            
        }
         
        
        
    }
    
    
}
