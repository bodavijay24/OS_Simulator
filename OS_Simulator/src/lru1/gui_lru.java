package lru1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextPane;

import lru1.opt.k;

import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class gui_lru {

	private JFrame frame;
	private JTextField lru_out;
	private JTextField in_pro;
	private JTextField frames;
	private JLabel lblNewLabel;
	private JLabel lblNumberOfFrames;
	private JLabel lblProcesses;
	private JTextPane second_in;
	private JTextField second_out;
	private JButton btnSecond;
	private JLabel lblProcessec;
	private JTextPane fifo_in;
	private JButton btnFifo_1;
	private JTextField fifo_out;
	private JLabel lblProcesses_1;
	private JButton btnHome;
	private JLabel lblNewLabel_1;
	private JLabel lblPagefaults;
	private JLabel lblPagefaults_1;
	private JLabel lblPageReplacement;
	private JTextField opt_out;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui_lru window = new gui_lru();
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
	public gui_lru() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 903, 457);
		
		frame.getContentPane().setLayout(null);
		
		lru_out = new JTextField();
		lru_out.setBounds(52, 288, 86, 20);
		frame.getContentPane().add(lru_out);
		lru_out.setColumns(10);
		
		in_pro = new JTextField();
		in_pro.setBounds(20, 25, 37, 21);
		frame.getContentPane().add(in_pro);
		in_pro.setColumns(10);
		
		frames = new JTextField();
		frames.setBounds(132, 25, 37, 20);
		frame.getContentPane().add(frames);
		frames.setColumns(10);
		
		JTextPane lru_in = new JTextPane();
		lru_in.setForeground(Color.WHITE);
		lru_in.setBackground(Color.BLACK);
		lru_in.setBounds(10, 128, 32, 236);
		frame.getContentPane().add(lru_in);
		
		JButton btnFifo = new JButton("lru");
		btnFifo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnFifo.setBackground(Color.RED);
		btnFifo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int k,n,i,w,jj,ll,e,min,temp,hh;
				//scan k,
				int request=0;
				Scanner sc= new Scanner(System.in);
				n= Integer.valueOf(in_pro.getText());
				k = Integer.valueOf(frames.getText());
				Random rand =new Random();
				int inputs[]=new int[n+2];
				for ( i=1;i<=n;i++)
				{
					 temp =rand.nextInt(10);
					inputs[i]=temp;
					System.out.print(inputs[i]+" ");
				}
				String inp=String.valueOf(inputs[1]+" "+'\n');
				
				for( i=2;i<=n;i++)
				{
					inp=inp.concat(inputs[i]+" "+'\n');
				}
				
				lru_in.setText(inp);
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
				String outp=String.valueOf(pf);
				lru_out.setText(outp);

				}
			
		});
	
		btnFifo.setBounds(45, 153, 89, 23);
		frame.getContentPane().add(btnFifo);
		
		lblNewLabel = new JLabel("processes");
		lblNewLabel.setBounds(10, 0, 110, 14);
		frame.getContentPane().add(lblNewLabel);
		
		lblNumberOfFrames = new JLabel("frames");
		lblNumberOfFrames.setBounds(132, 0, 96, 14);
		frame.getContentPane().add(lblNumberOfFrames);
		
		lblProcesses = new JLabel("processes");
		lblProcesses.setBounds(10, 103, 86, 14);
		frame.getContentPane().add(lblProcesses);
		
		second_in = new JTextPane();
		second_in.setForeground(Color.WHITE);
		second_in.setBackground(Color.BLACK);
		second_in.setBounds(210, 128, 26, 236);
		frame.getContentPane().add(second_in);
		
		second_out = new JTextField();
		second_out.setBounds(246, 288, 86, 20);
		frame.getContentPane().add(second_out);
		second_out.setColumns(10);
		
		btnSecond = new JButton("second");
		btnSecond.setBackground(Color.GREEN);
		btnSecond.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnSecond.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int n,k,i,j,temp,request,i1,q1;
				int pf=0;
				Scanner sc= new Scanner(System.in);
				n= Integer.valueOf(in_pro.getText());
				k = Integer.valueOf(frames.getText());
				int pointer=1;
				Random rand =new Random();
				int pages[]=new int[k+2];
				int iref[]=new int[k+2];
				int inputs[]=new int[n+2];
				for ( i=1;i<=n;i++)
				{
					 temp =rand.nextInt(10);
					inputs[i]=temp;
					System.out.print(inputs[i]+" ");
				}
				String inp=String.valueOf(inputs[1]+" "+'\n');
				
				for( i=2;i<=n;i++)
				{
					inp=inp.concat(inputs[i]+" "+'\n');
				}
				second_in.setText(inp);
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
				String outp=String.valueOf(pf);
				second_out.setText(outp);

			}
			
		});
		btnSecond.setBounds(243, 153, 89, 23);
		frame.getContentPane().add(btnSecond);
		
		lblProcessec = new JLabel("processes");
		lblProcessec.setBounds(194, 103, 61, 14);
		frame.getContentPane().add(lblProcessec);
		
		fifo_in = new JTextPane();
		fifo_in.setForeground(Color.WHITE);
		fifo_in.setBackground(Color.BLACK);
		fifo_in.setBounds(428, 128, 26, 236);
		frame.getContentPane().add(fifo_in);
		
		btnFifo_1 = new JButton("fifo");
		btnFifo_1.setBackground(Color.CYAN);
		btnFifo_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnFifo_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int count = 0;
				int k1;
				int z=0;
				Random rand = new Random(); 
				Scanner sc = new Scanner(System.in);
				int n;
				int k;
				n= Integer.valueOf(in_pro.getText());
				k = Integer.valueOf(frames.getText());
				int a[] = new int[n+10];
				int b[] = new int[k+10];
				int t[] = new int[k+10];
				
				
				for (int j=0;j<n;j++)
				{
					int temp =rand.nextInt(10);
						System.out.print(temp+" ");
						a[j]=temp;			
				} 
                String inp=String.valueOf(a[0]+" "+'\n');
				for(int i=1;i<n;i++)
				{
					inp=inp.concat(a[i]+" "+'\n');
				}
				fifo_in.setText(inp);
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
				String outp=String.valueOf(count);
				fifo_out.setText(outp);
				}
			
		});
		btnFifo_1.setBounds(461, 153, 89, 23);
		frame.getContentPane().add(btnFifo_1);
		
		fifo_out = new JTextField();
		fifo_out.setBounds(464, 288, 86, 20);
		frame.getContentPane().add(fifo_out);
		fifo_out.setColumns(10);
		
		lblProcesses_1 = new JLabel("processes");
		lblProcesses_1.setBounds(423, 103, 80, 14);
		frame.getContentPane().add(lblProcesses_1);
		
		btnHome = new JButton("home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gui_sim.main(null);
			}
		});
		btnHome.setBounds(246, 384, 89, 23);
		frame.getContentPane().add(btnHome);
		
		lblNewLabel_1 = new JLabel("pagefaults");
		lblNewLabel_1.setBounds(52, 263, 96, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblPagefaults = new JLabel("pagefaults");
		lblPagefaults.setBounds(246, 263, 100, 14);
		frame.getContentPane().add(lblPagefaults);
		
		lblPagefaults_1 = new JLabel("pagefaults");
		lblPagefaults_1.setBounds(464, 263, 98, 14);
		frame.getContentPane().add(lblPagefaults_1);
		
		lblPageReplacement = new JLabel("PAGE REPLACEMENT");
		lblPageReplacement.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblPageReplacement.setBounds(210, 28, 244, 29);
		frame.getContentPane().add(lblPageReplacement);
		
		JTextPane opt_in = new JTextPane();
		opt_in.setForeground(Color.WHITE);
		opt_in.setBackground(Color.BLACK);
		opt_in.setBounds(639, 128, 32, 236);
		frame.getContentPane().add(opt_in);
		
		JLabel lblProcesses_2 = new JLabel("processes");
		lblProcesses_2.setBounds(625, 103, 80, 14);
		frame.getContentPane().add(lblProcesses_2);
		opt_out = new JTextField();
		opt_out.setBounds(681, 288, 86, 20);
		frame.getContentPane().add(opt_out);
		opt_out.setColumns(10);
		
		JLabel lblPageFaults = new JLabel("page faults");
		lblPageFaults.setBounds(681, 263, 89, 14);
		frame.getContentPane().add(lblPageFaults);
		
		
		JButton btnOptimum = new JButton("optimal");
		btnOptimum.setBackground(Color.ORANGE);
		
		btnOptimum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 int nof;
				 nof = Integer.valueOf(frames.getText());
				  k[] pro=new k[nof];
				  int n= Integer.valueOf(in_pro.getText());
					
				  Queue queue=new LinkedList();
			 int[] arr=new int[n];
			 int f=0;
			  for(int i=0;i<n;i++){
				  arr[i]=(int)((Math.random()*10)+1);
				  System.out.println(arr[i]);
			  }
			  String inp=String.valueOf(arr[0]+" "+'\n');
				for(int i=1;i<n;i++)
				{
					inp=inp.concat(arr[i]+" "+'\n');
				}
				opt_in.setText(inp);
			 for(int l=0;l<nof;l++){
				 pro[l]=new k();
				 pro[l].index=l;
			 }
			 for(int i=0;i<n;i++){
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
						  f++;
						  break;
					  }
				  }
				  if(flag==0){
					 int max=0,in=0,main=0;
					 for(int p=0;p<nof;p++){
						 int ind=100;
						 in=p;
						 for(int h=i+1;h<n;h++){
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
				  int ou=n-f;
				  String outp=String.valueOf(ou);
					opt_out.setText(outp);
			  }
				
			}
		});
		btnOptimum.setForeground(Color.BLACK);
		btnOptimum.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnOptimum.setBounds(681, 154, 89, 23);
		frame.getContentPane().add(btnOptimum);
		
		
	
	
	}
}
