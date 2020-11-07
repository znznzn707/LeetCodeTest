import spock.lang.Specification

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/11/07 15:25
 */
class PermutationTest extends Specification{
    def "Permutation"() {
        given:
        Permutation perm = new Permutation()
        expect:
        perm.Permutation(str as String) == result as ArrayList
        where:
        str || result
        "abc" || ["abc","acb","bac","bca","cab","cba"]
        "ab"  || ["ab","ba"]
        "a"   || ["a"]
        ""    || []
    }
}
