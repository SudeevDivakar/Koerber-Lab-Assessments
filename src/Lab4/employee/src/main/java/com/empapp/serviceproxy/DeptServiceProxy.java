package com.empapp.serviceproxy;

import com.empapp.dto.Department;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(name="deptapp")
public interface DeptServiceProxy {
    @CircuitBreaker(name = "departmentServiceProxy", fallbackMethod = "departmentFallback")
    @GetMapping("departments/{name}")
    public Department getByName(@PathVariable String name);

    default Department departmentFallback(Exception ex) {
        return new Department(1, "Log", null);
    }
}
