//List of integers that comes from both sides.
public class LinkedListDeque<Doubly> {

    public static class LLNode {
        public Doubly item;
        public LLNode next; //sentinel after last
        public LLNode prev; //sentinel before first
        public LLNode(Doubly i, LLNode n, LLNode p) {
            item = i;
            next = n;
            prev = p;
        }
    }

    private LLNode sentinel;
    private int size;

    //Creates an empty linked list deque
    public LinkedListDeque(){
        sentinel = new LLNode(24, null, null);
        size = 0;


    }


    public LinkedListDeque(Doubly x) {
        sentinel = new LLNode(24, null, null);
        sentinel.next = new LLNode(x, null, sentinel);
        size = 1;
    }


//Adds an item of type T to the front of the deque
    public void addFirst(Doubly item){
        sentinel.next = new LLNode(item, sentinel, sentinel.next.next);
        size += 1;

    }

//Adds an item of Type "T" to the back of the deque
    public void addLast(Doubly item) {
        sentinel.prev = new LLNode(item, null, sentinel.prev.prev);
        size += 1;
    }


//Returns true if deque is empty, false otherwise
    public boolean isEmpty(){
        if (size == 0) {
            return true;
        }
        else {
            false;
        }
    }


//Returns the number of items in the deque
    public int size(){
        return size;
        }



//Prints the item in the deque from first to last, separated by a space
    public void printDeque(){
        int i = 0;
        while (sentinel.next != sentinel) {
            System.out.print(get(i));
            i++;
        }
    }




//Removes and returns the item at the front of the deque. If no such item exists, return null
    public T removeFirst(){
        if (sentinel.next == null) { //or put size == 0?
            return null;
        }
        else{
        Doubly placeholder = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return placeholder;

    }



//Removes and returns the item at the back of the deque. If no such item exists, return null
    public Doubly removeLast(){
        if (sentinel.prev == null) { //or put size == 0?
            return null;
        }
        else{
            Doubly place = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            size -= 1;
            return place;

        }

    }



//Gets the item at the given index, where 0 is the front. If no such item exists, return null.
    public Doubly get(int index){

        if (index > size){
            return null;
        }
        else {
            //find a way to iterate through the deque.
            int i = 0;
            LLNode p = sentinel.next;
            while (i <= index) {
                p = p.next;
                i++;
            }
            return p.item;
        }
            }




 public Doubly getRecursive(int index){
            if (index > size ){
                return null;
            }
            else{
                return helper(LLNode z, int i, index)
            }

        }

public Doubly helper(LLNode z, int i, index){
            if (z == null){
                return null;
            }
            else if (i == index){
                return z.item;
            }
            else{
                return helper(z.next, i++, index)
            }
        }

    }



}
