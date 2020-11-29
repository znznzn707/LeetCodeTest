package array

import spock.lang.Specification

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/11/17 15:44
 */
class InversePairsTest extends Specification{
    def "test"() {
        given:
        InversePairs inversePairs = new InversePairs()
        expect:
        inversePairs.inversePairs(arr as int[]) == result as int
        where:
        arr              || result
        [1,2,3,4,5,6,7,0]|| 7
    }
}
