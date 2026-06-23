import java.util.ArrayList;
import java.util.Scanner;

class Victim {
    int victimId;
    String name;
    int age;
    String gender;
    String location;

    Victim(int victimId, String name, int age, String gender, String location) {
        this.victimId = victimId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.location = location;
    }

    void display() {
        System.out.println("Victim ID: " + victimId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Location: " + location);
        System.out.println("----------------------------");
    }
}

class Volunteer {
    int volunteerId;
    String name;
    String skill;
    String availability;

    Volunteer(int volunteerId, String name, String skill, String availability) {
        this.volunteerId = volunteerId;
        this.name = name;
        this.skill = skill;
        this.availability = availability;
    }

    void display() {
        System.out.println("Volunteer ID: " + volunteerId);
        System.out.println("Name: " + name);
        System.out.println("Skill: " + skill);
        System.out.println("Availability: " + availability);
        System.out.println("----------------------------");
    }
}

class VolunteerVictim {
    int volunteerId;
    int victimId;
    String helpDate;
    String description;

    VolunteerVictim(int volunteerId, int victimId, String helpDate, String description) {
        this.volunteerId = volunteerId;
        this.victimId = victimId;
        this.helpDate = helpDate;
        this.description = description;
    }

    void display() {
        System.out.println("Volunteer ID: " + volunteerId +
                " helped Victim ID: " + victimId);
        System.out.println("Date: " + helpDate);
        System.out.println("Description: " + description);
        System.out.println("----------------------------");
    }
}

public class DisasterReliefSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Victim> victims = new ArrayList<>();
        ArrayList<Volunteer> volunteers = new ArrayList<>();
        ArrayList<VolunteerVictim> records = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== DISASTER RELIEF SYSTEM =====");
            System.out.println("1. Add Victim");
            System.out.println("2. View Victims");
            System.out.println("3. Add Volunteer");
            System.out.println("4. View Volunteers");
            System.out.println("5. Assign Volunteer to Victim");
            System.out.println("6. View Help Records");
            System.out.println("7. Update Victim");
            System.out.println("8. Delete Victim");
            System.out.println("9. Update Volunteer");
            System.out.println("10. Delete Volunteer");
            System.out.println("11. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Victim ID: ");
                    int vid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Name: ");
                    String vname = sc.nextLine();

                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Gender: ");
                    String gender = sc.nextLine();

                    System.out.print("Location: ");
                    String location = sc.nextLine();

                    victims.add(new Victim(vid, vname, age, gender, location));

                    System.out.println("Victim Added Successfully!");
                    break;

                case 2:
                    System.out.println("\n--- Victim List ---");
                    if (victims.isEmpty()) {
                        System.out.println("No Victims Found.");
                    } else {
                        for (Victim v : victims) {
                            v.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Volunteer ID: ");
                    int volId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Name: ");
                    String volName = sc.nextLine();

                    System.out.print("Skill: ");
                    String skill = sc.nextLine();

                    System.out.print("Availability: ");
                    String availability = sc.nextLine();

                    volunteers.add(new Volunteer(volId, volName, skill, availability));

                    System.out.println("Volunteer Added Successfully!");
                    break;

                case 4:
                    System.out.println("\n--- Volunteer List ---");
                    if (volunteers.isEmpty()) {
                        System.out.println("No Volunteers Found.");
                    } else {
                        for (Volunteer v : volunteers) {
                            v.display();
                        }
                    }
                    break;

                case 5:
                    System.out.print("Volunteer ID: ");
                    int volunteerId = sc.nextInt();

                    System.out.print("Victim ID: ");
                    int victimId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Help Date: ");
                    String date = sc.nextLine();

                    System.out.print("Description: ");
                    String desc = sc.nextLine();

                    records.add(new VolunteerVictim(
                            volunteerId,
                            victimId,
                            date,
                            desc));

                    System.out.println("Volunteer Assigned Successfully!");
                    break;

                case 6:
                    System.out.println("\n--- Help Records ---");
                    if (records.isEmpty()) {
                        System.out.println("No Records Found.");
                    } else {
                        for (VolunteerVictim r : records) {
                            r.display();
                        }
                    }
                    break;

                case 7:
                    System.out.print("Enter Victim ID to Update: ");
                    int updateVictimId = sc.nextInt();
                    sc.nextLine();

                    boolean victimFound = false;

                    for (Victim v : victims) {
                        if (v.victimId == updateVictimId) {

                            System.out.print("New Name: ");
                            v.name = sc.nextLine();

                            System.out.print("New Age: ");
                            v.age = sc.nextInt();
                            sc.nextLine();

                            System.out.print("New Gender: ");
                            v.gender = sc.nextLine();

                            System.out.print("New Location: ");
                            v.location = sc.nextLine();

                            System.out.println("Victim Updated Successfully!");
                            victimFound = true;
                            break;
                        }
                    }

                    if (!victimFound) {
                        System.out.println("Victim ID Not Found!");
                    }
                    break;

                case 8:
                    System.out.print("Enter Victim ID to Delete: ");
                    int deleteVictimId = sc.nextInt();

                    boolean removedVictim =
                            victims.removeIf(v -> v.victimId == deleteVictimId);

                    if (removedVictim)
                        System.out.println("Victim Deleted Successfully!");
                    else
                        System.out.println("Victim ID Not Found!");

                    break;

                case 9:
                    System.out.print("Enter Volunteer ID to Update: ");
                    int updateVolunteerId = sc.nextInt();
                    sc.nextLine();

                    boolean volunteerFound = false;

                    for (Volunteer v : volunteers) {
                        if (v.volunteerId == updateVolunteerId) {

                            System.out.print("New Name: ");
                            v.name = sc.nextLine();

                            System.out.print("New Skill: ");
                            v.skill = sc.nextLine();

                            System.out.print("New Availability: ");
                            v.availability = sc.nextLine();

                            System.out.println("Volunteer Updated Successfully!");
                            volunteerFound = true;
                            break;
                        }
                    }

                    if (!volunteerFound) {
                        System.out.println("Volunteer ID Not Found!");
                    }
                    break;

                case 10:
                    System.out.print("Enter Volunteer ID to Delete: ");
                    int deleteVolunteerId = sc.nextInt();

                    boolean removedVolunteer =
                            volunteers.removeIf(v -> v.volunteerId == deleteVolunteerId);

                    if (removedVolunteer)
                        System.out.println("Volunteer Deleted Successfully!");
                    else
                        System.out.println("Volunteer ID Not Found!");

                    break;

                case 11:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 11);

        sc.close();
    }
}