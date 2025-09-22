import java.util.*;
import java.util.Random;

public class quickpivo{
    public static Scanner ent=new Scanner(System.in);
    public static int movimentos=0;
    public static int comparacoes=0;
    public static void crescente(int[] array) {
		for (int i = 0; i < n; i++) {
			array[i] = i;
		}
	}
    public static void swap(int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    public static void quickSortFirst(int esq, int dir, int[] arr){
        int i=esq, j=dir; 
        int pivo=arr[esq];
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
        if(esq<j){
            quickSortFirst(esq, j);
        }
        if(i<dir){
            quickSortFirst(i, dir);
        }
    
    }
    public static void quickSortLast(int esq, int dir, int[] arr ){
        int i=esq, j=dir; 
        int pivo=arr[dir];
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
        if(esq<j){
            quickSortLast(esq, j);
        }
        if(i<dir){
            quickSortLast(i, dir);
        }
    }
    public static void quickSortRandom(int esq, int dir, int[] arr){
        int i=esq, j=dir; 
        Random rando=new Randow();
        int rand=rando.nextInt(dir- esq +1)+ esq;
        int pivo=arr[rand];
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
        if(esq<j){
            quickSortRandom(esq, j);
        }
        if(i<dir){
            quickSortRandom(i, dir);
        }
    }
    public static void quickSortMedianofThree(int esq, int dir, int[] arr ){
        int i=esq, j=dir; 
        int pivo;
        int pivo1=arr[esq];
        int pivo2=arr[(esq+dir)/2];
        int pivo3=arr[dir];
        if((pivo1>pivo2 && pivo1<pivo3) || (pivo1>pivo3 && pivo1<pivo2)){
            pivo=pivo1;
        }else if((pivo2>pivo3 && pivo2<pivo1) || (pivo2>pivo1 && pivo2<pivo3)){
            pivo=pivo2;
        }else if((pivo3>pivo2 && pivo3<pivo1) || (pivo3>pivo1 && pivo3<pivo2)){
            pivo=pivo3;
        }
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
        if(esq<j){
            quickSortMedianofThree(esq, j);
        }
        if(i<dir){
            quickSortMedianofThree(i, dir);
        }
    }
    
    
    public static void main(String []args){
        Random rand=new Random();
        int[] arr1= new int[1000];
        int[] arr2= new int[10000];
        int[] arr3= new int[100000];
        crescente(arr1);	
		for (int i = 0; i < arr1.length; i++) {
			swap(i, Math.abs(rand.nextInt()) % n);
		}
        crescente(arr2);	
		for (int i = 0; i < arr2.length; i++) {
			swap(i, Math.abs(rand.nextInt()) % n);
		}
        crescente(arr3);	
		for (int i = 0; i < arr3.length; i++) {
			swap(i, Math.abs(rand.nextInt()) % n);
		}

    }

}