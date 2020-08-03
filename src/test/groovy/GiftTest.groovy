import spock.lang.Specification

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/08/02 14:38
 */

class GiftTest extends Specification{
    def "getValue"() {
        given:
        def gift = new Gift()

        expect:
        gift.getValue(gifts as int[], n) == result

        where:
        gifts           | n || result
        [1,2,3,2,2]     | 5 || 2
        [1,6,3,7,4,2,4] | 7 || 0
    }
    def "getValue2"() {
        given:
        def gift = new Gift()

        expect:
        gift.getValue2(gifts as int[], n) == result

        where:
        gifts           | n || result
        [1,2,3,2,2]     | 5 || 2
        [1,6,3,7,4,2,4] | 7 || 0
    }
}
