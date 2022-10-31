
package pkgdiybinarytree;

/**
 *
 * @author arthu
 */
public class DIYBinaryTree<T extends Comparable> implements DIYBinaryTreeInterface<T> {
    
    private TreeNode<Comparable> root;
    

    @Override
    public void add(T e) {
        if(!isInTree(e)){
            TreeNode<Comparable> newNode = new TreeNode<Comparable>(e);
            if(root ==  null){
                root = newNode;
            } else{
                TreeNode<Comparable> temp = root;
                while(temp != null){
                    if(temp.info.compareTo(e) < 0){
                        if(temp.right != null){
                            temp = temp.right;
                        } else {
                            temp.right = newNode;
                        }
                    } else {
                        if(temp.left != null){
                            temp = temp.left;
                        } else {
                            temp.left = newNode;
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean remove(T e) {
        boolean answer = false;
        if (root != null) {
            if (root.info.equals(e)) {
                if (root.left == null) {
                    root.right = root;
                } else if (root.right == null) {
                    root.left = root;
                } else {
                    removeSubRoot(root);
                }
                answer = true;
            } else {
                //The node to remove is not the root
                TreeNode<Comparable> temp = root;
                TreeNode<Comparable> tempDad = temp;
                while (temp != null) {
                    if (temp.info.compareTo(e) == 0) {
                        //Found the node to remove
                        break;
                    } else if (temp.info.compareTo(e) < 0) {
                        tempDad = temp;
                        temp = temp.right;
                    } else {
                        tempDad = temp;
                        temp = temp.left;
                    }
                }
                if (temp != null) {
                    answer = true;
                    if (temp.left == null) {
                        if (tempDad.left == temp) {
                            tempDad.left = temp.right;
                        } else {
                            tempDad.right = temp.right;
                        }
                    } else if (temp.right == null) {
                        if (tempDad.left == temp) {
                            tempDad.left = temp.left;
                        } else {
                            tempDad.right = temp.left;
                        }
                    } else {
                        removeSubRoot(temp);
                    }
                }
            }
        }
        return answer;
    }

    private void removeSubRoot(TreeNode<Comparable> p) {
        TreeNode<Comparable> temp = p.right;
        TreeNode<Comparable> tempDad = temp;
        while (temp.left != null) {
            tempDad = temp;
            temp = temp.left;
        }
        //Achou o termo para substitur.
        p.info = temp.info;
        if (temp != tempDad) {
            //Remove o no que substituiu a raiz passando o ponteiro pro termo a direita de temp.
            tempDad.left = temp.right;
        } else {
            p.right = temp.right;
        }
    }
    
    
    @Override
    public boolean isInTree(T e) {
        boolean answer = false;
        if(root.info.equals(e)){
            //If the element to find is the root
            answer = true;
        } else{
            //If the element to find is not the root
            TreeNode<Comparable> temp = root;
                while(temp != null){
                    if(temp.info.compareTo(e) < 0){
                        if(temp.right != null){
                            temp = temp.right;
                        } else {
                            answer = false;
                        }
                    } else if(temp.info.compareTo(e) > 0){
                        if(temp.left != null){
                            temp = temp.left;
                        } else {
                            answer = false;
                        }
                    } else {
                        answer = true;
                    }
                }  
            }
        return answer;
    }
    
    @Override
    public T getInTree(T e){
        T answer = null;
        if(root.info.equals(e)){
            //If the element to find is the root
            answer = (T) root.info;
        } else{
            //If the element to find is not the root
            TreeNode<Comparable> temp = root;
                while(temp != null){
                    if(temp.info.compareTo(e) < 0){
                        temp = temp.right;
                    } else if(temp.info.compareTo(e) > 0){
                        temp = temp.left;
                    } else {
                        answer = (T) temp;
                        break;
                    }
                }  
            }
        return answer;
    }
    
}
