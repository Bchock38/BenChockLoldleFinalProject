import java.util.Scanner;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;

public class Loldle {
private static String[][] tsvData;
private static String header;
private static Champion[] champpool;
private static Scanner Input = new Scanner(System.in);
    private static Random rand = new Random();
private static Map<String, Integer> champMap;
    public Loldle(){
    }



    public static void main (String[] args){
        readData();
        createChampionMap();
        System.out.println(header);
        int randomNum = rand.nextInt(170);
        game(1, randomNum);
//        for (Champion champion : champpool) {
//            System.out.println(champion);
//        }
    }
    public static void game (int guess, int randomNum){
        int[] currentStatus = new int[8];
        Champion randChamp = champpool[randomNum];
        System.out.println("Guess " + guess);
        System.out.println("Enter a Champion name: ");
        String inputName = Input.nextLine();
        if (!champMap.containsKey(inputName)){
            System.out.println("Misspelled");
            game(guess,randomNum);
        }
        int champ = champMap.get(inputName);
        currentStatus = randChamp.check(champpool[champ]);
        System.out.println(champpool[champ]);
        int right = arryToPrint(currentStatus);
        System.out.println();
        if(right == 0){
            System.out.println("Your right the campion was " + randChamp.getChampion());
        }
        else if (guess >= 7){
            System.out.println("Your out of guesses the champion was " + randChamp.getChampion());
        }
        else{
            game(guess+1,randomNum);
        }

    }


    public static int arryToPrint(int[] code) {
        System.out.print("      ");
        for (int i = 1; i < 8; i++){
            if (code[i] == 0){
                System.out.print("green");
            }
            else if (code[i] == 1){
                System.out.print("yellow");
            }
            else{
                System.out.print("red");
            }
            System.out.print(' ');
        }
        return code[0];
    }


    public static void readData() {
        String filePath = "C:\\Users\\Benjamin Chock\\IdeaProjects\\BenChockLoldleFinalProject\\Resources\\Loldle Charcter Data - Sheet1.tsv";
        tsvData = TSVReader.readTSV(filePath);

        champpool = new Champion[tsvData.length - 1]; // Skip header row

        for (int i = 1; i < tsvData.length; i++) {
            champpool[i - 1] = new Champion(tsvData[i][0], tsvData[i][1], tsvData[i][2], tsvData[i][3], tsvData[i][4], tsvData[i][5], tsvData[i][6], tsvData[i][7]);
        }
        header = tsvData[0][0] + " " + tsvData[0][1] + " " + tsvData[0][2] + " " + tsvData[0][3] + " "
                + tsvData[0][4] + " " + tsvData[0][5] + " " + tsvData[0][6] + " " + tsvData[0][7];
    }




