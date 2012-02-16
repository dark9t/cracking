package cracking;

import java.util.HashMap;

public class ch1 {
	//reverse a string ending with \0
	public static String reverse(String cstr){
		int i=0;
		int j=cstr.length()-2;
		if(j>0)
		{
			StringBuilder cstrb=new StringBuilder(cstr);
			while(i<j){
				char temp=cstrb.charAt(i);
				cstrb.setCharAt(i, cstrb.charAt(j));
				cstrb.setCharAt(j, temp);
				i++;
				j--;
			}
			cstr=cstrb.toString();
		}
		return cstr;
	}
	
	//replace '_' with '%20'
	public static String replaceSpace(String str){
		String trimmed=str.trim();
		char[] chars=trimmed.toCharArray();
		StringBuilder sb=new StringBuilder();
		for(char c:chars){
			if(c==' ')
				sb.append("%20");
			else
				sb.append(c);
		}
		return sb.toString();
	}
	
	//compress a string
	public static String compress(String str){
		StringBuilder sb=new StringBuilder();
		char[] chars=str.toCharArray();
		int currentKeyCount=0;
		char currentKey=chars[0];
		for(int i=0;i<chars.length;i++){
			if(currentKey==chars[i])
				currentKeyCount++;
			else
			{
				//save current Key and its Count
				sb.append(currentKey);
				sb.append(currentKeyCount);
				//start to count the next key
				currentKey=chars[i];
				currentKeyCount=1;
			}
			if(i==chars.length-1)//last char key needs to be saved
			{
				sb.append(currentKey);
				sb.append(currentKeyCount);
			}
		}
		
		if(sb.length()<str.length())
			return sb.toString();
		else
			return str;
	}
	
	public static Object[][] rotateMatrix(Object[][] matrix, int N){
		for(int layer=0;layer<N/2;layer++){
			int i=layer;
			int last=N-1;
			while(i<N-layer-1){
				//save top
				Object temp=matrix[layer][i];
				//left->top
				matrix[layer][i]=matrix[last-i][layer];
				//bottom->left
				matrix[last-i][layer]=matrix[last-layer][last-i];
				//right->bottom
				matrix[last-layer][last-i]=matrix[i][last-layer];
				//top->right
				matrix[i][last-layer]=temp;
				i++;
			}
		}
		return matrix;
	}
	
	public static void clearMatrix(Object[][] matrix, int M, int N){
		HashMap<Integer, String> zeroMap=new HashMap<Integer,String>(M<N?N:M);
		
		for(int i=0;i<M;i++){
			for(int j=0;j<N;j++){
				if(Integer.parseInt(matrix[i][j].toString())==0)
				{
					zeroMap.put(i, "r");
					zeroMap.put(j, "c");	
				}
			}
		}
		
		for(int i=0;i<M;i++){
			for(int j=0;j<N;j++){
				if((zeroMap.get(i)!=null && zeroMap.get(i)=="r")
					|| (zeroMap.get(j)!=null &&zeroMap.get(j)=="c"))
					matrix[i][j]=0;
			}
		}
	}
}
