package org.example;

interface Cloneable{
    Cloneable clone();
}

class Enemy implements Cloneable{

    private String name;
    private int health;
    private int attackPower;
    private String gender;

    public Enemy(String name, int health, int attack, String gender){

        // suppose that if we create object using constructor, that would be a complex method
        // with too many DB calls.
        System.out.println("DB call to create Enemy: " + name);
        this.name = name;
        this.health = health;
        this.attackPower = attack;
        this.gender = gender;
    }

    public Enemy(Enemy other){
        name = other.name;
        health = other.health;
        attackPower = other.attackPower;
        gender = other.gender;
        System.out.println("Cloning Enemy: " + name);
    }


    @Override
    public Cloneable clone() {
        return new Enemy(this);
    }
    public void describe(){
        System.out.println("Enemy: " + name + ", Health: " + health + ", Attack Power: " + attackPower +
                " Gender:" + gender);
    }

    // generate setters

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}



public class Main {
    public static void main(String[] args) {

        Enemy e1 = new Enemy("Goblin",50,100,"Male");

        e1.describe();

        Enemy e2 = (Enemy) e1.clone();

        System.out.println("same enmey clone without any changing value");
        e2.describe();

        Enemy e3 = (Enemy) e1.clone();
        e3.setName("Laila");
        e3.setGender("Female");

        e3.setHealth(22);

        System.out.println("same enmey clone with some changing value");
        e3.describe();

    }
}