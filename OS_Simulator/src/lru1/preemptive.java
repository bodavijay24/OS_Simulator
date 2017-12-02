package lru1;
public class preemptive {
		static class srtf{
			public int bt;
			public int pid;
			public boolean running;
			public boolean completed;
			public int at;
			int wt;
			public int setBt(){
				bt=(int)(Math.random()*10+1);
				return bt;
			}
			public int setAt(int x){
				at=(int)(x+1+Math.random()*5);
				
				return at;
			}
			public void print(){
				System.out.println(pid+"\t"+at+"\t\t"+bt);
			}
			srtf(int x){
				wt=0;
				running=false;
				completed=false;
				pid=x;
			}
		}
		static void updateWaitingTime(srtf[] fcfs,int endTime){
			
			for(int i=0;i<10;i++)
			{
				
				if(fcfs[i].at>endTime){
					break;
				}
				if(!(fcfs[i].completed||fcfs[i].running))
				{

					fcfs[i].wt++;
				}
			}
			
		}
		static boolean allFinished(srtf[] fcfs){
			for(int i=0;i<10;i++){
				if(fcfs[i].completed==false){
					return false;

				}
			}
			return true;
		}
		static void avgWt(srtf[] fcfs)
	{
		float sum=0;
		for(int i=0;i<10;i++)
		{
			sum=sum+fcfs[i].wt;
		}
		float awt=sum/10;
		System.out.println("average wating time : "+awt);
	}
		public static void main(String args[]){
			int t=0;
			srtf[] fcfs=new srtf[10];
			for(int i=0;i<10;i++){
				fcfs[i]=new srtf(i);
			}
			System.out.println("Generating 10 Processes\n");
			System.out.println("P.id\tArrivalTime\tBurstTime");
			for(int i=0;i<10;i++)
			{
				fcfs[i].setBt();
				
				t=fcfs[i].setAt(t);
				fcfs[i].print();
			}
			System.out.println("Time\tExecutingPid");
			int running=0;
			for(int time=0;!allFinished(fcfs);){
				int minBurstIndex=-1;
				for(int i=0;i<10&&fcfs[i].at<=time;i++){
					if(!fcfs[i].completed){
						if(minBurstIndex==-1){
							minBurstIndex=i;
						}
						else if(fcfs[minBurstIndex].bt>fcfs[i].bt){
							minBurstIndex=i;
						}
					}
				}
				running=minBurstIndex;
				if(running==-1){
					System.out.println(time+"\t\t"+"-");
					time++;
					continue;
				}
				if(fcfs[running].bt==0){
					fcfs[running].completed=true;
					continue;
				}
				System.out.println(time+"\t\t"+running);
				fcfs[running].bt--;
				updateWaitingTime(fcfs,time);
				time++;
			}System.out.println("Pid\tWT");
			for(int i=0;i<10;i++){
				System.out.println(i+"\t\t"+fcfs[i].wt);
			}avgWt(fcfs);
		}
}
