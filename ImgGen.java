import java.io.*;
import java.awt.image.*;
//import java.awt.Font;
import javax.imageio.*;
//import java.awt.Color;
//import java.awt.Graphics2D;
import java.awt.geom.*;
import java.awt.*;
//import java.awt.image.BufferedImage;

class ImgGen
{
		//these values are a best guess for the system default font width and height
	final static int CHAR_WIDTH = 37;
	final static int CHAR_HEIGHT = 25;
	
	final static Color[] BACKGROUNDS = 
		{
			Color.blue,
			Color.green,
			Color.orange,
			Color.red,
			Color.yellow,
			Color.cyan,
			Color.magenta,
			Color.pink
		};
	
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
		BufferedImage canvas = new BufferedImage(width * CHAR_WIDTH, height* CHAR_HEIGHT + (CHAR_HEIGHT/3), BufferedImage.TYPE_INT_RGB);
		Graphics2D paper = canvas.createGraphics();
		Font imageFont = new Font("Consolas", Font.PLAIN, 20);
		paper.setFont(imageFont);

		
			//included to find the width and height of a character for the selected font.
		//Rectangle2D rect = imageFont.getMaxCharBounds(paper.getFontRenderContext());
		//int CharWidth = (int)rect.getWidth();
		//int CharHeight = (int)rect.getHeight();
		//System.out.println("Char Width: " + CharWidth + " Char Height: " + CharHeight);
		
		paper.setPaint(Color.gray);
			//draw different colored rows onto the image
		Rectangle rect = new Rectangle(canvas.getWidth(), CHAR_HEIGHT/6);
		paper.fill(rect);
		
		rect.setLocation(0, CHAR_HEIGHT/6);
		rect.setSize(canvas.getWidth(),CHAR_HEIGHT);
		
		for(int i = 0; i<height; i++)
		{
			paper.setPaint(BACKGROUNDS[i%BACKGROUNDS.length]);
			paper.fill(rect);
			rect.setLocation(0, (int)rect.getY() + CHAR_HEIGHT);
		}
		
		paper.setPaint(Color.gray);
		paper.fill(rect);

	paper.setPaint(Color.black);
			//read height lines from standard input
		for(int i = 0; i<height; i++)
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
			//paper.drawString(line, CHAR_WIDTH, (i + 1) * CHAR_HEIGHT);
			DrawString(i*CHAR_HEIGHT + CHAR_HEIGHT, CHAR_WIDTH, line, paper);
		}
		
			//save the image to the output file "ImgGen.jpg"
		try
		{
			File outputfile = new File("ImgGen.png");
			ImageIO.write(canvas, "png", outputfile);
		}
		catch(IOException e)
		{
			System.out.println("Error while saving image");
		}
  }
  
	static void DrawString(int y, int x, String string, Graphics2D paper)
	{
			//split the string into individual characters
		String[] chars = string.split("");
			//print each character at the "Correct" location
		for(int i = 0; i< chars.length; i++)
		{
			paper.drawString(chars[i], x * i + CHAR_WIDTH / 4, y);
		}
	}
}
