
public class TupleOperations {
	
	public static void main(String args[]) throws InterruptedException 
	{
		try
		{
		TupleShare t1 = new TupleShare();
		t1.start();
		
		Thread.sleep(15000);
		
		TupleShare t2 = new TupleShare();
		t2.start();
		
        Thread.sleep(15000);
		
		TupleShare t3 = new TupleShare();
		t3.start();
		
        Thread.sleep(15000);
		
		TupleShare t4 = new TupleShare();
		t4.start();
		Thread.sleep(15000);
		
		TupleShare t5 = new TupleShare();
		t5.start();
		
        Thread.sleep(15000);
		
		TupleShare t6 = new TupleShare();
		t6.start();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
