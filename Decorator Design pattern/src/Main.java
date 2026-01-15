interface Character{
    public String getAbilities();
}

class Mario implements Character{
    @Override
    public String getAbilities() {
       return "Mario";
    }
}

abstract class CharDecoratar implements Character{

    protected Character character;

    CharDecoratar(Character c){
        this.character = c;
    }
}

class HeightDecorator extends CharDecoratar{

    HeightDecorator(Character c){
        super(c);
    }

    @Override
    public String getAbilities() {
        return character.getAbilities() + " with increased height";
    }
}

class SpeedUpDecorator extends CharDecoratar{

    SpeedUpDecorator(Character c){
        super(c);
    }

    @Override
    public String getAbilities() {
        return character.getAbilities() + " with increased speed";
    }
}

class ImmuneDecorator extends CharDecoratar{

    ImmuneDecorator(Character c){
        super(c);
    }

    @Override
    public String getAbilities() {
        return character.getAbilities() + " with Immune booster";
    }
}

public class Main {
    public static void main(String[] args) {

        Character mario = new Mario();
        System.out.println("Basic qualities : "+mario.getAbilities());
        mario = new HeightDecorator(mario);
        System.out.println("Increased height : "+mario.getAbilities());
        mario = new SpeedUpDecorator(mario);
        System.out.println("Speed qualities : "+mario.getAbilities());
        mario = new ImmuneDecorator(mario);
        System.out.println("Immune qualities : "+mario.getAbilities());

        System.out.println("in total = "+ new ImmuneDecorator(new HeightDecorator(new Mario())).getAbilities());
    }
}