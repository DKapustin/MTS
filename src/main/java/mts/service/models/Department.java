package mts.service.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import mts.service.interfaces.IDepartment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Table(name = "departments")
public class Department implements IDepartment {
    @Column(name = "department")
    private String department;

    @Column(name = "job")
    private String job;

    @Column(name = "secondName")
    private String secondName;

    public Department(){};
    public Department(String department, String job, String secondName){
        this.department = department;
        this.job = job;
        this.secondName = secondName;
    }

    public String getDepartment() { return this.department; }
    public String getJob() { return this.job; }
    public String getSecondName() { return this.secondName; }

    public void setDepartment(String department) { this.department = department; }
    public void setJob(String job) { this.job = job; }
    public void setSecondName(String secondName) { this.secondName = secondName; }
}
