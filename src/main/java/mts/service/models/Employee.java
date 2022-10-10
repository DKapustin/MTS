package mts.service.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

/* Класс для таблицы 1 */
@Entity
@Table(name = "personalInfo")
@Data
public class Employee {
    @Id
    @Column(name = "id")

    @SequenceGenerator(name = "personalInfoIdSeq", sequenceName = "personalInfo_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personalInfoIdSeq")
    private Integer id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "secondName")
    private String secondName;

    public Employee(int id, String firstName, String secondName){
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
    }
    public Employee() {}

    public Integer getId(){
        return this.id;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public String getSecondName() {
        return this.secondName;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
