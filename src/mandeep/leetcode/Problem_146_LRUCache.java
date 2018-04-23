/**
 * 146. LRU Cache
 * 
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and put.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, 
 * otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. 
 * When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.]
 * 
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 */
package mandeep.leetcode;

import java.util.HashMap;

/**
 * @author mandeep
 * created on Feb 27, 2018, 11:59:13 PM
 */
public class Problem_146_LRUCache {
	int capacity;
	HashMap<Integer, Node> map = new HashMap<>();
	Node head = null;
	Node end = null;
	
	/**
	 * 
	 * @param capacity
	 */
	public Problem_146_LRUCache(int capacity){
		this.capacity = capacity;
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	private int get(int key){
		if(map.containsKey(key)){
			Node node = map.get(key);
			remove(node);
			setHead(node);
			return node.value;
		}
		return -1;
	}
	
	/**
	 * @param node
	 */
	private void setHead(Node node) {
		node.next = head;
		node.pre = null;
		
		if(head != null)
			head.pre = node;
		
		head = node;
		
		if(end == null)
			end = head;
	}

	/**
	 * @param node
	 */
	private void remove(Node node) {
		if(node.pre != null)
			node.pre.next = node.next;
		else
			head = node.next;
		
		if(node.next != null)
			node.next.pre = node.pre;
		else
			end = node.pre;
	}

	/**
	 * 
	 * @param key
	 * @param value
	 */
	private void put(int key, int value){
		if(map.containsKey(key)){
			Node old = map.get(key);
			old.value = value;
			remove(old);
			setHead(old);
		}else{
			Node created = new Node(key, value);
			if(map.size() >= capacity){
				map.remove(end.key);
				remove(end);
				setHead(created);
			}else
				setHead(created);
			
			map.put(key,  created);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int capacity = 2;
		Problem_146_LRUCache cache = new Problem_146_LRUCache(capacity);
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));       // returns 1
		cache.put(3, 3);    // evicts key 2
		System.out.println(cache.get(2));       // returns -1 (not found)
		cache.put(4, 4);    // evicts key 1
		System.out.println(cache.get(1));       // returns -1 (not found)
		System.out.println(cache.get(3));       // returns 3
		System.out.println(cache.get(4));       // returns 4
	}

}

class Node{
	int key, value;
	Node pre, next;
	public Node(int key, int value){
		this.key = key;
		this.value = value;
	}
}