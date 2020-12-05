package tree

import spock.lang.Specification
import util.Builder
import util.TreeNodeBuilder

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/12/02 16:37
 */
class TreeDepthTest extends Specification{
   def "test"() {
       given:
       TreeDepth depth = new TreeDepth()
       Builder<TreeNode> builder = new TreeNodeBuilder()
       when:
       TreeNode root = builder.build("1,2,3,4,5,6,#,7,8,#,#,#,9,#,#,#,#,10")
       then:
       depth.treeDepth(root) == 4
   }
}
