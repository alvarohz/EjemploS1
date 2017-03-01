
package com.aerolinea.cliente;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.aerolinea.cliente package. 
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

    private final static QName _Avion_QNAME = new QName("http://webservice.aerolinea.com/", "avion");
    private final static QName _ConsultarAviones_QNAME = new QName("http://webservice.aerolinea.com/", "consultarAviones");
    private final static QName _ConsultarAvionesResponse_QNAME = new QName("http://webservice.aerolinea.com/", "consultarAvionesResponse");
    private final static QName _Count_QNAME = new QName("http://webservice.aerolinea.com/", "count");
    private final static QName _CountResponse_QNAME = new QName("http://webservice.aerolinea.com/", "countResponse");
    private final static QName _Create_QNAME = new QName("http://webservice.aerolinea.com/", "create");
    private final static QName _Edit_QNAME = new QName("http://webservice.aerolinea.com/", "edit");
    private final static QName _Find_QNAME = new QName("http://webservice.aerolinea.com/", "find");
    private final static QName _FindAll_QNAME = new QName("http://webservice.aerolinea.com/", "findAll");
    private final static QName _FindAllResponse_QNAME = new QName("http://webservice.aerolinea.com/", "findAllResponse");
    private final static QName _FindRange_QNAME = new QName("http://webservice.aerolinea.com/", "findRange");
    private final static QName _FindRangeResponse_QNAME = new QName("http://webservice.aerolinea.com/", "findRangeResponse");
    private final static QName _FindResponse_QNAME = new QName("http://webservice.aerolinea.com/", "findResponse");
    private final static QName _Remove_QNAME = new QName("http://webservice.aerolinea.com/", "remove");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.aerolinea.cliente
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Avion }
     * 
     */
    public Avion createAvion() {
        return new Avion();
    }

    /**
     * Create an instance of {@link ConsultarAviones }
     * 
     */
    public ConsultarAviones createConsultarAviones() {
        return new ConsultarAviones();
    }

    /**
     * Create an instance of {@link ConsultarAvionesResponse }
     * 
     */
    public ConsultarAvionesResponse createConsultarAvionesResponse() {
        return new ConsultarAvionesResponse();
    }

    /**
     * Create an instance of {@link Count }
     * 
     */
    public Count createCount() {
        return new Count();
    }

    /**
     * Create an instance of {@link CountResponse }
     * 
     */
    public CountResponse createCountResponse() {
        return new CountResponse();
    }

    /**
     * Create an instance of {@link Create }
     * 
     */
    public Create createCreate() {
        return new Create();
    }

    /**
     * Create an instance of {@link Edit }
     * 
     */
    public Edit createEdit() {
        return new Edit();
    }

    /**
     * Create an instance of {@link Find }
     * 
     */
    public Find createFind() {
        return new Find();
    }

    /**
     * Create an instance of {@link FindAll }
     * 
     */
    public FindAll createFindAll() {
        return new FindAll();
    }

    /**
     * Create an instance of {@link FindAllResponse }
     * 
     */
    public FindAllResponse createFindAllResponse() {
        return new FindAllResponse();
    }

    /**
     * Create an instance of {@link FindRange }
     * 
     */
    public FindRange createFindRange() {
        return new FindRange();
    }

    /**
     * Create an instance of {@link FindRangeResponse }
     * 
     */
    public FindRangeResponse createFindRangeResponse() {
        return new FindRangeResponse();
    }

    /**
     * Create an instance of {@link FindResponse }
     * 
     */
    public FindResponse createFindResponse() {
        return new FindResponse();
    }

    /**
     * Create an instance of {@link Remove }
     * 
     */
    public Remove createRemove() {
        return new Remove();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Avion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.aerolinea.com/", name = "avion")
    public JAXBElement<Avion> createAvion(Avion value) {
        return new JAXBElement<Avion>(_Avion_QNAME, Avion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarAviones }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.aerolinea.com/", name = "consultarAviones")
    public JAXBElement<ConsultarAviones> createConsultarAviones(ConsultarAviones value) {
        return new JAXBElement<ConsultarAviones>(_ConsultarAviones_QNAME, ConsultarAviones.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarAvionesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.aerolinea.com/", name = "consultarAvionesResponse")
    public JAXBElement<ConsultarAvionesResponse> createConsultarAvionesResponse(ConsultarAvionesResponse value) {
        return new JAXBElement<ConsultarAvionesResponse>(_ConsultarAvionesResponse_QNAME, ConsultarAvionesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Count }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.aerolinea.com/", name = "count")
    public JAXBElement<Count> createCount(Count value) {
        return new JAXBElement<Count>(_Count_QNAME, Count.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.aerolinea.com/", name = "countResponse")
    public JAXBElement<CountResponse> createCountResponse(CountResponse value) {
        return new JAXBElement<CountResponse>(_CountResponse_QNAME, CountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Create }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.aerolinea.com/", name = "create")
    public JAXBElement<Create> createCreate(Create value) {
        return new JAXBElement<Create>(_Create_QNAME, Create.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Edit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.aerolinea.com/", name = "edit")
    public JAXBElement<Edit> createEdit(Edit value) {
        return new JAXBElement<Edit>(_Edit_QNAME, Edit.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Find }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.aerolinea.com/", name = "find")
    public JAXBElement<Find> createFind(Find value) {
        return new JAXBElement<Find>(_Find_QNAME, Find.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.aerolinea.com/", name = "findAll")
    public JAXBElement<FindAll> createFindAll(FindAll value) {
        return new JAXBElement<FindAll>(_FindAll_QNAME, FindAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.aerolinea.com/", name = "findAllResponse")
    public JAXBElement<FindAllResponse> createFindAllResponse(FindAllResponse value) {
        return new JAXBElement<FindAllResponse>(_FindAllResponse_QNAME, FindAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindRange }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.aerolinea.com/", name = "findRange")
    public JAXBElement<FindRange> createFindRange(FindRange value) {
        return new JAXBElement<FindRange>(_FindRange_QNAME, FindRange.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindRangeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.aerolinea.com/", name = "findRangeResponse")
    public JAXBElement<FindRangeResponse> createFindRangeResponse(FindRangeResponse value) {
        return new JAXBElement<FindRangeResponse>(_FindRangeResponse_QNAME, FindRangeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.aerolinea.com/", name = "findResponse")
    public JAXBElement<FindResponse> createFindResponse(FindResponse value) {
        return new JAXBElement<FindResponse>(_FindResponse_QNAME, FindResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Remove }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.aerolinea.com/", name = "remove")
    public JAXBElement<Remove> createRemove(Remove value) {
        return new JAXBElement<Remove>(_Remove_QNAME, Remove.class, null, value);
    }

}
