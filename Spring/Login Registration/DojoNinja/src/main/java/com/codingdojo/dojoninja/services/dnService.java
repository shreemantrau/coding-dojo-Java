package com.codingdojo.dojoninja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojoninja.models.Dojo;
import com.codingdojo.dojoninja.models.Ninja;
import com.codingdojo.dojoninja.repositories.dojoRepository;
import com.codingdojo.dojoninja.repositories.ninjaRepository;

@Service
public class dnService {
	
		private final dojoRepository dr;
		private final ninjaRepository nr;
		
		public dnService(dojoRepository dr, ninjaRepository nr){
			this.dr=dr;
			this.nr=nr;
		}

		public void createDojo(Dojo dojo) {
			//System.out.println("Hello from createdojo");
			dr.save(dojo);
			
		}

		public List<Dojo> getDojos() {
			return dr.findAll();
			
		}

		public void createNinja(Ninja ninja) {
			nr.save(ninja);
			
		}

		public Optional<Ninja> showAllDojos(Long id) {
			
			 return nr.findById(id);
			
			
		}

		public Optional<Dojo> getThatDojo(Long id) {
			
			return dr.findById(id);
			
		}
		
//		public List<Ninja> getNinjaWRTDojo(Long id){
//			
//			return dr.FindNinjaIDByDojoID(id);
//		}

		public Optional<Dojo> getDojo(Long id) {
			// TODO Auto-generated method stub
			return dr.findById(id);
			
		}

		public List<Ninja> findAllNinjasByDojoId(Long id) {
			Optional<Dojo> dojo = dr.findById(id);
			return dojo.get().getNinjas();
		}
		

		
		
}
