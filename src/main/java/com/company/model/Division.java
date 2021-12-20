package com.company.model;

/**
 * The class in which the data about the division is stored
 */
public class Division {

    /**
     * The field where the id is stored
     */
    private final long id;

    /**
     * The field in which the name of the division is stored
     */
    private final String name;

    /**
     * Designer
     * @param id id
     * @param name name of the division
     */
    public Division(long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Redefined method toString
     * @return  ID and name
     */
    @Override
    public String toString() {
        return "{" +
                "id: " + id +
                ", name: '" + name + '\'' +
                '}';
    }
}
