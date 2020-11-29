package string

import spock.lang.Specification

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/11/17 15:25 
 */
class FirstNotRepeatingCharTest extends Specification{
    def "test"() {
        given:
        FirstNotRepeatingChar repeatingChar = new FirstNotRepeatingChar()
        expect:
        repeatingChar.firstNotRepeatingChar(str as String) == result as int
        where:
        str                || result
        "abciopuytbciuytop"|| 0
    }
}
