package iot;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Making_ino {
	private static Scanner x;
	public static void editRecord(String filepath,String editTerm,String newId)
	{
		String tempFile ="temp.txt";
		File oldFile =new File(filepath);
		File newFile = new File(tempFile);
		String ID = "";
		try
		{
			FileWriter fw = new FileWriter(tempFile,true);//the true is for adding things and not deleting the info
			BufferedWriter	bw = new BufferedWriter(fw);
			PrintWriter pw= new PrintWriter(bw);
			x= new Scanner(new File(filepath));
			x.useDelimiter("[,\n]");
			
			while(x.hasNext())
			{ID = x.next();
			if (ID.equals(editTerm))
			{
				pw.println(newId +",");
			}
			else
			{
				pw.println(ID+ ",");
			}
				
			}
			x.close();
			pw.flush();
			pw.close();
			oldFile.delete();
			File dump = new File(filepath);
			newFile.renameTo(dump);
		}
		catch(Exception e)
		{
			System.out.println("Error");
		}
	}
}