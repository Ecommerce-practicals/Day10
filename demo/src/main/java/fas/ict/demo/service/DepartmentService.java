package fas.ict.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import fas.ict.demo.model.Department;
import fas.ict.demo.repo.DepartmentRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class DepartmentService {
    @Autowired
	private DepartmentRepository repo;
	
	public List<Department> getDepts(){
		return repo.findAll();
	}
	public Department getDept( int id) {
		if(repo.findById(id).isEmpty()) {
			throw new EntityNotFoundException("Department Not Found");
		}
		return repo.findById(id).get();
	}
	
	public String addDept(Department department) {
		if(repo.findById(department.getId()).isPresent()) {
			throw new DuplicateKeyException("The department id is already available");
		}
		repo.save(department);
		return "new department added";
	}
	
}
