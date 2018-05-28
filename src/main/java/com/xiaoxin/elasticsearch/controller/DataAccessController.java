package com.xiaoxin.elasticsearch.controller;

import com.xiaoxin.elasticsearch.model.Employee;
import com.xiaoxin.elasticsearch.repository.EmployeeRepository;
import com.xiaoxin.elasticsearch.service.EmployeeService;
import com.xiaoxin.validator.model.Result;
import com.xiaoxin.validator.model.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther zhangyongxin
 * @date 2018/5/27 下午2:17
 */
@RestController
@RequestMapping("elasticSearch")
public class DataAccessController {
    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getAll")
    public Result getAll() {
        List<Employee> employeeList = new ArrayList<>();
//        repository.findAll().forEach(employeeList::add);
//        repository.findByInterest("rock climbing").forEach(employeeList::add);
//        repository.findByFirstName("John").forEach(employeeList::add);
        employeeService.findAll().forEach(employeeList::add);
        return ResultGenerator.genSuccessResult(employeeList);
    }

    /**
     * 关键字搜索
     * @param keyWord
     * @return
     */
    @GetMapping("/findByKeywordAndSortByAge")
    public Result findByKeywordAndSortByAge(String keyWord) {
        List<Employee>  employeeList =employeeService.findByKeywordAndSortByAge(keyWord);
        return ResultGenerator.genSuccessResult(employeeList);
    }

    @PostMapping("/addOne")
    public Result addOne(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/deleteAll")
    public Result deleteAll() {
        repository.deleteAll();
        return ResultGenerator.genSuccessResult();
    }
}
