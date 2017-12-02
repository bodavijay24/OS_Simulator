package lru1;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class gui {

	private JFrame frame;
	private JTextField RROutput;
	private JTextField sjfNp;
	private JTextField srtf;
	private JTextField fcfsOut;
	private JTextField pnpOut;
	private JTextField ppOut;
	private JButton btnHome;
	private JLabel lblCpuScheduling;

	/**
	 * Launch the application.
	 */
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
	static float avgWt(pp[] fcfs)
	{
		float sum=0;
		for(int i=0;i<10;i++)
		{
			sum=sum+fcfs[i].wt;
		}
		float awt=sum/10;
		return awt;
	}

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
		static float avgWt(fcf[] fcfs)
		{
			float sum=0;
			for(int i=0;i<10;i++)
			{
				sum=sum+fcfs[i].wt;
			}
			float awt=sum/10;
			
			return awt;
		}
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
		static float avgWt(fcfs[] fcf)
		{
			float sum=0;
			for(int i=0;i<10;i++)
			{
				sum=sum+fcf[i].wt;
			}
			float awt=sum/10;
			return awt;
		}
		static boolean allFinished(fcfs[] fcf){
			for(int i=0;i<10;i++){
				if(fcf[i].completed==false){
					return false;
					
				}
			}
			return true;
		}
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
		static float avgWt(sjfNp[] fcfs)
	{
		float sum=0;
		for(int i=0;i<10;i++)
		{
			sum=sum+fcfs[i].WT;
		}
		float awt=sum/10;
		return awt;
	}
		static class pnp{
			public int BT;
			public int pid;
			public int priority;
			public boolean running;
			public boolean completed;
			public int AT;
			int WT;
			public int setPriority(){
				priority=(int)(Math.random()*10);
				return priority;
			}
			public int setBt(){
				BT=(int)(Math.random()*10+1);
				return BT;
			}
			public int setAt(int x){
				AT=(int)(x+1+Math.random()*5);
				
				return AT;
			}
			public void print(){
				System.out.println(pid+"\t"+AT+"\t\t"+BT+"\t\t"+priority);
			}
			pnp(int x){
				WT=0;
				running=false;
				completed=false;
				pid=x;
				priority=0;
			}
		}
		static void updateWT(pnp[] fcfs,int endTime){
			
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
		static boolean allFinished(pnp[] fcfs){
			for(int i=0;i<10;i++){
				if(fcfs[i].completed==false){
					return false;
					
				}
			}
			return true;
		}
		static float avgWt(pnp[] fcfs)
		{
			float sum=0;
			for(int i=0;i<10;i++)
			{
				sum=sum+fcfs[i].WT;
			}
			float awt=sum/10;
			return awt;
		}
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
		static float avgWt(srtf[] fcfs)
	{
		float sum=0;
		for(int i=0;i<10;i++)
		{
			sum=sum+fcfs[i].wt;
		}
		float awt=sum/10;
		return awt;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui window = new gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 364);
		
		frame.getContentPane().setLayout(null);
		
		JButton btnClick = new JButton("rRobin");
		btnClick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Queue Rrobin=new LinkedList();
				int t=0;
				int quantumTime=2;
				fcf[] fcfs=new fcf[10];
				for(int i=0;i<10;i++){
					fcfs[i]=new fcf(i);
				}
				System.out.println("Generating 10 fcfs with Quantum time of 2 seconds\n");
				System.out.println("P.id\tArrivalTime\tBurstTime");
				for(int i=0;i<10;i++)
				{
					fcfs[i].setBt();
					
					t=fcfs[i].setAt(t);
					fcfs[i].print();
				}
				System.out.println("Time\tExecutingPid");
				int running=0;
				for(int time=0;!allFinished(fcfs);)
				{
					for(int i=0;i<10;i++){
						if(fcfs[i].arrivalTime<=time && !fcfs[i].robin){
							Rrobin.add(i);
							fcfs[i].robin=true;
						}
					}
					if(Rrobin.isEmpty()){
						System.out.println(time+"\t\t"+"-");
						time++;
						continue;
					}
					running=(int)Rrobin.element();
					Rrobin.remove();
					for(int i=0;i<quantumTime;i++){
						if(fcfs[running].burstTime!=0)
						{
							System.out.println(time+"\t\t"+running);
							fcfs[running].burstTime--;
							
						}
						else
						{
							System.out.println(time+"\t\t"+"blank");
						}
						updateWaitingTime(fcfs,time);
						time++;
					}
					if(fcfs[running].burstTime==0){
						fcfs[running].completed=true;
					}
					else
					{
						Rrobin.add(running);
					}
						
				}
				System.out.println("P.Id\tWaitingTime");
				for(int i=0;i<10;i++){
					System.out.println(i+"\t\t"+fcfs[i].wt);
				}
				float ans=avgWt(fcfs);
				String S;
				S=String.valueOf(ans);
				RROutput.setText(S);
			
				
				System.out.println("average waiting time:"+ans);
				
			}
		});
		btnClick.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//String[] args = {};
				//roundRobin.main(args);
			}
		});
		btnClick.setBounds(43, 65, 89, 23);
		frame.getContentPane().add(btnClick);
		
		JButton btnFcfs = new JButton("FCFS");
		btnFcfs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				String ans;
				ans=String.valueOf(avgWt(fcf));
				fcfsOut.setText(ans);
				System.out.println("average waiting time:"+ans);
				
			}
		});
		btnFcfs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//String[] args = {};
				//FirstComeFirstServe.main(args);
			}
		});
		btnFcfs.setBounds(295, 65, 89, 23);
		frame.getContentPane().add(btnFcfs);
		
		JButton btnNonpreemptive = new JButton("SJF");
		btnNonpreemptive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
	String ans;			
	ans= String.valueOf(avgWt(fcfs));
	sjfNp.setText(ans);
	System.out.println("average waiting time:"+ans);
			}
		});
		btnNonpreemptive.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//String[] args = {};
				//nonpreemptive.main(args);
			}
		});
		btnNonpreemptive.setBounds(43, 143, 89, 23);
		frame.getContentPane().add(btnNonpreemptive);
		
		JButton btnPreemptive = new JButton("STRF");
		btnPreemptive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				}
				String ans;
				ans=String.valueOf(avgWt(fcfs));
				srtf.setText(ans);
				System.out.println("average waiting time:"+ans);
			}
		});
		btnPreemptive.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//String[] args = {};
				//preemptive.main(args);
			}
		});
		btnPreemptive.setBounds(43, 220, 89, 23);
		frame.getContentPane().add(btnPreemptive);
		
		JButton btnPrioritynp = new JButton("priority-NP");
		btnPrioritynp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int t=0;
				pnp[] fcfs=new pnp[10];
				for(int i=0;i<10;i++){
					fcfs[i]=new pnp(i);
				}
				System.out.println("Generating 10 fcfs\n");
				System.out.println("P.id\tArrivalTime\tBurstTime\tPriority");
				for(int i=0;i<10;i++)
				{
					fcfs[i].setBt();
					fcfs[i].setPriority();
					
					t=fcfs[i].setAt(t);
					fcfs[i].print();
				}
				System.out.println("Time\tExecutingPid");
				int running=0;
				for(int time=0;!allFinished(fcfs);){
					int minPriorityIndex=-1;
					for(int i=0;i<10&&fcfs[i].AT<=time;i++){
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
				String ans;
				ans=String.valueOf(avgWt(fcfs));
				pnpOut.setText(ans);
				System.out.println("average waiting time:"+ans);

			}
		});
		btnPrioritynp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//String[] args = {};
				//priorityNonPreemptive.main(args);
			}
		});
		btnPrioritynp.setBounds(295, 143, 89, 23);
		frame.getContentPane().add(btnPrioritynp);
		
		JButton btnPrioritypreemtive = new JButton("priority-P");
		btnPrioritypreemtive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
				String ans;
				ans=String.valueOf(avgWt(fcfs));
				ppOut.setText(ans);
				System.out.println("average waiting time:"+ans);
			}
		});
		btnPrioritypreemtive.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//String[] args = {};
				//priorityPreemtive.main(args);
			}
		});
		btnPrioritypreemtive.setBounds(295, 220, 89, 23);
		frame.getContentPane().add(btnPrioritypreemtive);
		
		RROutput = new JTextField();
		RROutput.setBounds(43, 99, 86, 20);
		frame.getContentPane().add(RROutput);
		RROutput.setColumns(10);
		
		sjfNp = new JTextField();
		sjfNp.setBounds(43, 177, 86, 20);
		frame.getContentPane().add(sjfNp);
		sjfNp.setColumns(10);
		
		srtf = new JTextField();
		srtf.setBounds(43, 254, 86, 20);
		frame.getContentPane().add(srtf);
		srtf.setColumns(10);
		
		fcfsOut = new JTextField();
		fcfsOut.setBounds(295, 99, 86, 20);
		frame.getContentPane().add(fcfsOut);
		fcfsOut.setColumns(10);
		
		pnpOut = new JTextField();
		pnpOut.setBounds(295, 177, 86, 20);
		frame.getContentPane().add(pnpOut);
		pnpOut.setColumns(10);
		
		ppOut = new JTextField();
		ppOut.setBounds(295, 254, 86, 20);
		frame.getContentPane().add(ppOut);
		ppOut.setColumns(10);
		
		btnHome = new JButton("home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gui_sim.main(null);
			}
		});
		btnHome.setBounds(156, 291, 89, 23);
		frame.getContentPane().add(btnHome);
		
		lblCpuScheduling = new JLabel("CPU SCHEDULING");
		lblCpuScheduling.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblCpuScheduling.setBounds(136, 11, 178, 23);
		frame.getContentPane().add(lblCpuScheduling);
	}
}
