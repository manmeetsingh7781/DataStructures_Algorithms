package Sorting;

import java.util.ArrayList;

public class InsertSort<T extends Number> extends ArrayList<T> {
	
	ArrayList<T> arr;

	public InsertSort(T[] arr){
		this.arr = new ArrayList<T>();
		for(T d: arr){
			this.arr.add(d);
		}
	}
		
	
	public void sort(){
		for(int i = 1; i < this.arr.size(); i++){
			int idx = 1, swapper = 0;
			// idx helps to keep track of pointer in array that goes from right to left towards the 0 index
			// swapper keeps track of the number that has been swapped for next comparison 
			for(int j = i-idx; j > -1; j--, idx++){

				if(this.arr.get(i-swapper).doubleValue() < this.arr.get(j).doubleValue()){
						T temp = this.arr.get(j);
						this.arr.set(j, this.arr.get(i-swapper));
						this.arr.set(i-swapper, temp);
						swapper++;
					
				}
			}

		}			
	}
	


	// this is the easier and simple way of algorithm
	public void sort2(){
		int j;
		for(int i = 1; i < this.arr.size(); i++){
			j = i;
			while(j > 0 && this.arr.get(j-1).doubleValue()  > this.arr.get(j).doubleValue()){
				
				T temp = this.arr.get(j-1);
				this.arr.set(j-1, this.arr.get(j));
				this.arr.set(j, temp);

				j--;	
			} 
		}
	}	
	
		
	@Override
	public String toString(){
		StringBuilder str = new StringBuilder();
		for(T i: this.arr){
			str.append(i.toString()).append(", ");
		}
		return str.toString();
	}
	

}
