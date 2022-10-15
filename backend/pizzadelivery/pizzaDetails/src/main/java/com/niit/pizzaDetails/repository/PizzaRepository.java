package com.niit.pizzaDetails.repository;

//import com.niit.pizzaDetails.model.User;
import com.niit.pizzaDetails.model.UserDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PizzaRepository extends MongoRepository<UserDetails, Integer> {

//    @Query("{'ProductDescription.productName':{$in:[?0]}}")
//    public List<Customer> findAllCustomerFromCustomerName(String custName);
//    public User findByUseridAndPassword(int userid, String password);

//    boolean findByEmailId(String emailId);

}
