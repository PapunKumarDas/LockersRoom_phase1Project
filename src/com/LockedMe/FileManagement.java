package com.LockedMe;




import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FileManagement {
	
public static int Filemenu(){
		
		// TODO Auto-generated method stub
Scanner in= new Scanner(System.in);
System.out.println("               *****************LockedMe.com ******************************" );
System.out.println("                 *******************FILE OPTION MENU***********************");
System.out.println("****************************************************************************");

    System.out.println("choose one of them: ");
    
System.out.println("1. Add a New Files in the  current directory");

System.out.println("2. Search a File from current directory");
System.out.println("3. Delete a file from current directory");
System.out.println("4. Back to main Menu");




System.out.println("*************************************************");


int choice=in.nextInt();




switch(choice) {
case 1:
	System.out.println(" Creating file:");
	creatingfiles  cf= new creatingfiles ();
	cf.create();

	break;




case 2:
	System.out.println(" File Details: ");
	 Fileinformation fi= new  Fileinformation ();
	fi.fileinfo();
	break; 

	
case 3:
	System.out.println(" Delete a File:");
	DeleteFile df= new DeleteFile();
	df.Delete();
	break;
	
case 4:
	Filemenu();
	break;
default:
                    System.out.println("invalid option choosed \n choose once again");
		
}
return choice;
}
}

//To show Files in a directory
class ShowallFiles {
          public void Show() {
              
			     
        int i;
              Scanner ch=new Scanner(System.in);

              
              System.out.println("press 1 if you want to search a file in current directory \npress 2 if you want to choose a another directory: ");
                           int choose=ch.nextInt();
              
              if(choose==1)
              {
                    File folder = new File(".");
            
            if(folder.isDirectory())
            {
                File[] fileList = folder.listFiles();
               
                //Arrays.sort(fileList);
                
                System.out.println("files present in this directory are :- "  );
                System.out.println();


			
             // Sort files by name
                Arrays.sort(fileList, new Comparator()
                {
                    @Override
                    public int compare(Object f1, Object f2) {
                        return ((File) f1).getName().compareTo(((File) f2).getName());
                    }
                });

               
                for(File file:fileList)
                {
                    System.out.println(" "+file.getName());
                    //System.out.println("*****************************************************************");  
                    
            }  
               
            }
              }
              else if(choose==2)
              {
                  Scanner scanner = new Scanner( System.in );
            System.out.println("Enter the file path: ");
            String dirPath = scanner.nextLine(); // Takes the directory path as the user input
            File folder = new File(dirPath);
           
            
            if(folder.isDirectory())
            {
                File[] fileList = folder.listFiles();
               
                //Arrays.sort(fileList);
                
                System.out.println("files present in this directory are :- "  );
                System.out.println();



			
             // Sort files by name
                Arrays.sort(fileList, new Comparator()
                {
                    @Override
                    public int compare(Object f1, Object f2) {
                        return ((File) f1).getName().compareTo(((File) f2).getName());
                    }
                });

               
                for(File file:fileList)
                {
                    System.out.println(" "+file.getName());
                    System.out.println("*****************************************************************");  
                    
            }  
               
            }
              }

              else
              {
                  System.out.println("incorrect option you choosed> \n Thank you");
              }
            
          
        }}

//delete file in current dir

class DeleteFile {
			 void Delete() {
				
			 
	  System.out.print("Enter the file Name (*extension*) which you Want to Delete : - ");
	  System.out.println("");
      

      Scanner input = new Scanner(System.in);
     
      File file = new File(input.nextLine());

    if (file.delete()) { 
    	System.out.println();
      System.out.println("		Deleted the file: " + file.getName());
    } else {
      System.out.println("		Failed to delete the file.\n(please Enter correct File name!)");
    } 
  } 
}
class Fileinformation {
				void fileinfo() {
					
				
	{
	
					 System.out.print("Enter the file name with (*extension*): ");
			            

			            Scanner input = new Scanner(System.in);

			            File file = new File(input.nextLine());

			          //  input = new Scanner(file);
                                  System.out.println("********************************");
                                  System.err.println("information about " +file+" is: ");
                                  System.out.println();
		System.out.println("Path: " + file.getAbsolutePath());
		System.out.println("Name: " + file.getName());
	
	
	}

	}
	
}


//reading file
class ReadFile {

	  
	public static void Read() {
		
	 {

	        try {
	            System.out.print("Enter the file name with (*extension*): ");
	            

	            Scanner input = new Scanner(System.in);

	          //  File file = new File(input.nextLine());
	            File file = new File(input.nextLine());
	            
//
	            input = new Scanner(file);
	            

	            while (input.hasNextLine()) {
	                String line = input.nextLine();
	                System.out.println();
	                //System.out.println("******************************************************************");
	                System.out.println();
	                System.out.println(line);
	            }
	            input.close();

	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	  
	}    


}}



//adding a new file

class creatingfiles {
void create() {
	{
		String p=setpath();
		try {
			write(p);
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		System.out.println("\n File created Successfully");}
		
	}
	static String setpath()
	{
		Scanner read=new Scanner(System.in);
		String path;
		System.out.println("Enter your File Name with  (*extention*):");
		return read.nextLine();
		
	}
	static void write(String path)throws Exception
	{
		Scanner sc= new Scanner(System.in);
		FileOutputStream fos=new FileOutputStream(path);
	}

}