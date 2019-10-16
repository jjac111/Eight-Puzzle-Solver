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
public class AStarManhattan extends AStar{

    @Override
    public Double cost(Node node) {
        return node.getHistory().size() + HeuristicFunctions.manhattanDist(node.getState());
    }
    
}
