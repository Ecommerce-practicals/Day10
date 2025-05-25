package fas.ict.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fas.ict.demo.model.Department;
import fas.ict.demo.service.DepartmentService;

@RestController
@RequestMapping("/dept")
public class DepartmentController {
	@Autowired
	public DepartmentService service;
	
	@GetMapping
	public ResponseEntity<List<Department>>getDepts(){
		return new ResponseEntity<List<Department>>
		(service.getDepts(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Department> getDept(@PathVariable("id") int id) {
		return new ResponseEntity<Department>(service.getDept(id),HttpStatus.OK);
	}

}
