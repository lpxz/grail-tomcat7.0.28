package bug53498;

import org.apache.catalina.core.ApplicationContext;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Catalina;

public class ApplicationContextRelated {
	
	public static void main(String[] args) throws Exception{
		// ApplicationContext.java
		
		
		
		// 5617  13124  13154  sharing sever
		// 	5917	6063	17273	no sharing sever: entry counts are different from above
		
		int threadNo = Integer.parseInt(args[0]);
		
		FakeServer server = new FakeServer();
		server.fill(20000);
		
		
		RemoveAttributeThread[] removers = new RemoveAttributeThread[threadNo];
		for(int i=0 ; i<threadNo; i++)
		{

			 removers[i] = new RemoveAttributeThread(server,i);
		}
		
		
		long start = System.currentTimeMillis();
		for(int i=0 ; i<threadNo; i++)
		{
			 removers[i].start();
			
		}
		
		for(int i=0 ; i<threadNo; i++)
		{
			 removers[i].join();
			
		}
		long stop = System.currentTimeMillis();
		System.out.println("duration: " + (stop -start));
		

		
		
		
	}

}
