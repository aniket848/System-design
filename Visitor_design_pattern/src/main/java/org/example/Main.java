package org.example;

abstract class IElement{
    private String name;

    public IElement(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public abstract void accept(IVisitor visitor);
}

class TextElement extends IElement{

    private String text;
    private String name;

    public TextElement(String name, String content){
        super(name);
        this.text = content;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}

class ImageElement extends IElement{

    private String text;
    private String name;
    private IVisitor visitor;

    public ImageElement(String name, String content){
        super(name);
        this.text = content;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}

class FileElement extends IElement{

    private String text;
    private String name;
    private IVisitor visitor;

    public FileElement(String name, String content){
        super(name);
        this.text = content;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}

interface IVisitor{
    void visit(TextElement element);
    void visit(ImageElement element);
    void visit(FileElement element);
}


class sizeVisitor implements IVisitor {

    @Override
    public void visit(TextElement element) {
        System.out.println("Size of text element: " + element.getName());
    }

    @Override
    public void visit(ImageElement element) {
        System.out.println("Size of image element: " + element.getName());
    }

    @Override
    public void visit(FileElement element) {
        System.out.println("Size of file element: " + element.getName());
    }
}

class compressVisitor implements IVisitor{

    @Override
    public void visit(TextElement element) {
        System.out.println("Compressing text element: " + element.getName());
    }

    @Override
    public void visit(ImageElement element) {
        System.out.println("Compressing image element: " + element.getName());
    }

    @Override
    public void visit(FileElement element) {
        System.out.println("Compressing file element: " + element.getName());
    }
}

class scanVisitor implements IVisitor{

    @Override
    public void visit(TextElement element) {
        System.out.println("Scanning text element: " + element.getName());
    }

    @Override
    public void visit(ImageElement element) {
        System.out.println("Scanning image element: " + element.getName());
    }

    @Override
    public void visit(FileElement element) {
        System.out.println("Scanning file element: " + element.getName());
    }
}


public class Main {
    public static void main(String[] args) {

        IElement file1 = new FileElement("file 1", "This is file 1");
        IElement image1 = new ImageElement("image 1", "This is image 1");

        file1.accept(new sizeVisitor());
        file1.accept(new compressVisitor());

        image1.accept(new sizeVisitor());
        image1.accept(new scanVisitor());

    }
}