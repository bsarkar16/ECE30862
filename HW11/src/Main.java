import java.util.Scanner;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		boolean status = true;
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter a number: ");
		int n = reader.nextInt();// Scans the next token of the input as an int.
		
		//try catch to get an acceptable value of N
		while(status) {
            try {
            	status = false;
                matrix.check(n);
            } catch (Exception e) {
                System.out.print(n + " is an unacceptable value of N, please enter a new value: ");
                n = reader.nextInt();
                status = true;
            }
        }
		
		//Forming the matrixes
		matrix mp = new matrix(n);
        int [][] A = mp.formmatrix();
        int [][] B = mp.formmatrix();
        
        
        //Instantiating the threads
        multiplythread Thread1 = new multiplythread(0,n,0,n,A,B,n);
        multiplythread Thread2 = new multiplythread(0,n/2,0,n,A,B,n);
        multiplythread Thread3 = new multiplythread(n/2,n,0,n,A,B,n);
        multiplythread Thread4 = new multiplythread(0,n/2,0,n/2,A,B,n);
        multiplythread Thread5 = new multiplythread(n/2,n,n/2,n,A,B,n);
        multiplythread Thread6 = new multiplythread(0,n/2,n/2,n,A,B,n);
        multiplythread Thread7 = new multiplythread(n/2,n,0,n/2,A,B,n);
        
        System.out.println("\nPrinting Matrix A:");
        mp.printmatrix(A, n);
        
        System.out.println("\nPrinting Matrix A:");
        mp.printmatrix(B, n);
        
        //Executing Thread1
        System.out.println("\nSingle Thread:");
        Thread1.start();
        Thread1.join();
        System.out.println("\nPrinting Matrix C:");
        mp.printmatrix(multiplythread.C, n);
        
        //Executing Thread2,3
        System.out.println("\nTwo Threads:");
        Thread2.start();
        Thread3.start();
        Thread2.join();
        Thread3.join();
        System.out.println("\nPrinting Matrix C:");
        mp.printmatrix(multiplythread.C, n);
        
        //Executing Thread4,5,6,7
        System.out.println("\nFour Threads:");
        Thread4.start();
        Thread5.start();
        Thread6.start();
        Thread7.start();
        Thread4.join();
        Thread5.join();
        Thread6.join();
        Thread7.join();
        System.out.println("\nPrinting Matrix C:");
        mp.printmatrix(multiplythread.C, n);
   
		reader.close();

	}
}
