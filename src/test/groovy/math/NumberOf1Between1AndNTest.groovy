package math

import spock.lang.Specification

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/11/09 10:48
 */
class NumberOf1Between1AndNTest extends Specification{
    def "test "() {
        given:
        NumberOf1Between1AndN numberOf1Between1AndN = new NumberOf1Between1AndN()
        expect:
        numberOf1Between1AndN.numberOf1Between1AndN(n as int) == result as int
        where:
        n    || result
        30   || 13
        100  || 21
    }
}
