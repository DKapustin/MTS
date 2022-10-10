package mts.service.interfaces;

public interface IUnion extends IDepartment, IPosition, IEmployee {
    Integer id = null;
    String firstName = null;
    String secondName = null;
    String job = null;
    String department = null;

    Integer getId();
    String getFirstName();
    String getSecondName();
    String getJob();
    String getDepartment();

    @Override
    void setId(Integer id);
    @Override
    void setFirstName(String firstName);
    @Override
    void setSecondName(String secondName);
    @Override
    void setJob(String job);
    @Override
    void setDepartment(String department);
}
