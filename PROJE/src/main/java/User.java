import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User.java
 * This is a model class represents a User entity
 * @author Ramesh Fadatare
 *
 */

@Entity
@Table(name="instructor")
public class User {
 
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 @Column(name="id")
 protected int id;
 
 @Column(name="name")
 protected String name;
 
 @Column(name="email")
 protected String email;
 
 @Column(name="password")
 protected String password;
 
 public User() {
 }
 
 public User(String name, String email, String password) {
  super();
  this.name = name;
  this.email = email;
  this.password = password;
 }

 public User(int id, String name, String email, String country) {
  super();
  this.id = id;
  this.name = name;
  this.email = email;
  this.password = password;
 }

 public int getId() {
  return id;
 }
 public void setId(int id) {
  this.id = id;
 }
 public String getName() {
  return name;
 }
 public void setName(String name) {
  this.name = name;
 }
 public String getEmail() {
  return email;
 }
 public void setEmail(String email) {
  this.email = email;
 }
 public String getCountry() {
  return password;
 }
 public void setCountry(String password) {
  this.password = password;
 }
}