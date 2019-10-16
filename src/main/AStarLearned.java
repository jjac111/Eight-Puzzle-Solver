package main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Juan Javier
 */
public class AStarLearned extends AStar {

    private final double B0;
    private final double B1;
    private final double B2;
    
    public AStarLearned(double B0, double B1, double B2){
        super();
        this.B0 = B0;
        this.B1 = B1;
        this.B2 = B2;
    }
    
    @Override
    public Double cost(Node node) {
        return node.getHistory().size() + B0 + HeuristicFunctions.x1(node.getState())*B1 + HeuristicFunctions.x2(node.getState())*B2;
    }
    
}
