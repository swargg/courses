package learning.java.stepik.collectionDraft;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class MainCollect {

    //data
    static List<User> users = Arrays.asList(
            new User(21, "Vasya", Role.USER),
            new User(1, "Admin", Role.ADMIN),
            new User(123, "Pupik", Role.GUEST),
            new User(234, "Lupik", Role.GUEST),
            new User(2342, "Dupik", Role.GUEST),
            new User(2342, "Mupik", Role.GUEST)
    );

    public  void testOldCollection_Java7() {


        System.out.println("Guests: "+users.size());



        List<User> guestsFromUsers = new LinkedList<>();

        for (User user : users) {

            if (user.getRole() == Role.GUEST) {

                guestsFromUsers.add(user);

            }
        }

        Collections.sort (guestsFromUsers, new Comparator<User>() {
            @Override
            public int compare (User u1, User u2) {
                return Long.compare(u2.getId(), u1.getId());
            }
        });

    } //testOldCollection closing


    public void testCollection_Java8 () {

        List<User> usr = Arrays.asList(
                new User(21, "Vasya", Role.USER),
                new User(1, "Admin", Role.ADMIN),
                new User(123, "Pupik", Role.GUEST),
                new User(234, "Lupik", Role.GUEST),
                new User(2342, "Dupik", Role.GUEST)
        );


        User dude= usr.get(0);
        System.out.println("name 1 ="+dude.getName());



        List<User> namesOfGuests = usr.stream()
                .filter(user -> user.getRole()==Role.GUEST)
               // .sorted((obj1, obj2) -> Integer.compare(obj1.getId(), obj2.getId()))
               // .map(user -> user.getName())
                .collect(Collectors.toList());

        int size = namesOfGuests.size();
        System.out.println("size="+size);

    }


    public static void main(String[] args) {
/*
         List<User> users1 = new ArrayList<>();
                users1.add(new User(21, "Vasya", Role.USER));

                new User(1, "Admin", Role.ADMIN),
                new User(123, "Pupik", Role.GUEST),
                new User(234, "Lupik", Role.GUEST),
                new User(2342, "Dupik", Role.GUEST),
                new User(2342, "Mupik", Role.GUEST)


        System.out.println(users1.size());
        User u1 = (User) users1.get(0);

        String k =(String) u1.getName();


        System.out.println("k="+k);


             */

    }

}
