package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Juan Javier
 */
public abstract class AStar {
    private ArrayList<Node> explored;
    private PriorityQueue<Node> frontier;
    public int expandedNodes;
    public int generatedNodes;
    public long timeTaken; //Time in nanoseconds
    
    public AStar(){
        this.explored = new ArrayList<>();
        this.frontier = new PriorityQueue<>(1, new Node.NodeComparator());
    }
    
    public ArrayList<Integer[]> search(Integer[] initialState, Integer[] goalState){
        expandedNodes = 0;  //Reset these counters for each search.
        generatedNodes = 0;
        timeTaken = 0;
        long startTime = System.nanoTime();
        
        Node currentNode = new Node(initialState);
        currentNode.setCost(0.0);
        frontier = new PriorityQueue<>(1, new Node.NodeComparator());
        frontier.add(currentNode);
        explored = new ArrayList<>();
        
        while(true){
            if(frontier.isEmpty()){
                timeTaken = System.nanoTime() - startTime;
                return null;
            }
            currentNode = frontier.poll();
            if(Arrays.equals(currentNode.getState(), goalState)){
                currentNode.getHistory().add(currentNode.getState());
                timeTaken = System.nanoTime() - startTime;
                return currentNode.getHistory();
            }
            explored.add(currentNode);
            expandedNodes++;
            
            ArrayList<Integer[]> childrenNodeStates 
                    = TransitionModel.children(currentNode.getState());
            
            for(Integer[] state : childrenNodeStates){
                Node childNode = new Node(state, currentNode);
                childNode.setCost(cost(childNode));
                generatedNodes++;
                boolean inFrontier = false;
                boolean inExplored = false;
                
                for(Node f:frontier){
                    if(Arrays.equals(f.getState(), childNode.getState())){
                        inFrontier = true;
                    }
                }
                for(Node e:explored){
                    if(Arrays.equals(e.getState(), childNode.getState())){
                        inExplored = true;
                    }
                }
                
                if(!inFrontier && !inExplored){
                    frontier.add(childNode);
                } else if (inFrontier && !inExplored){
                    for(Node f:frontier){
                        if(Arrays.equals(f.getState(), childNode.getState()) 
                                && f.getCost()>childNode.getCost()){
                            frontier.remove(f);
                            frontier.add(childNode);
                            break;
                        }
                    }
                }
            }
            //System.out.println(frontier.size());
        }
    }
    
    //sets the cost of a node
    public abstract Double cost(Node node);
}
