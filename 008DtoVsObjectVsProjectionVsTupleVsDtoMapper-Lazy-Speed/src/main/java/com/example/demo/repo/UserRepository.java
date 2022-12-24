package com.example.demo.repo;

import java.util.List;

import javax.persistence.Tuple;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.util.Streamable;

import com.example.demo.dto.UserDto1;
import com.example.demo.dto.UserDto2;
import com.example.demo.entity.User;
import com.example.demo.projections.UserProjection;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>{

	public <T> List<T> findBy(Class<T> clazz);

	
	@Query("select new com.example.demo.dto.UserDto1(u.id, u.email,u.password, u.adress.id, u.adress.no, u.adress.house) from User u")
	public List<UserDto1> findUserDto1();
	
	
	@Query("select new com.example.demo.dto.UserDto2(u.id, u.email,u.password, u.adress.id, u.adress.no) from User u")
	public List<UserDto2> findUserDto2();
	

	@EntityGraph(type = EntityGraphType.FETCH, value = "graph_adress")
	
	@Query("select u from User u")
	public List<UserProjection> findUserProjection();

	@EntityGraph(type = EntityGraphType.FETCH, value = "graph_adress")
	public List<User> findAll();

	
	@Query("select u.id, u.email,u.password,u.adress.id,u.adress.no,u.adress.house from User u")
	public List<Object[]> findAllObjectArray();
	
	
	@Query("select u.id, u.email,u.password,u.adress.id,u.adress.no from User u")
	public List<Object[]> findAllObjectArray2();

	
	@Query("select u.id, u.email,u.password,u.adress.id,u.adress.no,u.adress.house from User u")
	public Streamable<User> findAllStream();

	
	@Query("select u.id, u.email,u.password,u.adress.id,u.adress.no,u.adress.house from User u")
	public List<Tuple> findAllTuple();

	
	@Query(value = "select u.id, u.email,u.password, a.id as adressId,a.no,a.house from user u left join adress a ON u.id = a.id", nativeQuery = true)
	public List<Object[]> findAllNativeQuery();

	
	@Query(nativeQuery = true)
	public List<UserDto1> findAllNativeQuery2();

}
