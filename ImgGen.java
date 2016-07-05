import java.io.*;
import java.awt.image.*;
import javax.imageio.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

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
		
			//set up the graphics object to draw the image on
			//assume that there is a margin of 1 character on each edge of the image
			//assume for not that each glyph is 10px by 10px
		BufferedImage canvas = new BufferedImage((width + 1) * 10, (height +1) * 10, BufferedImage.TYPE_INT_RGB);
		Graphics2D paper = canvas.createGraphics();

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
			
				//draw the string on the image
			paper.drawString(line, 10, 10*i);
		}
		
			//save the image to the output file "ImgGen.jpg"
		try
		{
			File outputfile = new File("ImgGen.jpg");
			ImageIO.write(canvas, "jpg", outputfile);
		}
		catch(IOException e)
		{
			System.out.println("Error while saving image");
		}
  }
}
