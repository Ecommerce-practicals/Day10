package fas.ict.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import fas.ict.demo.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
