
package fl.site.wsclient.calc.fight;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for fighter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="fighter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="attack" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="defence" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="deity" type="{http://ws.calc.fl/}deity" minOccurs="0"/>
 *         &lt;element name="hp" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="image" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="maxHp" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nickName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fighter", propOrder = {
    "attack",
    "defence",
    "deity",
    "hp",
    "image",
    "maxHp",
    "name",
    "nickName"
})
public class Fighter {

    protected int attack;
    protected int defence;
    protected Deity deity;
    protected int hp;
    protected String image;
    protected int maxHp;
    protected String name;
    protected String nickName;

    /**
     * Gets the value of the attack property.
     * 
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Sets the value of the attack property.
     * 
     */
    public void setAttack(int value) {
        this.attack = value;
    }

    /**
     * Gets the value of the defence property.
     * 
     */
    public int getDefence() {
        return defence;
    }

    /**
     * Sets the value of the defence property.
     * 
     */
    public void setDefence(int value) {
        this.defence = value;
    }

    /**
     * Gets the value of the deity property.
     * 
     * @return
     *     possible object is
     *     {@link Deity }
     *     
     */
    public Deity getDeity() {
        return deity;
    }

    /**
     * Sets the value of the deity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Deity }
     *     
     */
    public void setDeity(Deity value) {
        this.deity = value;
    }

    /**
     * Gets the value of the hp property.
     * 
     */
    public int getHp() {
        return hp;
    }

    /**
     * Sets the value of the hp property.
     * 
     */
    public void setHp(int value) {
        this.hp = value;
    }

    /**
     * Gets the value of the image property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets the value of the image property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImage(String value) {
        this.image = value;
    }

    /**
     * Gets the value of the maxHp property.
     * 
     */
    public int getMaxHp() {
        return maxHp;
    }

    /**
     * Sets the value of the maxHp property.
     * 
     */
    public void setMaxHp(int value) {
        this.maxHp = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the nickName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * Sets the value of the nickName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNickName(String value) {
        this.nickName = value;
    }

}
