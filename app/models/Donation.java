package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Donation extends Model 
{
public long received;
public String methodDonated;
public long from_id;
public Date dateDonated;



public Donation(long from_id, long received, String methodDonated)
{
this.received = received;
this.methodDonated = methodDonated;
this.from_id = from_id;
this.dateDonated = new Date();
}
}
