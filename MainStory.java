import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class MainStory {
	
	static String lifePath = null;
	static int loyalty = 0;
	static int hacking = 4;
	static int pins = 4;
	static int health = 10;
	static int ruthless = 0;
	
	public static void main(String[] args) throws FileNotFoundException {
		//standard greeting
		System.out.println("Welcome to Cyberpunk 1867");
		System.out.println("Load a previous save?");
		System.out.println("Y/N");
		
		//scan the input
		Scanner input = new Scanner(System.in);
		String input1 = input.nextLine();
		
		//check for saveFile
		if(input1.equalsIgnoreCase("Y") || input1.equalsIgnoreCase("Yes")) {
			System.out.println("");
			System.out.println("Insert Save File Name (include .txt)");
			String fileName = input.nextLine();
			loadSaveFile(fileName);
			
			//begin a brand new story
		} else if(input1.equalsIgnoreCase("N") || input1.equalsIgnoreCase("No")) {
			characterCustomization();
		} else {
			System.out.println("Invalid Input");
			System.out.println("");
			main(null);
		}
	}
	
	//creates a save file
	public static void createSaveFile( ) throws FileNotFoundException {
		//asks for a file name
		System.out.println();
		System.out.println("Insert fileName to save the game");
		Scanner scan = new Scanner(System.in);
		String fileName = scan.next();
		
		//creates a file named the file name
		File f = new File(fileName);
		PrintStream save = new PrintStream(f);
		
		//use this command to add stuff to saveFile
		//only save important stats and stuff
		save.println(lifePath);
		save.println(loyalty);
		save.println(hacking);
		save.println(pins);
		save.println(health);
		save.println(ruthless);
	} 
	
	//loads a save file
	public static void loadSaveFile(String fileName) throws FileNotFoundException {
		//scans the file
		File saveFile = new File(fileName);
		Scanner fileScan = new Scanner(saveFile);
		
		//load each important file
		for(int i = 0; fileScan.hasNext(); i++) {
			if(i == 1) {
				lifePath = fileScan.next();
			} else if(i == 2) {
				loyalty = fileScan.nextInt();
			} else if(i == 3) {
				hacking = fileScan.nextInt();
			} else if(i == 4) {
				pins = fileScan.nextInt();
			} else if(i == 5) {
				health = fileScan.nextInt();
			} else if(i == 6) {
				ruthless = fileScan.nextInt();
			}
		}
	}
	
	//beggining
	public static void characterCustomization() {
		//prompts lifePath selection
		System.out.println();
		System.out.println("Please select your life path (1, 2 or 3)");
		System.out.println("1. Nomad");
		System.out.println("2. Mercenary");
		System.out.println("3. Samurai");
		System.out.println();
		//creates an input scanner
		Scanner input = new Scanner(System.in);
		String lifeChosen = input.next();
		
		//sends each path down
		if(lifeChosen.equalsIgnoreCase("1")) {
			lifePath = "Nomad";
			NomadIntro();
		} else if(lifeChosen.equalsIgnoreCase("2")) {
			lifePath = "Mercenary";
			MercenaryIntro();
		} else if(lifeChosen.equalsIgnoreCase("3")) {
			lifePath = "Samurai";
			SamuraiIntro();
		} else {
			System.out.println("Invalid Input");
			System.out.println();
			characterCustomization();
		}
	}
	
	//samurai story
	public static void SamuraiIntro(){
		System.out.println();
		System.out.println("Entering Samurai Path...");
		System.out.println();
		System.out.println("You are a samurai, a noble warrior");
		System.out.println("Used as a weapon by the corporates above you");
		System.out.println("You exist only to serve your shogun and eridicate his enemies");
		System.out.println("Completing your mission is all you need to do, no matter the cost...");
		System.out.println();
		System.out.println("TIP: Save when the option is presented to you");
		System.out.println();
		System.out.println("You are stationed outside a rural village");
		System.out.println("There has been whispers of  the village harboring ninjas");
		System.out.println("You are to take care of any rebel uprisings.");
		System.out.println("Upon entering the village, you realize something is wrong");
		System.out.println("It's quiet, even for a village");
		System.out.println();
	}	
	
	public static void SamuraiTutorial() {
	}
	
	//street kid story
	public static void MercenaryIntro() {
		System.out.println();
		System.out.println("Entering Mercenary Path...");
		System.out.println();
		System.out.println("You are an assasin hired to do the dirty work.");
		System.out.println("You use the most advanced weapons to complete your job.");
		System.out.println("You only care about making some cash and living the good life");
		System.out.println("Your current mission?");
		System.out.println("Take down Frederick Kelly, the leader of the Phantoms...");
		System.out.println();
		System.out.println("TIP: Save when the option is presented to you");
		System.out.println();
		System.out.println("Living in the booming city of Tokyo has it's up's and down's");
		System.out.println("One of the lows is living in the most crime infested city in Japan");
		System.out.println("You don't mind, since this criminal activity is what's giving you money");
		System.out.println("You approach a building, well more of a shack really.");
		System.out.println("According to your fixer, this is the last place Frederick was seen");
		System.out.println("Even if he's not here, it's still a good place to look for clues on his whereabouts");
		MercenaryTutorial();
	}
	
	public static void MercenaryTutorial() {
		Scanner scan = new Scanner(System.in);
		System.out.println();
		System.out.println("What do you do?");
		System.out.println("1. Approach the building");
		System.out.println("2. Lay low and see if someone goes inside");
		System.out.println("3. Leave the area and forfeit the mission");
		System.out.println();
		String input = scan.nextLine();
		if(input.equals("1")) {
			System.out.println();
			System.out.println("You approach the shack but there's a lock on the door");
			MercenaryOptions1();
		} else if(input.equals("2")) {
			System.out.println();
			System.out.println("You decide to lay low and wait");
			System.out.println("After half an hour, someone is trying to open the shed");
			MercenaryOptions2();
			
		} else if(input.equals("3")) {
			System.out.println();
			System.out.println("Leaving the area lowers your loyalty points");
			System.out.println("Do you wish to proceed?");
			String ans = scan.nextLine();
			if(ans.equals("Yes")) {
				System.out.println("Loyalty has decreased");
				loyalty--;
				System.out.println("Generating \"open world\"...");
			} else if(ans.equalsIgnoreCase("No")) {
				MercenaryTutorial();
			}
		} else {
			System.out.println("Invalid Input");
			System.out.println();
			MercenaryTutorial();
			
		}
	}
	
	public static void MercenaryOptions1() {
		System.out.println();
		System.out.println("Should you use your hacking tool or brute force to open the lock?");
		System.out.println("1. Hacking Tool");
		System.out.println("2. Brute Force");
		System.out.println();
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		if(input.equals("1")) {
			System.out.println("You pull out a tiny pin");
			System.out.println("It fits in the lock");
			System.out.println();
			System.out.println("There's a 1 in 4 chance of opening the lock");
			System.out.println("This percentage changes depending on what skills you upgrade");
			System.out.println("You can upgrade your hacking tool four times.");
			System.out.println("You currently have four pins");
			System.out.println();
			HackingMinigame();
			
		} else if(input.equals("2")) {
			System.out.println();
			System.out.println("Using brute force alerts people nearby");
			System.out.println("Thankfully the alley is empty");
			System.out.println("You break the lock and watch it clank to the ground");
			kidInsideShack();
		}  else {
			System.out.println("Invalid Input");
			System.out.println();
			MercenaryOptions1();
		}
	}
	
	public static void HackingMinigame() {
		Random rand = new Random();
		int correctValue = rand.nextInt(hacking + 1);
		
		if(pins == 0) {
			System.out.println("No pins left");
			MercenaryOptions1();
			return;
		}
		if(correctValue == hacking) {
			System.out.println("Lock opened");
			pins--;
			System.out.println("Used one pin");
			System.out.println(pins + " remain");
			kidInsideShack();
		} else {
			System.out.println("Lock failed");
			System.out.println();
			pins--;
			System.out.println("Used one pin");
			System.out.println(pins + " remain");
			Scanner scan = new Scanner(System.in);
			System.out.println();
			System.out.println("Try again?");
			String input = scan.next();
			if(input.equalsIgnoreCase("Yes")) {
				HackingMinigame();
			} else {
				MercenaryOptions1();
			}
		}
	}
	
	public static void kidInsideShack() {
		System.out.println("Inside you see papers thrown about, news articles and pencils everywhere");
		System.out.println("What do you investigate?");
		System.out.println();
		System.out.println("End of Demo");
	}
	
	public static void MercenaryOptions2(){
		System.out.println("What will you do?");
		System.out.println("1. Wait for them to open the door and attack");
		System.out.println("2. Attack immediately");
		System.out.println("3. Wait for them to leave");
		System.out.println("4. Leave the area and forfeit the mission");
		System.out.println();
		Scanner scan = new Scanner(System.in);
		String input = scan.next();
		if(input.equals("1")) {
			System.out.println();
			System.out.println("You see them pull out a key to open the shed.");
			System.out.println("You see them go inside and enter the shed");
			System.out.println("You run to the shed to corner him, but when you look inside there's no one there.");
			System.out.println("Inside you see papers thrown about, news articles and pencils everywhere");
			System.out.println("Nothing that directly yells how the person dissapeared.");
			System.out.println("End of Demo");
			//investigateShed();
		} else if(input.equals("2")) {
			System.out.println();
			System.out.println("You charge at them, they see you and pull out a knife, which does 2 attack damage");
			System.out.println();
			System.out.println("In PvE combat, weapons have different attack damage");
			System.out.println("Some weapons instantly kill enemies, while others incapacitate them");
			System.out.println("You currently have a short sword, that does 3 attack damage");
			System.out.println();
			System.out.println("The goon moves forward to attack");
			
			
		} else if(input.equals("3")) {
			
		} else if(input.equals("4")) {
			
		} else {
			System.out.println("Invalid input");
			System.out.println();
			MercenaryOptions2();
		}
	}
	
	public static void goonPvE() {
		Scanner scan = new Scanner(System.in);
		System.out.println("What will you do?");
		System.out.println();
		System.out.println("1. Incapacitate him and take away his weapon");
		System.out.println("2. Hack and Slash with your sword, till he's chopped");
		System.out.println("3. Run away and forfeit the mission");
		
		String attackInput = scan.next();
		if(attackInput.equals("1")) {
			System.out.println("You pull out your weapon and aim for his hand");
			System.out.println("You slap it with the flat of your blade and it falls to the ground");
			System.out.println("While he tries to pick up the weapon, you pin him against the wall");
			System.out.println("You ask about the location of Frederick");
			System.out.println("He says \"We have a secret underground tunnel underneath the shack the button to open the tunnel is behind the newspapers\" ");
			System.out.println();
			isThisMurder();
		} else if(attackInput.equals("2")) {
			System.out.println();
			System.out.println("You decide that dead men tell no tales");
			System.out.println("You grab your weapon and aim straight for the neck");
			System.out.println("A decapitation is impossible with a light sword");
			System.out.println("but with a well placed location you can sever important veins");
			System.out.println("The goon gasps as he slowly loses conciousness");
			System.out.println("You hack and slash with no decorum");
			System.out.println("Without a doubt the goon is dead");
			System.out.println();
			System.out.println("Ruthlessness is now level " + ruthless);
		} else if(attackInput.equals("3")) {
			
		} else {
			System.out.println("Invalid Input");
			System.out.println();
			goonPvE();
		}

	}
	
	public static void isThisMurder() {
		Scanner scan = new Scanner(System.in);
		System.out.println("What do you do with the goon?");
		System.out.println();
		System.out.println("1. Let him go, but tell him to keep quiet");
		System.out.println("2. Murder him, leave no witnesses");
		System.out.println();
	}
	
	//nomad path
	public static void NomadIntro() {
		System.out.println();
		System.out.println("Entering Nomad Path...");
		System.out.println();
		System.out.println("You are a no one living in the outskirts of a city");
		System.out.println("Your friends are planning a rebellion to take down the shogun");
		System.out.println("The corporate agents in your town, killing your people");
		System.out.println("Taking them down is all that matters...");
		System.out.println();
		System.out.println("TIP: Save when the option is presented to you");
		System.out.println();
		System.out.println("");
		NomadTutorial();
	}
	
	public static void NomadTutorial() {
		
	}
}
