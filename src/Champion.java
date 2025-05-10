import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Champion {
    private String champion;
    private String gender;
    private String position;
    private String species;
    private String resource;
    private String range;
    private String regions;
    private String skins;
    private Set<String> positions;
    private static final int MATCH = 0;
    private static final int PARTIAL = 1;
    private static final int NO_MATCH = 2;

    public Champion(String Champ, String Gender, String Position, String Species, String Resource, String Range, String Region, String Skin){
        this.champion = Champ;
        this.gender = Gender;
        this.position = Position;
        this.species = Species;
        this.range = Range;
        this.regions = Region;
        this.skins = Skin;
        this.resource = Resource;
        positions = new HashSet<>(Arrays.asList(position.split("\\s*,\\s*")));
    }
    @Override
    public String toString() {
        return champion + " " + gender + " " + position + " " + species + " "
                + resource + " " + range + " " + regions + " " + skins;
    }


    public static void main (String[] args){

    }
    public int[] check(Champion newChamp) {
        int[] checked = new int[8];

        // Local variables for newChamp's attributes
        String newChampion = newChamp.getChampion();
        String newGender = newChamp.getGender();
        String newPosition = newChamp.getPosition();
        String newResource = newChamp.getResource();
        String newRange = newChamp.getRange();
        String newRegions = newChamp.getRegions(); // Updated to String
        String newSkins = newChamp.getSkins(); // Skins is a String

        // Compare Champion got ? MATCH : NO_MATCH and trim from chatgpt
        checked[0] = newChampion.trim().equals(champion) ? MATCH : NO_MATCH;

        // Compare Gender
        checked[1] = newGender.trim().equals(gender.trim()) ? MATCH : NO_MATCH;

        // (Asked chatgpt how to do this since I wasn't too sure how to compare the values of a string seperated by commas)
        checked[2] = (checkPositionMatch(newChamp.getPosition(), position));

        // Compare Species (use retainAll for species, since it's a Set<String>)
        checked[3] = compareSpecies(newChamp);

        // Compare Resource
        checked[4] = newResource.trim().equals(resource) ? MATCH : NO_MATCH;

        // Compare Range
        checked[5] = newRange.trim().equals(range) ? MATCH : NO_MATCH;

        // Compare Regions (direct String comparison)
        checked[6] = newRegions.trim().equals(regions) ? MATCH : NO_MATCH;

        // Compare Skins (updated to string comparison)
        checked[7] = newSkins.trim().equals(skins) ? MATCH : NO_MATCH;

        return checked;
    }
    public String[] getAttributes() {
        return new String[] {
                champion,
                gender,
                position,
                species,
                resource,
                range,
                regions,
                skins
        };
    }
    public String getRace() {
        return species.contains("(")
                ? species.replaceAll("\\s*\\(.*\\)", "").toLowerCase().trim()
                : (species.contains(")") ? "" : species.toLowerCase().trim()); // if it's just a trait, race is empty
    }

    public String getTrait() {
        return species.contains("(")
                ? species.replaceAll(".*\\((.*)\\).*", "$1").toLowerCase().trim()
                : (species.contains(")") ? species.toLowerCase().trim() : ""); // if it's just a trait
    }

    public int checkPositionMatch(String position1, String position2) {
        // Split both positions by commas and trim any whitespace around the words
        String[] words1 = position1.split(",");
        String[] words2 = position2.split(",");

        // Trim extra spaces for each word
        for (int i = 0; i < words1.length; i++) {
            words1[i] = words1[i].trim();
        }

        for (int i = 0; i < words2.length; i++) {
            words2[i] = words2[i].trim();
        }

        // Check for full match (all words in position1 match all words in position2)
        boolean fullMatch = true;
        for (String word1 : words1) {
            boolean wordMatch = false;
            for (String word2 : words2) {
                if (word1.equalsIgnoreCase(word2)) {
                    wordMatch = true;
                    break;
                }
            }
            if (!wordMatch) {
                fullMatch = false;
                break;
            }
        }

        // If full match, return 0
        if (fullMatch) {
            return MATCH;
        }

        // Check for partial match (at least one word from position1 matches one word from position2)
        for (String word1 : words1) {
            for (String word2 : words2) {
                if (word1.equalsIgnoreCase(word2)) {
                    return PARTIAL;  // Partial match found
                }
            }
        }

        // If no match found, return 2
        return NO_MATCH;
    }


    // Got from gpt helps me seperate out the parenthesis to compare the species
    public int compareSpecies(Champion other) {
        String race1 = this.getRace();
        String trait1 = this.getTrait();
        String race2 = other.getRace();
        String trait2 = other.getTrait();

        boolean raceMatch = !race1.isEmpty() && race1.equals(race2);
        boolean traitMatch = !trait1.isEmpty() && trait1.equals(trait2);

        if (raceMatch && traitMatch) {
            return 0;
        } else if (raceMatch || traitMatch) {
            return 1;
        } else {
            return 2;
        }
    }


    public String getChampion(){
        return champion;
    }

    public Set<String> getPositions() {
        return positions;
    }

    public String getGender() {
        return gender;
    }

    public String getPosition() {
        return position;
    }

    public String getRange() {
        return range;
    }

    public String getRegions() {
        return regions;
    }

    public String getResource() {
        return resource;
    }

    public String getSkins() {
        return skins;
    }

    public String getSpecies() {
        return species;
    }
}
