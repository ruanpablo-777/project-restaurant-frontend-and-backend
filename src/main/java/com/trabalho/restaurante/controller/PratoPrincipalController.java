package com.trabalho.restaurante.controller;

import com.trabalho.restaurante.model.PratoPrincipal;
import com.trabalho.restaurante.model.db.PPrincipalDAO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class PratoPrincipalController {
    @GetMapping("/pratoprincipal")
    public List<PratoPrincipal> enviaPratoPrincipal() throws SQLException, ClassNotFoundException {
        PPrincipalDAO pprincipalDAO = new PPrincipalDAO();
        List<PratoPrincipal> listaPratoPrincipal = pprincipalDAO.selecionarAll();

        return listaPratoPrincipal;
    }
}