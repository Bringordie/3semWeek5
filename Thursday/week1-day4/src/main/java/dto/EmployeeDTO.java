/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Employee;

/**
 *
 * @author frederikbraagaard
 */
public class EmployeeDTO {
    Long id;
    String name;
    String address;

    public EmployeeDTO(Employee employee) {
        this.address = employee.getAddress();
        this.name = employee.getName();
        this.id = employee.getId();
    }

    public EmployeeDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" + "id=" + id + ", name=" + name + ", address=" + address + '}';
    }
    
    


    
}
