package lru1;
public class nonpreemptive {
		static class sjfNp{
			public int BT;
			public int pid;
			public boolean running;
			public boolean completed;
			public int AT;
			int WT;
			public int setBt(){
				BT=(int)(Math.random()*10+1);
				return BT;
			}
			public int setAt(int x){
				AT=(int)(x+1+Math.random()*10);
				
				return AT;
			}
			public void print(){
				System.out.println(pid+"\t"+AT+"\t\t"+BT);
			}
			sjfNp(int x){
				WT=0;
				running=false;
				completed=false;
				pid=x;
			}
		}
		static void updateWT(sjfNp[] fcfs,int endTime){
			
			for(int i=0;i<10;i++)
			{
				
				if(fcfs[i].AT>endTime){
					break;
				}
				if(!(fcfs[i].completed||fcfs[i].running))
				{

					fcfs[i].WT++;
				}
			}
			
		}
		static boolean allFinished(sjfNp[] fcfs){
			for(int i=0;i<10;i++){
				if(fcfs[i].completed==false){
					return false;					
				}
			}
			return true;
		}
		static void avgWt(sjfNp[] fcfs)
	{
		float sum=0;
		for(int i=0;i<10;i++)
		{
			sum=sum+fcfs[i].WT;
		}
		float awt=sum/10;
		System.out.println("average wating time : "+awt);
	}
		public static void main(String args[]){
			int t=0;
			sjfNp[] fcfs=new sjfNp[10];
			for(int i=0;i<10;i++){
				fcfs[i]=new sjfNp(i);
			}
			System.out.println("Generating 10 fcfs\n");
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
				for(int i=0;i<10&&fcfs[i].AT<=time;i++){
					if(!fcfs[i].completed){
						if(minBurstIndex==-1){
							minBurstIndex=i;
						}
						else if(fcfs[minBurstIndex].BT>fcfs[i].BT){
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
				for(int i=0;i<fcfs[running].BT;i++){
					fcfs[running].running=true;
					updateWT(fcfs,time);
					System.out.println(time+"\t\t"+running);
					time++;
				}
				fcfs[running].running=false;
				fcfs[running].completed=true;
				
			}
			System.out.println("P.Id\tWaitingTime");
			for(int i=0;i<10;i++){
				System.out.println(i+"\t\t"+fcfs[i].WT);
		}
			
avgWt(fcfs);
		}
	

}
