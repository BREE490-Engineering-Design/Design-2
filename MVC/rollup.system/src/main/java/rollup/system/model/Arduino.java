/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/

package rollup.system.model;
import java.util.*;

// line 53 "../../../RollUp.ump"
public class Arduino
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Arduino Attributes
  private String boardID;
  private String input;
  private String output;

  //Arduino Associations
  private List<Motors> motors;
  private List<Sensors> sensors;
  private RollUpSection rollUpSection;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Arduino(String aBoardID, String aInput, String aOutput, RollUpSection aRollUpSection)
  {
    boardID = aBoardID;
    input = aInput;
    output = aOutput;
    motors = new ArrayList<Motors>();
    sensors = new ArrayList<Sensors>();
    if (aRollUpSection == null || aRollUpSection.getArduino() != null)
    {
      throw new RuntimeException("Unable to create Arduino due to aRollUpSection. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    rollUpSection = aRollUpSection;
  }

  public Arduino(String aBoardID, String aInput, String aOutput, String aSectionNumberForRollUpSection, String aRollUpForRollUpSection, String aRollDownForRollUpSection, boolean aCurrentPositionForRollUpSection, Greenhouse aGreenhouseForRollUpSection)
  {
    boardID = aBoardID;
    input = aInput;
    output = aOutput;
    motors = new ArrayList<Motors>();
    sensors = new ArrayList<Sensors>();
    rollUpSection = new RollUpSection(aSectionNumberForRollUpSection, aRollUpForRollUpSection, aRollDownForRollUpSection, aCurrentPositionForRollUpSection, this, aGreenhouseForRollUpSection);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setBoardID(String aBoardID)
  {
    boolean wasSet = false;
    boardID = aBoardID;
    wasSet = true;
    return wasSet;
  }

  public boolean setInput(String aInput)
  {
    boolean wasSet = false;
    input = aInput;
    wasSet = true;
    return wasSet;
  }

  public boolean setOutput(String aOutput)
  {
    boolean wasSet = false;
    output = aOutput;
    wasSet = true;
    return wasSet;
  }

  public String getBoardID()
  {
    return boardID;
  }

  public String getInput()
  {
    return input;
  }

  public String getOutput()
  {
    return output;
  }
  /* Code from template association_GetMany */
  public Motors getMotor(int index)
  {
    Motors aMotor = motors.get(index);
    return aMotor;
  }

  public List<Motors> getMotors()
  {
    List<Motors> newMotors = Collections.unmodifiableList(motors);
    return newMotors;
  }

  public int numberOfMotors()
  {
    int number = motors.size();
    return number;
  }

  public boolean hasMotors()
  {
    boolean has = motors.size() > 0;
    return has;
  }

  public int indexOfMotor(Motors aMotor)
  {
    int index = motors.indexOf(aMotor);
    return index;
  }
  /* Code from template association_GetMany */
  public Sensors getSensor(int index)
  {
    Sensors aSensor = sensors.get(index);
    return aSensor;
  }

  public List<Sensors> getSensors()
  {
    List<Sensors> newSensors = Collections.unmodifiableList(sensors);
    return newSensors;
  }

  public int numberOfSensors()
  {
    int number = sensors.size();
    return number;
  }

  public boolean hasSensors()
  {
    boolean has = sensors.size() > 0;
    return has;
  }

  public int indexOfSensor(Sensors aSensor)
  {
    int index = sensors.indexOf(aSensor);
    return index;
  }
  /* Code from template association_GetOne */
  public RollUpSection getRollUpSection()
  {
    return rollUpSection;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfMotors()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Motors addMotor(String aMotorID, boolean aCurrentStatus)
  {
    return new Motors(aMotorID, aCurrentStatus, this);
  }

  public boolean addMotor(Motors aMotor)
  {
    boolean wasAdded = false;
    if (motors.contains(aMotor)) { return false; }
    Arduino existingArduino = aMotor.getArduino();
    boolean isNewArduino = existingArduino != null && !this.equals(existingArduino);
    if (isNewArduino)
    {
      aMotor.setArduino(this);
    }
    else
    {
      motors.add(aMotor);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeMotor(Motors aMotor)
  {
    boolean wasRemoved = false;
    //Unable to remove aMotor, as it must always have a arduino
    if (!this.equals(aMotor.getArduino()))
    {
      motors.remove(aMotor);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addMotorAt(Motors aMotor, int index)
  {  
    boolean wasAdded = false;
    if(addMotor(aMotor))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMotors()) { index = numberOfMotors() - 1; }
      motors.remove(aMotor);
      motors.add(index, aMotor);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveMotorAt(Motors aMotor, int index)
  {
    boolean wasAdded = false;
    if(motors.contains(aMotor))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMotors()) { index = numberOfMotors() - 1; }
      motors.remove(aMotor);
      motors.add(index, aMotor);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addMotorAt(aMotor, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfSensors()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Sensors addSensor(String aSensorID, boolean aCurrentStatus)
  {
    return new Sensors(aSensorID, aCurrentStatus, this);
  }

  public boolean addSensor(Sensors aSensor)
  {
    boolean wasAdded = false;
    if (sensors.contains(aSensor)) { return false; }
    Arduino existingArduino = aSensor.getArduino();
    boolean isNewArduino = existingArduino != null && !this.equals(existingArduino);
    if (isNewArduino)
    {
      aSensor.setArduino(this);
    }
    else
    {
      sensors.add(aSensor);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeSensor(Sensors aSensor)
  {
    boolean wasRemoved = false;
    //Unable to remove aSensor, as it must always have a arduino
    if (!this.equals(aSensor.getArduino()))
    {
      sensors.remove(aSensor);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addSensorAt(Sensors aSensor, int index)
  {  
    boolean wasAdded = false;
    if(addSensor(aSensor))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSensors()) { index = numberOfSensors() - 1; }
      sensors.remove(aSensor);
      sensors.add(index, aSensor);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSensorAt(Sensors aSensor, int index)
  {
    boolean wasAdded = false;
    if(sensors.contains(aSensor))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSensors()) { index = numberOfSensors() - 1; }
      sensors.remove(aSensor);
      sensors.add(index, aSensor);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSensorAt(aSensor, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=motors.size(); i > 0; i--)
    {
      Motors aMotor = motors.get(i - 1);
      aMotor.delete();
    }
    for(int i=sensors.size(); i > 0; i--)
    {
      Sensors aSensor = sensors.get(i - 1);
      aSensor.delete();
    }
    RollUpSection existingRollUpSection = rollUpSection;
    rollUpSection = null;
    if (existingRollUpSection != null)
    {
      existingRollUpSection.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "boardID" + ":" + getBoardID()+ "," +
            "input" + ":" + getInput()+ "," +
            "output" + ":" + getOutput()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "rollUpSection = "+(getRollUpSection()!=null?Integer.toHexString(System.identityHashCode(getRollUpSection())):"null");
  }
}