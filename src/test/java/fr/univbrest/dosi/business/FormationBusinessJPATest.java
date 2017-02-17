package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.google.common.collect.Lists;

import java.util.List;

import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.model.FormationComplete;
import fr.univbrest.dosi.repositories.FormationRepository;

public class FormationBusinessJPATest {

	@Test
	public void doitPouvoirAjouterUneFormation() {
		FormationRepository entrepot = new FormationRepositoryStub();
		FormationBusinessJPA businessFormation = new FormationBusinessJPA(entrepot);

		businessFormation.ajouterFormation(new FormationComplete());

		assertThat(entrepot.findAll()).hasSize(1);
	}

	@Test
	public void doitPouvoirRécupérerDesFormations() {
		List<Formation> dataSetUp = Lists.newArrayList(
			new Formation("34"), new Formation("35"), new Formation("36")
		);
		FormationRepository entrepot = new FormationRepositoryStub(dataSetUp);
		FormationBusinessJPA businessFormation = new FormationBusinessJPA(entrepot);

		List<FormationComplete> resultat = businessFormation.récupérerFormations();

		assertThat(resultat).hasSize(3);
	}
	
	@Test
	public void doitPouvoirRécupérerUneFormationParLECode() {
		List<Formation> dataSetUp = Lists.newArrayList(
			new Formation("34"), new Formation("35"), new Formation("36")
		);
		FormationRepository entrepot = new FormationRepositoryStub(dataSetUp);
		FormationBusinessJPA businessFormation = new FormationBusinessJPA(entrepot);

		FormationComplete resultat = businessFormation.récupérerFormationParLeCode("35");

		assertThat(resultat.getCodeFormation()).isEqualTo("35");
	}

}
