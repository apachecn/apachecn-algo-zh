package code;
/*
 * 116. Populating Next Right Pointers in Each Node
 * 题意：设置二叉树的next指针，指向同层右侧节点
 * 难度：Medium
 * 分类：Tree, Depth-first Search
 * 思路：自己写的递归，中间有冗余。迭代方法和较优的递归会利用先前已经设置的next指针，做下一步操作
 * Tips：复习时多看一下，自己没想起来利用已经设置好的指针
 */
public class lc116 {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }
    public void connect(TreeLinkNode root) {
        if(root==null) return;
        helper(root.left, root.right);
    }

    public void helper(TreeLinkNode root1, TreeLinkNode root2){//较慢，也能过
        if( root1==null || root2==null ) return;
        root1.next = root2;
        helper(root1.left, root1.right);
        helper(root1.right, root2.left);    //会重复设置
        helper(root2.left,root2.right);
    }

    public void connect2(TreeLinkNode root) {
        while(root!=null){
            TreeLinkNode start = root;
            while(start!=null){
                if(start.left!=null){
                    start.left.next = start.right;  //设置下一层的next指针
                    if(start.next!=null){
                        start.right.next = start.next.left;
                    }
                }
                start = start.next;
            }
            root = root.left;
        }
    }
}
