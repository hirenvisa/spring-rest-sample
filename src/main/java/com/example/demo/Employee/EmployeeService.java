package com.example.demo.Employee;

import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;


    public EmployeeService(EmployeeRepository employeeRepository ){
        this.employeeRepository = employeeRepository;
    }
    public EmployeeDto getEmployeeById(Integer Id){
        Employee emp = employeeRepository.getReferenceById(Id);
        if(emp == null) return null;
        ModelMapper modelMapper = new ModelMapper();
        EmployeeDto employeeDto = modelMapper.map(emp, EmployeeDto.class);

        return employeeDto;
    }
}
