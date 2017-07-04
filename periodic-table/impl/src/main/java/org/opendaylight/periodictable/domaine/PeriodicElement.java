/*
 * Copyright © 2016 Zouarab and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.periodictable.domaine;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.opendaylight.periodictable.tools.NumberConverterTools;

/**
 * Main resource class.
 *
 * @author ouazou on 2017-06-28.
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
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

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

        @JsonCreator
        public static TypeEnum fromValue(String text) {
            for (TypeEnum b : TypeEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }
    }


    public enum StableCrystalEnum {
        BCC("bcc"),
        HEX("hex"),
        RHO("rho"),
        FCC("fcc"),
        CUB("cub"),
        ORTH("ort"),
        TET("tet"),
        GAS("gas"),
        MNO("mno");

        private String value;

        StableCrystalEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static StableCrystalEnum fromValue(String text) {
            for (StableCrystalEnum b : StableCrystalEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
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

        @JsonCreator
        public static PhaseEnum fromValue(String text) {
            for (PhaseEnum b : PhaseEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }

    }

    public static class PeriodicElementBuilder {


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


        /**
         * Set  the atomicNumber parameter.
         *
         * @param atomicNumber of type int
         * @return the current PeriodicElementBuilder instance
         */
        public PeriodicElementBuilder atomicNumber(String atomicNumber) {
            this.atomicNumber = NumberConverterTools.convert2Int(atomicNumber);
            return this;
        }

        /**
         * Set the element parameter.
         *
         * @param element of type String
         * @return the current PeriodicElementBuilder instance
         */
        public PeriodicElementBuilder element(String element) {
            this.element = StringUtils.trimToNull(element);
            return this;
        }


        /**
         * Set the symbol parameter.
         *
         * @param symbol of type String
         * @return the current PeriodicElementBuilder instance
         */
        public PeriodicElementBuilder symbol(String symbol) {
            this.symbol = StringUtils.trimToNull(symbol);
            return this;
        }

        /**
         * Set the the atomicWeight parameter.
         *
         * @param atomicWeight of type String
         * @return the current PeriodicElementBuilder instance
         */
        public PeriodicElementBuilder atomicWeight(String atomicWeight) {
            this.atomicWeight = NumberConverterTools.convert2Float(atomicWeight);
            return this;
        }

        /**
         * Set the period parameter.
         *
         * @param period of type String
         * @return the current PeriodicElementBuilder instance
         */
        public PeriodicElementBuilder period(String period) {
            this.period = NumberConverterTools.convert2Int(period);
            return this;
        }

        /**
         * Set the group parameter.
         *
         * @param group of type String
         * @return the current PeriodicElementBuilder instance
         */
        public PeriodicElementBuilder group(String group) {
            this.group = NumberConverterTools.convert2Int(group);
            return this;
        }

        /**
         * Set the phase parameter.
         *
         * @param phase of type String
         * @return the current PeriodicElementBuilder instance
         */
        public PeriodicElementBuilder phase(String phase) {
            this.phase = PeriodicElement.PhaseEnum.fromValue(phase);
            return this;
        }

        /**
         * Set the mostStableCrystal parameter.
         *
         * @param mostStableCrystal of type String
         * @return the current PeriodicElementBuilder instance
         */
        public PeriodicElementBuilder mostStableCrystal(String mostStableCrystal) {
            this.mostStableCrystal =
                PeriodicElement.StableCrystalEnum
                    .fromValue(mostStableCrystal);
            return this;
        }

        /**
         * Set the type parameter.
         *
         * @param type of type String
         * @return the current PeriodicElementBuilder instance
         */
        public PeriodicElementBuilder type(String type) {
            this.type = PeriodicElement.TypeEnum.fromValue(type);
            return this;
        }

        /**
         * Set the ionicRadius parameter.
         *
         * @param ionicRadius of type String
         * @return the current PeriodicElementBuilder instance
         */
        public PeriodicElementBuilder ionicRadius(String ionicRadius) {
            this.ionicRadius = NumberConverterTools.convert2Float(ionicRadius);
            return this;
        }

        /**
         * Set the atomicRadius parameter.
         *
         * @param atomicRadius of type String
         * @return the current PeriodicElementBuilder instance
         */
        public PeriodicElementBuilder atomicRadius(String atomicRadius) {
            this.atomicRadius = NumberConverterTools.convert2Float(atomicRadius);
            return this;
        }

        /**
         * Set the electroNegativity parameter.
         *
         * @param electroNegativity of type String
         * @return the current PeriodicElementBuilder instance
         */
        public PeriodicElementBuilder electroNegativity(String electroNegativity) {
            this.electroNegativity = NumberConverterTools.convert2Float(electroNegativity);
            return this;
        }

        /**
         * Set the firstIonizationPotential parameter.
         *
         * @param firstIonizationPotential of type String
         * @return the current PeriodicElementBuilder instance
         */
        public PeriodicElementBuilder firstIonizationPotential(String firstIonizationPotential) {
            this.firstIonizationPotential =
                NumberConverterTools.convert2Float(firstIonizationPotential);
            return this;
        }

        /**
         * Set the density parameter.
         *
         * @param density of type String
         * @return the current PeriodicElementBuilder instance
         */
        public PeriodicElementBuilder density(String density) {
            this.density = NumberConverterTools.convert2Float(density);
            return this;
        }

        /**
         * Set the meltingPoint parameter.
         *
         * @param meltingPoint of type String
         * @return the current PeriodicElementBuilder instance
         */
        public PeriodicElementBuilder meltingPoint(String meltingPoint) {
            this.meltingPoint = NumberConverterTools.convert2Float(meltingPoint);
            return this;
        }

        /**
         * Set the boilingPoint parameter.
         *
         * @param boilingPoint of type String
         * @return the current PeriodicElementBuilder instance
         */
        public PeriodicElementBuilder boilingPoint(String boilingPoint) {
            this.boilingPoint = NumberConverterTools.convert2Float(boilingPoint);
            return this;
        }

        /**
         * Set the isotopes parameter.
         *
         * @param isotopes of type String
         * @return the current PeriodicElementBuilder instance
         */
        public PeriodicElementBuilder isotopes(String isotopes) {
            this.isotopes = NumberConverterTools.convert2Int(isotopes);
            return this;
        }

        /**
         * Set the discoverer parameter.
         *
         * @param discoverer of type String
         * @return the current PeriodicElementBuilder instance
         */
        public PeriodicElementBuilder discoverer(String discoverer) {
            this.discoverer = StringUtils.trimToNull(discoverer);
            return this;
        }

        /**
         * Set the yearOfDiscovery parameter.
         *
         * @param yearOfDiscovery of type String
         * @return the current PeriodicElementBuilder instance
         */
        public PeriodicElementBuilder yearOfDiscovery(String yearOfDiscovery) {
            this.yearOfDiscovery = NumberConverterTools.convert2Int(yearOfDiscovery);
            return this;
        }

        /**
         * Set the specificHeatCapacity parameter.
         *
         * @param specificHeatCapacity of type String
         * @return the current PeriodicElementBuilder instance
         */
        public PeriodicElementBuilder specificHeatCapacity(String specificHeatCapacity) {
            this.specificHeatCapacity = NumberConverterTools.convert2Float(specificHeatCapacity);
            return this;
        }

        /**
         * Set the electronConfiguration parameter.
         *
         * @param electronConfiguration of type String
         * @return the current PeriodicElementBuilder instance
         */
        public PeriodicElementBuilder electronConfiguration(String electronConfiguration) {
            this.electronConfiguration = StringUtils.trimToNull(electronConfiguration);
            return this;
        }

        /**
         * Set the displayRow parameter.
         *
         * @param displayRow of type String
         * @return the current PeriodicElementBuilder instance
         */
        public PeriodicElementBuilder displayRow(String displayRow) {
            this.displayRow = NumberConverterTools.convert2Int(displayRow);
            return this;
        }

        /**
         * * Set the displayColumn parameter.
         *
         * @param displayColumn of type String
         * @return the current PeriodicElementBuilder instance
         */
        public PeriodicElementBuilder displayColumn(String displayColumn) {
            this.displayColumn = NumberConverterTools.convert2Int(displayColumn);
            return this;
        }

        public PeriodicElement build() {
            PeriodicElement pe = new PeriodicElement();
            pe.setAtomicNumber(this.atomicNumber);
            pe.setElement(this.element);
            pe.setSymbol(this.symbol);
            pe.setAtomicWeight(this.atomicWeight);
            pe.setPeriod(this.period);
            pe.setGroup(this.group);
            pe.setPhase(this.phase);
            pe.setMostStableCrystal(this.mostStableCrystal);
            pe.setType(this.type);
            pe.setIonicRadius(this.ionicRadius);
            pe.setAtomicRadius(this.atomicRadius);
            pe.setElectroNegativity(this.electroNegativity);
            pe.setFirstIonizationPotential(this.firstIonizationPotential);
            pe.setDensity(this.density);
            pe.setMeltingPoint(this.meltingPoint);
            pe.setBoilingPoint(this.boilingPoint);
            pe.setIsotopes(this.isotopes);
            pe.setDiscoverer(this.discoverer);
            pe.setYearOfDiscovery(this.yearOfDiscovery);
            pe.setSpecificHeatCapacity(this.specificHeatCapacity);
            pe.setElectronConfiguration(this.electronConfiguration);
            pe.setDisplayRow(this.displayRow);
            pe.setDisplayColumn(this.displayColumn);
            return pe;
        }

    }
}
