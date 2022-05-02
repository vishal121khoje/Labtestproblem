package SerializableExample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class StudentToFile {

	public static void main(String[] args) {
		try
		{
		Scanner s= new Scanner(System.in);
		System.out.println("enter name and age");
        String n= s.next();
        int rollno= s.nextInt();
		
       Student s1= new Student(n,rollno);
		 
        
         File r= new File("student.dat");
		 int length=(int) r.length();
	
		 
		 if(length >0)
		 { 
			 FileOutputStream f= new FileOutputStream("student.dat",true);
		 	 Appendable a= new Appendable(f);
			 a.writeObject(s1); //this will not write header info to file 
			 a.close();
		 }
			
		 else
		 {   
		 FileOutputStream f= new FileOutputStream("student.dat",true);
 		 ObjectOutputStream o= new ObjectOutputStream(f);
		 o.writeObject(s1); //calls writeStreamHeader ()
		 o.close();
		 }
		  
		 
		 	
			FileInputStream i= new FileInputStream("student.dat");
			
			ObjectInputStream oi= new ObjectInputStream( i );
		
			 do
				 {
				 s1=(Student)oi.readObject() ; //readObject return Object
				 s1.display();
				 }while(s1!=null);
	 
				 

		}catch(Exception r)
		{
		 
		}

	}

}
