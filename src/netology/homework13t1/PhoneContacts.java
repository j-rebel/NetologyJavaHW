package netology.homework13t1;

import java.util.*;

public class PhoneContacts {

    public HashMap<String, List<Contact>> contacts = new HashMap<>();

    public void addGroup(String groupName) {
        if (this.contacts.containsKey(groupName)) {
            System.out.println("Группа уже существует..");
        } else {
            this.contacts.put(groupName, new ArrayList<Contact>());
        }
    }

    public void addContact(String groupName, Contact contact) {
        List<Contact> list = this.contacts.get(groupName);
        if (this.contacts.containsKey(groupName)) {
            list.add(contact);
            Collections.sort(list);
        } else {
            addGroup(groupName);
            addContact(groupName, contact);
        }
    }

    public void printContacts() {
        System.out.println("Группы в справочнике:");
        if (!this.contacts.isEmpty()) {
            for (Map.Entry<String, List<Contact>> pair :
                    this.contacts.entrySet()) {
                System.out.println(pair.getKey());
                if (!pair.getValue().isEmpty()) {
                    for (Contact element : pair.getValue()) {
                        System.out.println(" - " + element.getName() + " - " + element.getNumber());
                    }
                } else {
                    System.out.println(" - Группа пуста.");
                }
            }
        } else {
            System.out.println(" - Нет ни одной группы.");
        }
    }

    public void printContactsOfACertainGroup(String groupName) {
        System.out.println("Контакты в группе \"" + groupName + "\":");

        if (!this.contacts.containsKey(groupName)) {
            System.out.println(" - Группа не существует..");
        } else if (!this.contacts.get(groupName).isEmpty()) {
            for (Contact contact : this.contacts.get(groupName)) {
                System.out.println(" - " + contact.getName() + " - " + contact.getNumber());
            }
        } else {
            System.out.println(" - Группа пуста.");
        }

    }

}
