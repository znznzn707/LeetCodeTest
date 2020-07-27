import spock.lang.Specification

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/07/27 16:18
 * @see KNumber
 */

class KNumberTest extends Specification {

    def "test"() {
        expect:
        KNumber.kNumber(arr as int[]) == x

        where:
        arr            || x
        [1,2,3,4,5]    || 3
        [1,1,2,2,3]    || 2
        [6,5,4,4,1,2]  || 4
        [3,2,1,5,6,4]  || 4
        [1,2,3]        || 1
        [-1,-2,-3]     || -3
    }
}
