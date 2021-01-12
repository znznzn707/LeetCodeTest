package util;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/10/24 18:06
 * <p>用字符串构建二叉树{@link tree.TreeNode}、链表{@link listnode.ListNode}等复杂结构,
 * 子类有: {@link TreeNodeBuilder}和{@link ListNodeBuilder}</p>
 */
public interface Builder<T> {
    public T deserialize(String s) ;
    public String serialize(T t) ;
}