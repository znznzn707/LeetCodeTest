package string


import spock.lang.Specification

class CloseStringsTest extends Specification{
    def "test" () {
        given:
        CloseStrings closeStrings = new CloseStrings()
        expect:
        closeStrings.closeStrings(word1, word2) == res
        where:
        word1   | word2   || res
        "abc"   | "bca"   || true
        "a"     | "aa"    || false
        "cabbba"|"abbccc" || true
        "cabbba"|"aabbss" || false
    }
}