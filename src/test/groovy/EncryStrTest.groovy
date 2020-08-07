import spock.lang.Specification

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/08/03 15:07
 */
class EncryStrTest extends Specification{
    def "encryStr"() {
        expect:
        EncryStr.encryStr(str) == result

        where:
        str                    || result
        "HELLO WORLD<br/>SNHJ" || "CZGGJ RJMGY<br/>NICE"
    }
}
