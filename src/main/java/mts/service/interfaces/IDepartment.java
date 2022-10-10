package mts.service.interfaces;

public interface IDepartment {
    String department = null;
    String job = null;
    String secondName = null;

    String getDepartment();
    String getJob();
    String getSecondName();

    void setDepartment(String department);
    void setJob(String job);
    void setSecondName(String secondName);
}
