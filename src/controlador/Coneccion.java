/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import vista.Cargando;
import vista.Login;

public class Coneccion {

    public static EntityManagerFactory emf;//conexion
    public static EntityManager em;

    public static void iniciar() {
        if (em == null) {
            emf = Persistence.createEntityManagerFactory("DiscoPU2");
            em = emf.createEntityManager();
        }
    }

    public static void main(String[] args) {
        Cargando c= new Cargando();
        c.setVisible(true);
        new Login(c).setVisible(true);
    }
}
