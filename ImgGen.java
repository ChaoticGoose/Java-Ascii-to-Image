import java.io.*;
class ImgGen
{
	public static void main(String[] argv)
	{
			//reader to read from standard input
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//read first line from standard input
			//Should be two integer numbers, separated by a space
		String[] input;
		
		try
		{
			input = reader.readLine().split(" ");
		}
		catch(IOException e)
		{
			System.out.println("Error reading line 0");
			return;
		}  
		
			//should be two inputs on this line
		if(input.length != 2)
		{
			System.out.println("First line of input should be Length of longest line of text, and the number of lines to expect");
			return;
		}
		
		int width = 0;
		int height = 0;
			//parse the width and height for later use
		try
		{
			width = Integer.parseInt(input[0]);
			height = Integer.parseInt(input[1]);
		}
		catch(NumberFormatException e)
		{
			System.out.println("Invalid number on line 0");
			return;
		}

			//read height lines from standard input
		for(int i = 1; i<=height; i++)
		{
			String line;
			
			try
			{
				line = reader.readLine();
			}
			catch(IOException e)
			{
				System.out.println("Error reading line " + i);
				return;
			}
			
			if(line.length() > width)
			{
				System.out.println("Line " + i + " is too long, length is " + line.length() + " Should be no more than " + width);
				return;
			}
			//to ensure that lines are read properly, echo the line to standard output
			System.out.println(line);
		}
			//parse as an integer.
		//int n = Integer.parseInt(input);
			//write to standard output
		//System.out.println(input);
  }
}
