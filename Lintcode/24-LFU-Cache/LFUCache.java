import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {
	private final Map<Integer, CacheNode> cache;
	private final LinkedHashSet[] frequencyList;
	private int lowestFrequency;
	private int maxFrequency;
	private final int maxCacheSize;

	/**
	 * @param capacity： an integer
	 */
	public LFUCache(int capacity) {
		this.cache = new HashMap<Integer, CacheNode>(capacity);
		this.frequencyList = new LinkedHashSet[capacity * 2];
		this.lowestFrequency = 0;
		this.maxFrequency = capacity * 2 - 1;
		this.maxCacheSize = capacity;
		initFrequencyList();
	}

	/*
	 * @param key, an integer
	 * 
	 * @param value, an integer
	 * 
	 * @return nothing
	 */
	public void set(int key, int value) {
		CacheNode currentNode = cache.get(key);
		if (currentNode == null) {
			if (cache.size() == maxCacheSize) {
				doEviction();
			}
			LinkedHashSet<CacheNode> nodes = frequencyList[0];
			currentNode = new CacheNode(key, value, 0);
			nodes.add(currentNode);
			cache.put(key, currentNode);
			lowestFrequency = 0;
		} else {
			currentNode.v = value;
		}
		addFrequency(currentNode);
	}

	public int get(int key) {
		CacheNode currentNode = cache.get(key);
		if (currentNode != null) {
			addFrequency(currentNode);
			return currentNode.v;
		} else {
			return -1;
		}
	}

	public void addFrequency(CacheNode currentNode) {
		int currentFrequency = currentNode.frequency;
		if (currentFrequency < maxFrequency) {
			int nextFrequency = currentFrequency + 1;
			LinkedHashSet<CacheNode> currentNodes = frequencyList[currentFrequency];
			LinkedHashSet<CacheNode> newNodes = frequencyList[nextFrequency];
			moveToNextFrequency(currentNode, nextFrequency, currentNodes, newNodes);
			cache.put(currentNode.k, currentNode);
			if (lowestFrequency == currentFrequency && currentNodes.isEmpty()) {
				lowestFrequency = nextFrequency;
			}
		} else {
			// Hybrid with LRU: put most recently accessed ahead of others:
			LinkedHashSet<CacheNode> nodes = frequencyList[currentFrequency];
			nodes.remove(currentNode);
			nodes.add(currentNode);
		}
	}

	public int remove(int key) {
		CacheNode currentNode = cache.remove(key);
		if (currentNode != null) {
			LinkedHashSet<CacheNode> nodes = frequencyList[currentNode.frequency];
			nodes.remove(currentNode);
			if (lowestFrequency == currentNode.frequency) {
				findNextLowestFrequency();
			}
			return currentNode.v;
		} else {
			return -1;
		}
	}

	public int frequencyOf(int key) {
		CacheNode node = cache.get(key);
		if (node != null) {
			return node.frequency + 1;
		} else {
			return 0;
		}
	}

	public void clear() {
		for (int i = 0; i <= maxFrequency; i++) {
			frequencyList[i].clear();
		}
		cache.clear();
		lowestFrequency = 0;
	}

	public int size() {
		return cache.size();
	}

	public boolean isEmpty() {
		return this.cache.isEmpty();
	}

	public boolean containsKey(int key) {
		return this.cache.containsKey(key);
	}

	private void initFrequencyList() {
		for (int i = 0; i <= maxFrequency; i++) {
			frequencyList[i] = new LinkedHashSet<CacheNode>();
		}
	}

	private void doEviction() {
		int currentlyDeleted = 0;
		double target = 1; // just one
		while (currentlyDeleted < target) {
			LinkedHashSet<CacheNode> nodes = frequencyList[lowestFrequency];
			if (nodes.isEmpty()) {
				continue;
			} else {
				Iterator<CacheNode> it = nodes.iterator();
				while (it.hasNext() && currentlyDeleted++ < target) {
					CacheNode node = it.next();
					it.remove();
					cache.remove(node.k);
				}
				if (!it.hasNext()) {
					findNextLowestFrequency();
				}
			}
		}
	}

	private void moveToNextFrequency(CacheNode currentNode, int nextFrequency, LinkedHashSet<CacheNode> currentNodes,
			LinkedHashSet<CacheNode> newNodes) {
		currentNodes.remove(currentNode);
		newNodes.add(currentNode);
		currentNode.frequency = nextFrequency;
	}

	private void findNextLowestFrequency() {
		while (lowestFrequency <= maxFrequency && frequencyList[lowestFrequency].isEmpty()) {
			lowestFrequency++;
		}
		if (lowestFrequency > maxFrequency) {
			lowestFrequency = 0;
		}
	}

	private class CacheNode {
		public final int k;
		public int v;
		public int frequency;

		public CacheNode(int k, int v, int frequency) {
			this.k = k;
			this.v = v;
			this.frequency = frequency;
		}
	}
    
    /*
    private static class CacheNode {
        public int key;
        public int val;
        public int fre;
        public CacheNode(int k, int v, int f) {
            key = k;
            val = v;
            fre = f;
        }
    }
    
    
    private int capacity;
    private Map<Integer, CacheNode> map;
    private PriorityQueue<CacheNode> minHeap;
    
    // @param capacity, an integer
    public LFUCache(int c) {
        capacity = Math.max(c, 1);
        map = new HashMap<>();
        // minHeap = new PriorityQueue<>((a,b)->a.fre-b.fre);
        minHeap = new PriorityQueue<CacheNode>(capacity+1
            , new Comparator<CacheNode>(){
            public int compare(CacheNode cn1, CacheNode cn2) {
                return cn1.fre - cn2.fre;
            }
        });
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).val = value;
            updateFrequency(key);
        } else {
            CacheNode cn = new CacheNode(key, value, 1);
            map.put(key, cn);
            minHeap.offer(cn);
            adjustSize();
        }
    }

    private void adjustSize() {
        if (minHeap.size() > capacity) {
            CacheNode cn = minHeap.poll();
            map.remove(cn.key);
        }
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int res = map.get(key).val;
        updateFrequency(key);
        return res;
    }
    
    private void updateFrequency(int key) {
        CacheNode node = map.get(key);
        minHeap.remove(node);
        node.fre++;
        minHeap.offer(node);
    }// end of updateFrequency     
    */
}
