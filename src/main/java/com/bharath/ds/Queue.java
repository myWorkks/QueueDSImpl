package com.bharath.ds;

//Queue is a DS where first inserted element will be removed first(FIFO)
//Implementation of Queue with an fixed array
public class Queue<E> {
	private int size;// to track the size
	private E[] array;// to store elements
	private int capacity;// intializing the queue capacity
	private int rear_index;// index for adding the elements from last
	private int front_index;// index for removing the elements from first

	public Queue(int capacity) {
		this.size = 0;// intializing size to 0
		this.capacity = capacity;// intializing the capacity of an queue based on the queue object creation
		this.array = (E[]) new Object[capacity];// intitializing an array with provided capacity
		rear_index = 0;// intializing last index to add elements into an array
		front_index = 0;// intializing first index to remove the elements from an array

	}

//finding capacity
	public int capacity() {
		return this.capacity;
	}

//finding size
	public int size() {
		return this.size;
	}

	// adding an element to queue
	public void enQueue(E a) {
		// before adding check the queue is full or not
		if (isFull(this))
			throw new RuntimeException("queue is full");

		array[rear_index] = a;
		rear_index += 1;

		size += 1;

	}

//finding a queue is full or not
	public boolean isFull(Queue<E> queue) {
		return queue.size == queue.capacity;
	}

//finding a queue is empty or not
	public boolean isEmpty() {
		return this.size == 0;
	}

//removing an element
	public E deQueue() {
		if (this.isEmpty())
			throw new RuntimeException("Queue is empty");
		E a = array[front_index];
		size -= 1;
		front_index += 1;
		return a;
	}

//finding an element at first index
	public E first() {
		if (this.isEmpty())
			throw new RuntimeException("Queue is empty");
		return array[front_index];
	}

//finding an element at las index
	public E last() {
		if (this.isEmpty())
			throw new RuntimeException("Queue is empty");
		return array[rear_index - 1];
	}
}

class Tester {
	public static void main(String[] args) {
		Queue<Integer> q = new Queue<>(5);

		q.enQueue(10);

		

		System.out.println(q.first());
		System.out.println(q.last());

		Queue<String> qs = new Queue<>(10);
		qs.enQueue("bharath");
		System.out.println(qs.first());
		System.out.println(qs.last());
	}
}