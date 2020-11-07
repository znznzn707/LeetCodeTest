import spock.lang.Specification

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/11/07 16:09
 */
class MoreThanHalfNumTest extends Specification {
    MoreThanHalfNum thanHalfNum = new MoreThanHalfNum()

    def "MoreThanHalfNum"() {
        expect:
        thanHalfNum.MoreThanHalfNum(arr as int[]) == result as int
        where:
        arr                         || result
        [1, 2, 3, 2, 2, 2, 5, 4, 2] || 2
        [1, 2, 3, 4, 5]             || 0
        [2, 2]                      || 2
        [0]                         || 0
    }
}
