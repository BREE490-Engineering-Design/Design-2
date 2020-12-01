/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/

package rollup.system.model;
import java.util.*;

// line 24 "../../../RollUp.ump"
public class AdminAccount extends Account
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Map<String, AdminAccount> adminaccountsByAdminUsername = new HashMap<String, AdminAccount>();

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //AdminAccount Attributes
  private String adminUsername;
  private String adminPassword;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public AdminAccount(String aFullName, String aIdentificationNumber, String aPersonalEmailAddress, RollUpSystem aRollUpSystem, String aAdminUsername, String aAdminPassword)
  {
    super(aFullName, aIdentificationNumber, aPersonalEmailAddress, aRollUpSystem);
    adminPassword = aAdminPassword;
    if (!setAdminUsername(aAdminUsername))
    {
      throw new RuntimeException("Cannot create due to duplicate adminUsername. See http://manual.umple.org?RE003ViolationofUniqueness.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAdminUsername(String aAdminUsername)
  {
    boolean wasSet = false;
    String anOldAdminUsername = getAdminUsername();
    if (anOldAdminUsername != null && anOldAdminUsername.equals(aAdminUsername)) {
      return true;
    }
    if (hasWithAdminUsername(aAdminUsername)) {
      return wasSet;
    }
    adminUsername = aAdminUsername;
    wasSet = true;
    if (anOldAdminUsername != null) {
      adminaccountsByAdminUsername.remove(anOldAdminUsername);
    }
    adminaccountsByAdminUsername.put(aAdminUsername, this);
    return wasSet;
  }

  public boolean setAdminPassword(String aAdminPassword)
  {
    boolean wasSet = false;
    adminPassword = aAdminPassword;
    wasSet = true;
    return wasSet;
  }

  public String getAdminUsername()
  {
    return adminUsername;
  }
  /* Code from template attribute_GetUnique */
  public static AdminAccount getWithAdminUsername(String aAdminUsername)
  {
    return adminaccountsByAdminUsername.get(aAdminUsername);
  }
  /* Code from template attribute_HasUnique */
  public static boolean hasWithAdminUsername(String aAdminUsername)
  {
    return getWithAdminUsername(aAdminUsername) != null;
  }

  public String getAdminPassword()
  {
    return adminPassword;
  }

  public void delete()
  {
    adminaccountsByAdminUsername.remove(getAdminUsername());
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "adminUsername" + ":" + getAdminUsername()+ "," +
            "adminPassword" + ":" + getAdminPassword()+ "]";
  }
}