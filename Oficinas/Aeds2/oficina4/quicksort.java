import java.util.*;
public class quicksort{
    public static int[] arr={89, 45, 120, 23, 67, 199, 34};
    public static int movimentos=0;
    public static int comparacoes=0;
    public static void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;       
    }

    public static void quickSort(int low, int high) {
        int i=low, j=high; 
        int pivo=arr[(high-low)/2];
        System.out.println(low+" "+ high); 
        while(i<=j){
            //comparacoes++;
            System.out.println(arr[i]+" < "+ pivo); 
            while(arr[i]<pivo){
                i++;
            }
            //comparacoes++;
            System.out.println(arr[j]+" > "+ pivo); 
            while(arr[j]>pivo){
                j--;
            }
            if(i<=j){
                swap(i, j);
                //movimentos+=3;
                i++; j--;
            }
        }
        if(low<j){
            quickSort(low, j);
        }
        if(i<high){
            quickSort(i, high);
        }
    }
    

    public static void main(String[] args) {
        quickSort(0, arr.length-1);
        //System.out.println(comparacoes);
        //System.out.println(movimentos);
        System.out.print("{");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");

        }
        System.out.println("}");
        
    }
}