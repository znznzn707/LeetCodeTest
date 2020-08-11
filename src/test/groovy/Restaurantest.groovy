import spock.lang.Specification

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/08/11 19:09
 */
//时间复杂度不满足要求
class Restaurantest extends Specification{
    def "getMaxCost"() {
        expect:
        Restaurant.getMaxCost(n, m, a as int[], b as int[], c as int[]) == result

        where:
        n|m| a     | b         | c          || result
        3|5|[2,4,2]|[1,3,3,5,1]|[3,5,7,9,10]||20
    }
}
