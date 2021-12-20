package com.company.model;

import java.time.LocalDate;

/**
 * A class that stores information about a person
 */
public class Human {

    /**
     * Field with id
     */
    private final long id;

    /**
     * The field where the person's name is stored
     */
    private final String name;

    /**
     * The field in which the gender of a person is stored
     */
    private final String male;

    /**
     * The field where a person's date of birth is stored
     */
    private final LocalDate birthDate;

    /**
     * The field in which the person's division is stored
     */
    private final Division division;

    /**
     * The field where the person's salary is stored
     */
    private final double salary;

    /**
     * Designer
     * @param id human id
     * @param name human name
     * @param male human male
     * @param birthDate human birthDate
     * @param division human division
     * @param salary human salary
     */
    public Human(long id, String name, String male, LocalDate birthDate, Division division, double salary) {
        this.id = id;
        this.name = name;
        this.male = male;
        this.birthDate = birthDate;
        this.division = division;
        this.salary = salary;
    }

    /**
     * Redefined method toString
     * @return information about a person
     */
    @Override
    public String toString() {
        return "{" +
                "id: " + id +
                ", name: " + name + '\'' +
                ", male: " + male + '\'' +
                ", birthDate: " + birthDate +
                ", division: " + division +
                ", salary: "  + salary +
                '}';
    }
}
