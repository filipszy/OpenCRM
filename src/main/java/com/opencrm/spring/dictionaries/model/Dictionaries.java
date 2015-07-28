package com.opencrm.spring.dictionaries.model;

import javax.persistence.*;

/**
 * Created by Filip Szylderowicz on 28.07.15.
 */
@Entity(name = "dictionaries")
public class Dictionaries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int Id;

    @Column(name = "module", unique = false, nullable = false)
    private String Module;

    @Column(name = "type", unique = false, nullable = false)
    private String Type;

    @Column(name = "value", unique = false, nullable = false)
    private String Value;

    @Column(name = "name", unique = false, nullable = false)
    private String Name;

    @Column(name = "description", unique = false, nullable = true)
    private String Description;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getModule() {
        return Module;
    }

    public void setModule(String module) {
        Module = module;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
