package mts.service.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;


@Data
@Table(name = "positions")
public class Position {
    @Column(name = "id")
    private Integer id;

    @Column(name = "job")
    private String job;

    public Position(int id, String job){
        this.id = id;
        this.job = job;
    }

    public Position() {}

    public Integer getId(){
        return this.id;
    }
    public String getJob(){ return this.job; }

    public void setId(Integer id) { this.id = id; }
    public void setJob(String job) { this.job = job; }
}
