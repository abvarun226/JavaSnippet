package com.abvarun226.GeneralCode;

import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.map.LRUMap;

import java.util.ArrayList;

/**
 * Created by bharghav on 1/22/15.
 *
 * In-Memory Cache Implementation using LRUMap data structure from apache commons collections library
 *
 */

class InMemoryCache<K,T> {
    private long timeToLive;
    private LRUMap myCacheMap;

    protected class myCacheObject {
        public long lastAccessed = System.currentTimeMillis();
        public T value;

        protected myCacheObject(T v) {
            this.value = v;
            this.lastAccessed = System.currentTimeMillis();
        }
    }

    public InMemoryCache(long myTimeToLive, final long myTimerInterval, int maxItems) {
        this.timeToLive = myTimeToLive * 1000; // secs to milliseconds conversion

        myCacheMap = new LRUMap(maxItems);

        if(timeToLive > 0 && myTimerInterval > 0) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true) {
                        try {
                            Thread.sleep(myTimerInterval * 1000);
                        } catch (InterruptedException e) {

                        }
                        cleanup();
                    }
                }
            });

            t.setDaemon(true);
            t.start();

        }
    }

    public void put(K key, T value) {
        synchronized (myCacheMap) {
            myCacheMap.put(key, new myCacheObject(value));
        }
    }

    public T get(K key) {
        synchronized (myCacheMap) {
            myCacheObject cObj = (myCacheObject) myCacheMap.get(key);

            if ( cObj == null ) {
                return null;
            } else {
                cObj.lastAccessed = System.currentTimeMillis();
                return cObj.value;
            }
        }
    }

    public String toString() {
        String result = "[";
        boolean flag = false;

        synchronized (myCacheMap) {
            MapIterator itr = myCacheMap.mapIterator();
            myCacheObject cObj = null;

            while(itr.hasNext()) {
                K key = (K) itr.next();
                cObj = (myCacheObject) itr.getValue();
                T value = cObj.value;
                result += "(" + key + " , " + value + ") , ";
                flag = true;
            }
        }
        if(flag) {
            result = result.substring(0, result.length()-3);
        }
        result += "]";
        return result;
    }

    public void remove(K key) {
        synchronized (myCacheMap) {
            myCacheMap.remove(key);
        }
    }

    public int size() {
        synchronized (myCacheMap) {
            return myCacheMap.size();
        }
    }

    public void cleanup() {
        long now = System.currentTimeMillis();
        ArrayList<K> deleteKey = null;

        synchronized (myCacheMap) {
            MapIterator itr = myCacheMap.mapIterator();

            deleteKey = new ArrayList<>((myCacheMap.size()/2) + 1);

            K key = null;
            myCacheObject cObj = null;

            while(itr.hasNext()) {
                key = (K) itr.next();
                cObj = (myCacheObject) itr.getValue();

                if(cObj != null && (now > (timeToLive + cObj.lastAccessed))) {
                    deleteKey.add(key);
                }
            }
        }

        for (K key : deleteKey) {
            synchronized (myCacheMap) {
                myCacheMap.remove(key);
            }

            Thread.yield();
        }
    }
}

public class InMemoryCacheDemo1 {
    public static void main(String... args) throws InterruptedException {
        InMemoryCacheDemo1 myCache = new InMemoryCacheDemo1();

        System.out.println("\n\n======== Test1: Add-Remove Objects ========");
        myCache.testAddRemoveObjects();

        System.out.println("\n\n======== Test2: Expired Objects ===========");
        myCache.testExpiredCacheObjects();

        System.out.println("\n\n======== Test3: Objects Cleanup Time ======");
        myCache.testObjectsCleanupTime();

    }

    private void testAddRemoveObjects() {

        InMemoryCache<String,String> cache = new InMemoryCache<>(200, 500, 6);

        cache.put("eBay", "eBay");
        cache.put("Paypal", "Paypal");
        cache.put("Google", "Google");
        cache.put("Microsoft", "Microsoft");
        cache.put("IBM", "IBM");
        cache.put("Facebook", "Facebook");

        System.out.println("Cache size : " + cache.size());
        cache.remove("Google");
        System.out.println("Removed Google. Cache size : " + cache.size());

        cache.put("Yahoo" , "Yahoo");
        cache.put("Twitter", "Twitter");
        System.out.println("Added 2 objects. Cache size : " + cache.size());

        System.out.println("Contents of cache : \n" + cache);

    }

    private void testExpiredCacheObjects() throws  InterruptedException {
        InMemoryCache<String, String> cache = new InMemoryCache<>(1, 1, 10);

        cache.put("Yahoo", "yahoo");
        cache.put("Tumblr", "tumblr");
        Thread.sleep(3000);

        System.out.println("2 Objects were added with TTL 1 sec. Cache size : " + cache.size());

        System.out.println("Contents of cache : \n" + cache);

    }

    private void testObjectsCleanupTime() throws InterruptedException {
        int size = 500000;

        InMemoryCache<String, String> cache = new InMemoryCache<>(100, 100, size);

        for(int i=0 ; i<size ; i++) {
            String value = Integer.toString(i);
            cache.put(value, value);
        }

        Thread.sleep(200);

        long start = System.currentTimeMillis();
        cache.cleanup();
        double timeTaken = (double) (System.currentTimeMillis() - start) / 1000.0;

        System.out.println("Cleanup of " + size + " objects took " + timeTaken + " seconds");
    }
}
