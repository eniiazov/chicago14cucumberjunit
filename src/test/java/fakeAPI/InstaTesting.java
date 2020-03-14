package fakeAPI;

public class InstaTesting {

    public static void main(String[] args) {
        Instagram instagram = new Instagram();

        // Sign up page
        // On sign up page users MUST provide name, age, username etc
        InstagramUser user1 = new InstagramUser("John Wick", 45, "jw2020");

        instagram.addUser(user1);
        System.out.println();
        instagram.seeAllUsers("Cyb32134");

//        InstagramUser user2 = new InstagramUser("James Bond", 41, "jbcool");
//        instagram.addUser(user2);
//        instagram.seeAllUsers("Cyb32134");

    }

}
