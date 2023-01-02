import java.util.PriorityQueue;

public class Test {


    public static void main(String[] args) {


        PriorityQueue<Integer> pq = new PriorityQueue<>();


        if (pq.peek() == 100 && !pq.isEmpty()) {
            System.out.println(pq.peek());
        } else {
            System.out.println("error");
        }


    }


}
