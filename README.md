"# GuavaCachingUtility" 
1.	Checkout the project from Git
2.	Open CachingUtility.java
3.	Find getById(int index)method, this method will be used to query the DB based on the index passed as the method argument. 
The application has dummy data stored in the map (amap).

4.	Use the below snippet of code to access 
CachingUtility utility = new CachingUtility();
utility.loadDataFromCache(2) // 2 is the index specified

The Object return type can be changed to desired type like User-Defined class.
5.	The maximum size of the cache can be modified accordingly
.maximumSize(1000)
6.	The cache reload / refresh can also be configured 
 .expireAfterAccess(90, TimeUnit.SECONDS) // 90 seconds is the duration set for the demo code snippet.
 It can be adjusted based on the business requirement.
