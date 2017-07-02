package org.opendaylight.periodictable.domaine;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Created by ouazou on 2017-06-28.
 */
public class PeriodicElement {

  private int atomicNumber;
  private String element;
  private String symbol;
  private float atomicWeight;
  private int period;
  private int group;
  private PhaseEnum phase;
  private StableCrystalEnum mostStableCrystal;
  private TypeEnum type;
  private float ionicRadius;
  private float atomicRadius;
  private float electroNegativity;
  private float firstIonizationPotential;
  private float density;
  private float meltingPoint;
  private float boilingPoint;
  private int isotopes;
  private String discoverer;
  private int yearOfDiscovery;
  private float specificHeatCapacity;
  private String electronConfiguration;
  private int displayRow;
  private int displayColumn;

  public enum TypeEnum {

    NONMETAL("Nonmetal"),
    NOBLE_GAS("Noble Gas"),
    ALKALI_METAL("Alkali Metal"),
    ALKALINE_EARTH_METAL("Alkaline Earth Metal"),
    METALLOID("Metalloid"),
    HALOGEN("Halogen"),
    METAL("Metal"),
    TRANSITION_METAL("Transition Metal"),
    LANTHANIDE("Lanthanide"),
    ACTINIDE("Actinide"),
    TRANSACTINIDE("Transactinide");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

  }

  public enum StableCrystalEnum {
    BCC("bcc")  ,
    HEX("hex")  ,
    RHO("rho")  ,
    FCC("fcc")  ,
    CUB("cub")  ,
    ORTH("ort") ,
    TET("tet")  ,
    GAS("gas")  ,
    MNO("mno");

    private String value;

    StableCrystalEnum(String value) {
      this.value = value;
    }

  }

  public enum PhaseEnum {
    GAS("gas"),
    SOLID("solid"),
    LIQUID("liq"),
    ARTIFICIAL("artificial");
    private String value;

    PhaseEnum(String value) {
      this.value = value;
    }

  }

  public int getAtomicNumber() {
    return atomicNumber;
  }

  public void setAtomicNumber(int atomicNumber) {
    this.atomicNumber = atomicNumber;
  }

  public String getElement() {
    return element;
  }

  public void setElement(String element) {
    this.element = element;
  }

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public float getAtomicWeight() {
    return atomicWeight;
  }

  public void setAtomicWeight(float atomicWeight) {
    this.atomicWeight = atomicWeight;
  }

  public int getPeriod() {
    return period;
  }

  public void setPeriod(int period) {
    this.period = period;
  }

  public int getGroup() {
    return group;
  }

  public void setGroup(int group) {
    this.group = group;
  }

  public PhaseEnum getPhase() {
    return phase;
  }

  public void setPhase(PhaseEnum phase) {
    this.phase = phase;
  }

  public StableCrystalEnum getMostStableCrystal() {
    return mostStableCrystal;
  }

  public void setMostStableCrystal(StableCrystalEnum mostStableCrystal) {
    this.mostStableCrystal = mostStableCrystal;
  }

  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public float getIonicRadius() {
    return ionicRadius;
  }

  public void setIonicRadius(float ionicRadius) {
    this.ionicRadius = ionicRadius;
  }

  public float getAtomicRadius() {
    return atomicRadius;
  }

  public void setAtomicRadius(float atomicRadius) {
    this.atomicRadius = atomicRadius;
  }

  public float getElectroNegativity() {
    return electroNegativity;
  }

  public void setElectroNegativity(float electroNegativity) {
    this.electroNegativity = electroNegativity;
  }

  public float getFirstIonizationPotential() {
    return firstIonizationPotential;
  }

  public void setFirstIonizationPotential(float firstIonizationPotential) {
    this.firstIonizationPotential = firstIonizationPotential;
  }

  public float getDensity() {
    return density;
  }

  public void setDensity(float density) {
    this.density = density;
  }

  public float getMeltingPoint() {
    return meltingPoint;
  }

  public void setMeltingPoint(float meltingPoint) {
    this.meltingPoint = meltingPoint;
  }

  public float getBoilingPoint() {
    return boilingPoint;
  }

  public void setBoilingPoint(float boilingPoint) {
    this.boilingPoint = boilingPoint;
  }

  public int getIsotopes() {
    return isotopes;
  }

  public void setIsotopes(int isotopes) {
    this.isotopes = isotopes;
  }

  public String getDiscoverer() {
    return discoverer;
  }

  public void setDiscoverer(String discoverer) {
    this.discoverer = discoverer;
  }

  public int getYearOfDiscovery() {
    return yearOfDiscovery;
  }

  public void setYearOfDiscovery(int yearOfDiscovery) {
    this.yearOfDiscovery = yearOfDiscovery;
  }

  public float getSpecificHeatCapacity() {
    return specificHeatCapacity;
  }

  public void setSpecificHeatCapacity(float specificHeatCapacity) {
    this.specificHeatCapacity = specificHeatCapacity;
  }

  public String getElectronConfiguration() {
    return electronConfiguration;
  }

  public void setElectronConfiguration(String electronConfiguration) {
    this.electronConfiguration = electronConfiguration;
  }

  public int getDisplayRow() {
    return displayRow;
  }

  public void setDisplayRow(int displayRow) {
    this.displayRow = displayRow;
  }

  public int getDisplayColumn() {
    return displayColumn;
  }

  public void setDisplayColumn(int displayColumn) {
    this.displayColumn = displayColumn;
  }

  @Override
  public boolean equals(Object o) {
    return EqualsBuilder.reflectionEquals(this, o);
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
}
