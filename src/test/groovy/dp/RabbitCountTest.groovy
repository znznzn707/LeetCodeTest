package dp

import dp.RabbitCount
import spock.lang.Specification

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/08/03 14:27
 */
class RabbitCountTest extends Specification{

    def "getTotalCount"() {
        expect:
        RabbitCount.getTotalCount(count) == result

        where:
        count|| result
        9    || 34
        12   || 144
    }
    def "getTotalCountWithDP"() {
        expect:
        RabbitCount.getTotalCountWithDP(count) == result

        where:
        count|| result
        9    || 34
        12   || 144

    }
}
