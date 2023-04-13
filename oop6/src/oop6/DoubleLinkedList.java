package oop6;

/**
 * This class contains double linked list
 * @param <T> Generalized class
 */
public class DoubleLinkedList<T> {
    /**
     * The first element in list
     */
    private Node<T> first;
    /**
     * The last element in list
     */
    private Node<T> last;
    /**
     * The pointer in the list
     */
    private int pointer;
    /**
     * The length of list
     */
    private int size;

    /**
     * This class saving nodes and data of element
     * @param <T> Generalized class
     */
    private static class Node<T>{
        /**
         * Information in element
         */
        private T data;
        /**
         * Node with currently and next elements
         */
        private Node<T> next;
        /**
         * Node with previous and currently elements
         */
        private Node<T> prev;

        /**
         * Default constructor of nodes
         * @param data Information in element
         */
        Node(T data){
            this.data = data;
        }

        /**
         * This setter assigns new meaning of 'data'
         * @param data Information in element
         */
        public void setData(T data) {
            this.data = data;
        }

        /**
         * This getter returns data of element
         * @return Information in element
         */
        public T getData() {
            return data;
        }

        /**
         * This setter assigns new meaning of 'next'
         * @param next Node with currently and next elements
         */
        public void setNext(Node<T> next) {
            this.next = next;
        }

        /**
         * This getter returns 'next' node
         * @return Node with currently and next elements
         */
        public Node<T> getNext() {
            return next;
        }

        /**
         * This setter assigns new meaning of 'prev'
         * @param prev Node with previous and currently elements
         */
        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        /**
         * This getter returns 'prev' node
         * @return Node with previous and currently elements
         */
        public Node<T> getPrev() {
            return prev;
        }
    }

    /**
     * Default constructor of double linked list
     */
    public DoubleLinkedList(){
        this.size = 0;
        this.pointer = 0;
        this.first = null;
        this.last = null;
    }

    /**
     * This method check list to the void
     * @return True, if list is empty and false, if list is not empty
     */
    public boolean isEmpty(){
        return this.size == 0;
    }

    /**
     * This method return the meaning of size
     * @return The length of list
     */
    public int getSize() {
        return size;
    }

    /**
     * This method set pointer to start
     */
    public void setPointerToStart(){
        this.pointer = 0;
    }

    /**
     * This method set pointer to end
     */
    public void setPointerToEnd(){
        this.pointer = this.size;
    }

    /**
     * This method return pointer position
     * @return Position of pointer
     */
    public int getPointer(){
        return pointer;
    }

    /**
     * This method stores code to add element in empty list
     * @param node Added node
     */
    private void addToEmptyList(Node<T> node){
        this.first = node;
        this.first.setNext(this.first);
        this.last = node;
        this.last.setPrev(this.last);
    }

    /**
     * This method add element after the pointer
     * @param data Information in element
     */
    public void addAfterPointer(T data){
        Node<T> node = new Node<>(data);
        if (isEmpty()){
            addToEmptyList(node);
        }else {
            Node<T> firstNode;
            Node<T> secondNode;
            if (this.pointer == 0){
                firstNode = this.first;
                secondNode = this.last;
                this.first = node;
                this.first.setNext(firstNode);
                this.first.setPrev(secondNode);
                firstNode.setPrev(this.first);
                this.last.setNext(this.first);
            }else {
                Node<T> curNode = this.first;
                for (int i = 1; i != this.pointer; i++){
                    curNode = curNode.getNext();
                }
                firstNode = curNode.getNext();
                curNode.setNext(node);
                secondNode = curNode.getNext();
                secondNode.setNext(firstNode);
                secondNode.setPrev(curNode);
                firstNode.setPrev(secondNode);
                if (curNode == this.last){
                    this.last = secondNode;
                }
            }
        }
        this.size += 1;
    }

