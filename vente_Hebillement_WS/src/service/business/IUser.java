package service.business;


import javax.jws.WebMethod;
import javax.jws.WebService;

import model.Admin;
import model.Client;
import model.Fournisseur;

@WebService
public interface IUser {
	@WebMethod
	public boolean auth(Admin a);

	@WebMethod
	public Client addClient(Client c);

	@WebMethod
	public Client updateClient(Client c);

	@WebMethod
	public boolean deleteClient(int id);

	@WebMethod
	public Client[] getAllClient();

	@WebMethod
	public Fournisseur addFournisseur(Fournisseur f);

	@WebMethod
	public Fournisseur updateFournisseur(Fournisseur f);

	@WebMethod
	public boolean deleteFournisseur(int id);

	@WebMethod
	public Fournisseur[] getAllFournisseurs();
	
	@WebMethod
	public Fournisseur[] getFournisseursByMc(String mc);
	
	@WebMethod
	public Client[] getClientByMc(String mc);
	
}
