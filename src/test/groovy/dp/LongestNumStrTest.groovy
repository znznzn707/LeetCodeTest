package dp

import spock.lang.Specification
import spock.lang.Title

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/07/27 15:39
 *
 */
class LongestNumStrTest extends Specification{

    def "test"() {
        expect:
        LongestNumStr.numStr(str) == result

        where:
        str                || result
        "soeir123ori45678" || "45678"
        "12heidk9876w12345"|| "12345"
    }

}
