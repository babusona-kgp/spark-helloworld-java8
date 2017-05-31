package com.ericsson.core.spark.test;

public class QuickSortExample {

	public static void main(String[] args) {

		
		Integer [] intArr = {1,2};
		
		quickSort(intArr,0,intArr.length);
	}

	private static void quickSort(Integer[] intArr, int low, int length) {

		int lowVal = low;
		int highVal = length;
		if(lowVal<highVal){
			int pIndex = partition(intArr,lowVal,highVal);
			quickSort(intArr,lowVal,pIndex);
			quickSort(intArr,pIndex,highVal-1);
		}
	}

	private static int partition(Integer[] intArr, int lowVal, int highVal) {
		
		int pivot = highVal;
		
		for(int i=0;i<pivot;i++){
			
			
		}
		return 0;
	}

	

}
