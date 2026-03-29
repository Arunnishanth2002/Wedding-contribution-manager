package com.moy.moyapp.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="moy_entry")
public class Entry
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String village;
    private Double amount;
    private String functionName;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date=new Date();

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setFunctionName(String functionName)
    {
        this.functionName = functionName;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getVillage() {
        return village;
    }

    public Double getAmount() {
        return amount;
    }

    public String getFunctionName() {
        return functionName;
    }

    public Date getDate() {
        return date;
    }
}
