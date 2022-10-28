package com.mayank.st.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mayank.st.entity.Employee;
//Entity, primary key


public interface EmpRepository extends JpaRepository<Employee, Long>{

}
