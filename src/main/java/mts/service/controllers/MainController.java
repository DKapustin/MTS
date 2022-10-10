package mts.service.controllers;

import mts.service.dao.MainDAO;
import mts.service.models.Employee;
import mts.service.models.Union;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/main")
public class MainController {
    private final MainDAO mainDAO;
    @Autowired
    public MainController(MainDAO mainDAO){
        this.mainDAO = mainDAO;
    }

    /* Get - Получить список всех сотрудников (id, Имя, Фамилия, Должность, Отдел) */
    @GetMapping("/all")
    public List<Object> allData(){
        return mainDAO.allData();
    }

    /* Get - Получить данные одного сотрудника по id (Имя, Фамилия, Должность, Отдел) */
    @GetMapping("/{id}")
    public Object fullInfo(@PathVariable("id")int id){
        return mainDAO.fullInfo(id);
    }

    /* Get - Получить список всех сотрудников из 1й таблицы */
    @GetMapping("/employees")
    public List<Employee> indexEmployees(){
        return mainDAO.indexEmployees();
    }

    /* Get - Получить список всех отделов из 3й таблицы */
    @GetMapping("/departments")
    public List<String> indexDepartments(){
        return mainDAO.indexDepartments();
    }

    /* Get - Получить список всех должностей из 2й таблицы */
    @GetMapping("/positions")
    public List<String> indexPositions(){
        return mainDAO.indexPositions();
    }

    /* Post - Добавить сотрудника на существующую должность в существующий отдел */
    @PostMapping("/create")
    public void insertEmployee(@RequestBody Union union){
        mainDAO.insertEmployee(union);
    }
}
