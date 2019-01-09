package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
   // public static SimpleDateFormat dateFormat = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);

    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", "tmp", new File("/Users/User/Desktop"));
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);



            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.users.add(new User());
            javaRush.users.get(0).setFirstName("Alex");
            javaRush.users.get(0).setLastName("Bulygin");
            javaRush.users.get(0).setBirthDate(new Date(1508944516168L));
            javaRush.users.get(0).setMale(true);
            javaRush.users.get(0).setCountry(User.Country.RUSSIA);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the codeGym object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            if (users.size() != 0) {
                for (int i = 0; i < users.size(); i++) {
                    printWriter.println(users.get(i).getFirstName());
                    printWriter.println(users.get(i).getLastName());
                    printWriter.println(users.get(i).getBirthDate().getTime());
                    printWriter.println(users.get(i).isMale());
                    printWriter.println(users.get(i).getCountry().getDisplayName());
                }
                printWriter.flush();
                printWriter.close();

            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            if (users != null) {

                while (bufferedReader.ready()) {
                    String firstName = bufferedReader.readLine();
                    String lastName = bufferedReader.readLine();
                    String birthDateTime = bufferedReader.readLine();
                    boolean isMale = Boolean.parseBoolean(bufferedReader.readLine());
                    String displayName = bufferedReader.readLine();

                    User user = new User();
                    user.setFirstName(firstName);
                    user.setLastName(lastName);
                    user.setBirthDate(new Date(Long.parseLong(birthDateTime)));
                    user.setMale(isMale);

                    if (displayName.equals("Russia"))
                        user.setCountry(User.Country.RUSSIA);
                    if (displayName.equals("Ukraine"))
                        user.setCountry(User.Country.UKRAINE);
                    if (displayName.equals("Other"))
                        user.setCountry(User.Country.OTHER);

                    users.add(user);
                }
                bufferedReader.close();
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
