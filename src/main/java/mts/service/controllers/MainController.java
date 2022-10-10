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

    @GetMapping("/all")
    public List<Object> allData(){
        return mainDAO.allData();
    }

    @GetMapping("/{id}")
    public Object fullInfo(@PathVariable("id")int id){
        return mainDAO.fullInfo(id);
    }

    @GetMapping("/employees")
    public List<Employee> indexEmployees(){
        return mainDAO.indexEmployees();
    }

    @GetMapping("/departments")
    public List<String> indexDepartments(){
        return mainDAO.indexDepartments();
    }

    @GetMapping("/positions")
    public List<String> indexPositions(){
        return mainDAO.indexPositions();
    }

    @PostMapping("/create")
    public void insertEmployee(@RequestBody Union union){
        mainDAO.insertEmployee(union);
    }
}
