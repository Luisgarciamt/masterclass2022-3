package com.usa.misiontic.masterclass3.service;

import com.usa.misiontic.masterclass3.entities.Reservas;
import com.usa.misiontic.masterclass3.repository.ReservasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservasService {

    @Autowired
    private ReservasRepository reservasRepository;
    public List<Reservas> getAll() {
        return reservasRepository.getAll();
    }
    public Optional<Reservas> getCategory(int id) {
        return reservasRepository.getReservas(id);
    }
    public Reservas save(Reservas p) {
        if (p.getId() == null) {
            return reservasRepository.save(p);
        } else {
            Optional<Reservas> e = reservasRepository.getReservas(p.getId());
            if (e.isPresent()) {
                return p;
            } else {
                return reservasRepository.save(p);
            }
        }
    }

    public Reservas update(Reservas p) {
        if (p.getId() != null) {
            Optional<Reservas> q = reservasRepository.getReservas(p.getId());
            if (q.isPresent()) {
                if (p.getName() != null) {
                    q.get().setName(p.getName());
                }

                reservasRepository.save(q.get());
                return q.get();
            } else {
                return p;
            }
        } else {
             return p;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Reservas>p= reservasRepository.getReservas(id);
        if(p.isPresent()){
            reservasRepository.delete(p.get());
            flag=true;
        }
        return flag;
    }



}