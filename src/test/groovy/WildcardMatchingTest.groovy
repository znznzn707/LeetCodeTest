import dp.WildcardMatching
import spock.lang.Specification

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/08/13 21:51
 */
class WildcardMatchingTest extends Specification{

    def "isMatch"() {
        given:
        def wildcardMatching = new WildcardMatching()

        expect:
        wildcardMatching.isMatch(s, p) == result

        where:
        s      |p      ||result
        "aa"   |"a"    ||false
        "aa"   |"*"    ||true
        "cb"   |"?a"   ||false
        "adceb"|"*a*b" ||true
        "acdcb"|"a*c?b"||false
    }
}
