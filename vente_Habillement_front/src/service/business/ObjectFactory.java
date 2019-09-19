
package service.business;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the service.business package. 
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

    private final static QName _AddVenteResponse_QNAME = new QName("http://business.service/", "addVenteResponse");
    private final static QName _GetVenteBymotcle_QNAME = new QName("http://business.service/", "getVenteBymotcle");
    private final static QName _AddArticle_QNAME = new QName("http://business.service/", "addArticle");
    private final static QName _GetArticlesByMotcleResponse_QNAME = new QName("http://business.service/", "getArticlesByMotcleResponse");
    private final static QName _UpdateArticle_QNAME = new QName("http://business.service/", "updateArticle");
    private final static QName _UpdateArticleResponse_QNAME = new QName("http://business.service/", "updateArticleResponse");
    private final static QName _GetAllArticlesResponse_QNAME = new QName("http://business.service/", "getAllArticlesResponse");
    private final static QName _GetAllCreditParCreditResponse_QNAME = new QName("http://business.service/", "getAllCreditParCreditResponse");
    private final static QName _AddCreditResponse_QNAME = new QName("http://business.service/", "addCreditResponse");
    private final static QName _GetNeededArticleResponse_QNAME = new QName("http://business.service/", "getNeededArticleResponse");
    private final static QName _GetAllAchatsResponse_QNAME = new QName("http://business.service/", "getAllAchatsResponse");
    private final static QName _AddVersementResponse_QNAME = new QName("http://business.service/", "addVersementResponse");
    private final static QName _EchangerVenteResponse_QNAME = new QName("http://business.service/", "echangerVenteResponse");
    private final static QName _GetAllVentsOfAclient_QNAME = new QName("http://business.service/", "getAllVentsOfAclient");
    private final static QName _AddAchatResponse_QNAME = new QName("http://business.service/", "addAchatResponse");
    private final static QName _GetAchatBymotcleResponse_QNAME = new QName("http://business.service/", "getAchatBymotcleResponse");
    private final static QName _AddVersement_QNAME = new QName("http://business.service/", "addVersement");
    private final static QName _GetTotalCreditParClientResponse_QNAME = new QName("http://business.service/", "getTotalCreditParClientResponse");
    private final static QName _GetArticlesByMotcle_QNAME = new QName("http://business.service/", "getArticlesByMotcle");
    private final static QName _AnnulerVente_QNAME = new QName("http://business.service/", "annulerVente");
    private final static QName _GetVenteBymotcleResponse_QNAME = new QName("http://business.service/", "getVenteBymotcleResponse");
    private final static QName _GetAllVentsAvcCredit_QNAME = new QName("http://business.service/", "getAllVentsAvcCredit");
    private final static QName _AddCredit_QNAME = new QName("http://business.service/", "addCredit");
    private final static QName _GetAllCreditParCredit_QNAME = new QName("http://business.service/", "getAllCreditParCredit");
    private final static QName _GetAllVentsResponse_QNAME = new QName("http://business.service/", "getAllVentsResponse");
    private final static QName _AnnulerVenteResponse_QNAME = new QName("http://business.service/", "annulerVenteResponse");
    private final static QName _DeleteArticleResponse_QNAME = new QName("http://business.service/", "deleteArticleResponse");
    private final static QName _GetAchatBymotcle_QNAME = new QName("http://business.service/", "getAchatBymotcle");
    private final static QName _DeleteArticle_QNAME = new QName("http://business.service/", "deleteArticle");
    private final static QName _GetAllAchats_QNAME = new QName("http://business.service/", "getAllAchats");
    private final static QName _GetTotalCreditParClient_QNAME = new QName("http://business.service/", "getTotalCreditParClient");
    private final static QName _GetAllVents_QNAME = new QName("http://business.service/", "getAllVents");
    private final static QName _AddAchat_QNAME = new QName("http://business.service/", "addAchat");
    private final static QName _AddVente_QNAME = new QName("http://business.service/", "addVente");
    private final static QName _GetNeededArticle_QNAME = new QName("http://business.service/", "getNeededArticle");
    private final static QName _EchangerVente_QNAME = new QName("http://business.service/", "echangerVente");
    private final static QName _AddArticleResponse_QNAME = new QName("http://business.service/", "addArticleResponse");
    private final static QName _GetAllVentsAvcCreditResponse_QNAME = new QName("http://business.service/", "getAllVentsAvcCreditResponse");
    private final static QName _GetAllVentsOfAclientResponse_QNAME = new QName("http://business.service/", "getAllVentsOfAclientResponse");
    private final static QName _GetAllArticles_QNAME = new QName("http://business.service/", "getAllArticles");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: service.business
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetVenteBymotcle }
     * 
     */
    public GetVenteBymotcle createGetVenteBymotcle() {
        return new GetVenteBymotcle();
    }

    /**
     * Create an instance of {@link AddArticle }
     * 
     */
    public AddArticle createAddArticle() {
        return new AddArticle();
    }

    /**
     * Create an instance of {@link GetArticlesByMotcleResponse }
     * 
     */
    public GetArticlesByMotcleResponse createGetArticlesByMotcleResponse() {
        return new GetArticlesByMotcleResponse();
    }

    /**
     * Create an instance of {@link UpdateArticle }
     * 
     */
    public UpdateArticle createUpdateArticle() {
        return new UpdateArticle();
    }

    /**
     * Create an instance of {@link AddVenteResponse }
     * 
     */
    public AddVenteResponse createAddVenteResponse() {
        return new AddVenteResponse();
    }

    /**
     * Create an instance of {@link AddCreditResponse }
     * 
     */
    public AddCreditResponse createAddCreditResponse() {
        return new AddCreditResponse();
    }

    /**
     * Create an instance of {@link GetNeededArticleResponse }
     * 
     */
    public GetNeededArticleResponse createGetNeededArticleResponse() {
        return new GetNeededArticleResponse();
    }

    /**
     * Create an instance of {@link UpdateArticleResponse }
     * 
     */
    public UpdateArticleResponse createUpdateArticleResponse() {
        return new UpdateArticleResponse();
    }

    /**
     * Create an instance of {@link GetAllArticlesResponse }
     * 
     */
    public GetAllArticlesResponse createGetAllArticlesResponse() {
        return new GetAllArticlesResponse();
    }

    /**
     * Create an instance of {@link GetAllCreditParCreditResponse }
     * 
     */
    public GetAllCreditParCreditResponse createGetAllCreditParCreditResponse() {
        return new GetAllCreditParCreditResponse();
    }

    /**
     * Create an instance of {@link AddVersementResponse }
     * 
     */
    public AddVersementResponse createAddVersementResponse() {
        return new AddVersementResponse();
    }

    /**
     * Create an instance of {@link EchangerVenteResponse }
     * 
     */
    public EchangerVenteResponse createEchangerVenteResponse() {
        return new EchangerVenteResponse();
    }

    /**
     * Create an instance of {@link GetAllVentsOfAclient }
     * 
     */
    public GetAllVentsOfAclient createGetAllVentsOfAclient() {
        return new GetAllVentsOfAclient();
    }

    /**
     * Create an instance of {@link GetAllAchatsResponse }
     * 
     */
    public GetAllAchatsResponse createGetAllAchatsResponse() {
        return new GetAllAchatsResponse();
    }

    /**
     * Create an instance of {@link GetArticlesByMotcle }
     * 
     */
    public GetArticlesByMotcle createGetArticlesByMotcle() {
        return new GetArticlesByMotcle();
    }

    /**
     * Create an instance of {@link AnnulerVente }
     * 
     */
    public AnnulerVente createAnnulerVente() {
        return new AnnulerVente();
    }

    /**
     * Create an instance of {@link GetVenteBymotcleResponse }
     * 
     */
    public GetVenteBymotcleResponse createGetVenteBymotcleResponse() {
        return new GetVenteBymotcleResponse();
    }

    /**
     * Create an instance of {@link AddAchatResponse }
     * 
     */
    public AddAchatResponse createAddAchatResponse() {
        return new AddAchatResponse();
    }

    /**
     * Create an instance of {@link GetAchatBymotcleResponse }
     * 
     */
    public GetAchatBymotcleResponse createGetAchatBymotcleResponse() {
        return new GetAchatBymotcleResponse();
    }

    /**
     * Create an instance of {@link AddVersement }
     * 
     */
    public AddVersement createAddVersement() {
        return new AddVersement();
    }

    /**
     * Create an instance of {@link GetTotalCreditParClientResponse }
     * 
     */
    public GetTotalCreditParClientResponse createGetTotalCreditParClientResponse() {
        return new GetTotalCreditParClientResponse();
    }

    /**
     * Create an instance of {@link GetAllCreditParCredit }
     * 
     */
    public GetAllCreditParCredit createGetAllCreditParCredit() {
        return new GetAllCreditParCredit();
    }

    /**
     * Create an instance of {@link GetAllVentsResponse }
     * 
     */
    public GetAllVentsResponse createGetAllVentsResponse() {
        return new GetAllVentsResponse();
    }

    /**
     * Create an instance of {@link AnnulerVenteResponse }
     * 
     */
    public AnnulerVenteResponse createAnnulerVenteResponse() {
        return new AnnulerVenteResponse();
    }

    /**
     * Create an instance of {@link GetAllVentsAvcCredit }
     * 
     */
    public GetAllVentsAvcCredit createGetAllVentsAvcCredit() {
        return new GetAllVentsAvcCredit();
    }

    /**
     * Create an instance of {@link AddCredit }
     * 
     */
    public AddCredit createAddCredit() {
        return new AddCredit();
    }

    /**
     * Create an instance of {@link DeleteArticleResponse }
     * 
     */
    public DeleteArticleResponse createDeleteArticleResponse() {
        return new DeleteArticleResponse();
    }

    /**
     * Create an instance of {@link GetAchatBymotcle }
     * 
     */
    public GetAchatBymotcle createGetAchatBymotcle() {
        return new GetAchatBymotcle();
    }

    /**
     * Create an instance of {@link DeleteArticle }
     * 
     */
    public DeleteArticle createDeleteArticle() {
        return new DeleteArticle();
    }

    /**
     * Create an instance of {@link GetAllAchats }
     * 
     */
    public GetAllAchats createGetAllAchats() {
        return new GetAllAchats();
    }

    /**
     * Create an instance of {@link AddAchat }
     * 
     */
    public AddAchat createAddAchat() {
        return new AddAchat();
    }

    /**
     * Create an instance of {@link GetTotalCreditParClient }
     * 
     */
    public GetTotalCreditParClient createGetTotalCreditParClient() {
        return new GetTotalCreditParClient();
    }

    /**
     * Create an instance of {@link GetAllVents }
     * 
     */
    public GetAllVents createGetAllVents() {
        return new GetAllVents();
    }

    /**
     * Create an instance of {@link EchangerVente }
     * 
     */
    public EchangerVente createEchangerVente() {
        return new EchangerVente();
    }

    /**
     * Create an instance of {@link AddArticleResponse }
     * 
     */
    public AddArticleResponse createAddArticleResponse() {
        return new AddArticleResponse();
    }

    /**
     * Create an instance of {@link GetAllVentsAvcCreditResponse }
     * 
     */
    public GetAllVentsAvcCreditResponse createGetAllVentsAvcCreditResponse() {
        return new GetAllVentsAvcCreditResponse();
    }

    /**
     * Create an instance of {@link GetAllVentsOfAclientResponse }
     * 
     */
    public GetAllVentsOfAclientResponse createGetAllVentsOfAclientResponse() {
        return new GetAllVentsOfAclientResponse();
    }

    /**
     * Create an instance of {@link GetAllArticles }
     * 
     */
    public GetAllArticles createGetAllArticles() {
        return new GetAllArticles();
    }

    /**
     * Create an instance of {@link AddVente }
     * 
     */
    public AddVente createAddVente() {
        return new AddVente();
    }

    /**
     * Create an instance of {@link GetNeededArticle }
     * 
     */
    public GetNeededArticle createGetNeededArticle() {
        return new GetNeededArticle();
    }

    /**
     * Create an instance of {@link Fournisseur }
     * 
     */
    public Fournisseur createFournisseur() {
        return new Fournisseur();
    }

    /**
     * Create an instance of {@link Credit }
     * 
     */
    public Credit createCredit() {
        return new Credit();
    }

    /**
     * Create an instance of {@link Article }
     * 
     */
    public Article createArticle() {
        return new Article();
    }

    /**
     * Create an instance of {@link Designation }
     * 
     */
    public Designation createDesignation() {
        return new Designation();
    }

    /**
     * Create an instance of {@link Achat }
     * 
     */
    public Achat createAchat() {
        return new Achat();
    }

    /**
     * Create an instance of {@link Client }
     * 
     */
    public Client createClient() {
        return new Client();
    }

    /**
     * Create an instance of {@link Categorie }
     * 
     */
    public Categorie createCategorie() {
        return new Categorie();
    }

    /**
     * Create an instance of {@link Versement }
     * 
     */
    public Versement createVersement() {
        return new Versement();
    }

    /**
     * Create an instance of {@link Vente }
     * 
     */
    public Vente createVente() {
        return new Vente();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddVenteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.service/", name = "addVenteResponse")
    public JAXBElement<AddVenteResponse> createAddVenteResponse(AddVenteResponse value) {
        return new JAXBElement<AddVenteResponse>(_AddVenteResponse_QNAME, AddVenteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVenteBymotcle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.service/", name = "getVenteBymotcle")
    public JAXBElement<GetVenteBymotcle> createGetVenteBymotcle(GetVenteBymotcle value) {
        return new JAXBElement<GetVenteBymotcle>(_GetVenteBymotcle_QNAME, GetVenteBymotcle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddArticle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.service/", name = "addArticle")
    public JAXBElement<AddArticle> createAddArticle(AddArticle value) {
        return new JAXBElement<AddArticle>(_AddArticle_QNAME, AddArticle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetArticlesByMotcleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.service/", name = "getArticlesByMotcleResponse")
    public JAXBElement<GetArticlesByMotcleResponse> createGetArticlesByMotcleResponse(GetArticlesByMotcleResponse value) {
        return new JAXBElement<GetArticlesByMotcleResponse>(_GetArticlesByMotcleResponse_QNAME, GetArticlesByMotcleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateArticle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.service/", name = "updateArticle")
    public JAXBElement<UpdateArticle> createUpdateArticle(UpdateArticle value) {
        return new JAXBElement<UpdateArticle>(_UpdateArticle_QNAME, UpdateArticle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateArticleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.service/", name = "updateArticleResponse")
    public JAXBElement<UpdateArticleResponse> createUpdateArticleResponse(UpdateArticleResponse value) {
        return new JAXBElement<UpdateArticleResponse>(_UpdateArticleResponse_QNAME, UpdateArticleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllArticlesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.service/", name = "getAllArticlesResponse")
    public JAXBElement<GetAllArticlesResponse> createGetAllArticlesResponse(GetAllArticlesResponse value) {
        return new JAXBElement<GetAllArticlesResponse>(_GetAllArticlesResponse_QNAME, GetAllArticlesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCreditParCreditResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.service/", name = "getAllCreditParCreditResponse")
    public JAXBElement<GetAllCreditParCreditResponse> createGetAllCreditParCreditResponse(GetAllCreditParCreditResponse value) {
        return new JAXBElement<GetAllCreditParCreditResponse>(_GetAllCreditParCreditResponse_QNAME, GetAllCreditParCreditResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCreditResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.service/", name = "addCreditResponse")
    public JAXBElement<AddCreditResponse> createAddCreditResponse(AddCreditResponse value) {
        return new JAXBElement<AddCreditResponse>(_AddCreditResponse_QNAME, AddCreditResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNeededArticleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.service/", name = "getNeededArticleResponse")
    public JAXBElement<GetNeededArticleResponse> createGetNeededArticleResponse(GetNeededArticleResponse value) {
        return new JAXBElement<GetNeededArticleResponse>(_GetNeededArticleResponse_QNAME, GetNeededArticleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllAchatsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.service/", name = "getAllAchatsResponse")
    public JAXBElement<GetAllAchatsResponse> createGetAllAchatsResponse(GetAllAchatsResponse value) {
        return new JAXBElement<GetAllAchatsResponse>(_GetAllAchatsResponse_QNAME, GetAllAchatsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddVersementResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.service/", name = "addVersementResponse")
    public JAXBElement<AddVersementResponse> createAddVersementResponse(AddVersementResponse value) {
        return new JAXBElement<AddVersementResponse>(_AddVersementResponse_QNAME, AddVersementResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EchangerVenteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.service/", name = "echangerVenteResponse")
    public JAXBElement<EchangerVenteResponse> createEchangerVenteResponse(EchangerVenteResponse value) {
        return new JAXBElement<EchangerVenteResponse>(_EchangerVenteResponse_QNAME, EchangerVenteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllVentsOfAclient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.service/", name = "getAllVentsOfAclient")
    public JAXBElement<GetAllVentsOfAclient> createGetAllVentsOfAclient(GetAllVentsOfAclient value) {
        return new JAXBElement<GetAllVentsOfAclient>(_GetAllVentsOfAclient_QNAME, GetAllVentsOfAclient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddAchatResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.service/", name = "addAchatResponse")
    public JAXBElement<AddAchatResponse> createAddAchatResponse(AddAchatResponse value) {
        return new JAXBElement<AddAchatResponse>(_AddAchatResponse_QNAME, AddAchatResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAchatBymotcleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.service/", name = "getAchatBymotcleResponse")
    public JAXBElement<GetAchatBymotcleResponse> createGetAchatBymotcleResponse(GetAchatBymotcleResponse value) {
        return new JAXBElement<GetAchatBymotcleResponse>(_GetAchatBymotcleResponse_QNAME, GetAchatBymotcleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddVersement }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.service/", name = "addVersement")
    public JAXBElement<AddVersement> createAddVersement(AddVersement value) {
        return new JAXBElement<AddVersement>(_AddVersement_QNAME, AddVersement.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTotalCreditParClientResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.service/", name = "getTotalCreditParClientResponse")
    public JAXBElement<GetTotalCreditParClientResponse> createGetTotalCreditParClientResponse(GetTotalCreditParClientResponse value) {
        return new JAXBElement<GetTotalCreditParClientResponse>(_GetTotalCreditParClientResponse_QNAME, GetTotalCreditParClientResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetArticlesByMotcle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.service/", name = "getArticlesByMotcle")
    public JAXBElement<GetArticlesByMotcle> createGetArticlesByMotcle(GetArticlesByMotcle value) {
        return new JAXBElement<GetArticlesByMotcle>(_GetArticlesByMotcle_QNAME, GetArticlesByMotcle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnnulerVente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.service/", name = "annulerVente")
    public JAXBElement<AnnulerVente> createAnnulerVente(AnnulerVente value) {
        return new JAXBElement<AnnulerVente>(_AnnulerVente_QNAME, AnnulerVente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVenteBymotcleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.service/", name = "getVenteBymotcleResponse")
    public JAXBElement<GetVenteBymotcleResponse> createGetVenteBymotcleResponse(GetVenteBymotcleResponse value) {
        return new JAXBElement<GetVenteBymotcleResponse>(_GetVenteBymotcleResponse_QNAME, GetVenteBymotcleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllVentsAvcCredit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.service/", name = "getAllVentsAvcCredit")
    public JAXBElement<GetAllVentsAvcCredit> createGetAllVentsAvcCredit(GetAllVentsAvcCredit value) {
        return new JAXBElement<GetAllVentsAvcCredit>(_GetAllVentsAvcCredit_QNAME, GetAllVentsAvcCredit.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCredit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.service/", name = "addCredit")
    public JAXBElement<AddCredit> createAddCredit(AddCredit value) {
        return new JAXBElement<AddCredit>(_AddCredit_QNAME, AddCredit.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCreditParCredit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.service/", name = "getAllCreditParCredit")
    public JAXBElement<GetAllCreditParCredit> createGetAllCreditParCredit(GetAllCreditParCredit value) {
        return new JAXBElement<GetAllCreditParCredit>(_GetAllCreditParCredit_QNAME, GetAllCreditParCredit.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllVentsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.service/", name = "getAllVentsResponse")
    public JAXBElement<GetAllVentsResponse> createGetAllVentsResponse(GetAllVentsResponse value) {
        return new JAXBElement<GetAllVentsResponse>(_GetAllVentsResponse_QNAME, GetAllVentsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnnulerVenteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.service/", name = "annulerVenteResponse")
    public JAXBElement<AnnulerVenteResponse> createAnnulerVenteResponse(AnnulerVenteResponse value) {
        return new JAXBElement<AnnulerVenteResponse>(_AnnulerVenteResponse_QNAME, AnnulerVenteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteArticleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.service/", name = "deleteArticleResponse")
    public JAXBElement<DeleteArticleResponse> createDeleteArticleResponse(DeleteArticleResponse value) {
        return new JAXBElement<DeleteArticleResponse>(_DeleteArticleResponse_QNAME, DeleteArticleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAchatBymotcle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.service/", name = "getAchatBymotcle")
    public JAXBElement<GetAchatBymotcle> createGetAchatBymotcle(GetAchatBymotcle value) {
        return new JAXBElement<GetAchatBymotcle>(_GetAchatBymotcle_QNAME, GetAchatBymotcle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteArticle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.service/", name = "deleteArticle")
    public JAXBElement<DeleteArticle> createDeleteArticle(DeleteArticle value) {
        return new JAXBElement<DeleteArticle>(_DeleteArticle_QNAME, DeleteArticle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllAchats }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.service/", name = "getAllAchats")
    public JAXBElement<GetAllAchats> createGetAllAchats(GetAllAchats value) {
        return new JAXBElement<GetAllAchats>(_GetAllAchats_QNAME, GetAllAchats.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTotalCreditParClient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.service/", name = "getTotalCreditParClient")
    public JAXBElement<GetTotalCreditParClient> createGetTotalCreditParClient(GetTotalCreditParClient value) {
        return new JAXBElement<GetTotalCreditParClient>(_GetTotalCreditParClient_QNAME, GetTotalCreditParClient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllVents }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.service/", name = "getAllVents")
    public JAXBElement<GetAllVents> createGetAllVents(GetAllVents value) {
        return new JAXBElement<GetAllVents>(_GetAllVents_QNAME, GetAllVents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddAchat }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.service/", name = "addAchat")
    public JAXBElement<AddAchat> createAddAchat(AddAchat value) {
        return new JAXBElement<AddAchat>(_AddAchat_QNAME, AddAchat.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddVente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.service/", name = "addVente")
    public JAXBElement<AddVente> createAddVente(AddVente value) {
        return new JAXBElement<AddVente>(_AddVente_QNAME, AddVente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNeededArticle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.service/", name = "getNeededArticle")
    public JAXBElement<GetNeededArticle> createGetNeededArticle(GetNeededArticle value) {
        return new JAXBElement<GetNeededArticle>(_GetNeededArticle_QNAME, GetNeededArticle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EchangerVente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.service/", name = "echangerVente")
    public JAXBElement<EchangerVente> createEchangerVente(EchangerVente value) {
        return new JAXBElement<EchangerVente>(_EchangerVente_QNAME, EchangerVente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddArticleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.service/", name = "addArticleResponse")
    public JAXBElement<AddArticleResponse> createAddArticleResponse(AddArticleResponse value) {
        return new JAXBElement<AddArticleResponse>(_AddArticleResponse_QNAME, AddArticleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllVentsAvcCreditResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.service/", name = "getAllVentsAvcCreditResponse")
    public JAXBElement<GetAllVentsAvcCreditResponse> createGetAllVentsAvcCreditResponse(GetAllVentsAvcCreditResponse value) {
        return new JAXBElement<GetAllVentsAvcCreditResponse>(_GetAllVentsAvcCreditResponse_QNAME, GetAllVentsAvcCreditResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllVentsOfAclientResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.service/", name = "getAllVentsOfAclientResponse")
    public JAXBElement<GetAllVentsOfAclientResponse> createGetAllVentsOfAclientResponse(GetAllVentsOfAclientResponse value) {
        return new JAXBElement<GetAllVentsOfAclientResponse>(_GetAllVentsOfAclientResponse_QNAME, GetAllVentsOfAclientResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllArticles }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.service/", name = "getAllArticles")
    public JAXBElement<GetAllArticles> createGetAllArticles(GetAllArticles value) {
        return new JAXBElement<GetAllArticles>(_GetAllArticles_QNAME, GetAllArticles.class, null, value);
    }

}
