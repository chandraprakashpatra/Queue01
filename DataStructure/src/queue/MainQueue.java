package queue;

import java.util.*;

public class MainQueue {

	static int front = -1;
	static int rear = -1;
	Scanner sc = new Scanner(System.in);

	public boolean underflow() {
		if (front == -1 || rear == -1) {
			return true;
		} else
			return false;
	}

	public boolean overflow(int queue[], int Max) {
		if (rear == Max - 1) {
			return true;
		} else
			return false;
	}

	public int enqueue(int queue[], int Max) {
		boolean x = overflow(queue, Max);
		if (x == false) {
			rear++;
			System.out.println("input info :");
			queue[rear] = sc.nextInt();
			return 1;
		} else {
			return 0;
		}

	}

	public void display(int queue[], int Max) {
		System.out.println("FRONT = " + front);

		int i = 0;
		while (i < Max) {

			System.out.println("ELEMENT = " + queue[i]);
			i++;

		}

		System.out.println("REAR = " + rear);
	}

	public int dequeue(int queue[], int u) {

		if (underflow() == true) {
			return 0;
		} else if (front == rear + 1) {
			front = rear = -1;
			u = 0;
			return 0;
		} else {
			queue[front] = 0;
			front++;
			return 1;
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		MainQueue obj = new MainQueue();
		System.out.println("Enter the size of the que 1st : ");
		int size = sc.nextInt();
		int queue[] = new int[size];
		int Max = queue.length;
		obj.overflow(queue, Max);

		int p = 1;
		do {
			System.out.println("MENU >>>>>>>>>");
			System.out.println("1.enqueue:");
			System.out.println("2.dequeue");
			System.out.println("3.Display :");
			System.out.println("4.whats is Max size ?");

			int q = sc.nextInt();
			switch (q) {
			case 1:// enqueue

				int check1 = 1;
				if (check1 == 1) {
					front++;
				}
				while (check1 == 1) {
					int e = obj.enqueue(queue, Max);
					if (e == 0) {
						System.out.println("size of the queue is full . OVERFLOW .");
						check1 = 0;
					} else {
						System.out.println("do you want to add more elements to the queue ?(1- yes /0- no)");
						check1 = sc.nextInt();
					}
				}
				break;

			case 3:// traversing
				
				obj.display(queue, Max);
				break;

			case 2:// dequeue

				int u = 1;
				do {

					u = obj.dequeue(queue, u);
					if (u == 0) {
					} else {
						System.out.println(" do you want to delete more elements ?if not press 0 :");
						u = sc.nextInt();
					}
				} while (u != 0);
				break;
			case 4:
				System.out.println(Max);
				break;

			default:
				System.out.println("wrong input.");
				break;
			}

			System.out.println("do you want end ?(press 0) else press any key");
			p = sc.nextInt();
		} while (p != 0);
		System.out.println(" THE PROGRAM HAS BEEN ELIMINATED .");
		sc.close();
	}
}
