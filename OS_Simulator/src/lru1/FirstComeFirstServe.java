package lru1;
import java.util.*;
public class FirstComeFirstServe {
	static class fcfs{
		public int bt;
		public int processid;
		public boolean running;
		public boolean completed;
		public int at;
		int wt;
		
		public int setAt(int x){
			at=(int)(x+1+Math.random()*10);
			
			return at;
		}
		public void print(){
			System.out.println(processid+"\t"+at+"\t\t"+bt);
		}
		public int setBt(){
			bt=(int)(Math.random()*10+1);
			return bt;
		}
		fcfs(int x){
			wt=0;
			running=false;
			completed=false;
			processid=x;
		}
	}
	static void updateWT(fcfs[] fcf,int endTime){
		
		for(int i=0;i<10;i++)
		{
			
			if(fcf[i].at>endTime){
				break;
			}
			if(!(fcf[i].completed||fcf[i].running))
			{

				fcf[i].wt++;
			}
		}
		
	}
	static void avgWt(fcfs[] fcf)
	{
		float sum=0;
		for(int i=0;i<10;i++)
		{
			sum=sum+fcf[i].wt;
		}
		float awt=sum/10;
		System.out.println("average wating time : "+awt);
	}
	static boolean allFinished(fcfs[] fcf){
		for(int i=0;i<10;i++){
			if(fcf[i].completed==false){
				return false;
				
			}
		}
		return true;
	}
	public static void main(String args[]){
		int t=0;
		fcfs[] fcf=new fcfs[10];
		for(int i=0;i<10;i++){
			fcf[i]=new fcfs(i);
		}
		System.out.println("Generate 10 fcf\n");
		System.out.println("P.id\tAT\tBT");
		for(int i=0;i<10;i++)
		{
			fcf[i].setBt();
			
			t=fcf[i].setAt(t);
			fcf[i].print();
		}
		System.out.println("Time\trunningPid");
		int running=0;
		for(int time=0;!allFinished(fcf);)
		{
			while(time<fcf[running].at){
				System.out.println(time+"\t\t"+"-");
				
				updateWT(fcf,time);
				time++;
			}
			for(int i=0;i<fcf[running].bt;i++){
				System.out.println((time+i)+"\t\t"+running);
				fcf[running].running=true;
				updateWT(fcf,time);
				time++;
			}
			fcf[running].running=false;
			fcf[running].completed=true;
			running++;
			
		}
		System.out.println("Pid\tWT");
		for(int i=0;i<10;i++){
			System.out.println(i+"\t\t"+fcf[i].wt);
		}
		avgWt(fcf);		
	}
}