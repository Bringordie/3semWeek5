/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Employee;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author frederikbraagaard
 */
public class EmployeeListDTO {
    List<EmployeeDTO> employee;
    
    public EmployeeListDTO(List<Employee> e) {
        List<EmployeeDTO> employees = new ArrayList();
        for (Employee employee : e) {
            employees.add(new EmployeeDTO(employee));
        }
    }
    
    public List<EmployeeDTO> getEmployeeDTOs() {
        return employee;
    }
    
}
