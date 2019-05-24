package controller;

public class Ccheckint {
	public static char[] n= {'0','1','2','3','4','5','6','7','8','9'};
	public static Boolean check(String text)
	{
		boolean b=false;
		char a[]=text.toCharArray();
		for(int i=0;i<text.length();i++) {
			for(int j=0; j<n.length;j++)
			{
				if(a[i]==n[j])
				{
					b=true;
					break;
				}	
			}
			if(b==false)
				return false;
			b=false;
		}
		return true; 
	}
}
