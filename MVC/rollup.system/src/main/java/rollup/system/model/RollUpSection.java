/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/

package rollup.system.model;
import java.util.*;

// line 45 "../../../RollUp.ump"
public class RollUpSection
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Map<String, RollUpSection> rollupsectionsBySectionNumber = new HashMap<String, RollUpSection>();

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //RollUpSection Attributes
  private String sectionNumber;
  private String rollUp;
  private String rollDown;
  private boolean currentPosition;

  //RollUpSection Associations
  private Arduino arduino;
  private Greenhouse greenhouse;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public RollUpSection(String aSectionNumber, String aRollUp, String aRollDown, boolean aCurrentPosition, Arduino aArduino, Greenhouse aGreenhouse)
  {
    rollUp = aRollUp;
    rollDown = aRollDown;
    currentPosition = aCurrentPosition;
    if (!setSectionNumber(aSectionNumber))
    {
      throw new RuntimeException("Cannot create due to duplicate sectionNumber. See http://manual.umple.org?RE003ViolationofUniqueness.html");
    }
    if (aArduino == null || aArduino.getRollUpSection() != null)
    {
      throw new RuntimeException("Unable to create RollUpSection due to aArduino. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    arduino = aArduino;
    boolean didAddGreenhouse = setGreenhouse(aGreenhouse);
    if (!didAddGreenhouse)
    {
      throw new RuntimeException("Unable to create rollUpSection due to greenhouse. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  public RollUpSection(String aSectionNumber, String aRollUp, String aRollDown, boolean aCurrentPosition, String aBoardIDForArduino, String aInputForArduino, String aOutputForArduino, Greenhouse aGreenhouse)
  {
    if (!setSectionNumber(aSectionNumber))
    {
      throw new RuntimeException("Cannot create due to duplicate sectionNumber. See http://manual.umple.org?RE003ViolationofUniqueness.html");
    }
    rollUp = aRollUp;
    rollDown = aRollDown;
    currentPosition = aCurrentPosition;
    arduino = new Arduino(aBoardIDForArduino, aInputForArduino, aOutputForArduino, this);
    boolean didAddGreenhouse = setGreenhouse(aGreenhouse);
    if (!didAddGreenhouse)
    {
      throw new RuntimeException("Unable to create rollUpSection due to greenhouse. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSectionNumber(String aSectionNumber)
  {
    boolean wasSet = false;
    String anOldSectionNumber = getSectionNumber();
    if (anOldSectionNumber != null && anOldSectionNumber.equals(aSectionNumber)) {
      return true;
    }
    if (hasWithSectionNumber(aSectionNumber)) {
      return wasSet;
    }
    sectionNumber = aSectionNumber;
    wasSet = true;
    if (anOldSectionNumber != null) {
      rollupsectionsBySectionNumber.remove(anOldSectionNumber);
    }
    rollupsectionsBySectionNumber.put(aSectionNumber, this);
    return wasSet;
  }

  public boolean setRollUp(String aRollUp)
  {
    boolean wasSet = false;
    rollUp = aRollUp;
    wasSet = true;
    return wasSet;
  }

  public boolean setRollDown(String aRollDown)
  {
    boolean wasSet = false;
    rollDown = aRollDown;
    wasSet = true;
    return wasSet;
  }

  public boolean setCurrentPosition(boolean aCurrentPosition)
  {
    boolean wasSet = false;
    currentPosition = aCurrentPosition;
    wasSet = true;
    return wasSet;
  }

  public String getSectionNumber()
  {
    return sectionNumber;
  }
  /* Code from template attribute_GetUnique */
  public static RollUpSection getWithSectionNumber(String aSectionNumber)
  {
    return rollupsectionsBySectionNumber.get(aSectionNumber);
  }
  /* Code from template attribute_HasUnique */
  public static boolean hasWithSectionNumber(String aSectionNumber)
  {
    return getWithSectionNumber(aSectionNumber) != null;
  }

  public String getRollUp()
  {
    return rollUp;
  }

  public String getRollDown()
  {
    return rollDown;
  }

  public boolean getCurrentPosition()
  {
    return currentPosition;
  }
  /* Code from template attribute_IsBoolean */
  public boolean isCurrentPosition()
  {
    return currentPosition;
  }
  /* Code from template association_GetOne */
  public Arduino getArduino()
  {
    return arduino;
  }
  /* Code from template association_GetOne */
  public Greenhouse getGreenhouse()
  {
    return greenhouse;
  }
  /* Code from template association_SetOneToMany */
  public boolean setGreenhouse(Greenhouse aGreenhouse)
  {
    boolean wasSet = false;
    if (aGreenhouse == null)
    {
      return wasSet;
    }

    Greenhouse existingGreenhouse = greenhouse;
    greenhouse = aGreenhouse;
    if (existingGreenhouse != null && !existingGreenhouse.equals(aGreenhouse))
    {
      existingGreenhouse.removeRollUpSection(this);
    }
    greenhouse.addRollUpSection(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    rollupsectionsBySectionNumber.remove(getSectionNumber());
    Arduino existingArduino = arduino;
    arduino = null;
    if (existingArduino != null)
    {
      existingArduino.delete();
    }
    Greenhouse placeholderGreenhouse = greenhouse;
    this.greenhouse = null;
    if(placeholderGreenhouse != null)
    {
      placeholderGreenhouse.removeRollUpSection(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "sectionNumber" + ":" + getSectionNumber()+ "," +
            "rollUp" + ":" + getRollUp()+ "," +
            "rollDown" + ":" + getRollDown()+ "," +
            "currentPosition" + ":" + getCurrentPosition()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "arduino = "+(getArduino()!=null?Integer.toHexString(System.identityHashCode(getArduino())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "greenhouse = "+(getGreenhouse()!=null?Integer.toHexString(System.identityHashCode(getGreenhouse())):"null");
  }
}