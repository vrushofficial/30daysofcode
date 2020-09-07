package day11;

import java.util.Stack;
import java.util.Vector;

class ZigzagTraversal {
    TreeNode root;

    public static void main(String[] args) {
        ZigzagTraversal zigzagTraversal = new ZigzagTraversal();
        Vector<Vector<Integer>> result = zigzagTraversal.update();

    }

    Vector<Vector<Integer>> update() {
        Vector<Vector<Integer>> parent = new Vector<>();

        TreeNode head = new TreeNode(1);
        this.root = head;
        TreeNode LsecondRoot = new TreeNode(2);
        TreeNode RsecondRoot = new TreeNode(3);
        head.left = LsecondRoot;
        head.right = RsecondRoot;
        TreeNode LthirdRoot = new TreeNode(4);
        LthirdRoot.left = new TreeNode(8);
        TreeNode RthirdRoot = new TreeNode(5);
        RthirdRoot.left = new TreeNode(9);
        TreeNode L1thirdRoot = new TreeNode(6);
        TreeNode R1thirdRoot = new TreeNode(7);
        R1thirdRoot.right = new TreeNode(10);
        LsecondRoot.left = LthirdRoot;
        LsecondRoot.right = RthirdRoot;
        RsecondRoot.left = L1thirdRoot;
        RsecondRoot.right = R1thirdRoot;

        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        TreeNode top;
        //step 1
        s1.push(root);

        while (!(s1.isEmpty() && s2.isEmpty())) {
            Vector<Integer> child = new Vector<>();
            //step 2
            while (!s1.isEmpty()) {
                top = s1.pop();
                child.add(top.val);
                //step 3
                if (top.left != null) s2.push(top.left);
                if (top.right != null) s2.push(top.right);

            }
            parent.add(child);
            child = new Vector<>();
            //step 4
            while (!s2.isEmpty()) {
                top = s2.pop();
                child.add(top.val);
                //step 5
                if (top.right != null) s1.push(top.right);
                if (top.left != null) s1.push(top.left);
            }
            parent.add(child);
        }
        return parent;
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        Integer val;

        TreeNode(Integer val) {
            this.val = val;
            left = right = null;
        }
    }

}
