import java.io.*;
import java.util.ArrayList;

public class Template {
    File templates = new File("templates.txt");
    FileWriter myWriter = new FileWriter("templates.txt");


    public Template() throws IOException {
        myWriter.write("Language - Type - Content\n");
        myWriter.close();
    }

    public ArrayList<String> getTypes() throws IOException {
        String line;
        ArrayList<String> types = new ArrayList<String>();
        FileReader file = new FileReader("templates.txt");
        BufferedReader br = new BufferedReader(file);
        while ((line = br.readLine())!= null){
            String[] data = line.split(" - ");
            types.add(data[1]);
        }
        return types;
    }
    public String getContent(String templateName) throws IOException {
        String type,content,language,line;
        FileReader file = new FileReader("templates.txt");
        BufferedReader br = new BufferedReader(file);
        while ((line = br.readLine())!= null){
            String[] data = line.split(" - ");
            language = data[0];
            type = data[1];
            content = data[2];
            if (templateName.equalsIgnoreCase(type))return content;

        }

        return "NOT FOUND";
    }

    public void addTemplate(String Language , String templateName , String content) throws IOException {
        myWriter = new FileWriter("templates.txt",true);
        myWriter.write(Language+" - "+templateName+" - " + content);
        myWriter.write("\n");
        myWriter.close();



    }

    public void removeTemplate(String templateName) throws IOException {
        File tempFile= new File("tempFile.txt");
        FileWriter tempWriter = new FileWriter("tempFile.txt");
        String type,content,language,line;
        FileReader file = new FileReader("templates.txt");
        BufferedReader br = new BufferedReader(file);
        while ((line = br.readLine())!= null){
            String[] data = line.split(" - ");
            language = data[0];
            type = data[1];
            content = data[2];
            if (!(templateName.equalsIgnoreCase(type))) {
                tempWriter.write(language+" - "+templateName+" - " + content);
                tempWriter.write("\n");
            }

        }
        br.close();
        tempWriter.close();

        if (!templates.delete())
                System.out.println("Could not delete file");


        if (!tempFile.renameTo(templates))
            System.out.println("Could not rename file");



    }

}
