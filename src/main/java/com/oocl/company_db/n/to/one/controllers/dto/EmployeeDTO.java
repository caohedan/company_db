package com.oocl.company_db.n.to.one.controllers.dto;


import com.oocl.company_db.n.to.one.entities.Employee;

public class EmployeeDTO {
    private final Long id;
    private final String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getCompanyId() {
        return companyId;
    }

    private final Long companyId;

    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.companyId = employee.getCompany().getId();
    }
}
