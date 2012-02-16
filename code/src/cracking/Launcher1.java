package cracking;
public class Launcher1 {
	public static void main(String[] args)
	{
		String input="how are you my friend          ";
		String input2="aaabbbccdddda";
//		System.out.println(input);
//		System.out.print(FindNonRepeatedCharacter.Find(input));
//		System.out.println(ch1.reverse(input));
//		System.out.println(ch1.replaceSpace(input));
//		System.out.println(ch1.compress(input2));
		Object[][] m=new Object[5][5];
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				
				m[i][j]=i*5+j;
				if(i==2 && j==3)
					m[i][j]=0;
			}
		}
		printMatrix(m);
		//m=ch1.rotateMatrix(m, 5);
		ch1.clearMatrix(m, 5, 5);
		System.out.println("==================");
		printMatrix(m);
	}
	
	private static void printMatrix(Object[][] matrix)
	{
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				System.out.printf("%3s", matrix[i][j]);
			}
			System.out.println();
		}
	}
}
