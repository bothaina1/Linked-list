package eg.edu.alexu.csd.datastructure.linkedList.cs;
 class PolynomialSolver implements IPolynomialSolver{
	 doubly_linkedlist list_A = new doubly_linkedlist();
	 doubly_linkedlist list_B = new doubly_linkedlist();
	 doubly_linkedlist list_C = new doubly_linkedlist();
	 doubly_linkedlist list_R = new doubly_linkedlist();
	 doubly_linkedlist tem1 = new doubly_linkedlist();
	 doubly_linkedlist tem2 = new doubly_linkedlist();
	 int[][] array ;
	 int check1=0; int check2=0; int check3=0; int check4=0;
	  
	 
	 public int[][] scan(String str){
	        String[] arrOfStr = str.split("[, ()]+");
	        int[][] arr = new int[(arrOfStr.length-1)/2][2];
	        int k=1;
	        for (int i=0;i<(arrOfStr.length-1)/2;i++) {
	            for (int j = 0; j < 2; j++) {
	                arr[i][j] = Integer.parseInt(arrOfStr[k]);
	                k++;
	            }
	        }
	        return arr;
	    }
	 
	 
	 
	 public int[][] order( int[][] terms) {
		 int tem=0;
		 for(int j=0;j<terms.length;j++) {
			 for(int i=0;i<terms.length-1-j;i++) {
				 if(terms[i][1]<terms[i+1][1]) {
					 tem=terms[i+1][1];
					 terms[i+1][1]=terms[i][1];
					 terms[i][1]= tem;
					 tem=terms[i+1][0];
					 terms[i+1][0]=terms[i][0];
					 terms[i][0]= tem; }	
			 }  
		 }
		 for(int i=0;i<terms.length-1;i++) {
			 if(terms[i][1]==terms[i+1][1]) {
				 terms[i][0]=terms[i][0]+terms[i+1][0];
				 if(i+1==terms.length-1)
					 {terms[i+1][0]=0;
				     terms[i+1][1]=0; }
				 for(int j=0;j<terms.length-2-i;j++) {
					 terms[i+1+j][0]=terms[i+2+j][0];
					 terms[i+1+j][1]=terms[i+2+j][1];
					 if(terms.length-2-i-j==1) {
						 terms[i+2+j][0]=0;
						 terms[i+2+j][1]=0; }
						  }
				 
				         }
			            } 
	 return terms;
	 }
	 
	 
	 
	public doubly_linkedlist arraytolist(int[][] terms,doubly_linkedlist list) {
		
		terms=order(terms);
	    for(int i=0;i<terms.length;i++) {
	    	if(terms[i][0]!=0) {
	         list.add(terms[i][0]);
	         list.add(terms[i][1]);
	    	}
	    }
		return list;
	}
	
	

	public int[][] listtoarray(doubly_linkedlist list){
	int l=list.size()/2;
	 int[][] array =new int[l][2];
	 tem1.head=list.head;
	for(int i=0;i<l;i++) {
		array[i][0]=(int)tem1.head.element;
		tem1.head=tem1.head.next;
		array[i][1]=(int)tem1.head.element;
		tem1.head=tem1.head.next;	
	}
		return array;	
	}
	

	
   public void setPolynomial (char poly, int[][] terms ) {
		switch(poly) {
		case 'A' :
			check1=1;
			arraytolist(terms ,list_A);
			break;
		case 'B' :
			check2=1;
			arraytolist(terms ,list_B);
			break;
		case 'C' :
			check3=1;
			arraytolist(terms ,list_C);
			break;	
		case 'R' :
			check4=1;
			arraytolist(terms ,list_R);
			break;	
		}	
	}
	
   
   
  public   String print_list(doubly_linkedlist list,int check) {
	  if(list.head==null&&check==1)
			return "0";
			else if(list.head==null&&check==0)
				throw null;
			else {
		String s =new String();
		s="";  int m=(int)list.head.element;
		tem1.head=list.head;
		int l=list.size()/2;
		for(int i=0;i<l;i++) {
		s=s+Integer.toString((int)tem1.head.element);
		tem1.head=tem1.head.next;
		m=(int)tem1.head.element;
		if((int)tem1.head.element!=0) {
		s=s+"x^";
		s=s+Integer.toString((int)tem1.head.element);
		}
		tem1.head=tem1.head.next;
		if(i!=l-1)
		m=(int)tem1.head.element;
			if(i<l-1&&m>0) {
				s=s+"+"; }
			if(i<l-1&&m<0) {
				s=s+""; }
		}	
			return s;
	}
  }
  
  
       public String print(char poly) {
		switch(poly) {
		case 'A' :
		return	print_list(list_A,check1);
		
		case 'B' :
			return	print_list(list_B,check2);
		
		case 'C' :
			return	print_list(list_C,check3);
		
		case 'R' :
			return	print_list(list_R,check4);
			
		}
		return null;	
	}
	
	
        
	public void clearPolynomial (char poly) {
		switch(poly) {
		case 'A' :
			check1=0;
			list_A.clear();
			break;
		
		case 'B' :
			check2=0;
			list_B.clear();
			break;
		
		case 'C' :
			check3=0;
			list_C.clear();
			break;
		case 'R' :
			check4=0;
			list_R.clear();
			break;
			}	
	}
	

	
	
	public float evaluate (doubly_linkedlist list, float value) {
		float f=0;int tem=0;
		int l=list.size()/2;
		tem1.head=list.head;
		for(int i=0;i<l;i++) {
			tem=(int)tem1.head.element;
			tem1.head=tem1.head.next ;
		    f+=tem*Math.pow((double)value,(int)tem1.head.element);
		    tem1.head=tem1.head.next ; 
		}
		return f;
	}
	
	
  public  float evaluatePolynomial(char poly,float value) {
		switch (poly) {
		case 'A' :
		       return	evaluate(list_A,value);

		case 'B' :
			 return	evaluate(list_B,value);
		
		case 'C' :
			return	evaluate(list_C,value);
		
		case 'R' :
			return	evaluate(list_R,value);
		
		default	:
		return 0;
		}
      }
	
  
  
  doubly_linkedlist general(int num,doubly_linkedlist list1 ,doubly_linkedlist list2){

		       tem1.head=list1.head;
				tem2.head=list2.head;
				while(tem1.head!=null&&tem2.head!=null) {
					
				if((int)tem1.head.next.element>(int)tem2.head.next.element) {
					list_R.add(tem1.head.element);
					list_R.add(tem1.head.next.element);
					tem1.head=tem1.head.next;
					tem1.head=tem1.head.next;
					}
				
				else if((int)tem2.head.next.element>(int)tem1.head.next.element) {
					if(num==1) {
					list_R.add(tem2.head.element);list_R.add(tem2.head.next.element);}
					if(num==2) {
					list_R.add(0-(int)tem2.head.element);
					list_R.add(tem2.head.next.element);}
					tem2.head=tem2.head.next;
					tem2.head=tem2.head.next;			}
			
				else {
					
					if(num==1)
					 adding(list1,list2);
					if(num==2)
						 subtracting (list1,list2);
				}
			}
		
				while(tem1.head!=null) {
					list_R.add(tem1.head.element);
					list_R.add(tem1.head.next.element);
					tem1.head=tem1.head.next;
					tem1.head=tem1.head.next; 
					}
				while(tem2.head!=null) {
					list_R.add(0-(int)tem2.head.element);
					list_R.add(tem2.head.next.element);
					tem2.head=tem2.head.next;
					tem2.head=tem2.head.next; 
				}
			return list_R;	
			}
	
	
		
     void adding (doubly_linkedlist list1 ,doubly_linkedlist list2) {
		
	list_R.add((int)tem1.head.element+(int)tem2.head.element);
	list_R.add(tem2.head.next.element);
	if((int)list_R.tail.previous.element==0) {
		list_R.remove(list_R.size()-1);
	    list_R.remove(list_R.size()-1);  
	    }
	tem2.head=tem2.head.next;
	tem2.head=tem2.head.next;
	tem1.head=tem1.head.next;
	tem1.head=tem1.head.next;
	}

   
   
   
   
void subtracting (doubly_linkedlist list1 ,doubly_linkedlist list2) {
	
list_R.add((int)tem1.head.element-(int)tem2.head.element);
list_R.add(tem2.head.next.element);
if((int)list_R.tail.previous.element==0) {
	list_R.remove(list_R.size()-1);
    list_R.remove(list_R.size()-1);  
    }

tem2.head=tem2.head.next;
tem2.head=tem2.head.next;
tem1.head=tem1.head.next;
tem1.head=tem1.head.next;
}
	


doubly_linkedlist choice2(int num,doubly_linkedlist list1 ,doubly_linkedlist list2){
		
		if(num==1||num==2)
			return general(num,list1,list2);
		else
				return multyplying (list1,list2);
		}
	
	 
	
doubly_linkedlist multyplying(doubly_linkedlist list1 ,doubly_linkedlist list2) {
		
		tem1.head=list1.head;
		
		while(tem1.head!=null) {
			tem2.head=list2.head;
			while(tem2.head!=null) {
				list_R.add((int)tem1.head.element*(int)tem2.head.element);
				list_R.add((int)tem2.head.next.element+(int)tem1.head.next.element);
				if((int)list_R.tail.previous.element==0) {
					list_R.remove(list_R.size()-1);
				    list_R.remove(list_R.size()-1);    }
				tem2.head=tem2.head.next;
				tem2.head=tem2.head.next;
			}
			tem1.head=tem1.head.next;
			tem1.head=tem1.head.next;
		}
		
		
		
		
		return list_R;  }
	
	int[][] choice(char poly1, char poly2 ,int num ) {
		if(poly1=='A'&&poly2=='A') {
			return listtoarray( choice2(num,list_A, list_A)); }
		else if(poly1=='B'&&poly2=='B') {
			return listtoarray( choice2(num,list_B, list_B)); }
		else if(poly1=='C'&&poly2=='C') {
			return listtoarray( choice2(num,list_C, list_C)); }
		else if(poly1=='A'&&poly2=='B') {
			return listtoarray(choice2(num,list_A, list_B)); }
		else if(poly1=='A'&&poly2=='C') {
			return listtoarray(choice2(num,list_A, list_C)); }
		 if(poly1=='B'&&poly2=='C') {
			return listtoarray(choice2(num,list_B, list_C)); }
		 else if(poly1=='C'&&poly2=='B') {
				return listtoarray(choice2(num,list_C, list_B)); }
			else if(poly1=='B'&&poly2=='A') {
				return listtoarray(choice2(num,list_B, list_A)); }
			 if(poly1=='A'&&poly2=='C') {
			    return listtoarray(choice2(num,list_A, list_C)); }
		 
		return null;    
		} 
	
	

   public  int[][] add(char poly1 ,char poly2){
	   check4=1;
	 if(list_R.head!=null)
			list_R.clear();
		int num=1;
		return choice(poly1,poly2,num);    }
   
 
	
	public int[][] subtract(char poly1, char poly2){
		check4=1;
		if(list_R.head!=null)
			list_R.clear();
		int num=2;
	return	choice(poly1,poly2,num);	
	} 
	
	

	public int[][] multiply(char poly1, char poly2){
		check4=1;
		if(list_R.head!=null)
			list_R.clear();
		int num=3;int[][] m;
		m=choice(poly1,poly2,num);
		clearPolynomial('R');
		setPolynomial('R',m);
		return listtoarray(list_R)	;	
	} 
	}
