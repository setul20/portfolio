package Relation;

/************************************************************************************
 * @file LinHashMap.java
 *
 * @author  John Miller
 */

import java.io.*;
import java.lang.reflect.Array;
import static java.lang.System.out;
import java.util.*;

/************************************************************************************
 * This class provides hash maps that use the Linear Hashing algorithm.
 * A hash table is created that is an array of buckets.
 */
public class LinHashMap <K, V>
extends AbstractMap <K, V>
implements Serializable, Cloneable, Map <K, V>
{
	/** The number of slots (for key-value pairs) per bucket. 
	 */
	private static final int SLOTS = 4;

	/** The class for type K.
	 */
	private final Class <K> classK;

	/** The class for type V.
	 */
	private final Class <V> classV;

	/********************************************************************************
	 * This inner class defines buckets that are stored in the hash table.
	 */
	private class Bucket
	{
		int    nKeys;											// number of keys in the bucket
		K []   key;												// array of key objects
		V []   value;											// array of value objects
		Bucket next;											// used for hashing with chaining
		int locald = 1;

		@SuppressWarnings("unchecked")
		Bucket (Bucket n){										// given constructor which is useless.
			nKeys = 0;
			key   = (K []) Array.newInstance (classK, SLOTS);
			value = (V []) Array.newInstance (classV, SLOTS);
			next  = n;
		} // constructor

		Bucket (){												// constructor without Bucket parameter
			nKeys = 0;
			key   = (K []) Array.newInstance (classK, SLOTS);
			value = (V []) Array.newInstance (classV, SLOTS);
			next  = null;
			locald = 1;
		}

	} // Bucket inner class

	/** The list of buckets making up the hash table.
	 */
	private final List <Bucket> hTable;

	/** The modulus for low resolution hashing
	 */
	private int mod1;

	/** The modulus for high resolution hashing
	 */
	private int mod2;

	/**
	 * Global depth variable
	 */
	private int globald = 1;

	/** Counter for the number buckets accessed (for performance testing).
	 */
	private int count = 0;

	/** The index of the next bucket to split.
	 */
	private int split = 0;


	/********************************************************************************
	 * Construct a hash table that uses Linear Hashing.
	 * @param _classK    the class for keys (K)
	 * @param _classV    the class for values (V)
	 * @param initSize  the initial number of home buckets (a power of 2, e.g., 4)
	 */
	public LinHashMap (Class <K> _classK, Class <V> _classV, int initSize)
	{
		classK = _classK;
		classV = _classV;
		hTable = new ArrayList<>(initSize);
		for(int i = 0; i < initSize; i++){
			Bucket b = new Bucket();
			hTable.add(b);
		}
		mod1   = 4;                     
		mod2   = 2 * mod1;
	} // constructor

	/********************************************************************************
	 * Return a set containing all the entries as pairs of keys and values.
	 * @return  the set view of the map
	 */
	public Set <Map.Entry <K, V>> entrySet ()
	{
		Set <Map.Entry <K, V>> enSet = new HashSet <> ();

		//  T O   B E   I M P L E M E N T E D

		return enSet;
	} // entrySet

	/********************************************************************************
	 * Given the key, look up the value in the hash table.
	 * @param key  the key used for look up
	 * @return  the value associated with the key
	 */
	public V get (Object key)
	{      
		int i = h(key);
		if(i<split){
			i = h2(key);
		}
		V value = null;
		Bucket b = new Bucket();


		if(i < hTable.size()){
			b = hTable.get(i);								// get the bucket at i
			for(int j = 0; j < SLOTS; j++){                 // if no chain, then just get the value	
				if(b.key[j] == (key)){
					value = (V) b.value[j];
				}
			}
			if(b.next != null){
				while(b != null){							// if there's a chain, then go find value

					for(int j = 0; j < SLOTS; j++){			// find values in current bucket
						if(b.key[j] == (key)){
							value = (V) b.value[j];
							break;
						}
					}

					b = b.next;
				}
			}
		}									



		return value;

	} // get

	/********************************************************************************
	 * Put the key-value pair in the hash table.
	 * @param key    the key to insert
	 * @param value  the value to insert
	 * @return  null (not the previous value)
	 */
	public V put (K key, V value)
	{

		int i = h(key); 					// FIRST HASH FUNCTION
		//out.println ("LinearHashMap.put: key = " + key + ", h() = " + i + ", value = " + value);

		if(i < split){						// if h is less than split, put with h2
			i = h2(key);					// SECOND HASH FUNCTION
		}

		Bucket b = hTable.get(i);			

		if(b.nKeys < SLOTS){				// if b.nKeys has space... add key-value pair to the bucket
			b.key[b.nKeys] = key;
			b.value[b.nKeys] = value;
			b.nKeys++;
		}
		else{								// if b.nKeys has no space, overflows

			while(b.next != null){				// bucket walk
				b = b.next;
			}

			if(b.nKeys < SLOTS){				// adds to last available bucket
				b.key[b.nKeys] = key;
				b.value[b.nKeys] = value;
				b.nKeys++;
			}
			else{
				Bucket c = new Bucket();		// create new overflow, add key-value pair into that shit
				c.key[c.nKeys] = key;			
				c.value[c.nKeys] = value;
				c.nKeys++;
				b.next = c;
			}

			Bucket x = new Bucket();
			hTable.add(x);						// add a new bucket at the end of the list

			Bucket y = hTable.get(split);		// retrieve split bucket
			Queue kq = new LinkedList();		// key queue
			Queue vq = new LinkedList();		// value queue

			while(y != null){				// start at first bucket

				for(int j = 0; j < y.nKeys; j++){
					i = h2(y.key[j]);

					if(i == split){
						//out.println(y.key[j]);
						kq.add(y.key[j]);
						vq.add(y.value[j]);
					}
					else{
						b = hTable.get(i);

						while(b.next != null){				// bucket walk
							b = b.next;
						}

						if(b.nKeys < SLOTS){				// adds to last available bucket
							b.key[b.nKeys] = y.key[j];
							b.value[b.nKeys] = y.value[j];
							b.nKeys++;
						}
						else{
							Bucket c = new Bucket();		// create new overflow, add key-value pair into that shit
							c.key[c.nKeys] = y.key[j];			
							c.value[c.nKeys] = y.value[j];
							c.nKeys++;
							b.next = c;
						}

					}

				}

				y = y.next;

			}


			//			for(int j = 0; j < y.nKeys; j++){
			//				i = h2(y.key[j]);				// rehash with h2 = mod 8
			//				
			//				if(i == split){
			//					kq.add(y.key[j]);
			//					vq.add(y.value[j]);
			//				}
			//				else{
			//					b = hTable.get(i);
			//					
			//					while(b.next != null){				// bucket walk
			//						b = b.next;
			//					}
			//
			//					if(b.nKeys < SLOTS){				// adds to last available bucket
			//						b.key[b.nKeys] = key;
			//						b.value[b.nKeys] = value;
			//						b.nKeys++;
			//					}
			//					else{
			//						Bucket c = new Bucket();		// create new overflow, add key-value pair into that shit
			//						c.key[c.nKeys] = key;			
			//						c.value[c.nKeys] = value;
			//						c.nKeys++;
			//						b.next = c;
			//					}
			//					
			//				}
			//				
			//			}

			b = hTable.get(split);
			b.nKeys = 0;
			b.next = null;
			int qSize = kq.size();
			for(int k = 0; k < qSize; k++){
				//out.println(k);
				if(b.nKeys < SLOTS){	// adds to last available bucket
					//out.println(b.nKeys);

					b.key[b.nKeys] = (K) kq.remove();
					b.value[b.nKeys] = (V) vq.remove();
					b.nKeys++;

				}
				else{
					//out.println(kq.peek());
					Bucket c = new Bucket();			// create new overflow, add key-value pair into that shit
					c.key[c.nKeys] = (K) kq.remove();			
					c.value[c.nKeys] = (V) vq.remove();
					c.nKeys++;
					b.next = c;
				}
				//out.println(kq.peek());
			}



			split++;
			if(split >= mod1){
				split = 0;
				mod1 *= 2;
				mod2 *= 2;
			}


		}


		return null;
	} // put

	/********************************************************************************
	 * Return the size (SLOTS * number of home buckets) of the hash table. 
	 * @return  the size of the hash table
	 */
	public int size ()
	{
		return SLOTS * (mod1 + split);
	} // size

	/********************************************************************************
	 * Print the hash table.
	 */
	private void print ()
	{
		out.println ("Hash Table (Linear Hashing)");
		out.println ("-------------------------------------------");

		int counter = 0;
		for(Bucket b : hTable){ 								// for each bucket in hTable
			System.out.println("BUCKET: " + counter);

			if(b.nKeys != 0){

				for(int i = 0; i < b.nKeys; i++){
					System.out.println("     Key: " + b.key[i] + " & Value: " + b.value[i]);
				}

				while(b.next != null){
					b = b.next;
					out.println ("     ------------------------------");
					for(int i = 0; i < b.nKeys; i++){
						System.out.println("     Key: " + b.key[i] + " & Value: " + b.value[i]);
					}
				}

			}

			else{												// if it is empty... print empty
				System.out.println("     Bucket is empty.");
			}
			counter++;
		}

		out.println ("-------------------------------------------");
	} // print

	/********************************************************************************
	 * Hash the key using the low resolution hash function.
	 * @param key  the key to hash
	 * @return  the location of the bucket chain containing the key-value pair
	 */
	private int h (Object key)
	{
		return key.hashCode () % mod1; // where mod1 is 4
	} // h

	/********************************************************************************
	 * Hash the key using the high resolution hash function.
	 * @param key  the key to hash
	 * @return  the location of the bucket chain containing the key-value pair
	 */
	private int h2 (Object key)
	{
		return key.hashCode () % mod2; // where mod2 is 2^d+1
	} // h2


	/********************************************************************************
	 * The main method used for testing.
	 * @param  the command-line arguments (args [0] gives number of keys to insert)
	 */
	public static void main (String [] args)
	{

		int totalKeys = 35;
		int totalBuckets = 4;
		boolean RANDOMLY = false;

		LinHashMap <Integer, Integer> ht = new LinHashMap <> (Integer.class, Integer.class, totalBuckets);
		if (args.length == 1) totalKeys = Integer.valueOf (args [0]);

		if (RANDOMLY) {
			Random rng = new Random ();
			for (int i = 1; i <= totalKeys; i += 2) ht.put (rng.nextInt (2 * totalKeys), i * i);
		} 
		else {
			for (int i = 1; i <= totalKeys; i+=2) ht.put (i, i * i);
		} // if

		out.println ("-------------------------------------------");
		ht.print ();


		for (int i = 0; i <= totalKeys; i++) {
			out.println ("key = " + i + " value = " + ht.get(i));
		} // for
		out.println ("-------------------------------------------");
		out.println ("Average number of buckets accessed = " + ht.count / (double) totalKeys);



	} // main

} // LinHashMap class

