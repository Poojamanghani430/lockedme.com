import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class LockedMe {
	
	static final String errorMessage = " There is some error";
	static final String projectFilesPath= "/Volumes/WorkSpace/pooja";

	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		
		int choice;
		
		do
		{
			showMenu();
			
			System.out.println("Enter your Choice");
			
			choice=Integer.parseInt(scanner.nextLine());
			
			switch (choice)
            {
			case 1: getAllFiles();
			break;
			case 2: createFiles();
			break;
			case 3: deleteFiles();
			break;
			case 4: searchFiles();
			break;
			case 5: System.exit(0);
			break;
			
			default:
				System.out.println("Choose valid option");
				break;
			}
		}
		
		while(choice>0);
		
		scanner.close();
		}
	
	public static void showMenu()
	{
		System.out.println("----------------------------------\n");
		System.out.println("\t\t1. Display All the files");
		System.out.println("\t\t2. Add a new file");
		System.out.println("\t\t3. Delete a file");
		System.out.println("\t\t4. Search a file");
		System.out.println("\t\t5. Exit");
		
	}
	
	public static void getAllFiles()
	{
		try
		{
			File folder=new File(projectFilesPath);
			
			File[] listOfFiles= folder.listFiles();
			
			if(listOfFiles.length==0)
				
				System.out.println("There is no file in the Directory");
			
			else 
			{
				for(var l: listOfFiles)
				{
					System.out.println(l.getName());
				}
			}
		}
		catch (Exception e)
		{
			System.out.println(errorMessage);
			
		}
	}
	public static void createFiles()
	{
		try
		{
		 Scanner scanner = new Scanner(System.in);
		 
		 String fileName;
		 
		 System.out.println("Enter file name: ");
		 
		 fileName=scanner.nextLine();
		 
		 int linesCount;
		 
		 System.out.println("Enter how many lines in the file: ");
		 
		 linesCount= Integer.parseInt(scanner.nextLine());
		 
		 FileWriter fw = new FileWriter(projectFilesPath+ "\\"+fileName);
		 
		 for(int i=1; i<=linesCount; i++)
		 {
			 System.out.println("Enter the file line :");
			 
			 fw.write(scanner.nextLine()+"\n");
		 }
		 System.out.println("File successfully created.");
		 
		 fw.close();
		 
		 scanner.close();
		}
		catch (Exception e) 
		{
			System.out.println(errorMessage);
		}
		
	}
	public static void deleteFiles()
	{
		Scanner sc=new Scanner(System.in);
		
		try
		{
			
			String fileName;
			
			System.out.println("Enter the file name to be deleted");
			
			fileName=sc.nextLine();
			
			File file = new File(projectFilesPath+"\\"+ fileName);
			
			if(file.exists())
			{
				file.delete();
				
				System.out.println("File deleted successfully : "+fileName);
			}
			else
			{
				System.out.println("file does not exist.");
			}
		}
			catch (Exception e) 
			{
				System.out.println(errorMessage);
			}
			finally
			{
				sc.close();
			}
	    }
			public static void searchFiles()
			{
				Scanner sc = new Scanner(System.in);
				
				try
				{
					String fileName;
					
					System.out.println("Enter the file name to be searched");
					
					fileName = sc.nextLine();
					
					File folder = new File(projectFilesPath);
					
					File[] listOfFiles = folder.listFiles();
					
					LinkedList<String> fileNames=new LinkedList<String>();
					
					for (var l: listOfFiles)
						
						fileNames.add(l.getName());
					
					if (fileNames.contains(fileName))
						
						System.out.println("File is available");
					else
						System.out.println("file is not available");
		
				}
				catch (Exception e) 
					{
						System.out.println(errorMessage);
					}
					finally 
					{
						sc.close();
					}
				}
		}
				
			
					
			


