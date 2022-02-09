
// this works with sorted array with some unsorted elements in there
// best case O(n) avg, worst are O(n^2)
public void sort(int[] numbers){
  int i = 0;
  boolean swapped = true;
  
  while(swapped){
    swapped = false;
    i++;
    for(int j = 0 ; j < numbers.length-i; j++){
        if(numbers[j] > numbers[j+1]){
          swap(numbers, j);
          swapped = true;
        }
    }
  }
}


public void swap(int[] arr, int i){
  int temp = arr[i];
  arr[i] = arr[i+1];
  arr[i+1] = temp;
}
