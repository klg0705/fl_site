
package fl.site.wsclient.calc.fight;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fl.site.wsclient.calc.fight package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FightResponse_QNAME = new QName("http://ws.calc.fl/", "fightResponse");
    private final static QName _Fight_QNAME = new QName("http://ws.calc.fl/", "fight");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fl.site.wsclient.calc.fight
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Fight }
     * 
     */
    public Fight createFight() {
        return new Fight();
    }

    /**
     * Create an instance of {@link FightResponse }
     * 
     */
    public FightResponse createFightResponse() {
        return new FightResponse();
    }

    /**
     * Create an instance of {@link Deity }
     * 
     */
    public Deity createDeity() {
        return new Deity();
    }

    /**
     * Create an instance of {@link Fighter }
     * 
     */
    public Fighter createFighter() {
        return new Fighter();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FightResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.calc.fl/", name = "fightResponse")
    public JAXBElement<FightResponse> createFightResponse(FightResponse value) {
        return new JAXBElement<FightResponse>(_FightResponse_QNAME, FightResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Fight }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.calc.fl/", name = "fight")
    public JAXBElement<Fight> createFight(Fight value) {
        return new JAXBElement<Fight>(_Fight_QNAME, Fight.class, null, value);
    }

}
