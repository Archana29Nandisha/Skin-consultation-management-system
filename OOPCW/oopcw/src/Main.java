import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WestminsterSkinConsultationManager skin = new WestminsterSkinConsultationManager();
        skin.readData();

        Scanner scn = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    ---Westminster Skin Care Center---
                    A. Add Doctor
                    B. Delete Doctor
                    C. Sort Doctors Alphabetically
                    D. Save File
                    E. launch GUI
                    F. Exit
                    
                    Enter Option :""");
            String option = scn.nextLine();
            switch (option) {
                case "A":
                    skin.addDoctor();
                    break;

                case "B":
                    skin.delete();
                    break;

                case "C":
                    skin.sort();
                    break;
                case "E":
                    new GUIpart1(skin);
                    break;

                case "D":
                    skin.saveFile();
                    break;
                case "F":
                    System.out.println("Thank you..Good Bye " +
                            "");
                    return;

                default:
                    System.out.println("Invalid input, Please Try Again....");
                    System.out.println();
            }
        }
    }
}