package hashtable;

class Node<K, V> {

    K key;
    V value;

    Node<K, V> nextNode;

    Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

}

public class Hashtable<K, V> {

    private int hashtableSize, bucketSize;
    private Node[] bucket;

    public Hashtable() {
        this.bucketSize = 10;
        this.hashtableSize = 0;
        this.bucket = new Node[bucketSize];

        initializeBucketWithEmptyChains();
    }

    public void put(K key, V value) {

        Node headNode = bucket[getBucketIndex(key)];

        while (headNode != null) {
            if (headNode.key.equals(key)) {
                headNode.value = value;
                return;
            }

            headNode = headNode.nextNode;
        }

        Node newNode = new Node<>(key, value);

        headNode = bucket[getBucketIndex(key)];

        newNode.nextNode = headNode;

        bucket[getBucketIndex(key)] = newNode;

        hashtableSize++;

        if ((1.0*hashtableSize)/bucketSize >= 0.7)
            doubleBucketSize();

    }

    public V get(K key) {
        Node<K, V> node = bucket[getBucketIndex(key)];

        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }

            node = node.nextNode;
        }

        return null;
    }

    public V remove(K key) {
        Node<K, V> node = bucket[getBucketIndex(key)];

        Node<K, V> previousNode = null;

        while (node != null) {

            if (node.key.equals(key))
                break;

            previousNode = node;
            node = node.nextNode;

        }

        if (node == null)
            return null;

        if (previousNode == null) {
            bucket[getBucketIndex(key)] = node.nextNode;
        } else {
            previousNode.nextNode = node.nextNode;
        }

        return node.value;

    }

    public int getBucketSize() {
        return bucketSize;
    }

    public int getHashtableSize() {
        return hashtableSize;
    }

    private void initializeBucketWithEmptyChains() {
        for (int i=0; i<bucketSize; i++)
            bucket[i] = null;
    }

    private void doubleBucketSize() {
        Node[] temp = bucket;

        bucketSize *= 2;

        bucket = new Node[bucketSize];

        initializeBucketWithEmptyChains();

        hashtableSize = 0;

        for (Node<K, V> head : temp) {

            while (head != null) {
                put(head.key, head.value);
                head = head.nextNode;
            }

        }
    }

    private int getBucketIndex(K key) {
        return (key.hashCode() & 0x7fffffff) % bucketSize;
    }

}