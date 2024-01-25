package lrucache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LRUCacheTest {
    LRUCache classToTest;

    @Test
    void testLRUCache() {
        this.classToTest = new LRUCache(3);
        this.classToTest.put(1, 2);
        this.classToTest.put(2, 4);
        this.classToTest.put(3, 5);

        this.classToTest.put(4, 6);

        assertEquals(-1, this.classToTest.get(1));

//        ["LRUCache","put","put","get","put","get","put","get","get","get"]
//        [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
        this.classToTest = new LRUCache(2);

        this.classToTest.put(1,1);
        this.classToTest.put(2,2);

        int res = this.classToTest.get(1);

        assertEquals(1, res);

        this.classToTest.put(3,3);

        res = this.classToTest.get(2);

        assertEquals(-1, res);

        this.classToTest.put(4,4);

        res = this.classToTest.get(1);

        assertEquals(-1, res);

        res = this.classToTest.get(3);

        assertEquals(3, res);

        res = this.classToTest.get(4);

        assertEquals(4, res);

//["LRUCache","put","get","put","get","get"]
//[[1],[2,1],[2],[3,2],[2],[3]]

        this.classToTest = new LRUCache(1);

        this.classToTest.put(2,1);

        assertEquals(1, this.classToTest.get(2));

        this.classToTest.put(3,2);

        assertEquals(-1, this.classToTest.get(2));
        assertEquals(2, this.classToTest.get(3));

//        ["LRUCache","put","put","get","put","put","get"]
//        [[2],[2,1],[2,2],[2],[1,1],[4,1],[2]]
        this.classToTest = new LRUCache(2);

        this.classToTest.put(2,1);
        this.classToTest.put(2,2);

        assertEquals(2, this.classToTest.get(2));

        this.classToTest.put(1,1);
        this.classToTest.put(4,1);

        assertEquals(-1, this.classToTest.get(2));

//        ["LRUCache","put","put","put","put","get","get"]
//        [[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
//        Expected:
//        [null,null,null,null,null,-1,3]
        this.classToTest = new LRUCache(2);

        this.classToTest.put(2,1);
        this.classToTest.put(1,1);
        this.classToTest.put(2,3);
        this.classToTest.put(4,1);

        assertEquals(-1, this.classToTest.get(1));

        this.classToTest.get(2);

        assertEquals(3, this.classToTest.get(2));

//        ["LRUCache","get","get","put","get","put","put","put","put","get","put"]
//        [[1],[6],[8],[12,1],[2],[15,11],[5,2],[1,15],[4,2],[5],[15,15]
//        Expected:
//        [null,-1,-1,null,-1,null,null,null,null,-1,null]
        this.classToTest = new LRUCache(1);

        assertEquals(-1, this.classToTest.get(6));
        assertEquals(-1, this.classToTest.get(8));

        this.classToTest.put(12,1);

        assertEquals(-1, this.classToTest.get(2));

        this.classToTest.put(15,1);
        this.classToTest.put(5,2);
        this.classToTest.put(1,15);
        this.classToTest.put(4,2);

        assertEquals(-1, this.classToTest.get(5));

        this.classToTest.put(15,15);
    }
}
