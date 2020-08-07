import spock.lang.Specification

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/07/27 16:18
 * @see KNumber
 */

class KNumberTest extends Specification {

    def "test"() {
        expect:
        KNumber.kNumber(arr as int[], k) == x as ArrayList<Integer>

        where:
        arr                |k   || x
        [4,5,1,6,2,7,3,8]  |4   || [1,2,3,4]
    }
}
