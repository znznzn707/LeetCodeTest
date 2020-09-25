package listnode


import spock.lang.Specification

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/09/25 19:55
 */
class AddInListTest extends Specification{
    AddInList addInList = new AddInList()
    def "NodeToInt"() {
        given:
        ListNode head = new ListNode(9)
        ListNode n1 = new ListNode(3)
        ListNode n2 = new ListNode(7)
        when:
        head.next = n1
        n1.next = n2
        then:
        AddInList.NodeToInt(head) == 937
    }
}
