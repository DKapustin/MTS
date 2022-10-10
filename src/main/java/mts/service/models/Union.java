package mts.service.models;

import mts.service.interfaces.IUnion;

/* Класс для запросов одновременно из всех таблиц*/
public class Union implements IUnion {
    public Integer id;
    public String firstName;
    public String secondName;
    public String job;
    public String department;

    public Union(){}
    public Union(Integer id, String firstName, String secondName, String job, String department){
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.job =job;
        this.department = department;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getSecondName() {
        return this.secondName;
    }

    @Override
    public String getJob() {
        return this.job;
    }

    @Override
    public String getDepartment() {
        return this.department;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public void setDepartment(String department) {
        this.department = department;
    }
}
