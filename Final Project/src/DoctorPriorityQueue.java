package src;
import java.util.Arrays;

public class DoctorPriorityQueue {

    private Patient[] queue;
    private int size;
    private int capacity;

    public DoctorPriorityQueue(int capacity) {
        this.queue = new Patient[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public void enqueue(Patient patient) throws IllegalStateException{
        if (size >= capacity) {
            throw new IllegalStateException("The cancellation list is full, additional patients cannot be added at this time.");
        }

        // Insert patient based on priority
        int i;
        for (i = size - 1; i >= 0; i--) {
            if (patient.getAppointmentType().ordinal() < queue[i].getAppointmentType().ordinal()) {
                queue[i + 1] = queue[i];
            }
            else {
                break;
            }
        }

        queue[i + 1] = patient;
        size++;
    }

    public Patient dequeue() throws IllegalStateException {
        if (size == 0) {
            throw new IllegalStateException("The cancellation list is empty, there are no patients to remove.");
        }
        return queue[size--];
    }

    public Patient peek() throws IllegalStateException {
        if (size == 0) {
            throw new IllegalStateException("The cancellation list is empty, there are no patients to remove.");
        }
        return queue[size - 1];
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}