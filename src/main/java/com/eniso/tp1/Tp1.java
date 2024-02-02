package com.eniso.tp1;
import java.util.Arrays;
import java.util.Scanner;

public class Tp1 {
    public static double[] calculateProbability(int image[][]){
        int l = image.length;
        int c = image[0].length;
        double n = l*c;
        double tab[] = new double[256];
        for (int p = 0 ; p < 256 ; p++){
            int nbc = 0;
            for (int i = 0 ; i < l ; i++){
                for (int j = 0 ; j < c ; j++){
                    if (image[i][j]==p){
                        nbc++;
                    }
                }
            }
            tab[p]=nbc/n;
        }
        return tab;
    }
    public static double calculateEntropy(int image[][]){
        double H = 0;
        double tab[] = calculateProbability(image);
        for (int i =0 ; i< 256;i++){
            if (tab[i] != 0){
                H-= tab[i]*(Math.log(tab[i])/Math.log(2));
            }
        }
        return H; 
    }

    public static void main(String[] args) {
        System.out.println("Bonjour , mon premier TP en POO");
        
        // lecture du nom
        System.out.println("Quel est votre nom ?");
        Scanner read = new Scanner(System.in);
        String name = read.next();
        System.out.println("Bonjour "+name);
        
        //lecture d'age
        System.out.println("quel est votre age ?");
        read = new Scanner(System.in);
        int age;
        age = read.nextInt();
        System.out.println(name+" votre age est : "+age);
        
        //les images
        int image[][] = {{1,2,3},{4,5,6},{7,8,9}};
        double prob[] = calculateProbability(image);
        System.out.println(Arrays.toString(prob));
        double entropy = calculateEntropy(image);
        System.out.println(entropy);
        
   
    }

}
