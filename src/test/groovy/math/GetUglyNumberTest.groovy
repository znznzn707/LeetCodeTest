package math

import spock.lang.Specification

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/11/17 14:53
 */
class GetUglyNumberTest extends Specification{
    def "test"() {
        given:
        GetUglyNumber getUglyNumber = new GetUglyNumber()
        expect:
        getUglyNumber.getUglyNumber(index as int) == result as int
        where:
        index || result
        7     || 8
    }
}
