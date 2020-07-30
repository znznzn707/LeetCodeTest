package dp

import dp.Triangle
import spock.lang.Ignore
import spock.lang.Specification

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/07/27 18:32
 */
class TriangleTest extends Specification{
    Triangle triangle = new Triangle()

    @Ignore
    def "minimumTotal"() {
        expect:
        triangle.minimumTotal(lst as List<List<Integer>>) == result

        where:
        lst                             || result
        [[2],[3,4],[6,5,7],[4,1,8,3]]   || 11
        [[-1],[2,3],[1,-1,-3]]          || -1
    }

    def "minimumTotal2"() {
        expect:
        triangle.minimumTotal2(lst as List<List<Integer>>) == result

        where:
        lst                             || result
        [[2],[3,4],[6,5,7],[4,1,8,3]]   || 11
        [[-1],[2,3],[1,-1,-3]]          || -1
    }

}
