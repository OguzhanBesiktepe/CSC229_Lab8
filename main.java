/* Oguzhan Besiktepe
 * CSC 229
 * April 10th 2024
 */

import java.util.ArrayList;
import java.util.List;

// Elements of our Linked List listed below:

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// SinglyLinkedList class for our operations

class SinglyLinkedList {
    Node head;

    // Add to the end of our list

    void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    SinglyLinkedList filterContainsDigit(int digit) {
        SinglyLinkedList filteredList = new SinglyLinkedList();
        Node current = head;
        while (current != null) {
            if (String.valueOf(current.data).contains(String.valueOf(digit))) {
                filteredList.append(current.data);
            }
            current = current.next;
        }
        return filteredList;
    }

    // Sum of Elements listed
    int sumOfElements() {
        int sum = 0;
        Node current = head;
        while (current != null) {
            sum += current.data;
            current = current.next;
        }
        return sum;
    }
}


class PrimeUtils {

    // This will generate all prime numbers

    static List<Integer> sieveOfEratosthenes(int n) {
        boolean[] prime = new boolean[n + 1];
        List<Integer> primes = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            prime[i] = true;
        }
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }
        for (int p = 2; p <= n; p++) {
            if (prime[p]) {
                primes.add(p);
            }
        }
        return primes;
    }

    // Process primes to find sum of those containing the digit '3'

    static int processPrimes(int n) {
        List<Integer> primes = sieveOfEratosthenes(n);
        SinglyLinkedList allPrimesList = new SinglyLinkedList();
        for (int prime : primes) {
            allPrimesList.append(prime);
        }
        SinglyLinkedList primesWithDigit3 = allPrimesList.filterContainsDigit(3);
        return primesWithDigit3.sumOfElements();
    }
}

// Main class to execute the program

public class main {
    public static void main(String[] args) {
        int n = 100; // Change this value to test with different upper limits

        System.out.println("Sum of prime numbers containing the digit '3' from 0 to " + n + " is: " + PrimeUtils.processPrimes(n));
    }
}