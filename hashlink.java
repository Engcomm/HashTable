import java.util.*;

public class hashlink
{

	private int N;
	private Node first;

	private class Node
	{
		public String key; 
		public String val;
		public Node next;

		public Node(String key, String val, Node next)
		{
			this.key = key;
			this.val = val;
			this.next = next;
		}

	}

	public hashlink()
	{
		first = null;
		N = 0;
	}

	public int size()
	{
		return N;
	}

	public boolean isEmpty()
	{
		return size() == 0;
	}

	public boolean contains(String key)
	{
		return get(key) != null;
	}

	public String get(String key)
	{
		for (Node x = first; x != null; x = x.next)
		{
			if (key.equals(x.key))
			{
				return x.val;
			}
		}
		return null;
	}

	public void getall()
	{
		for(Node x = first; x != null; x = x.next)
		{
			System.out.print("[" + x.key + ",");
			System.out.print(x.val + "]" + ";");
		}
	}

	public void put(String key, String val)
	{
		for(Node x = first; x != null; x = x.next)
		{
			if (key.equals(x.key))
			{
				x.val = val;
				return;
			}
		}
		first = new Node(key, val, first);
		N++;
	}

	public int delete(String key)
	{
		Node curr = first;
		Node prev = null;

		while(curr != null)
		{
			if (key.equals(curr.key))
			{
				if (prev == null)
				{
					first = first.next;
				}
				else
				{
					prev.next = curr.next;
				}
				N--;
				return 1;
			}
			else
			{
				prev = curr;
				curr = curr.next;
			}
		}
		throw new NoSuchElementException();
	}

	public void printAll()
	{
		Node n = first;
		while(n != null)
		{
			System.out.print("[ " + n.key + ", " + n.val + " ] ");
			n = n.next;
		}
	}

	public static void main(String [] args)
	{
/**
		hashlink st = new hashlink();
		Scanner keyin = new Scanner(System.in);

		int i = 0;

		while (true)
		{
			String key = keyin.nextLine();
			if (key.equals("done"))
			{
				break;
			}
			else
			{
				st.put(key, Integer.toString(i));
			}
			i++;
		}

		st.getall();
		System.out.println("\nSize of list:" + st.size());
		System.out.println("Deleting key 2");
		st.delete("2");
		System.out.println("List after delete.");
		st.getall();
		System.out.println("\nSize of list:" + st.size());
		System.out.println("get value for key 1");
		System.out.println(st.get("gay"));
**/
		System.out.print("this works");
	}
}
