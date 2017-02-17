package fr.univbrest.dosi.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

import fr.univbrest.dosi.AppTestConfig;
import fr.univbrest.dosi.bean.Candidat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppTestConfig.class)
public class CandidatRepositoryTest {

    @Autowired
    private CandidatRepository candidatRepo;

    @Before
    public void init() {
        Candidat candidat1 = new Candidat("453", "LF", "JF", "H", new Date(), "Paris", "FR", "aaaa@aaa.com", "12 rue du plop", "Plop", "FR", "Univ 1");
        candidatRepo.save(candidat1);

        Candidat candidat2 = new Candidat("564", "PP", "GG", "F", new Date(), "Here", "FR", "bbb@bbb.com", "24 rue du glurps", "JJ", "FR", "Univ 2");
        candidatRepo.save(candidat2);
    }

    @Test
    public void doitCompterLesCandidats() {
        long resultat = candidatRepo.count();

        assertThat(resultat).isEqualTo(2L);
    }

    @Test
    public void doitRécupérerUnCandidatParNom() {
        List<Candidat> resultat = candidatRepo.findByNom("LF");

        assertThat(resultat).hasSize(1);
        assertThat(resultat.get(0).getPrenom()).isEqualTo("JF");
    }

    @Test
    public void doitRécupérerUnCandidatParUniversiteOrigine() {
        List<Candidat> resultat = candidatRepo.findByUniversiteOrigine("Univ 1");

        assertThat(resultat).hasSize(1);
        assertThat(resultat.get(0).getNoCandidat()).isEqualTo("453");
    }
}