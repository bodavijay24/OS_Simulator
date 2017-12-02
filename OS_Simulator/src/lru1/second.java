package lru1;

import java.util.Random;
import java.util.Scanner;

public class second {
	public static void main(String args[])
	{
		
		int n,k,i,j,temp,request,i1,q1;
		int pf=0;
		Scanner sc= new Scanner(System.in);
		n= sc.nextInt();
		k = sc.nextInt();
		int pointer=1;
		Random rand =new Random();
		int inputs[]=new int[n+2];
		int pages[]=new int[k+2];
		int iref[]=new int[k+2];
		for ( i=1;i<=n;i++)
		{
			 temp =rand.nextInt(10);
			inputs[i]=temp;
			System.out.print(inputs[i]+" ");
		}
		System.out.println();
		for(i=1;i<=n;i++)
		{
			
			request=inputs[i];
			int k1=0;
			for(j=1;j<=k;j++)
			{
				if(pages[j]==request)
				{
					iref[j]=1;
					
					k1=1;break;
				}
			}
			if(k1==0)
			{
				for(i1=1;i1<=k;i1++)
				{
					if(iref[pointer]==1)
					{
						iref[pointer]=0;
						if(pointer==k)
						{pointer=0;}
						pointer++;
						}
					else
					{pages[pointer]=request;
					if(pointer==k)
					{pointer=0;}
					pointer++;break;
					}
				}
				pf++;
		}
			for(q1=1;q1<=k;q1++)
			{
				System.out.print(iref[q1]);
				
			}System.out.println();
	}
		System.out.println("   "+pf);
	}
	}
