import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVFormat;
import java.util.List;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.Reader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.Writer;


import com.google.gson.Gson;

public class JarJarBinks {
    public static void main(String[] args) {
        List<StarWarsCharacter> charactersList = new ArrayList<>();

        try {
            // File to read data from
            Reader in = new FileReader("characters.csv");
            // CSV parser from Apache Commons CSV
            CSVFormat CSVparser = CSVFormat.Builder.create().setHeader().build();
            // We have seen the use of Iterable earlier to iterate through
            // the data stored within a class.
            // In this case, the Apache Commons CSV creates an instance that
            // holds all the CSV rows, and we iterate through them one by one
            Iterable<CSVRecord> records = CSVparser.parse(in);

            
            for (CSVRecord record : records) {
                StarWarsCharacter character = new StarWarsCharacter();

                //System.out.println(record.get("name"));
                character.setName(record.get("name")); 
                character.setHeight(record.get("height")); 
                character.setMass(record.get("mass")); 
                character.setHairColor(record.get("hair_color")); 
                character.setSkinColor(record.get("skin_color")); 
                character.setEyeColor(record.get("eye_color")); 
                character.setBirthYear(record.get("birth_year")); 
                character.setGender(record.get("gender")); 
                character.setHomeWorld(record.get("homeworld")); 
                character.setSpecies(record.get("species")); 
                //System.out.print(character.toString());
                charactersList.add(character);
            }
        } catch (IOException e) {
            // handle the exception appropriately
            e.printStackTrace();
        }
        
    
        
        
        try {
            // I have used a FileWriter here, but you can use something else too
            Writer out = new FileWriter("characters.json");
            
            // For use of GSON, refer to their user guide
            Gson gson = new Gson();
            gson.toJson(charactersList, out);
            out.close();
        } catch (IOException e) {
            // handle the exception appropriately
            e.printStackTrace();
        }
    }
}



// TODO: Add JavaDoc comments

class StarWarsCharacter {
    String name = "";
    String height = "";
    String mass = "";
    String hairColor = "";
    String skinColor = "";
    String eyeColor = "";
    String birthYear = "";
    String gender = "";
    String homeworld = "";
    String species = "";

    StarWarsCharacter(){ }

    // additional constructors go here

    // getters and setters go here
    public void setName(String name){
        this.name = name;
    }
    public void setHeight(String height){
        this.height = height;
    }
    public void setMass(String mass){
        this.mass = mass;
    }
    public void setHairColor(String hairColor){
        this.hairColor = hairColor;
    }
    public void setSkinColor(String skinColor){
        this.skinColor = skinColor;
    }
    public void setEyeColor(String eyeColor){
        this.eyeColor = eyeColor;
    }
    public void setBirthYear(String birthYear){
        this.birthYear = birthYear;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public void setHomeWorld(String homeWorld){
        this.homeworld = homeWorld;
    }
    public void setSpecies(String species){
        this.species = species;
    }


    public String getName(){
        return this.name;
    }
    public String getHeight(){
        return this.height;
    }
    public String getMass(){
        return this.mass;
    }
    public String getHairColor(){
        return this.hairColor;
    }
    public String getSkinColor(){
        return this.skinColor;
    }
    public String getEyeColor(){
        return this.eyeColor;
    }
    public String getBirthYear(){
        return this.birthYear;
    }
    public String getGender(){
        return this.gender;
    }
    public String getHomeWorld(){
        return this.homeworld;
    }
    public String getSpecies(){
        return this.species;
    }

    // toString to print character info.
    public String toString() {
        return getName( ) + getHomeWorld() + "\n";
    }
}

