package dp

import spock.lang.Specification

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/08/07 15:25
 */
class RrestaurantTest extends Specification{
    def "getTotalCost"() {
        expect:
        Restaurant.getTotalCost(n as int, m as int, a as int[], b as int[], c as int[])
                == result

        where:
        n|m|a    |b          |c           || result
        3|5|[2,4,2]|[1,3,3,5,1]|[3,5,7,9,10]|| 20
    }

}
