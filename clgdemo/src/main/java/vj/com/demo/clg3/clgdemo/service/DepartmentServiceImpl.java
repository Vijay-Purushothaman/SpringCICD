package vj.com.demo.clg3.clgdemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vj.com.demo.clg3.clgdemo.controller.MsgController;
import vj.com.demo.clg3.clgdemo.entity.Department;
import vj.com.demo.clg3.clgdemo.error.DepartmentNotFoundException;
import vj.com.demo.clg3.clgdemo.repository.DepartmentIRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    private static final Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);
    @Autowired
    private DepartmentIRepository repository;

    @Override
    public Department saveDepartment(Department department) {
        return repository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return repository.findAll();
    }
    @Override
    public Department fetchDepartmentByName(String name) {
        logger.info("DepartmentServiceImpl ..fetchDepartmentByName is calling ..."+name);
        return repository.findByDeptNameIgnoreCase(name);
    }

    @Override
    public Department fetchDepartmentByID(Long departmentID) throws DepartmentNotFoundException {
        logger.info("DepartmentServiceImpl ..fetchDepartmentByID is calling ..."+departmentID);
        Optional<Department> department = repository.findById(departmentID);
        logger.info("department is ..."+department);
        if (!department.isPresent()){
        throw new DepartmentNotFoundException("Department Not Available");
        }
        return department.get();
    }

     @Override
    public void deleteDepartmentById(Long departmentID) {
        repository.deleteById(departmentID);

    }

    @Override
    public Department updateDepartment(Long departmentId, Department dept) {
        logger.info("DepartmentServiceImpl ..departmentId is  ..."+departmentId+"..."+dept);
        Department departmentDb = repository.findById(departmentId).get();
        logger.info("DepartmentServiceImpl ..departmentDb is  ..."+departmentDb);
        logger.info("DepartmentServiceImpl ..name is  ..."+dept.getDeptName());
        if (Objects.nonNull(dept.getDeptName()) && !"".equalsIgnoreCase(dept.getDeptName())){
            departmentDb.setDeptName(dept.getDeptName());
        }
        logger.info("DepartmentServiceImpl ..getDeptCode is  ..."+dept.getDeptCode());
        if (Objects.nonNull(dept.getDeptCode()) && !"".equalsIgnoreCase(dept.getDeptCode())){
            departmentDb.setDeptCode(dept.getDeptCode());
        }
        logger.info("DepartmentServiceImpl.. oveall ..dept is  ..."+dept);

        return repository.save(departmentDb);
    }
}
