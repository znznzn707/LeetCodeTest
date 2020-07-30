package dp

import spock.lang.Specification

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/07/30 14:35
 */
class UniquePaths2Test extends Specification {

    def "uniquePathsWithObstacles"() {
        expect:
        UniquePaths2.uniquePathsWithObstacles(nums as int[][]) == result

        where:
        nums << [
                [
                        [0,0,0],
                        [0,1,0],
                        [0,0,0]
                ],
                [
                    [1,0]
                ],
                [
                        [1, 0],
                        [0, 0]
                ]
        ]
        result << [2, 0, 0]

    }
}
