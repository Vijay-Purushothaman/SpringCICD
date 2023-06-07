package vj.com.demo.clg3.clgdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vj.com.demo.clg3.clgdemo.entity.Department;

@Repository
public interface DepartmentIRepository extends JpaRepository<Department, Long> {
    public Department findByDeptName(String departmentName);
    public Department findByDeptNameIgnoreCase(String departmentName);
}
