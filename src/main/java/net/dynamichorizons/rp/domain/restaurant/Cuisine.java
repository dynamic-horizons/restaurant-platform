/**
 * Copyright (C) 2012 Dynamic Horizons, LLC <https://www.dynamichorizons.net>
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or 
 * (at your option) any later version.
 *   
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */
package net.dynamichorizons.rp.domain.restaurant;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for Cuisine.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="Cuisine">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="American"/>
 *     &lt;enumeration value="Afghan"/>
 *     &lt;enumeration value="African"/>
 *     &lt;enumeration value="Argentinean"/>
 *     &lt;enumeration value="Asian"/>
 *     &lt;enumeration value="Bakery"/>
 *     &lt;enumeration value="Barbeque"/>
 *     &lt;enumeration value="Brazilian"/>
 *     &lt;enumeration value="Brew / Pubs / Microbrewery"/>
 *     &lt;enumeration value="Cajun/Creole"/>
 *     &lt;enumeration value="California"/>
 *     &lt;enumeration value="Caribbean"/>
 *     &lt;enumeration value="Chinese"/>
 *     &lt;enumeration value="Coffee House"/>
 *     &lt;enumeration value="Continental"/>
 *     &lt;enumeration value="Cuban"/>
 *     &lt;enumeration value="Desserts"/>
 *     &lt;enumeration value="Diner"/>
 *     &lt;enumeration value="Ethiopian"/>
 *     &lt;enumeration value="Family / Homestyle"/>
 *     &lt;enumeration value="French/French Bistro"/>
 *     &lt;enumeration value="Fusion"/>
 *     &lt;enumeration value="German"/>
 *     &lt;enumeration value="Greek"/>
 *     &lt;enumeration value="Hamburger"/>
 *     &lt;enumeration value="Hawaiian"/>
 *     &lt;enumeration value="Hot Dog"/>
 *     &lt;enumeration value="Indian"/>
 *     &lt;enumeration value="International"/>
 *     &lt;enumeration value="Irish"/>
 *     &lt;enumeration value="Italian"/>
 *     &lt;enumeration value="Japanese"/>
 *     &lt;enumeration value="Latin"/>
 *     &lt;enumeration value="Kosher"/>
 *     &lt;enumeration value="Malaysian"/>
 *     &lt;enumeration value="Mediterranean"/>
 *     &lt;enumeration value="Mexican"/>
 *     &lt;enumeration value="Moroccan"/>
 *     &lt;enumeration value="Pacific Rim"/>
 *     &lt;enumeration value="Pizza"/>
 *     &lt;enumeration value="Portuguese"/>
 *     &lt;enumeration value="Russian"/>
 *     &lt;enumeration value="Sandwiches"/>
 *     &lt;enumeration value="Seafood"/>
 *     &lt;enumeration value="Soup"/>
 *     &lt;enumeration value="Southwest"/>
 *     &lt;enumeration value="Southern Cuisine"/>
 *     &lt;enumeration value="Spanish"/>
 *     &lt;enumeration value="Steakhouse"/>
 *     &lt;enumeration value="Sunday Brunch"/>
 *     &lt;enumeration value="Sushi"/>
 *     &lt;enumeration value="Tapas"/>
 *     &lt;enumeration value="Thai"/>
 *     &lt;enumeration value="Ukrainian"/>
 *     &lt;enumeration value="Vegetarian"/>
 *     &lt;enumeration value="Vietnamese"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType( name = "Cuisine" )
@XmlEnum
public enum Cuisine
{

