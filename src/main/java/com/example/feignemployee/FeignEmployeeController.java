package com.example.feignemployee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consume")
public class FeignEmployeeController {
    @Autowired
    private FeignEmployeeUtil feignEmployeeUtil;

    @GetMapping("/all")
    public List<Employee> employees(){
        return feignEmployeeUtil.employees();
    }

    @PostMapping(path = "/add",consumes = "application/json")
    public void add(@RequestBody Employee employee){
        feignEmployeeUtil.add(employee);
    }
    @DeleteMapping(path = "{empid}")
    public void delete(@PathVariable("empid") Long empid ){
        feignEmployeeUtil.delete(empid);
    }
    @PutMapping(path = "{empid}")
    public void update(@PathVariable("empid") Long empid,@RequestParam(required = false) String name,
                       @RequestParam(required = false) String dept){
        feignEmployeeUtil.update(empid,name,dept);
    }

}
