package service.business;

import java.util.List;

import javax.jws.WebService;

import dal.DaoUser;
import model.Admin;
import model.Client;
import model.Fournisseur;

@WebService(endpointInterface = "service.business.IUser")
public class UserImple implements IUser {

	@Override
	public boolean auth(final Admin a) {
		return DaoUser.auth(a);

	}

	@Override
	public Client addClient(final Client c) {

		return DaoUser.addClient(c);
	}

	@Override
	public Client updateClient(final Client c) {
		return DaoUser.updateClient(c);
	}

	@Override
	public boolean deleteClient(final int id) {
		return DaoUser.deleteClient(id);
	}

	@Override
	public Client[] getAllClient() {

		final List<Client> list = DaoUser.getAllClients();
		return list.toArray(new Client[list.size()]);

	}

	@Override
	public Fournisseur addFournisseur(final Fournisseur f) {
		return DaoUser.addFournisseur(f);
	}

	@Override
	public Fournisseur updateFournisseur(final Fournisseur f) {
		return DaoUser.updateFournisseur(f);
	}

	@Override
	public boolean deleteFournisseur(final int id) {
		return DaoUser.deleteFournisseur(id);
	}

	@Override
	public Fournisseur[] getAllFournisseurs() {
		final List<Fournisseur> listF = DaoUser.getAllFournisseur();
		return listF.toArray(new Fournisseur[listF.size()]);
	}

	@Override
	public Fournisseur[] getFournisseursByMc(final String mc) {
		if (mc.isEmpty()) {
			final List<Fournisseur> listF = DaoUser.getAllFournisseur();
			return listF.toArray(new Fournisseur[listF.size()]);
		} else {
			final List<Fournisseur> listF = DaoUser.getMatchedFournisseur(mc);
			return listF.toArray(new Fournisseur[listF.size()]);
		}
	}

	@Override
	public Client[] getClientByMc(final String mc) {
		if (mc.isEmpty()) {
			final List<Client> list = DaoUser.getAllClients();
			return list.toArray(new Client[list.size()]);
		} else {
			final List<Client> list = DaoUser.getMatchedClients(mc);
			return list.toArray(new Client[list.size()]);

		}
	}

}
