import java.util.*;
import java.io.*;

public class hashtable
{
	private int N;
	private int M;
	private hashlink[] st;

	public hashtable()
	{
		this(4);
	}

	public hashtable(int M)
	{
		this.M = M;
		st = (hashlink[]) new hashlink[M];
		for(int i = 0; i < M; i++)
		{
			st[i] = new hashlink();
		}
	}

	private int hash(String key)
	{
		int h = key.hashCode();
		h ^= (h >>> 20) ^ (h >>> 12);
		h = h ^ (h >>> 7) ^ (h >>> 4);
		return (h & 0x7FFFFFFF) % M;
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
		if (key == null)
			throw new NullPointerException("argument to contains() is null");
		return get(key) != null;
	}

	public String get(String key)
	{
		if (key == null)
			throw new NullPointerException("argument to get() is null");
		int i = hash(key);
		return st[i].get(key);
	}

	public void put(String key, String val)
	{
		if (key == null)
			throw new NullPointerException("first argument to put() is null");
		if (val == null)
		{
			delete(key);
			return;
		}

		//if(N >= 10+M)
			//resize(2*M);

		int i = hash(key);
		if (!st[i].contains(key))
			N++;

		st[i].put(key, val);
	}

	public void delete(String key)
	{
		if(key == null)
			throw new NullPointerException("argument to delete() is null");

		int i = hash(key);
		if(st[i].contains(key))
			N--;

		st[i].delete(key);

		//if(M > 4 && N <=2*M)
			//resize (M/2);
	}

	public void print() 
	{
	        for (int i = 0; i < M; ++i)
		{
			if(st[i].size() != 0)
			{
				st[i].printAll();
				System.out.println();
			}
		}
	}

	public static void main (String[] args) throws FileNotFoundException
	{
		hashtable table = new hashtable();
		Scanner cin = new Scanner(System.in);
		Scanner filescanner = new Scanner(new File("file.txt"));

        	while (filescanner.hasNext()) 
		{
            		String input = filescanner.nextLine();
            		String[] split = input.split(" ");
            		table.put(split[0], split[1]);
        	}
        	filescanner.close();

		System.out.print("\n|||HASHMAP PROGRAM|||");
		System.out.print("\n|||EVAN   FALL2017|||");

		do
		{
			System.out.println("\n\n*************************************");
			System.out.println("Please choose from the following menu");
			System.out.println("1: Lookup entry via key");
			System.out.println("2: Add entry");
			System.out.println("3: Show contents of hashtable");
			System.out.println("0: Terminate program");
			System.out.println("*************************************");

			int menu_choice;
			menu_choice = cin.nextInt();
			cin.nextLine();

			if(menu_choice == 1)
			{
				System.out.print("Search key: ");
				String read = cin.nextLine();

				if(table.get(read) == null)
				{
					System.out.print("KEY NOT PRESENT. Would you like to add it? (1 for yes. 2 for no.)");
					int choice = cin.nextInt();
					cin.nextLine();
					if (choice == 1)
					{
						System.out.print("KEY: ");
						String input_key = null;
						input_key = cin.nextLine();
						System.out.print("VAL: ");
						String input_val = null;
						input_val = cin.nextLine();
						table.put(input_key, input_val);
					}
					else
					{
						System.out.print("KEY NOT ADDED. RETURNING TO MAIN MENU.");
					} 
				}
				else
				{
					System.out.print("VALUE ASSOCIATED WITH KEY: " + table.get(read));
				}

			}
			else if(menu_choice == 2)
			{
				System.out.print("KEY: ");
				String input_key = null;
				input_key = cin.nextLine();
				System.out.print("VAL: ");
				String input_val = null;
				input_val = cin.nextLine();
				table.put(input_key, input_val);
			}
			else if(menu_choice == 3)
			{
				table.print();
			}
			else
			{
				break;
			}
		} while(true);

	System.out.println();
	}
}
