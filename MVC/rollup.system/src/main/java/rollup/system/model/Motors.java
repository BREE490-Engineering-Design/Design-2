/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/

package rollup.system.model;
import java.util.*;

// line 61 "../../../RollUp.ump"
public class Motors
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Map<String, Motors> motorssByMotorID = new HashMap<String, Motors>();

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Motors Attributes
  private String motorID;
  private boolean currentStatus;

  //Motors Associations
  private Arduino arduino;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Motors(String aMotorID, boolean aCurrentStatus, Arduino aArduino)
  {
    currentStatus = aCurrentStatus;
    if (!setMotorID(aMotorID))
    {
      throw new RuntimeException("Cannot create due to duplicate motorID. See http://manual.umple.org?RE003ViolationofUniqueness.html");
    }
    boolean didAddArduino = setArduino(aArduino);
    if (!didAddArduino)
    {
      throw new RuntimeException("Unable to create motor due to arduino. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setMotorID(String aMotorID)
  {
    boolean wasSet = false;
    String anOldMotorID = getMotorID();
    if (anOldMotorID != null && anOldMotorID.equals(aMotorID)) {
      return true;
    }
    if (hasWithMotorID(aMotorID)) {
      return wasSet;
    }
    motorID = aMotorID;
    wasSet = true;
    if (anOldMotorID != null) {
      motorssByMotorID.remove(anOldMotorID);
    }
    motorssByMotorID.put(aMotorID, this);
    return wasSet;
  }

  public boolean setCurrentStatus(boolean aCurrentStatus)
  {
    boolean wasSet = false;
    currentStatus = aCurrentStatus;
    wasSet = true;
    return wasSet;
  }

  public String getMotorID()
  {
    return motorID;
  }
  /* Code from template attribute_GetUnique */
  public static Motors getWithMotorID(String aMotorID)
  {
    return motorssByMotorID.get(aMotorID);
  }
  /* Code from template attribute_HasUnique */
  public static boolean hasWithMotorID(String aMotorID)
  {
    return getWithMotorID(aMotorID) != null;
  }

  public boolean getCurrentStatus()
  {
    return currentStatus;
  }
  /* Code from template attribute_IsBoolean */
  public boolean isCurrentStatus()
  {
    return currentStatus;
  }
  /* Code from template association_GetOne */
  public Arduino getArduino()
  {
    return arduino;
  }
  /* Code from template association_SetOneToMany */
  public boolean setArduino(Arduino aArduino)
  {
    boolean wasSet = false;
    if (aArduino == null)
    {
      return wasSet;
    }

    Arduino existingArduino = arduino;
    arduino = aArduino;
    if (existingArduino != null && !existingArduino.equals(aArduino))
    {
      existingArduino.removeMotor(this);
    }
    arduino.addMotor(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    motorssByMotorID.remove(getMotorID());
    Arduino placeholderArduino = arduino;
    this.arduino = null;
    if(placeholderArduino != null)
    {
      placeholderArduino.removeMotor(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "motorID" + ":" + getMotorID()+ "," +
            "currentStatus" + ":" + getCurrentStatus()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "arduino = "+(getArduino()!=null?Integer.toHexString(System.identityHashCode(getArduino())):"null");
  }
}