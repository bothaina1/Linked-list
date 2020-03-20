package eg.edu.alexu.csd.datastructure.linkedList.cs;



public class doubly_linkedlist implements ILinkedList {


	
 Node head ;
 Node tail ;

	 public class Node {
		 Object element;
		 Node next;
		 Node previous;	
	}
	

	public void add( Object element) {
		Node node =new Node();
		node.element=element;
		node.next= null ;
	
		if(head==null) {
			head=node;
		}
		else {
			tail.next=node;
			node.previous=tail ;
			
			}
		tail=node;
		
		}
	
	
	public Object get(int index) {
		if(index>=size()||index<0) {
		throw null ;
		}
		
		Node n=head;
		for(int i=0;i<index;i++) {
			n=n.next;
		}
		return n.element ;	
	}
	
	public void add(int index,Object element) {
		Node node =new Node();
		node.element=element;
		node.next= null ;
		
		Node n=head;
		
		if(index>=size()||index<0) {
			throw null ;
			}
	
		else if (index==0) {
		head=node;
		head.next=n;
		}
		else {
		for(int i=0;i<index-1;i++) {
			n=n.next;
		}
		node.next=n.next;
		node.previous=n ;
		n.next=node ;
		n=n.next;
		n.previous=node ;	
	}
	}
	
	public void set(int index , Object element) {
		if(index>=size()||index<0) {
			throw null ;
			}
		Node node =new Node();
		node.element=element;
		node.next= null ;
		
		Node n=head;
		for(int i=0;i<index;i++) {
			n=n.next;
		}
	n.element=node.element;	
	}
	
	
	public void clear() {
		if(size()==0) {
			throw null;
		}
		
		for(int i=0;i<size()-1;i++) {
			head=head.next;
			head.previous=null;
		
		}
		head=null;		
	}
	
	public boolean isEmpty() {
		if(head==null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int size() {
		int lenght=0 ;
		Node n= head ;
		while(n!=null)
		{	lenght++;
		n=n.next;  }
		return lenght ;	
	}
	
	public void remove(int index) {
		if(index>size()||index<0) {
			throw null ;
			}
		Node n= head ;
		for(int i=0;i<index;i++) {
			n=n.next;
		}
		
		 if(size()==1) {
			head=null;
		tail=null;  }
		 
		 else if(index==size()-1)
			{tail.previous.next=null ;
		tail=tail.previous; }
		
		
		else  {
				n.previous.next=n.next ;
				n.next.previous=n.previous ;
			}
     }
	
	public boolean contains(Object o) {

	Node n=head;
		while(n!=null) {
			if(o.equals(n.element)) {
				return true;
			}
			else
				n=n.next;
		}

		if(tail.element==o) {
			return true;
		}
		return false ;
	}
	
	
	public ILinkedList sublist(int fromIndex, int toIndex) {
		if(toIndex>=size()||toIndex<0||fromIndex>=size()||fromIndex<0||fromIndex>toIndex) {
			throw null ;
			}
		doubly_linkedlist sub =new doubly_linkedlist();
		Node n=head;
		for(int i=0;i<fromIndex;i++) {
			n=n.next;
		
		}
		for(int i=fromIndex;i<=toIndex;i++) {
			sub.add(n.element);
			n=n.next ;	
		}
		return sub;
	}		
}

