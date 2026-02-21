package Model;

import Enums.Gender;

import java.util.ArrayList;
import java.util.List;

public class userProfile {
    private String name;
    private int age;
    private Location location;
    private String bio;
    private Gender gender;
    private List<String> hobbies;


    public userProfile(String name, int age, Location location, Gender gender){
        this.name = name;
        this.age = age;
        this.location = location;
        this.bio = "";
        this.hobbies = new ArrayList<>();
        this.gender = gender;
    }

    public void addHobbies(String hobby){
        hobbies.add(hobby);
    }

    public void addBio(String bio){
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "userProfile{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", location=" + location +
                ", bio='" + bio + '\'' +
                ", gender=" + gender +
                ", hobbies=" + hobbies +
                '}';
    }

    public void showProfile(){
        System.out.println("===== Profile =====");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.print("Gender: ");
        switch (gender) {
            case MALE:
                System.out.print("Male");
                break;
            case FEMALE:
                System.out.print("Female");
                break;
            case OTHERS:
                System.out.print("Other");
                break;
        }
        System.out.println();
        System.out.println("Bio: " + bio);
        System.out.println();
        System.out.print("Interests: ");
        for (String i : hobbies) {
            System.out.println(i);
        }
        System.out.println();
        System.out.println("Location: " + location.getLat() + ", " + location.getLon());
        System.out.println("===================");
        System.out.println();
    }

    public int getAge() {
        return age;
    }

    public Location getLocation() {
        return location;
    }

    public String getBio() {
        return bio;
    }

    public Gender getGender() {
        return gender;
    }

    public List<String> getHobbies() {
        return hobbies;
    }
}
