package co;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class EmployeeSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  List<Employee> data = readCsvData("us-500.csv");
		  List<Employee> e2 =SortList(data);
		  for(Employee e3:e2)
		  {
				System.out.println(e3.getFirst_Name());

		  }
		  SortNewyork(data);
			
	}

	private static List<Employee> readCsvData (String fileName)
	{
		 List<Employee> data = new ArrayList<>();
    Path pathToFile = Paths.get(fileName);
     try (BufferedReader br = Files.newBufferedReader(pathToFile,StandardCharsets.US_ASCII)) {
        String line = br.readLine();
        while (line != null) {
            String[] field = line.split(",");
               Employee row = new Employee(field[0],field[1],field[2],field[3],field[4],field[5],field[6],field[7],field[8],field[9],field[10],field[11]);           
            data.add(row);
            line = br.readLine();
        }

    } catch (IOException ioe) {
        ioe.printStackTrace();
    }
   return data;
 	}
     public static List<Employee> SortList(List<Employee> e )
 	{
 		
 		for(int i=0;i<e.size()-1;i++)
 		{
 			for(int j=i+1;j<e.size()-1;j++)
 			{
 				if(e.get(i).getFirst_name().compareTo(e.get(j).getFirst_name())>0)
 				{
 					 Collections.swap(e,i,j);
 					
 				}
 			}
 		}
 		return e;
 	}
 	
 		public static void SortNewyork(List<Employee> e1)
 		{
 			for(Employee f:e1)
 			{
 				if(f.getCity().equals("\"New York\""))

 						{
 					System.out.println(f.getFirst_name()+" "+f.getLast_name()+" "+f.getCity());

 						}
 			}
 		}
}
     
     
     
     
 