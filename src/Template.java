import java.io.*;
import java.util.Scanner;

public class Template {
    File test = new File("templates.txt");
    FileWriter myWriter = new FileWriter("templates.txt");
    FileReader file = new FileReader("templates.txt");
    BufferedReader br = new BufferedReader(file);
    Scanner input = new Scanner((Readable) file);
    String line = new String();


    public Template() throws IOException {
        myWriter.write("Type - Content\n");
        myWriter.write("\n");
        myWriter.close();
    }


    public String getContent(String templateName) throws IOException {
        String type=new String();
        String content=new String();

        while ((line = br.readLine())!= null){
            String[] data = line.split(" - ");
            for (String d : data){
                type = data[0];
                content = data[1];
                if (templateName.equalsIgnoreCase(type))return content;
            }
        }

        return "";
    }

    public void addTemplate(String templateName , String content) throws IOException {
        myWriter = new FileWriter("templates.txt");
        myWriter.write(templateName+" - " + content);
        myWriter.write("\n");
        myWriter.close();



    }

    public void removeTemplate(String templateName){

    }

}
