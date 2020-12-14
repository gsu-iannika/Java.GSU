package com.by.gsu.pms.repo;



import java.sql.Date;
import java.util.List;

import com.by.gsu.pms.entity.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.by.gsu.pms.entity.Registration;
import com.by.gsu.pms.entity.User;
@Repository
public interface RegistrationRepository extends CrudRepository<Registration, Long> {
	
	
	public List<Registration> findByUser(User user);



	List<Registration> findAll();
	List<Registration> getAllByUser(User user);
	List<Registration> getAllByUserAndDate(User user, Date date);
	List<Registration> getAllByUserAndFlightClass(User author, Flight flight);
	Registration getFirstById(long id);

}
