import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;

public class CachingUtility {
	static CacheLoader<Integer, String> cacheLoader;
	static Cache<Integer, String> cacheData;
	static Map<Integer,String> amap;
		
	static {
			cacheLoader = new CacheLoader<Integer, String>() {
				@Override
				public String load(Integer key) throws Exception {
					return getById(key);
				}
			};
			
			cacheData = CacheBuilder.newBuilder()
			.maximumSize(1000)
			.expireAfterAccess(90, TimeUnit.SECONDS)
			.build(cacheLoader);
			
			// Dummy Data for testing
			amap = new HashMap<>();
			amap.put(1, "Raj");
			amap.put(2, "Rahul");
			amap.put(3, "Rohini");
			amap.put(4, "Sulekha");
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public String loadDataFromCache(Integer key) throws Exception {
		return cacheData.get(key);
	}
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	private static String getById(int index) {
		System.out.println("Hit for ID : " + index);
		return amap.get(index);
	}
	
	public static void main(String[] args) {
		try {
			CachingUtility utility = new CachingUtility();
			
			 System.out.println("Invocation #1");
			 System.out.println(utility.loadDataFromCache(2));
			 System.out.println(utility.loadDataFromCache(4));
			 System.out.println("Invocation #2");
			 System.out.println(utility.loadDataFromCache(1));
			 System.out.println( utility.loadDataFromCache(2));
			 System.out.println("Invocation #3");
			 System.out.println(utility.loadDataFromCache(1));
			 System.out.println(utility.loadDataFromCache(2));
			 System.out.println(utility.loadDataFromCache(3));
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
