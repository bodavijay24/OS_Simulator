package lru1;
public class priorityPreemtive {
	static class pp{
		public int bt;
		public int pid;
		public int priority;
		public boolean running;
		public boolean completed;
		public int at;
		int wt;
		public int setPriority(){
			priority=(int)(Math.random()*10);
			return priority;
		}
		public int setBt(){
			bt=(int)(Math.random()*10+1);
			return bt;
		}
		public int setAt(int x){
			at=(int)(x+1+Math.random()*5);

			return at;
		}
		public void print(){
			System.out.println(pid+"\t"+at+"\t\t"+bt+"\t\t"+priority);
		}
		pp(int x){
			wt=0;
			running=false;
			completed=false;
			pid=x;
			priority=0;
		}
	}
	static void updateWaitingTime(pp[] fcfs,int endTime){
		
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
	static boolean allFinished(pp[] fcfs){
		for(int i=0;i<10;i++){
			if(fcfs[i].completed==false){
				return false;

			}
		}
		return true;
	}
	static void avgWt(pp[] fcfs)
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
		pp[] fcfs=new pp[10];
		for(int i=0;i<10;i++){
			fcfs[i]=new pp(i);
		}
		System.out.println("Generating 10 fcfs\n");
		System.out.println("P.id\tArrivalTime\tBurstTime");
		for(int i=0;i<10;i++)
		{
			fcfs[i].setBt();
			fcfs[i].setPriority();
			
			t=fcfs[i].setAt(t);
			fcfs[i].print();
		}
		System.out.println("Time\tExecutingPid\tPriority");
		int running=0;
		for(int time=0;!allFinished(fcfs);){
			int minPriorityIndex=-1;
			for(int i=0;i<10&&fcfs[i].at<=time;i++){
				if(!fcfs[i].completed){
					if(minPriorityIndex==-1){
						minPriorityIndex=i;
					}
					else if(fcfs[minPriorityIndex].priority>fcfs[i].priority){
						minPriorityIndex=i;
					}
				}
			}
			running=minPriorityIndex;
			if(running==-1){
				System.out.println(time+"\t\t"+"-");
				time++;
				continue;
			}
			if(fcfs[running].bt==0){
				fcfs[running].completed=true;
				continue;
			}
			updateWaitingTime(fcfs,time);
			System.out.println(time+"\t\t"+running);
			fcfs[running].bt--;
			time++;
		}
		System.out.println("P.Id\tWaitingTime");
		for(int i=0;i<10;i++){
			System.out.println(i+"\t\t"+fcfs[i].wt);
		}
		avgWt(fcfs);
}
}

