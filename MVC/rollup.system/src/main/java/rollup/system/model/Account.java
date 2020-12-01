/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/

package rollup.system.model;

// line 9 "../../../RollUp.ump"
public abstract class Account
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Account Attributes
  private String fullName;
  private String identificationNumber;
  private String personalEmailAddress;

  //Account Associations
  private RollUpSystem rollUpSystem;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Account(String aFullName, String aIdentificationNumber, String aPersonalEmailAddress, RollUpSystem aRollUpSystem)
  {
    fullName = aFullName;
    identificationNumber = aIdentificationNumber;
    personalEmailAddress = aPersonalEmailAddress;
    boolean didAddRollUpSystem = setRollUpSystem(aRollUpSystem);
    if (!didAddRollUpSystem)
    {
      throw new RuntimeException("Unable to create account due to rollUpSystem. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setFullName(String aFullName)
  {
    boolean wasSet = false;
    fullName = aFullName;
    wasSet = true;
    return wasSet;
  }

  public boolean setIdentificationNumber(String aIdentificationNumber)
  {
    boolean wasSet = false;
    identificationNumber = aIdentificationNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setPersonalEmailAddress(String aPersonalEmailAddress)
  {
    boolean wasSet = false;
    personalEmailAddress = aPersonalEmailAddress;
    wasSet = true;
    return wasSet;
  }

  public String getFullName()
  {
    return fullName;
  }

  public String getIdentificationNumber()
  {
    return identificationNumber;
  }

  public String getPersonalEmailAddress()
  {
    return personalEmailAddress;
  }
  /* Code from template association_GetOne */
  public RollUpSystem getRollUpSystem()
  {
    return rollUpSystem;
  }
  /* Code from template association_SetOneToMany */
  public boolean setRollUpSystem(RollUpSystem aRollUpSystem)
  {
    boolean wasSet = false;
    if (aRollUpSystem == null)
    {
      return wasSet;
    }

    RollUpSystem existingRollUpSystem = rollUpSystem;
    rollUpSystem = aRollUpSystem;
    if (existingRollUpSystem != null && !existingRollUpSystem.equals(aRollUpSystem))
    {
      existingRollUpSystem.removeAccount(this);
    }
    rollUpSystem.addAccount(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    RollUpSystem placeholderRollUpSystem = rollUpSystem;
    this.rollUpSystem = null;
    if(placeholderRollUpSystem != null)
    {
      placeholderRollUpSystem.removeAccount(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "fullName" + ":" + getFullName()+ "," +
            "identificationNumber" + ":" + getIdentificationNumber()+ "," +
            "personalEmailAddress" + ":" + getPersonalEmailAddress()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "rollUpSystem = "+(getRollUpSystem()!=null?Integer.toHexString(System.identityHashCode(getRollUpSystem())):"null");
  }
}