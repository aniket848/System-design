
import java.util.ArrayList;
import java.util.List;

// for saving file in diff platform
interface Persistence{
    public void save();
}

class DBSave implements Persistence{

    @Override
    public void save() {
        System.out.println("Document is saved in MYSQL DB");
    }
}

class FileSave implements Persistence{
    @Override
    public void save() {
        System.out.println("Document is saved in file.txt");
    }
}


// To store different type of element in document and which have their own render function
interface DocumentElement{
    public String render();
}

class TextElement implements DocumentElement{
    private String text;

    TextElement(String text){
        this.text = text;
    }

    @Override
    public String render() {
        return text;
    }
}

class ImageElement implements DocumentElement{
    private String fileName;

    ImageElement(String name){
        this.fileName = name;
    }

    @Override
    public String render() {
        return "[path: " + fileName + "]";
    }
}

class nextLine implements DocumentElement{
    @Override
    public String render() {
        return "\n";
    }
}

class tabSpace implements DocumentElement{
    @Override
    public String render() {
        return "\t";
    }
}


class Document {

    private List<DocumentElement> documentElements;

    Document(){
        documentElements = new ArrayList<>();
    }

    void addElement(DocumentElement ele){
        documentElements.add(ele);
    }

    List<DocumentElement> getAllElemnent(){
        return documentElements;
    }

    String render(){
        StringBuilder res = new StringBuilder();
        for(DocumentElement ele:documentElements){
            res.append(ele.render());
        }
        return res.toString();
    }
}

class DocumentEditor{

    private Document doc;
    private Persistence pc;

    DocumentEditor(Document doc, Persistence pc){
        this.doc = doc;
        this.pc = pc;
    }

    void addImage(String imageName){
         doc.addElement(new ImageElement(imageName));
    }

    void addText(String Text){
        doc.addElement(new TextElement(Text));
    }

    void addNewLine(){
        doc.addElement(new nextLine());
    }

    void addTabSpace(){
        doc.addElement(new tabSpace());
    }

    void saveDoc(){
        pc.save();
    }

    String renderDoc(){
        return doc.render();
    }

}

public class Client{
    public static void main(String[] args) {

        Document doc = new Document();
        Persistence pc = new DBSave();

        DocumentEditor docEditor = new DocumentEditor(doc,pc);

        // simulate a client doing its operations
        docEditor.addText("Hi my name is Aniket Mehrotra");
        docEditor.addNewLine();
        docEditor.addText("This is my first system design project");
        docEditor.addNewLine();
        docEditor.addText("Path of the image I try to upload:");
        docEditor.addTabSpace();
        docEditor.addImage("kailashgiri.png");
        docEditor.addNewLine();
        docEditor.addText("KEEP IT UP!");

        System.out.println(docEditor.renderDoc());

        pc.save();
    }
}
