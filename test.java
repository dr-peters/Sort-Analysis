import java.util.Scanner;
import java.util.*;

public class test {
	public static void main (String[] args) {
		System.out.print("Please enter the type of sorting algorithm you would like to use. \nYour options are selection, insertion, bubble, merge, or quick: ");
		Scanner keyboard = new Scanner(System.in);
		System.out.println();
		String type = keyboard.nextLine();
		int repeat = 1;
		int numArrays, arrSizes;
		
		do {
			if(type.contains("selection")) {
				repeat = 0;
				System.out.print("Enter the number of arrays you want to sort: ");
				numArrays = keyboard.nextInt();
				System.out.println();
				System.out.print("Enter the desired size of all the arrays: ");
				arrSizes = keyboard.nextInt();
				System.out.println();
				
				selection(numArrays, arrSizes);
			}
			else if(type.contains("insertion")) {
				repeat = 0;
				System.out.print("Enter the number of arrays you want to sort: ");
				numArrays = keyboard.nextInt();
				System.out.println();
				System.out.print("Enter the desired size of all the arrays: ");
				arrSizes = keyboard.nextInt();
				System.out.println();
				insertion(numArrays, arrSizes);
			}
			else if(type.contains("bubble")) {
				repeat = 0;
				System.out.print("Enter the number of arrays you want to sort: ");
				numArrays = keyboard.nextInt();
				System.out.println();
				System.out.print("Enter the desired size of all the arrays: ");
				arrSizes = keyboard.nextInt();
				System.out.println();
				bubble(numArrays, arrSizes);
			}
			else if(type.contains("merge")) {
				repeat = 0;
				System.out.print("Enter the number of arrays you want to sort: ");
				numArrays = keyboard.nextInt();
				System.out.println();
				System.out.print("Enter the desired size of all the arrays: ");
				arrSizes = keyboard.nextInt();
				System.out.println();
				m(numArrays, arrSizes);
			}
			else if(type.contains("quick")) {
				repeat = 0;
				System.out.print("Enter the number of arrays you want to sort: ");
				numArrays = keyboard.nextInt();
				System.out.println();
				System.out.print("Enter the desired size of all the arrays: ");
				arrSizes = keyboard.nextInt();
				System.out.println();
				quick(numArrays, arrSizes);
			}
			else {
				System.out.println("Invalid sorting algorithm type. Please enter again, choosing from selection, insertion, bubble, merge, or quick.");
				type = keyboard.nextLine();
			}
		} while(repeat == 1);
	}
	
	
	
	
	
	public static void selection(int arrs, int size) {
		Random rand = new Random();
		long totalTime = 0;
		
		double[] array = new double[size];
		for(int x = 0; x < arrs; x++) {
			
			
			
			for(int j = 0; j < array.length; j++) {
				array[j] = rand.nextInt(size);
				
			}
			
			long startTime = System.nanoTime();
			
			for(int i = 0; i < array.length - 1; i++) {
				
				int min = i;
				
				for(int j = i + 1; j < array.length; j++) {
					if(array[j] < array[min]) {
						min = j;
					}
				}
				
				if(min != i) {
					double temp = array[min];
					array[min] = array[i];
					array[i] = temp;
				}
			}
			
			long endTime = System.nanoTime();
			
			totalTime += (endTime - startTime);
		}
		
		double avgTime = totalTime / arrs;
		
		System.out.print("Each sort took about " + avgTime + " nanoseconds, or ");
		
		avgTime = avgTime / 1000000;
		
		System.out.println("about " + avgTime + " milliseconds.");
	}
	
	
	
	
	
	public static void insertion(int arrs, int size) {
		Random rand = new Random();
		long totalTime = 0;
		
		for(int x = 0; x < arrs; x++) {
			double[] array = new double[size];
			
			for(int j = 0; j < array.length; j++) {
				array[j] = rand.nextInt(size);
				
			}
			
			long startTime = System.nanoTime();
			
			for(int i = 0; i < array.length; i++) {
				double val = array[i];
				int position = i;
				
				while(position > 0 && array[position - 1] > val) {
					array[position] = array[position - 1];
					position = position - 1;
				}
				array[position] = val;
			}
			
			long endTime = System.nanoTime();
			
			totalTime += (endTime - startTime);
		}
		
		double avgTime = totalTime / arrs;
		
		System.out.print("Each sort took about " + avgTime + " nanoseconds, or ");
		
		avgTime = avgTime / 1000000;
		
		System.out.println("about " + avgTime + " milliseconds.");
	}
	
	
	
	
	
