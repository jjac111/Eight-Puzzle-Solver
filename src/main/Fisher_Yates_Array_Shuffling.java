package main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author dfellig
 */
public class Fisher_Yates_Array_Shuffling {

    static ArrayList<Integer> list = new ArrayList();
    static int[] targetConf = {1, 2, 3, 4, 5, 6, 7, 8, 0};

    static Integer[] fisherYatesShuffling(Integer[] arr, int n) {
        Integer[] a = new Integer[n];
        int[] ind = new int[n];
        for (int i = 0; i < n; i++) {
            ind[i] = 0;
        }
        int index;
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            do {
                index = rand.nextInt(n);
            } while (ind[index] != 0);

            ind[index] = 1;
            a[i] = arr[index];
        }
        return a;
    }

    public static ArrayList<Integer[]> generatePuzzles() {
        ArrayList<Integer[]> puzzles = new ArrayList<>();
        int count = 0;
        while (count < 100) {
            int n = 9;
            Integer[] a = new Integer[n];
            int[] res = new int[n];
            Integer[] resObj;
            for (int i = 0; i < n; i++) {

                a[i] = i;
            }

            resObj = fisherYatesShuffling(a, n);
            /*
            System.out.print("Reshuffled array: ");
            for (int i = 0; i < n; i++) {
                System.out.print(resObj[i] + " ");
            }
            */
            ArrayList<Integer> arrList = new ArrayList<>(Arrays.asList(resObj));
            arrList.remove(new Integer(0));
            Integer[] invCntArray = arrList.toArray(new Integer[arrList.size() - 1]);
            /*
            System.out.println();
            System.out.print("Array with the blank removed: ");
            for (int i = 0; i < n - 1; i++) {
                System.out.print(invCntArray[i] + " ");
            }
            System.out.println();
            for (int i = 0; i < n; i++) {
                System.out.print(targetConf[i] + " ");
            }

            System.out.println("\n" + "Inverse count: " + getInvCount(invCntArray, 8));
            */
            if((getInvCount(invCntArray,8)%2)==0){
                puzzles.add(resObj);
                count++;
            }
        }
        return puzzles;
    }

    static int getInvCount(Integer arr[], int n) {
        int inv_count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    inv_count++;
                }
            }
        }
        return inv_count;
    }

}
