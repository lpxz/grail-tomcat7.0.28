package bug53498;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class RemoveAttributeThread extends Thread{

	public int  id =-1;
	FakeServer server =null;
	public RemoveAttributeThread(FakeServer serverarg, int  idarg){
		server = serverarg;
		id = idarg;
	}

	Random rand = new Random();
	public void run()
	{
		int interval = server.totalEntry*500;
		for(int i=0; i<interval; i++)
		{
			removeAttribute((""+rand.nextInt(server.totalEntry)).intern());
		}
	}
	private void removeAttribute(String name) {// simulate
		Map attributes =server.attributes;
		synchronized (name)//lpxz
		{
			
		
		boolean found = attributes.containsKey(name);
        if (found) {
            Object value = attributes.get(name);
            attributes.remove(name);
            int hashCode = value.hashCode();
//            System.out.println(value.toString());// throw null exception!
            
        } else {
            return;
        }
        
		}
	}
}
