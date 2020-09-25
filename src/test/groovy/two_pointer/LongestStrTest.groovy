package two_pointer

import spock.lang.Specification

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/08/16 18:22
 */
class LongestStrTest extends Specification{
   def "lengthOfLongestSubstring"() {
      given:
      def longestStr = new LongestStr()

      expect:
      longestStr.lengthOfLongestSubstring(s) == result

      where:
      s          || result
      "abcabcbb" || 3
      "bbbbb"    || 1
      "pwwkew"   || 3
   }
}
