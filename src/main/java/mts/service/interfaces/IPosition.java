package mts.service.interfaces;

public interface IPosition {
    Integer id = null;
    String job = null;

    Integer getId();
    String getJob();

    void setId(Integer id);
    void setJob(String job);
}
