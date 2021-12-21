package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        IncomeData incomeData = new IncomeData() {
            @Override
            public String getCountryCode() {
                return "UA";
            }

            @Override
            public String getCompany() {
                return "JavaRush Ltd.";
            }

            @Override
            public String getContactFirstName() {
                return "Ivan";
            }

            @Override
            public String getContactLastName() {
                return "Ivanov";
            }

            @Override
            public int getCountryPhoneCode() {
                return 38;
            }

            @Override
            public int getPhoneNumber() {
                return 501234567;
            }
        };
        Customer c = new IncomeDataAdapter(incomeData);
        System.out.println(c.getCompanyName());
        System.out.println(c.getCountryName());
        Contact a = new IncomeDataAdapter(incomeData);
        System.out.println(a.getName());
        System.out.println(a.getPhoneNumber());
    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        public String getCompanyName() {
            return data.getCompany();
        }


        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }


        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }


        public String getPhoneNumber() {
            int phoneNumber = data.getPhoneNumber();
            String scale = String.format("%+d(%010d", data.getCountryPhoneCode(),phoneNumber);
            StringBuilder stringBuilder = new StringBuilder(scale);
            stringBuilder.insert(scale.length()-2,"-");
            stringBuilder.insert(scale.length()-4,"-");
            stringBuilder.insert(scale.length()-7,")");
            return String.valueOf(stringBuilder);
        }
    }


    public interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

    public interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}