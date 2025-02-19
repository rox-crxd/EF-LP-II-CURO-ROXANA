package com.bd.almacenEF.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.almacenEF.modelo.TblMedicot3;
import com.bd.almacenEF.repositorio.IMedicoRepositorio;

@Service
public class MedicoServicioImp implements IMedicoServicio{
	
	@Autowired
	private IMedicoRepositorio imedicorepositorio;

	@Override
	public void RegistrarMedico(TblMedicot3 tblmedicot3) {
		// TODO Auto-generated method stub
		imedicorepositorio.save(tblmedicot3);
	}

	@Override
	public void EliminarMedico(TblMedicot3 tblmedicot3) {
		// TODO Auto-generated method stub
		imedicorepositorio.deleteById(tblmedicot3.getIdmedicot3());
	}

	@Override
	public List<TblMedicot3> ListadoMedicos() {
		// TODO Auto-generated method stub
		return (List<TblMedicot3>)imedicorepositorio.findAll();
	}

	@Override
	public TblMedicot3 buscarporId(Integer id) {
		// TODO Auto-generated method stub
		return imedicorepositorio.findById(id).orElse(null);
	}

}
