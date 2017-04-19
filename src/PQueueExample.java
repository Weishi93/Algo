import java.util.*;
import java.util.PriorityQueue;

/**
 * Created by Wei Shi on 11/3/16.
 */

public class PQueueExample {
    static class Node {
        Integer data;
        public Node(Integer data) {
            this.data = data;
        }
    }
//    static PriorityQueue<Node> pq = new PriorityQueue<Node>(
//            new Comparator<Node>() {
//                @Override
//                public int compare(Node o1, Node o2) {
//                    return o1.data - o2.data;
//                }
//            }
//    );

    public static void main(String[] args) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.data - o2.data;
            }
        });
//        pq = new PriorityQueue<Node>();
        Node n1 = new Node(4);
        Node n2 = new Node(2);
        Node n3 = new Node(12);
        Node n4 = new Node(5);
        pq.add(n1);
        pq.add(n2);
        pq.add(n3);
        pq.add(n4);
        System.out.println(pq.poll().data);
        System.out.println(pq.poll().data);
        System.out.println(pq.poll().data);
        System.out.println(pq.poll().data);
    }
}
