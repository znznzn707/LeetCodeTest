import spock.lang.Specification

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/07/27 18:32
 */
class TriangleTest extends Specification{

    def "minimumTotal"() {
        given:
        Triangle triangle = new Triangle()

        expect:
        triangle.minimumTotal(lst as List<List<Integer>>) == result

        where:
        lst                             || result
        [[2],[3,4],[6,5,7],[4,1,8,3]]   || 11
        [[-1],[2,3],[1,-1,-3]]          || -1
    }
}
