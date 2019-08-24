
import java.util.*;


class Tuple<A,B,C> {
	
	A first_ele ;
	B second_ele ;
	C third_ele ;
	
	Tuple(A a, B b, C c)
	{
		this.first_ele = a;
		this.second_ele = b;
		this.third_ele = c;
	}
	

		
	public void show() 
	{
		System.out.println("<" + this.first_ele + "," +this.second_ele + "," + this.third_ele + ">");
	}
	
	
	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object x)
	{
		
		if(x instanceof Tuple)
		{
			Tuple pt = (Tuple) x;
			if((pt.first_ele.equals(this.first_ele)) && (pt.second_ele.equals(this.second_ele)) && (pt.third_ele.equals(this.third_ele)))
					{
				        return true;
					}
		}
		return false;
	}
	}
	
	
	
	
 
public class TupleShare extends Thread {
	@SuppressWarnings("rawtypes")
	static ArrayList<Tuple> Tupleobjects = new ArrayList<Tuple>(); // TupleObjects is a Tuple Space to store all the tuples.
	static ArrayList<Tuple> TupleReadObjs = new ArrayList<Tuple>(); 
	static int u =0;

 
 
	 @SuppressWarnings("rawtypes")
 
public boolean change(Tuple t, int c) //User input is by default in String format so this method will change input to Integer, String, Boolean in order according to user input. 
{
	 
		 try{
			 
		 
	 if(((String) t.first_ele).matches("[0-9]+"))
		{
			t.first_ele = Integer.parseInt((String) t.first_ele);
		}
	 else
		{
			if((((String) t.first_ele).equalsIgnoreCase("true")) || (((String) t.first_ele).equalsIgnoreCase("false")))
			{
				t.first_ele = Boolean.parseBoolean((String) t.first_ele);
			}
		}
	 
	 if(((String) t.second_ele).matches("[0-9]+"))
		{
			t.second_ele = Integer.parseInt((String) t.second_ele);
		}
	 else
		{
			if((((String) t.second_ele).equalsIgnoreCase("true")) || (((String) t.second_ele).equalsIgnoreCase("false")))
			{
				t.second_ele = Boolean.parseBoolean((String) t.second_ele);
			}
		}
	 
	 if(((String) t.third_ele).matches("[0-9]+"))
		{
			t.third_ele = Integer.parseInt((String) t.third_ele);
		}
	 else
		{
			if((((String) t.third_ele).equalsIgnoreCase("true")) || (((String) t.third_ele).equalsIgnoreCase("false")))
			{
				t.third_ele = Boolean.parseBoolean((String) t.third_ele);
			}
		}
		

		if((!(Tupleobjects.contains(t))) && (c == 0))
		{
		    
			    addTuple(t);
			    return true;
			    
			}
			
			else
			{
				
				return false;
				
			}
		 }
		 
		 catch(Exception e)
		 {
			 e.printStackTrace();
			 return false;
			
		 }
}
 @SuppressWarnings("rawtypes")
public void addTuple(Tuple t) //Write or add tuple in a tuple space.
 {
	 try
	 {
 Tupleobjects.add(t);
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
 }
	
 @SuppressWarnings({ "rawtypes", "static-access" })
public ArrayList read(Tuple t) // Read the requested tuple t by user.
 {
	 
	 int checkTupleavl =0;
	 
	while (checkTupleavl == 0) 
	{
		
 if(Tupleobjects.contains(t))
 {
	// TupleReadObjs.add(t);
	 System.out.println("Requested tuple to read");
	 t.show();
	 checkTupleavl = 1;
	 
 }
 
 else // this else part is for matching means if user write <String,7,Boolean> then it should return such as <abc,7,true>
 {
	 System.out.println("Requested tuple to read");
	 for(int i=0;i<Tupleobjects.size();i++)
	 {
		
		 if(((Tupleobjects.get(i).first_ele.toString().equalsIgnoreCase((String) t.first_ele)) ||(Tupleobjects.get(i).first_ele.getClass().toString().substring(16).equals((t.first_ele))))
				 
				 
				 && ((Tupleobjects.get(i).second_ele.toString().equalsIgnoreCase((String) t.second_ele)) || (t.second_ele.equals(Tupleobjects.get(i).second_ele.getClass().toString().substring(16))))
				 
				 
				 
				 && ((Tupleobjects.get(i).third_ele.toString().equalsIgnoreCase((String) t.third_ele)) ||(t.third_ele.equals(Tupleobjects.get(i).third_ele.getClass().toString().substring(16)))))
		 {
			
			 Tupleobjects.get(i).show();
			 TupleReadObjs.add(Tupleobjects.get(i)); 
			 checkTupleavl =1 ;
			
		 }}}
		 
		
			 try {
				 
				if (checkTupleavl == 0) 
				{
				System.out.println("Tuple: " + t.first_ele+ ","+ t.second_ele + "," + t.third_ele + " "  + "is now not available to read"); // if requested tuple such as <String,7,Boolean> does not exist then sleep that thread.
				Thread.currentThread().sleep(15000);
				//read(t);
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 
	
 return TupleReadObjs;
	 }
	 
	

	 
 @SuppressWarnings({ "rawtypes", "static-access" })
public synchronized void remove(Tuple t)
 {
	 int checkTupleavl =0;
	 while (checkTupleavl == 0) 
		{
	
 if(Tupleobjects.contains(t))
 {
	Tupleobjects.remove(t);
	 checkTupleavl = 1;
	 
 }
 
 else
 {
	 for(int i=0;i<Tupleobjects.size();i++)
	 {
		
		 
		 if(((Tupleobjects.get(i).first_ele.toString().equalsIgnoreCase((String) t.first_ele)) ||(Tupleobjects.get(i).first_ele.getClass().toString().substring(16).equals((t.first_ele))))
				 
				 
				 && ((Tupleobjects.get(i).second_ele.toString().equalsIgnoreCase((String) t.second_ele)) || (t.second_ele.equals(Tupleobjects.get(i).second_ele.getClass().toString().substring(16))))
				 
				 
				 
				 && ((Tupleobjects.get(i).third_ele.toString().equalsIgnoreCase((String) t.third_ele)) ||(t.third_ele.equals(Tupleobjects.get(i).third_ele.getClass().toString().substring(16)))))
		 {
			 
			 Tupleobjects.remove(i);
			 checkTupleavl = 1;
		 }
	 }}
			 try {
				 
				if (checkTupleavl == 0) 
				{
				System.out.println("Tuple: " + t.first_ele+ ","+ t.second_ele + "," + t.third_ele + " "  + "is not available to remove now");
				Thread.currentThread().sleep(15000);
				//read(t);
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 
		
	
 }
 
 
  public synchronized int update_lock ()
 
 {
	 if(u ==0)
	 {
    u = 1;//  lock update method
    return u;
	 }
	 else
	 {
	 u =0;
    return u;
	 }
 }
 
 public synchronized  void  update_unlock ()
 {
    u = 0;//unlock update method
  
 }

 
	@SuppressWarnings({ "unchecked", "static-access" })
	public void run()
	{
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("which operation do want to do ?");
		System.out.println("1. Read");
		System.out.println("2. Write");
		System.out.println("3. take");
		System.out.println("4. Update");
		System.out.println("5. Display");
		System.out.println("6. Exit");
		try{
			
		
		int a = sc.nextInt();
		int c =0;
		switch(a)
		{
			case 1:
				System.out.println("enter tuples inputs by comma to read e.g abc,2,true");
				Scanner sc5 = new Scanner(System.in);
				String st = sc5.nextLine();
				String[] s  = st.split(",");
				@SuppressWarnings("rawtypes")
				ArrayList<Tuple> ans = new ArrayList<Tuple>();
				@SuppressWarnings({ "rawtypes", "unused" })
				Tuple t2 = new Tuple(s[0], s[1], s[2]);
				ans = read(t2);
				break;
				
			case 2:
				boolean b = false;
				while (b == false) // for tuple if already exists then ask again for another input.
				{
				Scanner sc2 = new Scanner(System.in);
				System.out.println("enter tuple inputs by comma to write e.g abc,2,true");
				String st2 = sc2.nextLine();
				String[] s2  = st2.split(",");
				@SuppressWarnings("rawtypes")
				Tuple t1 = new Tuple(s2[0], s2[1], s2[2]);
				b= change(t1,0);
			    }
				
				System.out.println("Tuple added to tuple spaces after write operation performed");
				Tupleobjects.get(Tupleobjects.size()-1).show();
				
				System.out.println("Total available tuples in a Tuple Space");
				if(Tupleobjects.size() == 0)
				{
					System.out.println("There is no tuples in a Tuple Space");
				}
				else
				{
				for(int i =0;i<Tupleobjects.size();i++)
				{
					
					Tupleobjects.get(i).show();
				}}
				break;	
				
			case 3:
				System.out.println("enter tuple inputs by comma to do take operation");
				Scanner sc3 = new Scanner(System.in);
				String st3 = sc3.nextLine();
				String[] s3  = st3.split(",");
				ArrayList<Tuple> ans3 = new ArrayList<Tuple>();
				Tuple t3 = new Tuple(s3[0], s3[1], s3[2]);
				ans3 = read(t3); //get all matching tuple and store in ans ArrayList.
				
				for(int i =0;i<ans3.size();i++)
				{
				remove(ans3.get(i));
				}
				
				
				System.out.println("Available tuples in a Tuple Space after Take operation performed");
				if(Tupleobjects.size() == 0)
				{
					System.out.println("There is no tuples in a Tuple Space");
				}
				else
				{
				for(int i =0;i<Tupleobjects.size();i++)
				{
					
					Tupleobjects.get(i).show();
				}
				}
				break;
				
			case 4:
				
				int u_loc = update_lock();
				
				while(u_loc == 0)
				{
					System.out.println("Please wait to update");
					//this.wait();
					Thread.sleep(15000);
					u_loc = update_lock();
				}
				
				Scanner sc4 = new Scanner(System.in);
				System.out.println("enter old inputs of tuple by comma to update");
				String st4 = sc4.nextLine();
				String[] s4  = st4.split(",");
				
				@SuppressWarnings("rawtypes")
				Tuple t4 = new Tuple(s4[0], s4[1], s4[2]);
				b= change(t4,1);
				
				try{
                  
				
				
				synchronized(this) //this is for synchronization means if one thread is updating then another thread should wait or block untill current thread complete its update operation.
				{
					
				@SuppressWarnings({ "unused", "resource" })
				Thread t1 = this.currentThread();
				String[] strArr = new String[3];
				Scanner sc4_2 = new Scanner(System.in);
				System.out.println("enter new inputs of tuple by comma to update tuple");
				
				String str = sc4_2.nextLine();
				strArr = str.split(",");
				
				
				@SuppressWarnings("rawtypes")
				Tuple t4_2 = new Tuple(strArr[0], strArr[1], strArr[2]);
				b= change(t4_2,1);
				
				remove(t4);
				
				Thread.currentThread().sleep(25000);
				
				 addTuple(t4_2);
				
				
				 System.out.println("Available tuples in a Tuple Space after update operation performed");
				 if(Tupleobjects.size() == 0)
					{
						System.out.println("There is no tuples in a Tuple Space");
					}
				 else
				 {
				for(int i =0;i<Tupleobjects.size();i++)
				{
					
					Tupleobjects.get(i).show();
				}}
				 
				update_unlock();
				//this.notify();
				
				
				}
				
				}
				
				catch(Exception e)
				{
					e.printStackTrace();
				
					}
					
				
			 break;	
			
			case 5:
				if(Tupleobjects.size() == 0)
				{
					System.out.println("There is no tuples in a Tuple Space");
				}
				else
				{
				for(int i =0;i<Tupleobjects.size();i++)
				{
					System.out.println("Available tuples in a Tuple Space");
					Tupleobjects.get(i).show();
				}}
				break;	
				
			case 6:
				System.exit(0);
				break;
		  /*default:
			  System.out.println("Please enter valid input");
			  break;*/
		}}
		
		catch(Exception e)
		{
			System.out.println("you have eneterd wrong input");
			e.printStackTrace();
		
		}

	}}



