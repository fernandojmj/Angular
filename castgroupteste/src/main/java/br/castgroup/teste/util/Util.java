/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.castgroup.teste.util;

/**
 *
 * @author fernando.j.junior
 */
public class Util {

    public static void main(String[] args) {

        Integer[] a = //{2, 3, 10, 2, 4, 8, 1};
        {7, 9, 5, 6, 3, 2};
        System.out.println("maior diferença: " + maxDifference(a));

    }

    public static int maxDifference(Integer[] a) {
        int maiorDiferenca = 0;
        for (int j = 1; j < a.length; j++) {

            for (int i = 0; i < a.length; i++) {
                if(j==i){
                    break;
                }
                if (a[i] < a[j]) {
                    if (maiorDiferenca == 0) {
                        maiorDiferenca = a[j] - a[i];
                    } else {
                        if (maiorDiferenca < (a[j] - a[i])) {
                            maiorDiferenca = a[j] - a[i];
                        }
                    }

                }
            }

        }
        return maiorDiferenca;
    }

}
