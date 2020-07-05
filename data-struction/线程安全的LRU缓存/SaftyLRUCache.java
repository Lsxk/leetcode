package 线程安全的LRU缓存;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SaftyLRUCache<K, V> {

    public static void main(String[] args) {
        SaftyLRUCache<Integer, Integer> cache = new SaftyLRUCache<>(100);

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.submit(() -> {
                try {
                    while (true) {
                        for (int j = 0; j < 200; j++) {
                            cache.put(j, j);
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }

            });
        }

        ExecutorService executorService2 = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService2.submit((Runnable) () -> {
                while (true) {
                    for (int j = 0; j < 200; j++) {
                        System.out.println(cache.get(j));
                    }
                }
            });
        }
    }

    int maxCapacity = 0;

    ConcurrentHashMap<K, V> cache = new ConcurrentHashMap<>();

    ConcurrentLinkedQueue<K> lru = new ConcurrentLinkedQueue<>();

    public SaftyLRUCache(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public V get(K key) {
        V v = cache.get(key);
        if (v != null) {
            lru.remove(key);
            lru.offer(key);
        }

        return v;
    }

    public void put(K key, V value) {
        if (cache.size() == maxCapacity) {
            K k = lru.poll();
            cache.remove(k);
        }

        cache.put(key, value);
        lru.offer(key);
    }
}
