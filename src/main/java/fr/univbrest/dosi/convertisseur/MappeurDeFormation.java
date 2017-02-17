package fr.univbrest.dosi.convertisseur;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.model.FormationComplete;
@Component
@Mapper(uses = OuiNonMappeur.class)
public interface MappeurDeFormation {

	MappeurDeFormation INSTANCE = Mappers.getMapper( MappeurDeFormation.class );
	 
	@Mappings({
		@Mapping(source = "estUnDoubleDiplome", target = "doubleDiplome"),
		@Mapping(source = "nombreDAnnee", target = "n0Annee")
	})
    Formation formationCompleteEnFormation(FormationComplete fc);

	@InheritInverseConfiguration
    FormationComplete formationEnFormationComplete(Formation formation);	

}
