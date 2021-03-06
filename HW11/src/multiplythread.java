
public class multiplythread extends Thread{
	static int [][] C;
	private int rowS;
    private int rowE;
    private int colS;
    private int colE;
    private int [][] A;
    private int [][] B;
    private int N;
    
	public multiplythread(int rstart,int rend, int cstart,int cend,int [][] A, int [][] B, int n) {
		rowS = rstart;
		rowE = rend;
		colS = cstart;
		colE = cend;
		this.A = A;
		this.B = B;
		this.N = n;
		C = new int[n][n];
	}
	
	public void run(){
		//Performing the multiplication
		int i,j,k,sum=0; 
		long startTime = System.nanoTime();
		
		
        for(i=rowS;i<rowE;i++){
            for(j=colS;j<colE;j++){
                for(k=0;k<N;k++){
                    sum = sum + A[i][k]*B[k][j];
                }
                C[i][j] = sum;
                sum = 0;
            }
        }
        long endTime = System.nanoTime();
        
        System.out.println("Mul() for thread:" + Thread.currentThread().getId() + " took place in " + (endTime-startTime) + " seconds");
    }

}
