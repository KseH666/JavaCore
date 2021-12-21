package com.javarush.task.task14.task1414;

/* 
MovieFactory
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //ввести с консоли несколько ключей (строк), пункт 7
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; ; i++) {
            String word = reader.readLine();
            if (word.equals("cartoon")) {
                Movie movie = new Cartoon();
                movie = MovieFactory.getMovie(word);
                System.out.println(movie.getClass().getSimpleName());
            } else if (word.equals("thriller")) {
                Movie movie = new Thriller();
                movie = MovieFactory.getMovie(word);
                System.out.println(movie.getClass().getSimpleName());
            } else if (word.equals("soapOpera")) {
                Movie movie = new SoapOpera();
                movie = MovieFactory.getMovie(word);
                System.out.println(movie.getClass().getSimpleName());
            } else {
                MovieFactory.getMovie(word);
                break;
            }
        }
        /*
8 Создать переменную movie класса Movie и для каждой введенной строки(ключа):
8.1 получить объект используя MovieFactory.getMovie и присвоить его переменной movie
8.2 вывести на экран movie.getClass().getSimpleName()
        */

    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            //создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            }
            if ("cartoon".equals(key)) {
                movie = new Cartoon();
            }
            if ("thriller".equals(key)) {
                movie = new Thriller();
            }


            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    static class Cartoon extends Movie {
    }

    static class Thriller extends Movie {
    }
}
