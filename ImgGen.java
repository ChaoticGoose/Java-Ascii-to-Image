import java.io.*;
class ImgGen
{
	public static void main(String[] argv)
		throws IOException
	{
			//reader to read from standard input
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//read first line from standard input
			//Should be two integer numbers, separated by a space
		String[] input = reader.readLine().split(" ");
		  
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

			//parse as an integer.
		//int n = Integer.parseInt(input);
			//write to standard output
		//System.out.println(input);
  }
}
