package listnode


import spock.lang.Specification

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/10/30 11:26
 */
class LRUCacheTest extends Specification{
    LRUCache cache = new LRUCache(3)
    def "test put"() {
        when:
        cache.put(1, 1)
        cache.put(2, 2)
        cache.put(3, 3)
        cache.put(4, 4)
        then:
        cache.size() == 3
    }
    def "test get"() {
        when:
        cache.put(1, 1)
        cache.put(2, 2)
        cache.put(3, 3)
        cache.put(4, 4)
        then:
        cache.get(2) == 2
        cache.get(3) == 3
        cache.get(4) == 4
        cache.get(1) == 1
    }
}
