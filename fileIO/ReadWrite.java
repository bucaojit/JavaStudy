package fileIO;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.*;


public class ReadWrite {
  private final static String prefix = System.getProperty("user.home") + "/toRead";
  private final static String filename = "helloWorld";
  
  public static void main(String[] args) {   
    Path path = Paths.get(prefix + "/" + filename);

    // Writing and creating
    try (OutputStream out = new BufferedOutputStream(
      Files.newOutputStream(path, CREATE, APPEND))) {
      String s = "Writings 123\n";
      byte data[] = s.getBytes();
      out.write(data, 0, data.length);
    } catch (IOException x) {
      System.err.println(x);
    }
    
    Charset charset = Charset.forName("US-ASCII");
    try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    } catch (IOException x) {
        System.err.format("IOException: %s%n", x);
    }
    
        
    // Another way to write
    try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path.toString(),true)))) {
      String line = "This is the String to write\n";
      out.println(line);
    } catch (IOException x) {
      System.err.format("IOException: %s%n", x);
    }
     
    
  }

}
