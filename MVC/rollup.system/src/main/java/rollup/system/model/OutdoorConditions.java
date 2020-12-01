/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/

package rollup.system.model;

// line 39 "../../../RollUp.ump"
public class OutdoorConditions
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //OutdoorConditions Attributes
  private String windSpeed;
  private String temperature;

  //OutdoorConditions Associations
  private Greenhouse greenhouse;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public OutdoorConditions(String aWindSpeed, String aTemperature, Greenhouse aGreenhouse)
  {
    windSpeed = aWindSpeed;
    temperature = aTemperature;
    if (aGreenhouse == null || aGreenhouse.getOutdoorConditions() != null)
    {
      throw new RuntimeException("Unable to create OutdoorConditions due to aGreenhouse. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    greenhouse = aGreenhouse;
  }

  public OutdoorConditions(String aWindSpeed, String aTemperature, ClimateControl aClimateControlForGreenhouse, User aUserForGreenhouse)
  {
    windSpeed = aWindSpeed;
    temperature = aTemperature;
    greenhouse = new Greenhouse(aClimateControlForGreenhouse, this, aUserForGreenhouse);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setWindSpeed(String aWindSpeed)
  {
    boolean wasSet = false;
    windSpeed = aWindSpeed;
    wasSet = true;
    return wasSet;
  }

  public boolean setTemperature(String aTemperature)
  {
    boolean wasSet = false;
    temperature = aTemperature;
    wasSet = true;
    return wasSet;
  }

  public String getWindSpeed()
  {
    return windSpeed;
  }

  public String getTemperature()
  {
    return temperature;
  }
  /* Code from template association_GetOne */
  public Greenhouse getGreenhouse()
  {
    return greenhouse;
  }

  public void delete()
  {
    Greenhouse existingGreenhouse = greenhouse;
    greenhouse = null;
    if (existingGreenhouse != null)
    {
      existingGreenhouse.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "windSpeed" + ":" + getWindSpeed()+ "," +
            "temperature" + ":" + getTemperature()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "greenhouse = "+(getGreenhouse()!=null?Integer.toHexString(System.identityHashCode(getGreenhouse())):"null");
  }
}