    public static void createChampionMap() {
        champMap = new HashMap<>();
        champMap.put("Aatrox", 0);
        champMap.put("Ahri", 1);
        champMap.put("Akali", 2);
        champMap.put("Akshan", 3);
        champMap.put("Alistar", 4);
        champMap.put("Ambessa", 5);
        champMap.put("Amumu", 6);
        champMap.put("Anivia", 7);
        champMap.put("Annie", 8);
        champMap.put("Aphelios", 9);
        champMap.put("Ashe", 10);
        champMap.put("AurelionSol", 11);
        champMap.put("Aurora", 12);
        champMap.put("Azir", 13);
        champMap.put("Bard", 14);
        champMap.put("BelVeth", 15);
        champMap.put("Blitzcrank", 16);
        champMap.put("Brand", 17);
        champMap.put("Braum", 18);
        champMap.put("Briar", 19);
        champMap.put("Caitlyn", 20);
        champMap.put("Camille", 21);
        champMap.put("Cassiopeia", 22);
        champMap.put("ChoGath", 23);
        champMap.put("Corki", 24);
        champMap.put("Darius", 25);
        champMap.put("Diana", 26);
        champMap.put("DrMundo", 27);
        champMap.put("Draven", 28);
        champMap.put("Ekko", 29);
        champMap.put("Elise", 30);
        champMap.put("Evelynn", 31);
        champMap.put("Ezreal", 32);
        champMap.put("Fiddlesticks", 33);
        champMap.put("Fiora", 34);
        champMap.put("Fizz", 35);
        champMap.put("Galio", 36);
        champMap.put("Gangplank", 37);
        champMap.put("Garen", 38);
        champMap.put("Gnar", 39);
        champMap.put("Gragas", 40);
        champMap.put("Graves", 41);
        champMap.put("Gwen", 42);
        champMap.put("Hecarim", 43);
        champMap.put("Heimerdinger", 44);
        champMap.put("Hwei", 45);
        champMap.put("Illaoi", 46);
        champMap.put("Irelia", 47);
        champMap.put("Ivern", 48);
        champMap.put("Janna", 49);
        champMap.put("JarvanIV", 50);
        champMap.put("Jax", 51);
        champMap.put("Jayce", 52);
        champMap.put("Jhin", 53);
        champMap.put("Jinx", 54);
        champMap.put("KSante", 55);
        champMap.put("KaiSa", 56);
        champMap.put("Kalista", 57);
        champMap.put("Karma", 58);
        champMap.put("Karthus", 59);
        champMap.put("Kassadin", 60);
        champMap.put("Katarina", 61);
        champMap.put("Kayle", 62);
        champMap.put("Kayn", 63);
        champMap.put("Kennen", 64);
        champMap.put("KhaZix", 65);
        champMap.put("Kindred", 66);
        champMap.put("Kled", 67);
        champMap.put("KogMaw", 68);
        champMap.put("LeBlanc", 69);
        champMap.put("LeeSin", 70);
        champMap.put("Leona", 71);
        champMap.put("Lillia", 72);
        champMap.put("Lissandra", 73);
        champMap.put("Lucian", 74);
        champMap.put("Lulu", 75);
        champMap.put("Lux", 76);
        champMap.put("Malphite", 77);
        champMap.put("Malzahar", 78);
        champMap.put("Maokai", 79);
        champMap.put("MasterYi", 80);
        champMap.put("Mel", 81);
        champMap.put("Milio", 82);
        champMap.put("MissFortune", 83);
        champMap.put("Mordekaiser", 84);
        champMap.put("Morgana", 85);
        champMap.put("Naafiri", 86);
        champMap.put("Nami", 87);
        champMap.put("Nasus", 88);
        champMap.put("Nautilus", 89);
        champMap.put("Neeko", 90);
        champMap.put("Nidalee", 91);
        champMap.put("Nilah", 92);
        champMap.put("Nocturne", 93);
        champMap.put("NunuAndWillump", 94);
        champMap.put("Olaf", 95);
        champMap.put("Orianna", 96);
        champMap.put("Ornn", 97);
        champMap.put("Pantheon", 98);
        champMap.put("Poppy", 99);
        champMap.put("Pyke", 100);
        champMap.put("Qiyana", 101);
        champMap.put("Quinn", 102);
        champMap.put("Rakan", 103);
        champMap.put("Rammus", 104);
        champMap.put("RekSai", 105);
        champMap.put("Rell", 106);
        champMap.put("RenataGlasc", 107);
        champMap.put("Renekton", 108);
        champMap.put("Rengar", 109);
        champMap.put("Riven", 110);
        champMap.put("Rumble", 111);
        champMap.put("Ryze", 112);
        champMap.put("Samira", 113);
        champMap.put("Sejuani", 114);
        champMap.put("Senna", 115);
        champMap.put("Seraphine", 116);
        champMap.put("Sett", 117);
        champMap.put("Shaco", 118);
        champMap.put("Shen", 119);
        champMap.put("Shyvana", 120);
        champMap.put("Singed", 121);
        champMap.put("Sion", 122);
        champMap.put("Sivir", 123);
        champMap.put("Skarner", 124);
        champMap.put("Smolder", 125);
        champMap.put("Sona", 126);
        champMap.put("Soraka", 127);
        champMap.put("Swain", 128);
        champMap.put("Sylas", 129);
        champMap.put("Syndra", 130);
        champMap.put("TahmKench", 131);
        champMap.put("Taliyah", 132);
        champMap.put("Talon", 133);
        champMap.put("Taric", 134);
        champMap.put("Teemo", 135);
        champMap.put("Thresh", 136);
        champMap.put("Tristana", 137);
        champMap.put("Trundle", 138);
        champMap.put("Tryndamere", 139);
        champMap.put("TwistedFate", 140);
        champMap.put("Twitch", 141);
        champMap.put("Udyr", 142);
        champMap.put("Urgot", 143);
        champMap.put("Varus", 144);
        champMap.put("Vayne", 145);
        champMap.put("Veigar", 146);
        champMap.put("VelKoz", 147);
        champMap.put("Vex", 148);
        champMap.put("Vi", 149);
        champMap.put("Viego", 150);
        champMap.put("Viktor", 151);
        champMap.put("Vladimir", 152);
        champMap.put("Volibear", 153);
        champMap.put("Warwick", 154);
        champMap.put("Wukong", 155);
        champMap.put("Xayah", 156);
        champMap.put("Xerath", 157);
        champMap.put("XinZhao", 158);
        champMap.put("Yasuo", 159);
        champMap.put("Yone", 160);
        champMap.put("Yorick", 161);
        champMap.put("Yuumi", 162);
        champMap.put("Zac", 163);
        champMap.put("Zed", 164);
        champMap.put("Zeri", 165);
        champMap.put("Ziggs", 166);
        champMap.put("Zilean", 167);
        champMap.put("Zoe", 168);
        champMap.put("Zyra", 169);
        }

}
