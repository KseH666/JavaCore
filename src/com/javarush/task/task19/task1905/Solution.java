package com.javarush.task.task19.task1905;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        Contact contact = new Contact() {
            @Override
            public String getName() {
                return "Ivanov, Ivan";
            }

            @Override
            public String getPhoneNumber() {
                return "+38(050)123-45-67";
            }
        };
        Customer customer = new Customer() {
            @Override
            public String getCompanyName() {
                return "JavaRush Ltd.";
            }

            @Override
            public String getCountryName() {
                return "Ukraine";
            }
        };
        DataAdapter dataAdapter = new DataAdapter(customer, contact);
        System.out.println(dataAdapter.getCompany());
        System.out.println(dataAdapter.getContactFirstName());
        System.out.println(dataAdapter.getContactLastName());
        System.out.println(dataAdapter.getCountryCode());
        System.out.println(dataAdapter.getDialString());

    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            String desiredKey = null;
            for (Map.Entry<String, String> pair : countries.entrySet()) {
                if (pair.getValue().equals(customer.getCountryName())) {
                    desiredKey = pair.getKey();
                    break;
                }
            }
            return desiredKey;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            return contact.getName().substring(contact.getName().indexOf(",") + 2);
        }

        @Override
        public String getContactLastName() {
            return contact.getName().substring(0, contact.getName().indexOf(","));
        }

        @Override
        public String getDialString() {
                char[] c = contact.getPhoneNumber().toCharArray();
                String t = "";
                for(int z = 0; z< c.length; z++){
                    if(c[z]>='0'&&c[z]<='9'){
                        t =t+ c[z];
                    }
                }
            return "callto://"+t;
        }
    }

    public interface RowItem {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        String getDialString();         //For example: callto://+380501234567
    }

    public interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}