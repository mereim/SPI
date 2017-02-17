package fr.univbrest.dosi.convertisseur;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OuiNonMappeur {
	
	OuiNonMappeur INSTANCE = Mappers.getMapper( OuiNonMappeur.class );
	 	
	default boolean charToBoolean(char ouiNon) {
		if(ouiNon == 'O') {
			return true;
		} else {
			return false;
		}
	}
	
	default char booleanToChar(boolean ouiNon) {
		if(ouiNon) {
			return 'O';
		} else {
			return 'N';
		}
	}
}
