package day21;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeDeserializeTree {

    List<Integer> serializeIt(Node root, List<Integer> result) {
        if (root == null) {
//          hasn't any child node, mark as -1
            result.add(-1);
            return result;
        }
        result.add(root.val);
        serializeIt(root.left, result);
        serializeIt(root.right, result);
        return result;
    }

    Node deSerializeIt(Integer[] ip) {
        Queue<Integer> qu = new LinkedList<>();
        for (Integer i : ip) qu.add(i);
        return deSerializeHelper(qu);
    }

    Node deSerializeHelper(Queue<Integer> qu) {
        if (qu.size() == 0)
            return null;
        Node root = new Node(qu.remove());
        if (root.val != -1) {
            root.left = deSerializeHelper(qu);
            root.right = deSerializeHelper(qu);
        }
        return root;
    }

    public static void main(String[] args) {

        SerializeDeserializeTree sdbt = new SerializeDeserializeTree();
        Node root = new Node(1);
        root.left = new Node(2);
        Node child = new Node(3);
        child.left = new Node(4);
        child.right = new Node(5);
        root.right = child;
        List<Integer> result = sdbt.serializeIt(root, new ArrayList<Integer>());
        Node Tree = sdbt.deSerializeIt(new Integer[]{1, 2, -1, -1, 3, 4, -1, -1, 5, -1, -1});

    }

}

class Node {
    Integer val;
    Node left;
    Node right;

    Node(Integer val) {
        this.val = val;
        left = right = null;
    }
}
