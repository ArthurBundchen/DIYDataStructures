package pkgdiybinarytree;

/**
 *
 * @author arthu
 */
public class TreeNode<T extends Comparable> {
    
    T info;
    
    TreeNode<Comparable> left;
    
    TreeNode<Comparable> right;

    public TreeNode(T info) {
        this.info = info;
    }
}
