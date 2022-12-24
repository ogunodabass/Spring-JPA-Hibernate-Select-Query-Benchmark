package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.example.demo.dto.UserDto1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;



@SqlResultSetMapping(name="Mapping.UserDto1",classes = {
		@ConstructorResult(targetClass = UserDto1.class,
				columns = {
						@ColumnResult(name = "id",type = Long.class),
						@ColumnResult(name = "email",type = String.class),
						@ColumnResult(name = "password",type = String.class),
						@ColumnResult(name = "adressId",type = Long.class),
						@ColumnResult(name = "no",type = Integer.class),
						@ColumnResult(name = "house",type = String.class)
				})
})
@NamedNativeQuery(name = "User.findAllNativeQuery2", 
query = "select u.id as id, u.email as email,u.password as password, a.id as adressId,a.no as no,a.house as house from user u left join adress a ON u.id = a.id", 
resultSetMapping = "Mapping.UserDto1")

@Data
@Builder(setterPrefix = "set")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table
@NamedEntityGraphs(value = @NamedEntityGraph(name = "graph_adress", attributeNodes = @NamedAttributeNode(value = "adress")))
public class User {

	@Id
	@SequenceGenerator(name = "user_sequence", sequenceName = "sq_user",allocationSize = 1_000)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
	private Long id;
	@Column
	private String email;
	@Column
	private String password;

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@ToString.Include(name = "id")
	private Adress adress;
/*
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", adress=" + this.getAdress().getId()
				+ "]";
	}
*/
}