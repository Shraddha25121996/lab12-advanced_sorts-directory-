/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.simplesorters;

import java.util.Arrays;
import java.util.Comparator;

public class AdvancedSorters {

    // MergeSort
    public static <K> void mergeSort(K[] S, Comparator<? super K> comp) {
        int n = S.length;
        if (n < 2) return;

        int mid = n / 2;
        K[] S1 = Arrays.copyOfRange(S, 0, mid);
        K[] S2 = Arrays.copyOfRange(S, mid, n);

        mergeSort(S1, comp);
        mergeSort(S2, comp);

        merge(S, S1, S2, comp);
    }

    private static <K> void merge(K[] S, K[] S1, K[] S2, Comparator<? super K> comp) {
        int i = 0, j = 0;
        while (i < S1.length && j < S2.length) {
            if (comp.compare(S1[i], S2[j]) <= 0) {
                S[i + j] = S1[i++];
            } else {
                S[i + j] = S2[j++];
            }
        }
        while (i < S1.length) S[i + j] = S1[i++];
        while (j < S2.length) S[i + j] = S2[j++];
    }

    // QuickSort
    public static <K> void quickSort(K[] S, Comparator<? super K> comp) {
        quickSort(S, comp, 0, S.length - 1);
    }

    private static <K> void quickSort(K[] S, Comparator<? super K> comp, int a, int b) {
        if (a >= b) return;

        int pivotIndex = partition(S, comp, a, b);

        quickSort(S, comp, a, pivotIndex - 1);
        quickSort(S, comp, pivotIndex + 1, b);
    }

    private static <K> int partition(K[] S, Comparator<? super K> comp, int a, int b) {
        K pivot = S[b];
        int left = a;
        for (int i = a; i < b; i++) {
            if (comp.compare(S[i], pivot) <= 0) {
                K temp = S[i];
                S[i] = S[left];
                S[left] = temp;
                left++;
            }
        }
        K temp = S[left];
        S[left] = S[b];
        S[b] = temp;
        return left;
    }
}