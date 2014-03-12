
import java.util.Random;

/**
 *
 * @author Mengfei
 */
public class CountSort {
    protected int[] array;
    private Random r=new Random();
    public CountSort(int n){
        array=new int[n];
        for(int i=0;i<array.length;i++)
            array[i]=r.nextInt(100);
    }
    
    public void CountingSort(){
	int n=array.length;
	int output[] = new int[n];
	int count[]=new int[100];
	int i;
		
	for(i=0;i<n;i++){
            count[array[i]]++;
	}
	for(i=1;i<count.length;i++)
            count[i]=count[i]+count[i-1];
	for(i=n-1;i>=0;i--)
	{
            output[count[array[i]]-1]=array[i];
            count[array[i]]--;
	}
        for(i=0;i<n;i++)
            array[i]=output[i];
    }
}
