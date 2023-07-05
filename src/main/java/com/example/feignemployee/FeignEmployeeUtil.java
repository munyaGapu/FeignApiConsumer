package com.example.feignemployee;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "feignEmployee",url = "http://localhost:8080/api")
public interface FeignEmployeeUtil {
    @GetMapping("/all")
    public List<Employee> employees();

    @PostMapping(path = "/add",consumes = "application/json")
    public void add(@RequestBody Employee employee);
    @DeleteMapping(path = "{empid}")
    public void delete(@PathVariable("empid") Long empid );
    @PutMapping(path = "{empid}")
    public void update(@PathVariable("empid") Long empid,@RequestParam(required = false) String name,
                       @RequestParam(required = false) String dept);

}
