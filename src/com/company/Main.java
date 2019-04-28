package com.company;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String s = "";
        Scanner in = null;
        try {
            in = new Scanner(new File("C:\\Users\\Gennady\\Downloads\\irisdata.txt")); // Insert the path to file;
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        while (in.hasNext()) {
            s += in.nextLine() + " ";
        }

        if (in != null) {
            in.close();
        }
        String [] mass;
        s=s.replace("Iris-setosa ", "");
        s=s.replace("Iris-versicolor ", "").replace("Iris-virginica ", "");
        mass = s.split(",");
        double [][] arr = new double[150][4];
        int y = 0;
        for(int k = 0; k<150; k++){
            for(int i = 0; i<4; i++)
                arr[k][i] = Double.parseDouble(mass[y++]);
        }
        System.out.println(Arrays.deepToString(arr));

        foundElements(arr, 0, 49, 0);
        foundIntervals_l_5(arr, 0, 49, 0);
        foundIntervals_l_5_6(arr, 0, 49, 0);
        foundIntervals_l_6_7(arr, 0, 49, 0);
        foundIntervals_l_7(arr, 0, 49, 0);
        foundElements(arr, 0, 49, 1);
        foundIntervals_w_3 (arr, 0, 49, 1);
        foundIntervals_w_3_3_5(arr, 0, 49, 1);
        foundIntervals_w_3_5_4(arr, 0, 49, 1);


        foundElements(arr, 50, 99, 0);
        foundIntervals_l_5(arr, 50, 99, 0);
        foundIntervals_l_5_6(arr, 50, 99, 0);
        foundIntervals_l_6_7(arr, 50, 99, 0);
        foundIntervals_l_7(arr, 50, 99, 0);
        foundElements(arr, 50, 99, 1);
        foundIntervals_w_3 (arr, 50, 99, 1);
        foundIntervals_w_3_3_5(arr, 50, 99, 1);
        foundIntervals_w_3_5_4(arr, 50, 99, 1);


        foundElements(arr, 100, 149, 0);
        foundIntervals_l_5(arr, 100, 149, 0);
        foundIntervals_l_5_6(arr, 100, 149, 0);
        foundIntervals_l_6_7(arr, 100, 149, 0);
        foundIntervals_l_7(arr, 100, 149, 0);
        foundElements(arr, 100, 149, 1);
        foundIntervals_w_3 (arr, 100, 149, 1);
        foundIntervals_w_3_3_5(arr, 100, 149, 1);
        foundIntervals_w_3_5_4(arr, 100, 149, 1);


        foundElements(arr, 0, 149, 0);
        foundIntervals_l_5(arr, 0, 149, 0);
        foundIntervals_l_5_6(arr, 0, 149, 0);
        foundIntervals_l_6_7(arr, 0, 149, 0);
        foundIntervals_l_7(arr, 0, 149, 0);
        foundElements(arr, 0, 149, 1);
        foundIntervals_w_3 (arr, 0, 149, 1);
        foundIntervals_w_3_3_5(arr, 0, 149, 1);
        foundIntervals_w_3_5_4(arr, 0, 149, 1);


    }
    static void foundElements(double [][] a, int st, int fn, int col) {
        int min;
        for (int i = st; i < fn; i++) {
            min = i;
            for (int k = i; k <= fn; k++) {
                if (a[min][col] > a[k][col]) {
                    min = k;
                }
            }
            double t = a[i][col];
            a[i][col] = a[min][col];
            a[min][col] = t;
        }
        System.out.println("MIN = " + a[st][col]);
        System.out.println("MAX = " + a[fn][col]);
        int mid = st + fn;
        //     System.out.println(mid % 2);
        if (mid % 2 == 0) {
            System.out.println("median = "+ a[mid / 2][col]);
        } else {
            System.out.println("median = "+ (a[mid / 2][col] + a[mid / 2 + 1][col]) / 2);
        }
        double sum = 0;
        for(int i = st; i<=fn; i++){
            sum += a[i][col];
        }
        //     System.out.println(sum);
        double mean = Math.round(sum/(fn-st+1)*10)/10.0;
        System.out.println("mean = "+ mean);
        //     System.out.println(sum/50);
        double sumsqr = 0;
        for(int i = st; i<=fn; i++){
            double std = Math.pow(a[i][col] - mean, 2.0);
            sumsqr += std;
        }
        double stddev = Math.sqrt(sumsqr/(fn-st));
        System.out.println("Standard deviation = " + Math.round(stddev*10)/10.0);

    }
    static void foundIntervals_l_5(double[][] a, int st, int fn, int col){
        ArrayList<Double> mass= new ArrayList<Double>();
        for(int i = st; i<=fn; i++){
            if(a[i][col] < 5.0){
                mass.add(a[i][col]);
            }
        }
        //     System.out.println(mass.size());
        System.out.println("Result <5 = "+ Math.round((double)mass.size()/(fn-st+1)*100*10)/10.0);
    }
    static void foundIntervals_l_5_6(double[][] a, int st, int fn, int col){
        ArrayList<Double> mass= new ArrayList<Double>();
        for(int i = st; i<=fn; i++){
            if(a[i][col] >= 5.0 && a[i][col] < 6.0){
                mass.add(a[i][col]);
            }
        }
        //   System.out.println(mass.size());
        System.out.println("Result 5 and 6 = "+ Math.round((double)mass.size()/(fn-st+1)*100*10)/10.0);
    }
    static void foundIntervals_l_6_7(double[][] a, int st, int fn, int col){
        ArrayList<Double> mass= new ArrayList<Double>();
        for(int i = st; i<=fn; i++){
            if(a[i][col] >= 6.0 && a[i][col] < 7.0){
                mass.add(a[i][col]);
            }
        }
        //   System.out.println(mass.size());
        System.out.println("Result 6 and 7 = "+ Math.round((double)mass.size()/(fn-st+1)*100*10)/10.0);
    }
    static void foundIntervals_l_7(double[][] a, int st, int fn, int col){
        ArrayList<Double> mass= new ArrayList<Double>();
        for(int i = st; i<=fn; i++){
            if(a[i][col] >= 7.0){
                mass.add(a[i][col]);
            }
        }
        //   System.out.println(mass.size());
        System.out.println("Result > 7 = "+ Math.round((double)mass.size()/(fn-st+1)*100*10)/10.0);
    }
    static void foundIntervals_w_3(double[][] a, int st, int fn, int col){
        ArrayList<Double> mass= new ArrayList<Double>();
        for(int i = st; i<=fn; i++){
            if(a[i][col] < 3.0){
                mass.add(a[i][col]);
            }
        }
        //   System.out.println(mass.size());
        System.out.println("Result < 3 = "+ Math.round((double)mass.size()/(fn-st+1)*100*10)/10.0);
    }
    static void foundIntervals_w_3_3_5(double[][] a, int st, int fn, int col){
        ArrayList<Double> mass= new ArrayList<Double>();
        for(int i = st; i<=fn; i++){
            if(a[i][col] >= 3.0 && a[i][col] < 3.5){
                mass.add(a[i][col]);
            }
        }
        //   System.out.println(mass.size());
        System.out.println("Result 3 and 3.5 = "+ Math.round((double)mass.size()/(fn-st+1)*100*10)/10.0);
    }
    static void foundIntervals_w_3_5_4(double[][] a, int st, int fn, int col){
        ArrayList<Double> mass= new ArrayList<Double>();
        for(int i = st; i<=fn; i++){
            if(a[i][col] >= 3.5 && a[i][col] < 4.0){
                mass.add(a[i][col]);
            }
        }
        //   System.out.println(mass.size());
        System.out.println("Result 3.5 and 4 = "+ Math.round((double)mass.size()/(fn-st+1)*100*10)/10.0);
    }
}