    @XmlEnumValue( "American" )
    AMERICAN( "American" ), @XmlEnumValue( "Afghan" )
    AFGHAN( "Afghan" ), @XmlEnumValue( "African" )
    AFRICAN( "African" ), @XmlEnumValue( "Argentinean" )
    ARGENTINEAN( "Argentinean" ), @XmlEnumValue( "Asian" )
    ASIAN( "Asian" ), @XmlEnumValue( "Bakery" )
    BAKERY( "Bakery" ), @XmlEnumValue( "Barbeque" )
    BARBEQUE( "Barbeque" ), @XmlEnumValue( "Brazilian" )
    BRAZILIAN( "Brazilian" ), @XmlEnumValue( "Brew / Pubs / Microbrewery" )
    BREW_PUBS_MICROBREWERY( "Brew / Pubs / Microbrewery" ), @XmlEnumValue( "Cajun/Creole" )
    CAJUN_CREOLE( "Cajun/Creole" ), @XmlEnumValue( "California" )
    CALIFORNIA( "California" ), @XmlEnumValue( "Caribbean" )
    CARIBBEAN( "Caribbean" ), @XmlEnumValue( "Chinese" )
    CHINESE( "Chinese" ), @XmlEnumValue( "Coffee House" )
    COFFEE_HOUSE( "Coffee House" ), @XmlEnumValue( "Continental" )
    CONTINENTAL( "Continental" ), @XmlEnumValue( "Cuban" )
    CUBAN( "Cuban" ), @XmlEnumValue( "Desserts" )
    DESSERTS( "Desserts" ), @XmlEnumValue( "Diner" )
    DINER( "Diner" ), @XmlEnumValue( "Ethiopian" )
    ETHIOPIAN( "Ethiopian" ), @XmlEnumValue( "Family / Homestyle" )
    FAMILY_HOMESTYLE( "Family / Homestyle" ), @XmlEnumValue( "French/French Bistro" )
    FRENCH_FRENCH_BISTRO( "French/French Bistro" ), @XmlEnumValue( "Fusion" )
    FUSION( "Fusion" ), @XmlEnumValue( "German" )
    GERMAN( "German" ), @XmlEnumValue( "Greek" )
    GREEK( "Greek" ), @XmlEnumValue( "Hamburger" )
    HAMBURGER( "Hamburger" ), @XmlEnumValue( "Hawaiian" )
    HAWAIIAN( "Hawaiian" ), @XmlEnumValue( "Hot Dog" )
    HOT_DOG( "Hot Dog" ), @XmlEnumValue( "Indian" )
    INDIAN( "Indian" ), @XmlEnumValue( "International" )
    INTERNATIONAL( "International" ), @XmlEnumValue( "Irish" )
    IRISH( "Irish" ), @XmlEnumValue( "Italian" )
    ITALIAN( "Italian" ), @XmlEnumValue( "Japanese" )
    JAPANESE( "Japanese" ), @XmlEnumValue( "Latin" )
    LATIN( "Latin" ), @XmlEnumValue( "Kosher" )
    KOSHER( "Kosher" ), @XmlEnumValue( "Malaysian" )
    MALAYSIAN( "Malaysian" ), @XmlEnumValue( "Mediterranean" )
    MEDITERRANEAN( "Mediterranean" ), @XmlEnumValue( "Mexican" )
    MEXICAN( "Mexican" ), @XmlEnumValue( "Moroccan" )
    MOROCCAN( "Moroccan" ), @XmlEnumValue( "Pacific Rim" )
    PACIFIC_RIM( "Pacific Rim" ), @XmlEnumValue( "Pizza" )
    PIZZA( "Pizza" ), @XmlEnumValue( "Portuguese" )
    PORTUGUESE( "Portuguese" ), @XmlEnumValue( "Russian" )
    RUSSIAN( "Russian" ), @XmlEnumValue( "Sandwiches" )
    SANDWICHES( "Sandwiches" ), @XmlEnumValue( "Seafood" )
    SEAFOOD( "Seafood" ), @XmlEnumValue( "Soup" )
    SOUP( "Soup" ), @XmlEnumValue( "Southwest" )
    SOUTHWEST( "Southwest" ), @XmlEnumValue( "Southern Cuisine" )
    SOUTHERN_CUISINE( "Southern Cuisine" ), @XmlEnumValue( "Spanish" )
    SPANISH( "Spanish" ), @XmlEnumValue( "Steakhouse" )
    STEAKHOUSE( "Steakhouse" ), @XmlEnumValue( "Sunday Brunch" )
    SUNDAY_BRUNCH( "Sunday Brunch" ), @XmlEnumValue( "Sushi" )
    SUSHI( "Sushi" ), @XmlEnumValue( "Tapas" )
    TAPAS( "Tapas" ), @XmlEnumValue( "Thai" )
    THAI( "Thai" ), @XmlEnumValue( "Ukrainian" )
    UKRAINIAN( "Ukrainian" ), @XmlEnumValue( "Vegetarian" )
    VEGETARIAN( "Vegetarian" ), @XmlEnumValue( "Vietnamese" )
    VIETNAMESE( "Vietnamese" );
    private final String value;

    Cuisine( String v )
    {
        value = v;
    }

    public String value()
    {
        return value;
    }

    public static Cuisine fromValue( String v )
    {
        for ( Cuisine c : Cuisine.values() )
        {
            if ( c.value.equals( v ) )
            {
                return c;
            }
        }
        throw new IllegalArgumentException( v );
    }

}