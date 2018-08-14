import java.util.LinkedList;
import java.util.Queue;
 
public class Q_single
{
    Queue<Integer> q = new LinkedList<Integer>();
     
    
    void push(int val) 
    {
        int size = q.size();

        q.add(val);

        for (int i = 0; i < size; i++) 
        {
  
            int x = q.remove();
            q.add(x);
        }
    }
     

    int pop() 
    {
        if (q.isEmpty()) 
        {
            System.out.println("No elements");
            return -1;
        }
        int x = q.remove();
        return x;
    }

    int top() 
    {
        if (q.isEmpty())
            return -1;
        return q.peek();
    }

    boolean isEmpty() 
    {
        return q.isEmpty();
    }
 
    public static void main(String[] args) 
    {
        Q_single s = new Q_single();
        s.push(10);
        s.push(20);
        s.push(99);
        s.push(88);
        System.out.println("Top element :" + s.top());
        s.pop();
        s.pop();
        s.push(30);
        s.push(126);
        s.pop();
        System.out.println("Top element :" + s.top());
    }
}