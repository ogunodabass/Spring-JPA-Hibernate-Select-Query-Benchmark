package com.example.demo.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.transform.ResultTransformer;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.UserDto1;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserEntityManegerRepository {

	@PersistenceContext
	private final EntityManager em;

	public List<UserDto1> findAllEM() {
		String sql = "select u.id, u.email,u.password, u.adress.id, u.adress.no, u.adress.house from User u";
		@SuppressWarnings({ "deprecation", "unchecked", "serial" })
		List<UserDto1> resultList = em.createQuery(sql).unwrap(org.hibernate.query.Query.class)
				.setResultTransformer(new ResultTransformer() {

					@Override
					public Object transformTuple(Object[] tuple, String[] aliases) {
						UserDto1 dto = new UserDto1((Long) tuple[0], (String) tuple[1], (String) tuple[2],
								(Long) tuple[3], (Integer) tuple[4], (String) tuple[5]);
						return dto;
					}

					@SuppressWarnings("rawtypes")
					@Override
					public List transformList(List collection) {
						return collection;
					}
				}).getResultList();
		return resultList;
	}
}
