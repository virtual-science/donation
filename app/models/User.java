package models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import play.db.jpa.Blob;
import play.db.jpa.Model;
import play.Logger;


@Entity
public class User extends Model
{
  
  public boolean usaCitizen;
  public String firstName;
  public String lastName;
  public String email;
  public String password;
  
 // @OneToMany(mappedBy = "from_id") 
//  public List<Donation> donations = new ArrayList<Donation>();

  
  public User(boolean usaCitizen, String firstName, String lastName, String email, String password)
  {
    this.usaCitizen = usaCitizen;
    this.firstName = firstName;
    this.lastName  = lastName;
    this.email = email;
    this.password  = password;
  }
  
 public static User findByEmail(String email)
  {
    return find("email", email).first();
  }

  public boolean checkPassword(String password)
  {
    return this.password.equals(password);
  }
    
}
  