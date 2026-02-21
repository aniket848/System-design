package Model;

import Enums.Gender;

import java.util.ArrayList;
import java.util.List;

public class userPreference {

    private int minAge;
    private int maxAge;
    private Gender interesetGender;
    private List<String> interests;
    private Double maxDistance;

    public userPreference(int minAge, int maxAge, Gender gender, Double dist){
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.interesetGender = gender;
        this.maxDistance = dist;
        interests = new ArrayList<>();
    }

    public void addInterest(String interest){
        interests.add(interest);
    }

    public Boolean isAgeEligible(int age){
        return age >= minAge && age <= maxAge;
    }

    public Boolean isInterestedInGender(Gender g){
        return interesetGender == g;
    }

    public Boolean isInterestedInCommonInterests(List<String> commonInterests){
        for(String interest : commonInterests){
            if(interests.contains(interest)){
                return true;
            }
        }
        return false;
    }

     public Boolean isWithinDistance(Double distance){
        return distance <= maxDistance;
    }

    public int getMinAge() {
        return minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public Gender getInteresetGender() {
        return interesetGender;
    }

    public List<String> getInterests() {
        return interests;
    }

    public Double getMaxDistance() {
        return maxDistance;
    }
}
