package Sorting;

public class SelectionSort{


      // find the smallest element and place it at the beginning
      // best, worst, average: O(n^2)
      public static void sort(int[] a){
            int pvot = 0;
            int mini = 0; // index
            for(int i = pvot+1; i < a.length; i++){
                  mini = pvot;
                  for(int j = pvot+1; j < a.length; j++){
                        if(a[mini] > a[j]){
                              mini = j;
                        }
                  }

                  int temp = a[mini];
                  a[mini] = a[pvot];
                  a[pvot] = temp;
                  pvot++;
                  // swap() then pvot++
            }
      }


      public static void main(String... args){
            int[] a = {3, 0, 2, 21, 213,123, 213,433, 4,325434, 12, 1, 12, -21312, 213 , 321, -1121};
            sort(a);
            for(int x: a){
                  System.out.print(x+", ");

            }
      }
}
