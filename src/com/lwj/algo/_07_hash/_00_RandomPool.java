package com.lwj.algo._07_hash;

import org.junit.Test;

import java.util.HashMap;

/**
 * create by lwj on 2019/10/2
 * 等概率获取池中的元素
 * 使用两个HashMap，映射键值关系
 */
public class _00_RandomPool<T> {
    @Test
    public void test(){
            Pool<String> pool = new Pool<String>();
            pool.insert("a");
            pool.insert("b");
            pool.insert("c");
            System.out.println(pool.getRandom());
            System.out.println(pool.getRandom());
            System.out.println(pool.getRandom());
            System.out.println(pool.getRandom());
            System.out.println(pool.getRandom());
            System.out.println(pool.getRandom());

    }
    public static class Pool<T> {
        private HashMap<T, Integer> keyIndexMap;
        private HashMap<Integer, T> indexKeyMap;
        private int size;

        public Pool() {
            keyIndexMap = new HashMap<>();
            indexKeyMap = new HashMap<>();
            size = 0;
        }

        public void insert(T key) {
            keyIndexMap.put(key, size);
            indexKeyMap.put(size++, key);
        }

        public void remove(T key) {
            if (keyIndexMap.containsKey(key)) {
                Integer remove = keyIndexMap.get(key);
                Integer lastIndex = --size;
                T lastKey = indexKeyMap.get(lastIndex);
                keyIndexMap.put(lastKey, remove);
                indexKeyMap.put(remove, lastKey);
                keyIndexMap.remove(key);
                indexKeyMap.remove(lastIndex);
            }
        }

        public T getRandom() {
            if (size == 0)
                return null;
            int i = (int) (Math.random() * size);
            return indexKeyMap.get(i);
        }
    }


}
