package src;

/**
 * This class represents a queue specifically designed for managing a cancellation list of hygiene
 * appointments with a dental hygienist. The queue operates on a first-in, first-out (FIFO) basis.
 */

public class HygieneQueue {
    private String[] queueArray;
    private int capacity;
    private int front;
    private int rear;
    private int currentSize;

    /**
     * Constructs a new HygieneQueue with a specified capacity. Initializes the queue to empty.
     * @param size the size of the queue
     */
    public HygieneQueue(int size) {
        capacity = size;
        queueArray = new String[size];
        front = 0;
        rear = -1;
        currentSize = 0;
    }

    /**
     * Checks if the queue is full, if full no additional patients can be added.
     * @return
     */
    public boolean isFull() {
        return currentSize == capacity;
    }

    /**
     * Checks if the queue is empty, if empty no patients can be removed.
     * @return
     */
    public boolean isEmpty() {
        return currentSize == 0;
    }

    /**
     * Adds a patient to the end of the queue.
     * @param patient the patient
     */
    public void enqueue(String patient) {
        if (isFull()) {
            throw new IllegalStateException("The cancellation list is full, additional patients cannot be added at this time.");
        }
        rear = (rear + 1) % capacity;
        queueArray[rear] = patient;
        currentSize++;
        System.out.println(patient + " was added to the cancellation list.");
    }

    /**
     * Removes a patient from the front of the queue.
     * @return the patient at the front of the list
     */
    public String dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("The cancellation list is empty, there are no patients to remove.");
        }

        String patient = queueArray[front];
        front = (front + 1) % capacity;
        currentSize--;
        return patient;
    }

    /**
     *
     * @return
     */
    public String peek() {
        if (isEmpty()) {
            throw new IllegalStateException("The cancellation list is empty, there are no patients to remove.");
        }
        return queueArray[front];
    }
}