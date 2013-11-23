package bug53498;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FakeServer {

	public int totalEntry = -1; 
	protected Map<String,Object> attributes =
	        new ConcurrentHashMap<String,Object>();
	
	public void fill(int entryCount)
	{
		for(int i=0; i<entryCount;i++)
		{
			attributes.put((""+i).intern(), ("value"+i).intern());
			
		}
		totalEntry = entryCount;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
