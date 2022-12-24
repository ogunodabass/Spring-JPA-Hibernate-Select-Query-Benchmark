Solitions						Sepeed		Data(Mb)		Endpoints

UserDTO1-JPA		 			 561ms		5.71			http://localhost:8080/ex1
UserDto1-HQL		 			 597ms		5.71			http://localhost:8080/ex11
Obect[]ToUserDto1-HQL		 	 703ms		5.71			http://localhost:8080/ex111
ResultTransformerToUserDto1-HQL	 625ms		5.71			http://localhost:8080/ex1111
UserProjection-JPA  			3990ms		5.56			http://localhost:8080/ex2
UserProjection-HQL				4510ms		5.56			http://localhost:8080/ex22
User-JPA						1056ms		5.56			http://localhost:8080/ex3
UserToUserDto1-JPA				1197ms		5.71			http://localhost:8080/ex4
Object[]-HQL	 	 			 582ms		3.04			http://localhost:8080/ex5
Streamable<User>-HQL		 	 616ms		3.04			http://localhost:8080/ex6
TupleToget(int,Class<T>)-HQL 	 719ms		5.71			http://localhost:8080/ex7
Object[]-NativeQuery	 	 	 577ms		3.04			http://localhost:8080/ex8
UserDto1-NativeQuery	 	 	 735ms		5.71			http://localhost:8080/ex9

UserDto2-JPA					531ms		4.67			http://localhost:8080/exDynamic1
ArrayToUserDto2-HQL				602ms		4.67 			http://localhost:8080/exDynamic11
UserDto2-HQL					651ms		4.67			http://localhost:8080/exDynamic111
UserDto3-JPA					512ms		4.15			http://localhost:8080/exDynamic2
UserDto4-JPA					406ms		2.97			http://localhost:8080/exDynamic3
UserDto5-JPA					364ms		1.65			http://localhost:8080/exDynamic4


# run configration->VM Arguments: -Xms5120M -Xmx10240M
# Java 15.0.2
# Computer Specifications Ram 16Gb, 2.70GHz, 4 CPU, Intel İ7-7500U

#https://vladmihalcea.com/hibernate-tupletransformer/
#https://spring.io/guides/gs/testing-web/
#https://vladmihalcea.com/jpa-sqlresultsetmapping/
#https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#projections
#https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#projections.dtos

#projections.dtos:
Another way of defining projections is by using value type DTOs (Data Transfer Objects) that hold properties for the fields that are supposed to be retrieved. These DTO types can be used in exactly the same way projection interfaces are used, except that no proxying happens and no nested projections can be applied.

#Example UserDto1,UserDto2,UserDto3,UserDto4 .class http://localhost:8080/exDynamic***
Dont n+1 problem, Lazy auto join
