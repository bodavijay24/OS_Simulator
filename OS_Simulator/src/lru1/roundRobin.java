package lru1;
import java.util.*;
public class roundRobin {
	static class fcf{
		public int burstTime;
		public int pid;
		public boolean running;
		boolean robin;
		public boolean completed;
		public int arrivalTime;
		int wt;
		public int setBt(){
			burstTime=(int)(Math.random()*10+1);
			return burstTime;
		}
		public int setAt(int x){
			arrivalTime=(int)(x+1+Math.random()*10);

			return arrivalTime;
		}
		public void print(){
			System.out.println(pid+"\t"+arrivalTime+"\t\t"+burstTime);
		}
		fcf(int x){
			robin=false;
			wt=0;
			running=false;
			completed=false;
			pid=x;
		}
	}
static void updateWaitingTime(fcf[] fcfs,int endTime){
		
		for(int i=0;i<10;i++)
		{

			if(fcfs[i].arrivalTime>endTime){
				break;
			}
			if(!(fcfs[i].completed||fcfs[i].running))
			{

				fcfs[i].wt++;
			}
		}
		
	}
	static boolean allFinished(fcf[] fcfs){
		for(int i=0;i<10;i++){
			if(fcfs[i].completed==false){
				return false;

			}
		}
		return true;
	}
	static void avgWt(fcf[] fcfs)
	{
		float sum=0;
		for(int i=0;i<10;i++)
		{
			sum=sum+fcfs[i].wt;
		}
		float awt=sum/10;
		//System.out.println("average wating time : "+awt);
	}
	public static void main(String args[]){
		Queue rRobin=new LinkedList();
		int t=0;
		int quantumTime=2;
		fcf[] fcfs=new fcf[10];
		for(int i=0;i<10;i++){
			fcfs[i]=new fcf(i);
		}
		//System.out.println("Generating 10 fcfs with Quantum time of 2 seconds\n");
		//System.out.println("P.id\tArrivalTime\tBurstTime");
		for(int i=0;i<10;i++)
		{
			fcfs[i].setBt();
			
			t=fcfs[i].setAt(t);
			fcfs[i].print();
		}
		//System.out.println("Time\tExecutingPid");
		int running=0;
		for(int time=0;!allFinished(fcfs);)
		{
			for(int i=0;i<10;i++){
				if(fcfs[i].arrivalTime<=time && !fcfs[i].robin){
					rRobin.add(i);
					fcfs[i].robin=true;
				}
			}
			if(rRobin.isEmpty()){
				//System.out.println(time+"\t\t"+"-");
				time++;
				continue;
			}
			running=(int)rRobin.element();
			rRobin.remove();
			for(int i=0;i<quantumTime;i++){
				if(fcfs[running].burstTime!=0)
				{
					//System.out.println(time+"\t\t"+running);
					fcfs[running].burstTime--;
					
				}
				else
				{
					//System.out.println(time+"\t\t"+"blank");
				}
				updateWaitingTime(fcfs,time);
				time++;
			}
			if(fcfs[running].burstTime==0){
				fcfs[running].completed=true;
			}
			else
			{
				rRobin.add(running);
			}
				
		}
		//System.out.println("P.Id\tWaitingTime");
		for(int i=0;i<10;i++){
			//System.out.println(i+"\t\t"+fcfs[i].wt);
		}avgWt(fcfs);
	}
}

