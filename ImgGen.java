import java.io.*;
class ImgGen
{
  public static void main(String[] argv)
    throws IOException
  {
	//reader to read from standard input
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	//read a line from standard input
    String input = reader.readLine();
	//parse as an integer.
    int n = Integer.parseInt(input);
	//writeto standard output
    System.out.println(input);
  }
}
