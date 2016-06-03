package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import play.db.jpa.Blob;
import play.db.jpa.Model;



@Entity
@Table(name="`User`")
public class User extends Model
{
  
  public boolean usaCitizen;
  public String firstName;
  public String lastName;
  @OneToMany(mappedBy = "from", cascade = CascadeType.ALL)
  List<Donation> donations = new ArrayList<Donation>();
  
  public String email;
  public String password;
  
  public User(boolean usaCitizen, String firstName, String lastName, String email, String password)
  {
    this.usaCitizen = usaCitizen;
    this.firstName = firstName;
    this.lastName  = lastName;
    this.email = email;
    this.password  = password;
  }
  
  public User(String firstName2, String lastName2, String email2, String password2) {
	// TODO Auto-generated constructor stub
}

public static User findByEmail(String email)
  {
    return find("email", email).first();
  }

  public boolean checkPassword(String password)
  {
    return this.password.equals(password);
  }  
  
  //public void befriend(User friend)
  //{
   // Friendship friendship = new Friendship(this, friend);
   // friendships.add(friendship);
  //  friendship.save();
   // save();
  //}

 // public void unfriend(User friend)
  //{
   // Friendship thisFriendship = null;
    //
    //for (Friendship friendship : friendships)
    //{
     // if (friendship.targetUser == friend)
     // {
      //  thisFriendship = friendship;
      //}
   // }
   // friendships.remove(thisFriendship);
   // thisFriendship.delete();
   // save();
 // }
  
//  public void sendMessage (User to,String messagesubject, String messageText)
 // {
  //  Message message = new Message (this, to, messagesubject, messageText);
   // outbox.add(message);
    //to.inbox.add(message);
    //message.save();
    
//  } 
}