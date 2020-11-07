package listnode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/10/28 19:25
 * <pre>
 *
 * 设计一个数据结构，实现LRU Cache的功能(Least Recently Used – 最近最少使用缓存)。它支持如下2个操作： get 和 put。
 *
 * int get(int key) – 如果key已存在，则返回key对应的值value（始终大于0）；如果key不存在，则返回-1。
 * void put(int key, int value) – 如果key不存在，将value插入；如果key已存在，则使用value替换原先已经存在的值。如果容量达到了限制，LRU Cache需要在插入新元素之前，将最近最少使用的元素删除。
 *
 * 请特别注意“使用”的定义：新插入或获取key视为被使用一次；而将已经存在的值替换更新，不算被使用。
 *
 * 限制：请在O(1)的时间复杂度内完成上述2个操作。
 *
 * </pre>
 * <a href="https://www.nowcoder.com/questionTerminal/3da4aeb1c76042f2bc70dbcb94513338">LRUCache</a>
 */
public class LRUCache {
   private Map<Integer, Entry> map ;
   private int MAX_CAPACITY = 10;
   private Entry head;
   private Entry tail ;

   public LRUCache(int capacity) {
       this.MAX_CAPACITY = capacity ;
       map = new HashMap<>() ;
   }

    public void put(int key, int value) {
        Entry entry = map.get(key) ;
        while(map.size()> MAX_CAPACITY-1) {
            removeTail();
        }
        if(entry == null) {
            entry = new Entry(key, value) ;
            moveToHead(entry);
        }
        entry.value = value ;
        map.put(key, entry);
    }
    public int get(int key) {
        Entry entry = map.get(key) ;
        if(entry == null) return -1;
        moveToHead(entry);
        return entry.value;
    }
    public int size() {
        return map.size() ;
    }
    private void removeTail() {
        if(tail != null) {
            Entry tmp = tail;
            if(tail != head) {
                tail = tail.next;
                tail.prev = null;
            }
            map.remove(tmp.key);
            tmp = null;
        }
    }
    private void moveToHead(Entry entry) {
        if(entry != null) {
            if (head == null) {
                head = tail = entry;
            } else {
                if(entry.next != null) entry.next.prev = entry.prev;
                entry.prev = head;
                head.next = entry;
                head = entry;
            }
        }
    }
    static class Entry {
        final int key ;
        int value;
        Entry prev ;
        Entry next ;
        Entry(int key, int value) {
            this.key = key;
            this.value = value ;
        }
    }
}
