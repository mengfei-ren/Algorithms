import java.util.Random;

/**
 *
 * @author Mengfei
 */
public class SelectionSort {
    protected int[] array;
    private Random r=new Random();
    public SelectionSort(int n){
        array=new int[n];
        for(int i=0;i<array.length;i++)
            array[i]=r.nextInt(100);
    }
    /**
     * Selection Sort Algorithm
     * @param array
     */
    public void SelectionSort(){
	for(int i=array.length-1;i>=0;i--)
	{
            int loc=0;
            //Find the max value of the array
            int m1=array[i];
            for(int j=0;j<i;j++)
            {
		if(m1<array[j]){
                    m1=array[j];
                    loc=j;
		}
            }
            array[loc]=array[i];
            array[i]=m1;
	}
    }
}
