package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        try {
            File yourFile = new File(args[0]);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();

            User user = new User();
            user.setFirstName("Rubi");
            user.setLastName("Rail");
            user.setBirthDate(new Date(1508944516168L));
            user.setMale(true);
            user.setCountry(User.Country.OTHER);
            javaRush.users.add(user);

            User user1 = new User();
            user1.setFirstName("Vasa1");
            user1.setLastName("Peta1");
            user1.setBirthDate(new Date(1508944516163L));
            user1.setMale(true);
            user1.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user1);

            User user3 = new User();
            user3.setFirstName("Solo");
            user3.setLastName("Han");
            user3.setBirthDate(new Date(1508944516169L));
            user3.setMale(true);
            user3.setCountry(User.Country.UKRAINE);
            javaRush.users.add(user3);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {

        public  List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter writer = new PrintWriter(outputStream);
            String isUsers = users.isEmpty() ? "no" : "yes";
            writer.println(isUsers);
            writer.flush();
            if(!isUsers.isEmpty()){
                for (User user : users){
                    writer.println("start");
                    writer.println(user.getFirstName());
                    writer.println(user.getLastName());
                    writer.println(user.getBirthDate().getTime());
                    writer.println(user.isMale());
                    writer.println(user.getCountry());

                }
                writer.flush();
            }
        }
        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String isUsers = reader.readLine();
            if(isUsers.equals("yes")){
                while (reader.ready()){
                    if(reader.readLine().equals("start")){
                        User user = new User();
                        user.setFirstName(reader.readLine());
                        user.setLastName(reader.readLine());
                        user.setBirthDate(new Date(Long.parseLong(reader.readLine())));
                        user.setMale(Boolean.parseBoolean(reader.readLine()));
                        user.setCountry(User.Country.valueOf(reader.readLine()));
                        users.add(user);
                    }
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
