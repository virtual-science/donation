package utils;
import java.util.Comparator;
import models.Donation;
import play.Logger;
public class DonationDateComparator  implements Comparator<Donation>
{
	@Override
	public int compare(Donation o1, Donation o2) 
	{
		return o1.dateDonated.compareTo(o2.dateDonated);
	}
	
}