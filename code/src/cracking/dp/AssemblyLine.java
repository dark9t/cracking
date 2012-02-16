package cracking.dp;

public class AssemblyLine {
	
	int len;
	//entry time
	float e1=1.5f;
	float e2=1.35f;
	
	//exit time
	float x1=0.3f;
	float x2=0.41f;
	
	//station processing time
	float[] a1;
	float[] a2;
	
	//transfering time
	float[] t1;
	float[] t2;
	
	//optimal time
	float[] f1;
	float[] f2;
	
	//step tracker
	int[][] tracker;
	
	//line number of last station
	int L;
	float OptimalVal;
	
	//optimal steps
	int[] result;
	public AssemblyLine(int n){
		this.len=n;
		
		
	}
	
	public float getOptimalPath(){
		//calculate base case
		f1[0]=e1+a1[0];
		f2[0]=e2+a2[0];
		
		//recursively calculate optimal value for sub problem
		for(int j=0;j<len;j++){
			if(f1[j-1]< f2[j-1]+t2[j-1])
			{
				f1[j]=a1[j]+f1[j-1];
				tracker[0][j]=0;
			}
			else
			{
				f1[j]=a1[j]+f2[j-1]+t2[j-1];
				tracker[1][j]=1;
			}
			
			if(f2[j-1]< f1[j-1]+t1[j-1])
			{
				f2[j]=a2[j]+f2[j-1];
				tracker[1][j]=1;
			}
			else
			{
				f2[j]=a2[j]+f1[j-1]+t1[j+1];
				tracker[0][j]=0;
			}
		}
		
		if(f1[len-1]+x1< f2[len-1]+x2)
		{
			L=0;
			OptimalVal=f1[len-1]+x1;
		}
		else 
		{
			L=1;
			OptimalVal=f2[len-1]+x2;
		}
		
		//figure out the steps
		int i=L;
		result[len-1]=i;
		for(int k=len-1;k>0;k--){
			result[k-1]=tracker[i][k];
			i=result[k-1];
		}
		
		return OptimalVal;
	}
}
