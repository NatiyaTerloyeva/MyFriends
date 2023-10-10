import MyFriends.Friend;
import org.w3c.dom.ls.LSOutput;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private ArrayList<Friend> friends;
    private boolean running;
    private Scanner scanner;

    public Main() {
        friends = new ArrayList<>();
        running = true;
        scanner = new Scanner(System.in);

    }

    public void run() {

        while (running) {

            System.out.println("MENU:");
            System.out.println("1. View friend list");
            System.out.println("2. Add a new friend");
            System.out.println("3. Quit");
            System.out.println("Please choose en option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewFriendList();
                    break;
                case 2:
                    addFriend();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
        System.out.println("Goodbye!");


    }

    public void viewFriendList() {
        System.out.println("FRIEND LIST");
        for (int i = 0; i < friends.size(); i++) {
            System.out.println("#" + (i + 1) + ":" + friends.get(i));
        }
    }

    public void addFriend() {

    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter name: ");
    String name = scanner.nextLine();
    System.out.print("Enter phone: ");
    String phone = scanner.nextLine();
    System.out.print("Enter email: ");
    String email = scanner.nextLine();


    Friend friend = new Friend(name, phone, email);

    friends.add(friend);

    System.out.println("Friend added.");

    }

    public void deleteFriend() {
        System.out.println("Enter the index of the friend to delete: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index >=0 && index < friends.size()) {
            Friend deletedFriend = friends.remove(index);
            System.out.println("Deleted friend: " + deletedFriend.getName());
        } else {
            System.out.println("Invalid index. No friend deleted.");


        }
    }

    public void saveList() {

        System.out.println("Friend list saved. ");

    }

    public void loadList() {
        System.out.println("Friend list loaded.");

    }


    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
}






