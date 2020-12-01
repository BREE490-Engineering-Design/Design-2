/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/

package rollup.system.model;
import java.util.*;

// line 16 "../../../RollUp.ump"
public class User extends Account
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //User Attributes
  private String username;
  private String password;
  private Business specifiedBusiness;

  //User Associations
  private List<Greenhouse> greenhouses;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public User(String aFullName, String aIdentificationNumber, String aPersonalEmailAddress, RollUpSystem aRollUpSystem, String aUsername, Business aSpecifiedBusiness)
  {
    super(aFullName, aIdentificationNumber, aPersonalEmailAddress, aRollUpSystem);
    username = aUsername;
    resetPassword();
    specifiedBusiness = aSpecifiedBusiness;
    greenhouses = new ArrayList<Greenhouse>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setUsername(String aUsername)
  {
    boolean wasSet = false;
    username = aUsername;
    wasSet = true;
    return wasSet;
  }
  /* Code from template attribute_SetDefaulted */
  public boolean setPassword(String aPassword)
  {
    boolean wasSet = false;
    password = aPassword;
    wasSet = true;
    return wasSet;
  }

  public boolean resetPassword()
  {
    boolean wasReset = false;
    password = getDefaultPassword();
    wasReset = true;
    return wasReset;
  }

  public boolean setSpecifiedBusiness(Business aSpecifiedBusiness)
  {
    boolean wasSet = false;
    specifiedBusiness = aSpecifiedBusiness;
    wasSet = true;
    return wasSet;
  }

  public String getUsername()
  {
    return username;
  }

  public String getPassword()
  {
    return password;
  }
  /* Code from template attribute_GetDefaulted */
  public String getDefaultPassword()
  {
    return "password";
  }

  public Business getSpecifiedBusiness()
  {
    return specifiedBusiness;
  }
  /* Code from template association_GetMany */
  public Greenhouse getGreenhous(int index)
  {
    Greenhouse aGreenhous = greenhouses.get(index);
    return aGreenhous;
  }

  public List<Greenhouse> getGreenhouses()
  {
    List<Greenhouse> newGreenhouses = Collections.unmodifiableList(greenhouses);
    return newGreenhouses;
  }

  public int numberOfGreenhouses()
  {
    int number = greenhouses.size();
    return number;
  }

  public boolean hasGreenhouses()
  {
    boolean has = greenhouses.size() > 0;
    return has;
  }

  public int indexOfGreenhous(Greenhouse aGreenhous)
  {
    int index = greenhouses.indexOf(aGreenhous);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfGreenhouses()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Greenhouse addGreenhous(ClimateControl aClimateControl, OutdoorConditions aOutdoorConditions)
  {
    return new Greenhouse(aClimateControl, aOutdoorConditions, this);
  }

  public boolean addGreenhous(Greenhouse aGreenhous)
  {
    boolean wasAdded = false;
    if (greenhouses.contains(aGreenhous)) { return false; }
    User existingUser = aGreenhous.getUser();
    boolean isNewUser = existingUser != null && !this.equals(existingUser);
    if (isNewUser)
    {
      aGreenhous.setUser(this);
    }
    else
    {
      greenhouses.add(aGreenhous);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeGreenhous(Greenhouse aGreenhous)
  {
    boolean wasRemoved = false;
    //Unable to remove aGreenhous, as it must always have a user
    if (!this.equals(aGreenhous.getUser()))
    {
      greenhouses.remove(aGreenhous);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addGreenhousAt(Greenhouse aGreenhous, int index)
  {  
    boolean wasAdded = false;
    if(addGreenhous(aGreenhous))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfGreenhouses()) { index = numberOfGreenhouses() - 1; }
      greenhouses.remove(aGreenhous);
      greenhouses.add(index, aGreenhous);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveGreenhousAt(Greenhouse aGreenhous, int index)
  {
    boolean wasAdded = false;
    if(greenhouses.contains(aGreenhous))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfGreenhouses()) { index = numberOfGreenhouses() - 1; }
      greenhouses.remove(aGreenhous);
      greenhouses.add(index, aGreenhous);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addGreenhousAt(aGreenhous, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=greenhouses.size(); i > 0; i--)
    {
      Greenhouse aGreenhous = greenhouses.get(i - 1);
      aGreenhous.delete();
    }
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "username" + ":" + getUsername()+ "," +
            "password" + ":" + getPassword()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "specifiedBusiness" + "=" + (getSpecifiedBusiness() != null ? !getSpecifiedBusiness().equals(this)  ? getSpecifiedBusiness().toString().replaceAll("  ","    ") : "this" : "null");
  }
}