package main;


import java.util.ArrayList;
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Juan Javier
 */
class Node {
    private Integer[] state;
    private Double cost;
    private ArrayList<Integer[]> history;

    public Node(Integer[] state){
        this.state = state.clone();
        this.cost = 0.0;
        this.history = new ArrayList<>();
    }

    Node(Integer[] state, Node currentNode) {
        this.state = state.clone();
        this.cost = 0.0;
        this.history = (ArrayList<Integer[]>) currentNode.getHistory().clone();
        this.history.add(currentNode.getState().clone());
    }
    
    public Integer[] getState() {
        return state;
    }

    public Double getCost() {
        return cost;
    }

    public ArrayList<Integer[]> getHistory() {
        return history;
    }

    public void setState(Integer[] state) {
        this.state = state.clone();
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public void setHistory(ArrayList<Integer[]> history) {
        this.history = (ArrayList<Integer[]>) history.clone();
    }
    
    public static class NodeComparator implements Comparator<Node>{

        public NodeComparator() {
        }

        @Override
        public int compare(Node o1, Node o2) {
            return (int) (o1.getCost() - o2.getCost());
        }

    }
}
