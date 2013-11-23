package bugMine;

public class TOMCATMainDriver 
{
	public static void main(final String[] args)
	{
		try{
		Thread t1 = new Thread()
		{
			public void run()
			{
				//org.apache.catalina.startup.Bootstrap.main(new String[0]);
				String[] arg = {"start"};
				org.apache.catalina.startup.Catalina.main(arg);
			}
		};
		
		
		Thread t2 = new Thread()
		{
			public void run()
			{
				//@JspServletWrapper
				MainClient.main(args); // "threadNo opNO"
			}
		};
		
		t1.start();
		Thread.sleep(1000);
		t2.start();
		Thread.sleep(100000);
		System.exit(0);
	}catch(Exception e)
	{
		
	}
	}
}
