import java.util.ArrayList;

public class PQueue<E extends Comparable<E>>
{
    private final ArrayList<E> list;
    private final int capacity;

    public PQueue()
    {
        this.list = new ArrayList<>();
        this.capacity = 10;
    }


    public boolean offer(E item)
    {
        if (list.size() >= capacity)
        {
            return false;
        }
        int i = 0;
        while (i < list.size() && list.get(i).compareTo(item) <= 0)
        {
            i++;
        }
        list.add(i, item);
        return true;
    }


    public E peek()
    {
        if (list.isEmpty())
        {
            return null;
        }
        return list.get(0);
    }


    public E poll()
    {
        if (list.isEmpty())
        {
            return null;
        }
        return list.remove(0);
    }


    public boolean remove(E item)
    {
        return list.remove(item);
    }


    public int size()
    {
        return list.size();
    }


    public boolean isEmpty()
    {
        return list.isEmpty();
    }


    public void clear()
    {
        list.clear();
    }
    
    @Override
    public String toString()
    {
        if (list.isEmpty())
        {
            return "  (No pending orders)";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++)
        {
            sb.append("  ").append(i + 1).append(". ").append(list.get(i).toString());
            if (i < list.size() - 1)
            {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
