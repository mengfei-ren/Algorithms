
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mengfei
 */
public class Median {
    protected int[] array;
    private Random r=new Random();
    public Median(int n){
        array=new int[n];
        for(int i=0;i<array.length;i++)
            array[i]=r.nextInt(10);
    }
    public int MedianFinding(){
        int m=array.length/5;
        int[][] group=new int[5][m];
        for(int i=0;i<5;i++)
            for(int j=0;j<m;j++)
                group[i][j]=array[j+i*m];
        //Using selection to sort each group
        for(int k=0;k<5;k++){
            for(int i=m-1;i>=0;i--)
            {
                int loc=0;
                //Find the max value of the array
                int m1=group[k][i];
                for(int j=0;j<i;j++)
                {
                    if(m1<group[k][j]){
                    m1=group[k][j];
                    loc=j;
                    }
                }
                group[k][loc]=group[k][i];
                group[k][i]=m1;
            }
        }
        int[] median=new int[5];
        if(m%2==0){
            for(int i=0;i<5;i++)
                median[i]=(group[i][m/2-1]+group[i][m/2])/2;
        }
        else{
           for(int i=0;i<5;i++)
               median[i]=group[i][m/2];
        }
        int k=Partition(median,0,4);
        return median[k];
    }
    public int Partition(int[] array,int p,int r){
	int x=array[r];
	int i=p-1;
	int tmp=0;
	for(int j=p;j<=r-1;j++){
            if(array[j]<=x){
		i++;
		tmp=array[i];
		array[i]=array[j];
		array[j]=tmp;
            }
	}
	tmp=array[i+1];
	array[i+1]=array[r];
	array[r]=tmp;

	return i+1;
    }
    public static void main(String[] args) throws IOException{
        Timer tt=new Timer();
        double[] timer=new double[10];
        Median m;
        int pivot;

        System.out.print("Please input the number of elements in array is: ");
	BufferedReader br=null;
	br=new BufferedReader(new InputStreamReader(System.in));
	int n=Integer.parseInt(br.readLine());

        for(int i=0;i<10;i++){
            m=new Median(n);
            System.out.println("The original array is(500-535):");
            for(int j=500;j<535;j++)
                System.out.print(m.array[j]+" ");
            tt.start();
            pivot=m.MedianFinding();
            tt.stop();
            timer[i]=tt.getTime();
            System.out.println("\nThe median of the array is:"+pivot);
            System.out.println("The running time is "+timer[i]+"\n");
        }
        double sum = 0;
        for(int i=0;i<10;i++){
            sum+=timer[i];
        }
        System.out.println("\nThe average runtime of Median Finding is "+sum/10);
    }
}
