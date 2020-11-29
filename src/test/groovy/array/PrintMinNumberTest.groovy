package array

import spock.lang.Specification

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/11/10 20:35
 */
class PrintMinNumberTest extends Specification{
    def "test "() {
        given:
        PrintMinNumber minNumber = new PrintMinNumber()
        expect:
        minNumber.PrintMinNumber(numbers as int[]) == result as String
        where:
        numbers     || result
        [3,32,321]  || "321323"
    }
}
