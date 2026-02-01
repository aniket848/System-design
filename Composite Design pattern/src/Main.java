import java.util.ArrayList;
import java.util.List;

interface IFileSystem{
    public void ls(Integer indent);
    public void openAll(Integer indent);
    public Integer getSize();
    public IFileSystem cd(String name);
    public String getName();
    public boolean isFolder();
}

class fileSystem implements IFileSystem{

    private String name;
    private Integer size;

    public fileSystem(String name, Integer size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void ls(Integer indent) {
        String spaces = " ".repeat(indent);
        System.out.println(spaces + name);
    }

    @Override
    public void openAll(Integer indent) {
        String spaces = " ".repeat(indent);
        System.out.println(spaces + name);
    }

    @Override
    public Integer getSize() {
        return size;
    }

    @Override
    public IFileSystem cd(String name) {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isFolder() {
        return false;
    }
}

class FolderSystem implements IFileSystem{

    private String name;
    private List<IFileSystem> folderStructure;

    public FolderSystem(String name){
        this.name = name;
        folderStructure = new ArrayList<>();
    }

    public void addComponent(IFileSystem fileSystem){
        folderStructure.add(fileSystem);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void ls(Integer indent) {
        System.out.println(name + ":");
        String spaces = " ".repeat(indent+4);
        for(IFileSystem fs:folderStructure){
             if(fs.isFolder()){
                 System.out.println(spaces + "+" + fs.getName());
             }
             else{
                 System.out.println(spaces + fs.getName());
             }
        }//for
    }

    @Override
    public void openAll(Integer indent) {
        String spaces = " ".repeat(indent);
        System.out.println(spaces + "+" + name + " :");
        for(IFileSystem fs:folderStructure){
            fs.openAll(indent + 4);
        }
    }

    @Override
    public Integer getSize() {
        Integer size = 0;
        for(IFileSystem fs:folderStructure){
            size+= fs.getSize();
        }
        return size;
    }

    @Override
    public IFileSystem cd(String name) {
        for(IFileSystem fs:folderStructure){
            if(fs.isFolder() && fs.getName().equals(name)){
                System.out.println("Changed directory to: " + fs.getName());
                return fs;
            }
        }

        return null;
    }

    @Override
    public boolean isFolder() {
        return true;
    }
}


public class Main {
    public static void main(String[] args) {

        FolderSystem root = new FolderSystem("root");
        fileSystem file1 = new fileSystem("file1.txt",5);
        fileSystem file2 = new fileSystem("file2.txt",3);
        root.addComponent(file1);
        root.addComponent(file2);

        FolderSystem utils = new FolderSystem("utils");
        fileSystem file3 = new fileSystem("timestamp.txt",7);
        utils.addComponent(file3);

        FolderSystem images = new FolderSystem("images");
        fileSystem file4 = new fileSystem("image1.png",15);
        fileSystem file5 = new fileSystem("image2.jpg",25);
        images.addComponent(file4);
        images.addComponent(file5);

        root.addComponent(utils);
        root.addComponent(images);

        root.ls(0);
        root.openAll(0);
        root.getSize();

        IFileSystem newFolder = root.cd("images");
        newFolder.ls(0);
        newFolder.getSize();

    }
}