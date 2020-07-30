package dp

import dp.UniquePaths
import spock.lang.Specification

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/07/29 18:07
 */
class UniquePathsTest extends Specification{

    def "uniquePaths"() {
        expect:
        UniquePaths.uniquePaths(m, n) == result

        where:
        m << [3, 7]
        n << [2, 3]
        result << [3, 28]
    }
}
