package binary


import spock.lang.Specification

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/11/29 15:33
 */
class GetNumberOfKTest extends Specification{
    def "test" () {
        given:
        GetNumberOfK getNumberOfK = new GetNumberOfK()
        expect:
        getNumberOfK.GetNumberOfK(arr as int[], k as int) == result
        where:
        arr               | k || result
        [1,2,3,3,3,3,4,5] | 3 || 4
        [1,2,3,4,5,6,7,8] | 9 || 0
        []                | 1 || 0
    }
}
