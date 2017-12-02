package lru1;

//import second.sec.k;
import java.util.*;
public class opt {
	public static class k{
		public int val;
		public boolean oc;
		public int index;
		k(){
			val=0;
			oc=false;
			index=0;
		}
	}
	 public static void main(String[] args) {
		  int nof=3;
		  k[] pro=new k[nof];
		  Queue queue=new LinkedList();
	 int[] arr=new int[10];
	  for(int i=0;i<10;i++){
		  arr[i]=(int)((Math.random()*10)+1);
		  System.out.println(arr[i]);
	  }
	 for(int l=0;l<3;l++){
		 pro[l]=new k();
		 pro[l].index=l;
	 }
	 for(int i=0;i<10;i++){
		  int flag=0;
		  for(int j=0;j<pro.length;j++){
			  if(pro[j].oc==false){
				  pro[j].val=arr[i];
				  pro[j].oc=true;
				  queue.add(j);
				  flag=1;
			//	  System.out.println("val"+pro[j].val+i);
				  break;
			  }
			  if(pro[j].oc==true&&pro[j].val==arr[i]){
				  flag=1;
				  break;
			  }
		  }
		  if(flag==0){
			 int max=0,in=0,main=0;
			 for(int p=0;p<nof;p++){
				 int ind=100;
				 in=p;
				 for(int h=i+1;h<10;h++){
					 if(arr[h]==pro[p].val){
						 ind=h;
						 in=p;
						 System.out.println("hey"+h);
						 break;
					 }
				 }
				 if(ind==100){
					 main=in;
					 max=ind;
					 break;
				 }
				 else if(ind>max)
					 max=ind;
				 main=in;
				 
			 }
			 System.out.println("hi"+max+main);
			 if(max==0){
				 int k1=(int)queue.poll();
				  pro[k1].val=arr[i];
				  pro[k1].oc=true;
				  queue.add(k1);
			 }
			 else{
				 pro[main].val=arr[i];
			 }
		  }
		  for(int y=0;y<pro.length;y++){
			  System.out.println("val"+pro[y].val+"index"+pro[y].index);
		  }
	  }
}
}
