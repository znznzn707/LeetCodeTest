package dp


import spock.lang.Specification

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/08/09 20:43
 */
class PackageProblemTest extends Specification{
    def "getMaxValue"() {
        expect:
        PackageProblem.getMaxValue(weight as int[], value as int[], capacity as int) == result
        where:
        weight                  | value                       | capacity|| result
        [1, 2, 4, 5, 3, 7]      | [4, 8, 16, 19, 13, 28]      | 6       || 25
    }
}
