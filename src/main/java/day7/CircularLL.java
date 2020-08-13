package day7;

public class CircularLL {

    static Node head;
    class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    void deleteNode(int key)
    {

        Node first = head;

       //second points to Nth+1 node from loop's start end (3 in thish case)
        Node second = head;
        for (int i = 0; i < key; i++) {

            // If node count in linked list is <= N, means it reach to end point
            if (second.next == null) {

                // If count = N i.e. delete the head node
                if (i == key - 1)
                    head = head.next;
                return;
            }
            second = second.next;
        }

        // Increment both the pointers by one until
        // second pointer reaches the end
        while (second.next != null) {
            first = first.next;
            second = second.next;
        }

        //first is at Nth node from end of LL, so delete it
        assert first.next != null;
        first.next = first.next.next;
    }

    public void push(int new_data)
    {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    public void printList()
    {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    /*
    detects LL contains any circular dependency
    if : then return starting point of circular loop
    Solution : Hare & Tortoise Approch (floyd's algo)
    */
    public static Node detectReturnCycle()
    {
        Node hare, tortoise;
        hare=tortoise= head;
        boolean found=false;
        Node loopStart=null;

        while (hare.next != null && tortoise != null && tortoise.next != null)
        {
            hare= hare.next;
            tortoise= tortoise.next.next;
            if(hare ==tortoise)
            {
                found=true;
                break;
            }
        }
        if (found)
        {
            Node first= head;
            while (first != hare)
            {
                first= first.next;
                hare=hare.next;
            }
           loopStart=hare;
        }
        return loopStart;
    }
    public static void main(String[] args)
    {
        CircularLL list = new CircularLL();

        list.push(7);
        list.push(1);
        list.push(3);
        list.push(2);

//        list.printList();
        list.head.next.next.next.next = list.head.next;
        System.out.println(detectReturnCycle().data);

        /* int N = 1;
        llist.deleteNode(N);*/

    }
}
