import java.io.*;

public class Main {
    public static void main(String[] args) {
        String in= "input.txt";
        String out = "output.txt";
        try {
            FileReader fileReader = new FileReader(in);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter(out);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedReader.close();
            bufferedWriter.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }catch(IOException e){
            System.out.println("I/O exception");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}