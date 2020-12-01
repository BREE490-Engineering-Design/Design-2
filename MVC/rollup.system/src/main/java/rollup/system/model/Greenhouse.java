/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/

package rollup.system.model;
import java.util.*;

// line 30 "../../../RollUp.ump"
public class Greenhouse
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Greenhouse Associations
  private List<RollUpSection> rollUpSections;
  private ClimateControl climateControl;
  private OutdoorConditions outdoorConditions;
  private User user;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Greenhouse(ClimateControl aClimateControl, OutdoorConditions aOutdoorConditions, User aUser)
  {
    rollUpSections = new ArrayList<RollUpSection>();
    if (aClimateControl == null || aClimateControl.getGreenhouse() != null)
    {
      throw new RuntimeException("Unable to create Greenhouse due to aClimateControl. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    climateControl = aClimateControl;
    if (aOutdoorConditions == null || aOutdoorConditions.getGreenhouse() != null)
    {
      throw new RuntimeException("Unable to create Greenhouse due to aOutdoorConditions. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    outdoorConditions = aOutdoorConditions;
    boolean didAddUser = setUser(aUser);
    if (!didAddUser)
    {
      throw new RuntimeException("Unable to create greenhous due to user. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  public Greenhouse(String aWindSpeedForOutdoorConditions, String aTemperatureForOutdoorConditions, User aUser)
  {
    rollUpSections = new ArrayList<RollUpSection>();
    climateControl = new ClimateControl(this);
    outdoorConditions = new OutdoorConditions(aWindSpeedForOutdoorConditions, aTemperatureForOutdoorConditions, this);
    boolean didAddUser = setUser(aUser);
    if (!didAddUser)
    {
      throw new RuntimeException("Unable to create greenhous due to user. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public RollUpSection getRollUpSection(int index)
  {
    RollUpSection aRollUpSection = rollUpSections.get(index);
    return aRollUpSection;
  }

  public List<RollUpSection> getRollUpSections()
  {
    List<RollUpSection> newRollUpSections = Collections.unmodifiableList(rollUpSections);
    return newRollUpSections;
  }

  public int numberOfRollUpSections()
  {
    int number = rollUpSections.size();
    return number;
  }

  public boolean hasRollUpSections()
  {
    boolean has = rollUpSections.size() > 0;
    return has;
  }

  public int indexOfRollUpSection(RollUpSection aRollUpSection)
  {
    int index = rollUpSections.indexOf(aRollUpSection);
    return index;
  }
  /* Code from template association_GetOne */
  public ClimateControl getClimateControl()
  {
    return climateControl;
  }
  /* Code from template association_GetOne */
  public OutdoorConditions getOutdoorConditions()
  {
    return outdoorConditions;
  }
  /* Code from template association_GetOne */
  public User getUser()
  {
    return user;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfRollUpSections()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public RollUpSection addRollUpSection(String aSectionNumber, String aRollUp, String aRollDown, boolean aCurrentPosition, Arduino aArduino)
  {
    return new RollUpSection(aSectionNumber, aRollUp, aRollDown, aCurrentPosition, aArduino, this);
  }

  public boolean addRollUpSection(RollUpSection aRollUpSection)
  {
    boolean wasAdded = false;
    if (rollUpSections.contains(aRollUpSection)) { return false; }
    Greenhouse existingGreenhouse = aRollUpSection.getGreenhouse();
    boolean isNewGreenhouse = existingGreenhouse != null && !this.equals(existingGreenhouse);
    if (isNewGreenhouse)
    {
      aRollUpSection.setGreenhouse(this);
    }
    else
    {
      rollUpSections.add(aRollUpSection);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeRollUpSection(RollUpSection aRollUpSection)
  {
    boolean wasRemoved = false;
    //Unable to remove aRollUpSection, as it must always have a greenhouse
    if (!this.equals(aRollUpSection.getGreenhouse()))
    {
      rollUpSections.remove(aRollUpSection);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addRollUpSectionAt(RollUpSection aRollUpSection, int index)
  {  
    boolean wasAdded = false;
    if(addRollUpSection(aRollUpSection))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRollUpSections()) { index = numberOfRollUpSections() - 1; }
      rollUpSections.remove(aRollUpSection);
      rollUpSections.add(index, aRollUpSection);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveRollUpSectionAt(RollUpSection aRollUpSection, int index)
  {
    boolean wasAdded = false;
    if(rollUpSections.contains(aRollUpSection))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRollUpSections()) { index = numberOfRollUpSections() - 1; }
      rollUpSections.remove(aRollUpSection);
      rollUpSections.add(index, aRollUpSection);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addRollUpSectionAt(aRollUpSection, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOneToMany */
  public boolean setUser(User aUser)
  {
    boolean wasSet = false;
    if (aUser == null)
    {
      return wasSet;
    }

    User existingUser = user;
    user = aUser;
    if (existingUser != null && !existingUser.equals(aUser))
    {
      existingUser.removeGreenhous(this);
    }
    user.addGreenhous(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    while (rollUpSections.size() > 0)
    {
      RollUpSection aRollUpSection = rollUpSections.get(rollUpSections.size() - 1);
      aRollUpSection.delete();
      rollUpSections.remove(aRollUpSection);
    }
    
    ClimateControl existingClimateControl = climateControl;
    climateControl = null;
    if (existingClimateControl != null)
    {
      existingClimateControl.delete();
    }
    OutdoorConditions existingOutdoorConditions = outdoorConditions;
    outdoorConditions = null;
    if (existingOutdoorConditions != null)
    {
      existingOutdoorConditions.delete();
    }
    User placeholderUser = user;
    this.user = null;
    if(placeholderUser != null)
    {
      placeholderUser.removeGreenhous(this);
    }
  }

}