/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/

package rollup.system.model;
import java.util.*;

// line 66 "../../../RollUp.ump"
public class Sensors
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Map<String, Sensors> sensorssBySensorID = new HashMap<String, Sensors>();

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Sensors Attributes
  private String sensorID;
  private boolean currentStatus;

  //Sensors Associations
  private Arduino arduino;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Sensors(String aSensorID, boolean aCurrentStatus, Arduino aArduino)
  {
    currentStatus = aCurrentStatus;
    if (!setSensorID(aSensorID))
    {
      throw new RuntimeException("Cannot create due to duplicate sensorID. See http://manual.umple.org?RE003ViolationofUniqueness.html");
    }
    boolean didAddArduino = setArduino(aArduino);
    if (!didAddArduino)
    {
      throw new RuntimeException("Unable to create sensor due to arduino. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSensorID(String aSensorID)
  {
    boolean wasSet = false;
    String anOldSensorID = getSensorID();
    if (anOldSensorID != null && anOldSensorID.equals(aSensorID)) {
      return true;
    }
    if (hasWithSensorID(aSensorID)) {
      return wasSet;
    }
    sensorID = aSensorID;
    wasSet = true;
    if (anOldSensorID != null) {
      sensorssBySensorID.remove(anOldSensorID);
    }
    sensorssBySensorID.put(aSensorID, this);
    return wasSet;
  }

  public boolean setCurrentStatus(boolean aCurrentStatus)
  {
    boolean wasSet = false;
    currentStatus = aCurrentStatus;
    wasSet = true;
    return wasSet;
  }

  public String getSensorID()
  {
    return sensorID;
  }
  /* Code from template attribute_GetUnique */
  public static Sensors getWithSensorID(String aSensorID)
  {
    return sensorssBySensorID.get(aSensorID);
  }
  /* Code from template attribute_HasUnique */
  public static boolean hasWithSensorID(String aSensorID)
  {
    return getWithSensorID(aSensorID) != null;
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
      existingArduino.removeSensor(this);
    }
    arduino.addSensor(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    sensorssBySensorID.remove(getSensorID());
    Arduino placeholderArduino = arduino;
    this.arduino = null;
    if(placeholderArduino != null)
    {
      placeholderArduino.removeSensor(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "sensorID" + ":" + getSensorID()+ "," +
            "currentStatus" + ":" + getCurrentStatus()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "arduino = "+(getArduino()!=null?Integer.toHexString(System.identityHashCode(getArduino())):"null");
  }
}