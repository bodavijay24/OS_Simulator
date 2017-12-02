package lru1;

import java.util.*;
import java.util.Random;
public class fifo {
public static int z=0;

public static void main(String args[])
{
	
	int count = 0;
	int k1;
	Random rand = new Random(); 
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int k = sc.nextInt();
	int a[] = new int[n+10];
	int b[] = new int[k+10];
	int t[] = new int[k+10];
	for (int j=0;j<n;j++)
	{
		int temp =rand.nextInt(10);
			System.out.print(temp+" ");
			a[j]=temp;			
	} 
	System.out.println();
	for (int i=0;i<n;i++)
	{
		if(i==0)
		{
			count=count+1;
			b[z]=a[i];
			t[z]=i;
			z++;
		}
		else
		{
			int c=0;
			for( k1=0;k1<k;k1++)
			{
			
				if(k1<z)
				{
					if(a[i]==b[k1])
					{
						
						c=1;
						break;
					}
				}
			}
			if(c==0)
			{
			if(i>=k)
			{
				if(z==k)
				{
			int y=t[0];
			int w =0;
			for (k1=1;k1<k;k1++)
			{
				if(y>t[k1])
				{
					y=t[k1];
					w=k1;
				}
			}
			b[w]=a[i];
			t[w]=i;
			}
			}
			
				count=count+1;
				if(z<k)
				{
				b[z]=a[i];
				t[z]=i;
				z++;
				}
			}
		}	
		for (int l=0;l<z;l++)
		{
			System.out.print(b[l]+" ");
		}
		System.out.println();
		
	}
	System.out.println(count);
	}
}
