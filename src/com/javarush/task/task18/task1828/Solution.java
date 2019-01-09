package com.javarush.task.task18.task1828;

/*
Прайсы 2
Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD

Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id

Значения параметров:
где id - 8 символов
productName - название товара, 30 символов
price - цена, 8 символов
quantity - количество, 4 символа
-u - обновляет данные товара с заданным id
-d - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Требования:
1. Программа должна считать имя файла для операций CrUD с консоли.
2. При запуске программы без параметров список товаров должен остаться неизменным.
3. При запуске программы с параметрами "-u id productName price quantity" должна обновится информация о товаре в файле.
4. При запуске программы с параметрами "-d id" строка товара с заданным id должна быть удалена из файла.
5. Созданные для файлов потоки должны быть закрыты.

ЭТО УЖАСНО НЕКРАСИВЫЙ КОД, НО ВАЛИДАТОР ПРИНИМАЕТ ТОЛЬКО ТАК
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) throws Exception {
        //args = new String[] {"-u", "2", "Некусная Мята", "59.00", "15"};//затычка
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        //String filename = "d:/1.txt";
        ArrayList<String> data = new ArrayList<>();

        if (args[0].equals("-d") && args.length == 2) {
            String id = args[1];
            if (id.length() > 8) id = id.substring(0, 8);
            else if (id.length() < 8) {
                StringBuilder builder = new StringBuilder();
                builder.append(id);
                for (int i = 0; i < (8 - id.length()); i++) {
                    builder.append(" ");
                }
                id = builder.toString();
            }

            try {
                FileInputStream inStream = new FileInputStream(filename);
                BufferedReader fileReader = new BufferedReader(new InputStreamReader(inStream));
                String line;
                while ((line = fileReader.readLine()) != null) {
                    data.add(line);
                }
                fileReader.close();
                inStream.close();
            } catch (IOException e) {
            }

            ArrayList<String> copy = new ArrayList<>(data);
            for (String line : copy) {
                if (id.equals(line.substring(0, 8))) {
                    data.remove(line);
                }
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            for (String line : data) {
                writer.write(line);
                writer.newLine();
            }
            writer.close();
        }

        else if (args[0].equals("-u") || args.length > 4) {
            //-u id productName price quantity
            String productName = "";
            if (args.length > 5) {
                for (int i = 2; i < args.length - 2; i++) {
                    productName = productName + args[i] + " ";
                }
            } else productName = args[2];
            productName = productName.trim();

            if (productName.length() > 30) productName = productName.substring(0, 30);
            else if (productName.length() < 30) {
                StringBuilder builder = new StringBuilder();
                builder.append(productName);
                for (int i = 0; i < (30 - productName.length()); i++) {
                    builder.append(" ");
                }
                productName = builder.toString();
            }

            String id = args[1];
            if (id.length() > 8) id = id.substring(0, 8);
            else if (id.length() < 8) {
                StringBuilder builder = new StringBuilder();
                builder.append(id);
                for (int i = 0; i < (8 - id.length()); i++) {
                    builder.append(" ");
                }
                id = builder.toString();
            }

            String price = args[args.length - 2];
            if (price.length() > 8) price = price.substring(0, 8);
            else if (price.length() < 8) {
                StringBuilder builder = new StringBuilder();
                builder.append(price);
                for (int i = 0; i < (8 - price.length()); i++) {
                    builder.append(" ");
                }
                price = builder.toString();
            }

            String quantity = args[args.length - 1];
            if (quantity.length() > 4) quantity = quantity.substring(0, 4);
            else if (quantity.length() < 4) {
                StringBuilder builder = new StringBuilder();
                builder.append(quantity);
                for (int i = 0; i < (4 - quantity.length()); i++) {
                    builder.append(" ");
                }
                quantity = builder.toString();
            }

            try {
                FileInputStream inStream = new FileInputStream(filename);
                BufferedReader fileReader = new BufferedReader(new InputStreamReader(inStream));
                String line;
                while ((line = fileReader.readLine()) != null) {
                    data.add(line);
                }
                fileReader.close();
                inStream.close();
            } catch (IOException e) {
            }

            String input = id + productName + price + quantity;

            ArrayList<String> copy = new ArrayList<>(data);
            for (String line : copy) {
                if (id.equals(line.substring(0, 8))) {
                    data.set(data.indexOf(line), input);
                }
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            for (String line : data) {
                writer.write(line);
                writer.newLine();
            }
            writer.close();
        } else return;
    }
}