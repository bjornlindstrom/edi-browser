package com.afconsult.edibrowser.domain;

import java.util.List;

public interface EdiErrorRepository {

	List<EdiError> findEdiErrors();
	
}
