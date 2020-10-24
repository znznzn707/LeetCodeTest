package tree


import spock.lang.Specification
import util.Builder

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/10/24 16:41
 *
 */
class IsSymmetricTest extends Specification{
    IsSymmetric symmetric = new IsSymmetric()

    def "will return true"() {
        expect:
        symmetric.isSymmetric(Builder.buildTree(root) as TreeNode) == result as boolean
        where:
        root           || result
        "1,2,2"        || true
        "1,2,3,3,#,2,#"|| false
    }
}
