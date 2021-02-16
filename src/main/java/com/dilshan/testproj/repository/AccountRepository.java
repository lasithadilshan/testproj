package com.dilshan.testproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dilshan.testproj.entity.Account;


@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	
	@Query(value = "SELECT SUM(coun) FROM Account a WHERE a.employee_emp_id = ?1 AND a.leave_type_id = ?2", nativeQuery = true)
	Integer findCounts(Long employee_emp_id,Long leave_type_id);
	
//	@Query(value = "SELECT SUM(coun) FROM Account a WHERE a.employee_emp_id =:empId AND a.leave_type_leave_id =:leaveId" , nativeQuery = true)
//	Integer findByAccounts(@Param("empId") Long empId,@Param("leaveId") Long leaveId);

}
