package it.prova.municipioAbitanteJPA.service.abitante;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.municipioAbitanteJPA.dao.EntityManagerUtil;
import it.prova.municipioAbitanteJPA.dao.abitante.AbitanteDAO;
import it.prova.municipioAbitanteJPA.model.Abitante;

public class AbitanteServiceImpl implements AbitanteService {

	private AbitanteDAO abitanteDAO;

	public void setAbitanteDAO(AbitanteDAO abitanteDAO) {
		this.abitanteDAO = abitanteDAO;
	}

	@Override
	public List<Abitante> listAllAbitanti() throws Exception {

		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			abitanteDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return abitanteDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Abitante caricaSingoloAbitante(Long id) throws Exception {

		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			abitanteDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return abitanteDAO.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void aggiorna(Abitante abitanteInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			abitanteDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			abitanteDAO.update(abitanteInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void inserisciNuovo(Abitante abitanteInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			abitanteDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			abitanteDAO.insert(abitanteInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void rimuovi(Abitante abitanteInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			abitanteDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			abitanteDAO.delete(abitanteInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Abitante> cercaTuttiGliAbitantiConNome(String nome) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			abitanteDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return abitanteDAO.findAllByNome(nome);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public List<Abitante> cercaTuttiGliAbitantiConCognome(String cognome) throws Exception {
		// questo è come una connection
				EntityManager entityManager = EntityManagerUtil.getEntityManager();

				try {
					// uso l'injection per il dao
					abitanteDAO.setEntityManager(entityManager);

					// eseguo quello che realmente devo fare
					return abitanteDAO.findAllByCognome(cognome);
				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				} finally {
					entityManager.close();
				}
			}

	@Override
	public List<Abitante> cercaTuttiGliAbitantiConCodiceMunicipioIniziaPer(String codice) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			abitanteDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return abitanteDAO.findAllByCodiceMunicipioIniziaCon(codice);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

}