    /**
     * This method add element before the pointer
     * @param data Information in element
     */
    public void addBeforePointer(T data){
        Node<T> node = new Node<>(data);
        if (isEmpty()) {
            addToEmptyList(node);
        }else {
            Node<T> firstNode;
            Node<T> secondNode;
            if (this.pointer == 0){
                firstNode = this.first;
                secondNode = this.last;
                this.last = node;
                this.last.setNext(firstNode);
                this.last.setPrev(secondNode);
                firstNode.setPrev(this.last);
                secondNode.setNext(this.last);
            } else {
                Node<T> curNode = this.last;
                for (int i = (this.size - 1); i != this.pointer; i--){
                    curNode = curNode.getPrev();
                }
                firstNode = curNode.getPrev();
                curNode.setPrev(node);
                secondNode = curNode.getPrev();
                secondNode.setPrev(firstNode);
                secondNode.setNext(curNode);
                firstNode.setNext(secondNode);
                if (curNode == this.first){
                    this.first = secondNode;
                }
            }
        }
        this.size += 1;
    }

    /**
     * This method stores code to delete element in list with 1 element
     */
    private void deleteInOneElementList(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * This method delete element after the pointer
     */
    public void deleteAfterPointer(){
        switch (this.size){
            case 0 -> System.out.println("*List is empty.");
            case 1 -> deleteInOneElementList();
            default -> {
                Node<T> node;
                if (this.pointer == 0){
                    node = this.first.getNext().getNext();
                    this.first.setNext(node);
                    node.setPrev(this.first);
                }else {
                    Node<T> curNode = this.first;
                    for (int i = 1; i != this.pointer; i++){
                        curNode = curNode.getNext();
                    }
                    if (curNode.getNext() == this.last){
                        curNode.setNext(this.first);
                        this.last = curNode;
                        this.first.setPrev(this.last);
                    }else if (curNode.getNext() == this.first){
                        this.first = this.first.getNext();
                        this.first.setPrev(this.last);
                        this.last.setNext(this.first);
                    } else {
                        node = curNode.getNext().getNext();
                        curNode.setNext(node);
                        node.setPrev(curNode);
                    }
                }
                this.size -= 1;
            }
        }
    }

    /**
     * This method delete element before the pointer
     */
    public void deleteBeforePointer(){
        switch (this.size){
            case 0 -> System.out.println("*List is empty.");
            case 1 -> deleteInOneElementList();
            default -> {
                Node<T> node;
                if (this.pointer == 0){
                    node = this.last.getPrev();
                    this.first.setPrev(node);
                    node.setNext(this.first);
                    this.last = node;
                }else {
                    Node<T> curNode = this.last;
                    for (int i = (this.size - 1); i != this.pointer; i--){
                        curNode = curNode.getPrev();
                    }
                    if (curNode.getPrev() == this.first){
                        curNode.setPrev(this.last);
                        this.first = curNode;
                        this.last.setNext(this.first);
                    }else if (curNode.getPrev() == this.last){
                        this.last = this.last.getPrev();
                        this.first.setPrev(this.last);
                        this.last.setNext(this.first);
                    } else {
                        node = curNode.getPrev().getPrev();
                        curNode.setPrev(node);
                        node.setNext(curNode);
                    }
                }
                this.size -= 1;
            }
        }
    }

    /**
     * This method switch first and last elements in list
     */
    public void switchFirstAndLast(){
        if (this.size > 0) {
            Node<T> nowNode = this.first;
            for (int i = 0; i != this.pointer; i++) {
                nowNode = nowNode.getNext();
            }
            T firstNode = nowNode.getNext().getData();
            T SecondNode = nowNode.getPrev().getData();
            nowNode.getNext().setData(SecondNode);
            nowNode.getPrev().setData(firstNode);
        } else{
            System.out.println("*List is empty.");
        }
    }

    /**
     * This method move pointer right
     * @return Meaning of pointer
     */
    public int movePointerRight(){
        if (this.pointer + 1 > this.size){
            this.setPointerToStart();
        }else {
            this.pointer += 1;
        }
        return this.pointer;
    }

    /**
     * This method move pointer left
     * @return Meaning of pointer
     */
    public int movePointerLeft(){
        if (this.pointer - 1 < 0){
            this.setPointerToEnd();
        }else {
            this.pointer -= 1;
        }
        return this.pointer;
    }

    /**
     * This method move pointer right and get data of element
     * @return Data of currently element
     */
    public T getNext(){
        if (isEmpty()){
            System.out.println("*List is empty.");
        }
        Node<T> curNode = this.first;
        for (int i = 0; i != this.pointer; i++) {
            curNode = curNode.getNext();
        }
        return curNode.getData();
    }
}
