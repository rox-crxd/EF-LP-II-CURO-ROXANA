package com.bd.almacenEF.servicio;

import java.util.List;
import com.bd.almacenEF.modelo.TblMedicot3;


public interface IMedicoServicio {
	
	void RegistrarMedico(TblMedicot3 tblmedicot3);
	void EliminarMedico(TblMedicot3 tblmedicot3);
	List<TblMedicot3> ListadoMedicos();
	TblMedicot3 buscarporId(Integer id);
}
