package lru1;

import java.util.*;
import java.util.Random;
public class lru
{
	public static void main(String args[])
	{
		
		
	int k,n,i,w,jj,ll,e,min,temp,hh;
	//scan k,
	int request=0;
	Scanner sc= new Scanner(System.in);
	n= sc.nextInt();
	k = sc.nextInt();

	Random rand =new Random();
	int inputs[]=new int[n+2];
	for ( i=1;i<=n;i++)
	{
		 temp =rand.nextInt(10);
		inputs[i]=temp;
		System.out.print(inputs[i]+" ");
	}
	System.out.println();
	int pf=0;
	int time=1;
	int pages[]=new int[k+2];
	int itime[]=new int[k+2];
	for(i=1;i<=n;i++)
	{
		request=inputs[i];
		//search;
		int kkk=0;
		//System.out.println(time);
			for(w=1;w<=k;w++)
			{
				if(pages[w]==request&&itime[w]!=0)
				{
					kkk=1;
					itime[w]=time;
					break;
				}
			}
				if(kkk==0)
				{
					int test=0;
					for(jj=1;jj<=k;jj++)
					{
						if(pages[jj]==0&&itime[jj]==0)
						{
							pages[jj]=request;
							itime[jj]=time;
							test=1;
							break;
						
						}
					}
					if(test==0)
					{
					min=itime[1];
					ll=1;
					for(e=1;e<=k;e++){
						if(min>itime[e])
						{
							min=itime[e];
							ll=e;
						}	
					}
					pages[ll]=request;
					itime[ll]=time;
					}
					pf+=1;
				}
				time++;
				for(hh=1;hh<=k;hh++)
				{
					System.out.print(pages[hh]+" ");
				}
				System.out.println();
			}
		
		
	
	System.out.println(" "+pf);
	}
	
}
