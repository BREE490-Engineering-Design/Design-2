/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/

package rollup.system.model;

// line 36 "../../../RollUp.ump"
public class ClimateControl
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ClimateControl Associations
  private Greenhouse greenhouse;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ClimateControl(Greenhouse aGreenhouse)
  {
    if (aGreenhouse == null || aGreenhouse.getClimateControl() != null)
    {
      throw new RuntimeException("Unable to create ClimateControl due to aGreenhouse. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    greenhouse = aGreenhouse;
  }

  public ClimateControl(OutdoorConditions aOutdoorConditionsForGreenhouse, User aUserForGreenhouse)
  {
    greenhouse = new Greenhouse(this, aOutdoorConditionsForGreenhouse, aUserForGreenhouse);
  }

  //------------------------
  // INTERFACE
  //------------------------
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

}