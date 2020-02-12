package mx.internetbrands.spring.beana.controller;

import mx.internetbrands.spring.beana.db.entity.jpa.EmployeesEntity;
import mx.internetbrands.spring.beana.db.repository.jpa.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {


    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index( ){
        ModelAndView modelAndView = new ModelAndView("new");
        EmployeesEntity emp=employeeRepository.findById(10001).orElse(new EmployeesEntity());
        System.out.println(emp.getSalariesByEmpNo());
        modelAndView.addObject("employee", emp);
        return modelAndView;
    }
}
