import spock.lang.Specification

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/07/27 17:26
 */
class GreatestSumOfSubArrayTest extends Specification{

    def  "test"() {
        expect:
        GreatestSumOfSubArray.findGreatestSumOfSubArray(arr as int[]) == result

        where:
        arr                      || result
        [6,-3,-2,7,-15,1,2,2]    || 8
        [-15, 5,-10, -20]        || 5
    }
}
