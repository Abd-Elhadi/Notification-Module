import java.io.*;
import java.util.Scanner;

public class Template {
    File templates = new File("templates.txt");
    FileWriter myWriter = new FileWriter("templates.txt");
    String line = new String();


    public Template() throws IOException {
        myWriter.write("Language - Type - Content\n");
        myWriter.close();
    }


    public String getContent(String templateName) throws IOException {
        String type,content,language;
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
        String type,content,language;
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

    public static void main(String[] args) throws IOException {
        Template t= new Template();
        t.addTemplate("English","what ? ","gppd");
        t.addTemplate("arabic","gfref? ","وبحبايبكم اما الحب يا روحي عليه");
        t.addTemplate("english","okat" , "gdfg g");
        System.out.println(t.getContent("okat"));

    }
}
