package mts.service.interfaces;

public interface IEmployee {
    Integer id = null;
    String firstName = null;
    String secondName = null;

    Integer getId();
    String getFirstName();
    String getSecondName();

    void setId(Integer id);
    void setFirstName(String firstName);
    void setSecondName(String secondName);
}