	public static void bubble(int arrs, int size) {
		Random rand = new Random();
		long totalTime = 0;
		
		for(int x = 0; x < arrs; x++) {
			double[] array = new double[size];
			
			for(int j = 0; j < array.length; j++) {
				array[j] = rand.nextInt(size);
				
			}
			int n = array.length;
			
			
			long startTime = System.nanoTime();
			
			boolean swapped = true;
			while(swapped) {
				swapped = false;
				for(int i = 1; i < n; i++) {
					if(array[i - 1] > array[i]) {
						double temp = array[i - 1];
						array[i - 1] = array[i];
						array[i] = temp;
						swapped = true;
					}
					
				}
				n = n - 1;
			}
			
			long endTime = System.nanoTime();
			
			totalTime += (endTime - startTime);
			
			
		}
		
		double avgTime = totalTime / arrs;

		System.out.print("Each sort took about " + avgTime + " nanoseconds, or ");
		
		avgTime = avgTime / 1000000;
		
		System.out.println("about " + avgTime + " milliseconds.");
	}
	
	
	
	
	
	public static void m(int arrs, int size) {
		Random rand = new Random();
		long totalTime = 0;
		
		for(int x = 0; x < arrs; x++) {
			double[] array = new double[size];
			
			for(int j = 0; j < array.length; j++) {
				array[j] = rand.nextInt(size);	
			}
			int n = array.length;
			

			long startTime = System.nanoTime();
			mergeSort(array, n);
			long endTime = System.nanoTime();

			
			
			totalTime += (endTime - startTime);
			
		}
		
		double avgTime = totalTime / arrs;

		System.out.print("Each sort took about " + avgTime + " nanoseconds, or ");
		
		avgTime = avgTime / 1000000;
		
		System.out.println("about " + avgTime + " milliseconds.");
	}
	
	
	public static void mergeSort(double[] array, int n) {
		if(n < 2) {
			return;
		}
		int mid = n / 2;
		double[] L = new double[mid];
		double[] R = new double[n - mid];
		
		for(int i = 0; i < mid; i++) {
			L[i] = array[i];
		}
		for(int i = mid; i < n; i++) {
			R[i - mid] = array[i];
		}
		
		mergeSort(L, mid);
		mergeSort(R, n - mid);
		
		merge(array, L, R);
		
		return;
	}
	
	public static void merge(double[] array, double[] L, double[] R) { // Online source was used to help understand pseudo code. See lines 9 and 10 of source code for reference.
		
		int l = L.length;
		int r = R.length;
		
		int i = 0, j = 0, k = 0;
		
		while(i < l && j < r) {
			if(L[i] > R[j]) {
				array[k] = R[j];
				j++;
			}
			else {
				array[k] = L[i];
				i++;
			}
			k++;
			
		}
		
		while(i < l) {
			array[k] = L[i];
			i++;
			k++;
		}
		while(j < r) {
			array[k] = R[j];
			j++;
			k++;
		}
		return;
	}
	
	
	
	
	
	public static void quick(int arrs, int size) {
		Random rand = new Random();
		long totalTime = 0;
		
		for(int x = 0; x < arrs; x++) {
			double[] array = new double[size];
			
			for(int j = 0; j < array.length; j++) {
				array[j] = rand.nextInt(size);
				
			}
			
			

			
			long startTime = System.nanoTime();
			qSort(array, 0, array.length - 1);
			long endTime = System.nanoTime();
			

			
			
			totalTime += (endTime - startTime);
			
		}
		
		double avgTime = totalTime / arrs;

		System.out.print("Each sort took about " + avgTime + " nanoseconds, or ");
		
		avgTime = avgTime / 1000000;
		
		System.out.println("about " + avgTime + " milliseconds.");
	}
	
	public static void qSort(double[] array, int low, int high) {
		if(low < high) {
			int p = partition(array, low, high);
			qSort(array, low, p - 1);
			qSort(array, p + 1, high);
		}
	}
	
	public static int partition(double[] array, int low, int high) { // Online source was used to help debug. See lines 9 and 10 of source code for reference.
		double pivot = array[high];
		int i = (low - 1);
		
		for(int j = low; j < high; j++) {
			if(array[j] <= pivot) {
				i++;
				double temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				
			}
		}
		
		double temp = array[i + 1];
		array[i + 1] = array[high];
		array[high] = temp;
		return (i + 1);
	}
}
