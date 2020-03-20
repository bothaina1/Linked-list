package eg.edu.alexu.csd.datastructure.linkedList.cs;


public class SingleLinkedList implements ILinkedList {
    private class Node {
        private Object data ;
        private Node next;
        public Node (Object data){
            this.data = data;
        }
    }
    private Node head;
    @Override
    public void add(int index, Object element) {
        if (index<0||index>=size()){
            throw null;
        }
        Node node = new Node(element);
        Node n = head;
        if(index==0){
            node.next = head;
            head = node;
        }
        else {
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            node.next = n.next;
            n.next = node;
        }
    }




    @Override
    public void add(Object element) {
        Node node = new Node(element);
        if (head == null)
            head = node;
        else {
            Node n = head;
            while (n.next != null){
                n = n.next;
            }
            n.next = node;
        }
    }

    @Override
    public Object get(int index) {
        if (index<0||index>=size()){
            throw null;
        }
        Object element;
        Node n = head;
        for (int i=0;i<index;i++){
            n = n.next;
        }
        element = n.data;
        System.out.println(element);
        return element;
    }

    @Override
    public void set(int index, Object element) {
        if (index<0||index>=size()){
            throw null;
        }
        Node node = new Node(element);
        Node n = head;
        Node n1 = null;
        if(index == 0){
            node.next = n.next;
            head = node;
            n = null;
        }
        else {
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            n1 = n.next;
            node.next = n1.next;
            n.next = node;
            n1 = null;

        }
    }

    @Override
    public void clear() {
        Node node = head;
        while (node.next != null){
            Node n = head;
            head = node.next;
            node = node.next;
            n = null;
        }
        head = null;
        node = null;
    }

    @Override
    public boolean isEmpty() {
        boolean empty = false;
        if (head == null){
            empty = true;
        }
        System.out.println(empty);
        return empty;
    }

    @Override
    public void remove(int index) {
        if (index<0||index>=size()){
            throw null;
        }
        if(index == 0){
            head = head.next;
        }
        else {
            Node n = head;
            Node n1 = null;
            for (int i=0;i<index-1;i++){
                n = n.next;
            }
            n1 = n.next;
            n.next = n1.next;
            n1 = null;
        }
    }

    @Override
    public int size() {
        int counter;
        if(head == null){
            counter = 0;
        }
        else {
            counter = 1;
            Node node = head;
            while (node.next != null) {
                counter++;
                node = node.next;
            }
        }
        System.out.println(counter);
        return counter;
    }

    @Override
    public ILinkedList sublist(int fromIndex, int toIndex)
    {
        if (fromIndex<0||fromIndex>=size()||toIndex<0||toIndex>=size()||fromIndex>toIndex){
            throw null;
        }
        SingleLinkedList sublist = new SingleLinkedList();
        Node node = head;
        for(int i=0;i<fromIndex;i++){
            node = node.next;
        }
        for (int i=fromIndex;i<=toIndex;i++)
        {
            sublist.add(node.data);
            node = node.next;
        }
        return sublist;
    }

    @Override
    public boolean contains(Object o) {
        boolean found = false;
        Node n = head;
        if (head.data == o){
            found = true;
        }
        else {
            while (n.next != null) {
                if (n.data == o) {
                    found = true;
                }
                n = n.next;
            }
            if (n.data == o) {
                found = true;
            }
        }
        System.out.println(found);
        return found;
    }
    public void show(){
        Node node = head;
        while (node.next != null){
            System.out.println(node.data);
            node = node.next;
        }
        System.out.println(node.data);
    }
}
