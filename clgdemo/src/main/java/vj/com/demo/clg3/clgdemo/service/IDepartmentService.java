package vj.com.demo.clg3.clgdemo.service;

import vj.com.demo.clg3.clgdemo.entity.Department;
import vj.com.demo.clg3.clgdemo.error.DepartmentNotFoundException;

import java.util.List;

public interface IDepartmentService {
    public List<Department> fetchDepartmentList();
    public Department saveDepartment(Department department);
    public Department fetchDepartmentByName(String Name);
    public Department fetchDepartmentByID(Long departmentID) throws DepartmentNotFoundException;
    public void deleteDepartmentById(Long DepartmentID);
    public Department updateDepartment(Long depatmentId, Department department);

}
