package eg.edu.alexu.csd.datastructure.linkedList.cs;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
	
		
		
	    PolynomialSolver polynomialSolver = new PolynomialSolver();
	      char poly;
        char poly1;
        float value;
        boolean a= false;
        boolean b = false;
        boolean c = false;
        boolean r = false;
        String str;
       int num;
        char ch='y';
        while (true) {
            Scanner scanner = new Scanner(System.in);
            do {
                System.out.println("Please Choose an action:\n");
                System.out.println("1- Set a polynomial variable\n");
                System.out.println("2- Print the value of a polynomial variable\n");
                System.out.println("3- Add two polynomials\n");
                System.out.println("4- Subtract two polynomials\n");
                System.out.println("5- Multiply two polynomials\n");
               System.out.println("6- Evaluate a polynomial at some point\n");
                System.out.println("7- Clear a polynomial variable\n");
                while(!scanner.hasNextInt()) {
                	String input = scanner.next();
                    System.out.printf("\"%s\" is not a valid choice.\n enter a correct number\n", input);
                	
                }
                  num = scanner.nextInt();
            }
            while (1>num||num>7);
            switch (num) {
                case 1:
                    do {
                        System.out.println("Insert the variable name : (A,B,C)\n ");
                        poly = scanner.next().toUpperCase().charAt(0);

                        switch (poly) {
                            case 'A':
                                if (a) {
                                    System.out.println("A is already set !\n Do you want replace it ? (y/n)");
                                    ch = scanner.next().toLowerCase().charAt(0);
                                    if (ch == 'y') {
                                        polynomialSolver.clearPolynomial('A');
                                    } else if (ch == 'n')
                                        break;
                                }
                                a = true;
                                break;
                            case 'B':
                                if (b) {
                                    System.out.println("B is already set !\n Do you want replace it ? (y/n)");
                                    ch = scanner.next().toLowerCase().charAt(0);
                                    if (ch == 'y') {
                                        polynomialSolver.clearPolynomial('B');
                                    } else if (ch == 'n')
                                        break;
                                }
                                b = true;
                                break;
                            case 'C':
                                if (c) {
                                    System.out.println("C is already set !\n Do you want replace it ? (y/n)");
                                    ch = scanner.next().toLowerCase().charAt(0);
                                    if (ch == 'y') {
                                        polynomialSolver.clearPolynomial('C');
                                    } else if (ch == 'n')
                                        break;
                                }
                                c = true;
                                break;
                        }
                    }
                    while (poly!='A'&&poly!='B'&&poly!='C');
                    if(ch!='n'){
                    System.out.println("Insert the polynomial terms in the form :\n (coeff1, exponent1), (coeff2, exponent2), ..\n ");
                    str = scanner.next();
                    int[][] terms=polynomialSolver.scan(str);
                    polynomialSolver.setPolynomial(poly, terms);
                    System.out.println("Polynomial " + poly + " is set\n");}
                    break;
                case 2:
                	if(a||b||c) {
                    do {
                        System.out.println("Insert the variable name : (A,B,C,R)\n ");
                        poly = scanner.next().toUpperCase().charAt(0);
                    }
                    while (!((poly=='A'&&a)||(poly=='B'&&b)||(poly=='C'&&c)||(poly=='R'&&r)));
                    System.out.println(polynomialSolver.print(poly));
                	}
                    break;
                	
                case 3:
                	if(a||b||c) {
                    do {
                        System.out.println("Insert two variables : (A,B,C)\n");
                        poly = scanner.next().toUpperCase().charAt(0);
                        poly1 = scanner.next().toUpperCase().charAt(0);
                    }

                    while (!((poly=='A'&&a)||(poly=='B'&&b)||(poly=='C'&&c))||!((poly1=='A'&&a)||(poly1=='B'&&b)||(poly1=='C'&&c)));
                    polynomialSolver.add(poly, poly1);
                    r=true;
                    System.out.println(poly+" + "+poly1+" is: "+polynomialSolver.print('R'));
                	}
                    break;
                case 4:
                	if(a||b||c) {
                    do {
                        System.out.println("Insert two variables : (A,B,C)\n");
                        poly = scanner.next().toUpperCase().charAt(0);
                        poly1 = scanner.next().toUpperCase().charAt(0);
                    }
                    while (!((poly=='A'&&a)||(poly=='B'&&b)||(poly=='C'&&c))||!((poly1=='A'&&a)||(poly1=='B'&&b)||(poly1=='C'&&c)));
                    polynomialSolver.subtract(poly, poly1);
                    r=true;
                    System.out.println(poly+" - "+poly1+" = "+polynomialSolver.print('R'));
                	}
                    break;
                case 5:if(a||b||c) {
                    do {
                        System.out.println("Insert two variables : (A,B,C)\n");
                        poly = scanner.next().toUpperCase().charAt(0);
                        poly1 = scanner.next().toUpperCase().charAt(0);
                    }
                    while (!((poly=='A'&&a)||(poly=='B'&&b)||(poly=='C'&&c))||!((poly1=='A'&&a)||(poly1=='B'&&b)||(poly1=='C'&&c)));
                    polynomialSolver.multiply(poly, poly1);
                    r=true;
                    System.out.println(poly+" * "+poly1+" is: "+polynomialSolver.print('R'));
                }
                    break;
                case 6:
                	if(a||b||c) {
                    do {
                        System.out.println("Insert the variable name : (A,B,C)\n");
                        poly = scanner.next().toUpperCase().charAt(0);
                    }
                    while (!((poly=='A'&&a)||(poly=='B'&&b)||(poly=='C'&&c)||(poly=='R'&&r)));
                    System.out.println("Insert your value :\n");
                    value = scanner.nextFloat();
                    System.out.println("The result is: "+polynomialSolver.evaluatePolynomial(poly, value));
                	}
                    break;
                case 7:
                	if(a||b||c) {
                    do {
                        System.out.println("Insert the variable name : (A,B,C,R)\n");
                        poly = scanner.next().toUpperCase().charAt(0);
                    }
                    while (!((poly=='A'&&a)||(poly=='B'&&b)||(poly=='C'&&c)||(poly=='R'&&r)));
                    polynomialSolver.clearPolynomial(poly);
                    if(poly=='A')
                    	a=false;
                    if(poly=='B')
                    	b=false;
                    if(poly=='C')
                    	c=false;
                    if(poly=='R')
                    	r=false;
                    System.out.println("Polynomial " + poly + " is cleared");
                	}
                    break;
                     

                    	
                    
            }

        }
	
	}	

}
