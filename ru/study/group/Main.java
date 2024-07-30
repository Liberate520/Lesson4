package ru.study.group;

public class Main {
    public static void main(String[] args) {

        Service service = new Service();
        service.addStudent("Dasha", 17);
        service.addStudent("Pasha", 18);
        service.addStudent("Dima", 20);
        service.addStudent("Diana", 19);

        System.out.println(service.getStudentsListInfo());
        service.sortByName();
        System.out.println(service.getStudentsListInfo());
        service.sortByAge();
        System.out.println(service.getStudentsListInfo());

    }



}

