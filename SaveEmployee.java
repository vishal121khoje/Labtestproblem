package SerializableExample;
import java.io.*;

public class SaveEmployee {

	public static void main(String[] args)throws Exception
	{
		
		Employee e= new Employee("puja",23);
   
		
		// if we donot specify the path system will take current file path
		FileOutputStream f= new FileOutputStream("emp.dat");

		ObjectOutputStream o= new ObjectOutputStream( f );

		o.writeObject( e);  //NotSerializable Exception
		
		o.close();

		
		
		// to read data from file 
		
		FileInputStream i= new FileInputStream("emp.dat");
		
		ObjectInputStream oi= new ObjectInputStream( i );
		
		//convert binary to object 
		// deserialization 
		Employee k=(Employee)  oi.readObject(); //readObject return Object
		
		k.display();
		
 
		
		
		}
		
		
	}

}
