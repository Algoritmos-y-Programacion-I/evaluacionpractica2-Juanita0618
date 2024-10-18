package model;

import java.lang.runtime.SwitchBootstraps;

public class Controller {

    private Pillar[] pillars;

    public Controller() {

        pillars = new Pillar[4];

    }

    public void precargaDePilares() {
        Pillar pilar1 = new Pillar("Biodiversidad");
        pillars[0] = pilar1;

        Pillar pilar2 = new Pillar("Agua");
        pillars[1] = pilar2;

        Pillar pilar3 = new Pillar("Tratamiento de Basuras");
        pillars[2] = pilar3;

        Pillar pilar4 = new Pillar("Energía");
        pillars[3] = pilar4;
    }

    /**
     * Descripcion: Permite crear y añadir un Project en un Pillar en el sistema
     * 
     * @return boolean true si se logra añadir el Prject en el Pillar, false en caso
     *         contrario
     */
    public boolean registerProjectInPillar(int pillarType, String id, String name, String description, int status) {
        // BIODIVERSIDAD, AGUA, BASURAS, ENERGÍA;
        Boolean estado = null;
        switch (status) {
            case 1:
                estado = true;
                break;
            case 2:
                estado = false;
                break;
        }
        Project newProject = new Project(id, name, description, estado);
        switch (pillarType) {
            case 1:
                return pillars[0].registerProject(newProject);
            case 2:
                return pillars[1].registerProject(newProject);
            case 3:
                return pillars[2].registerProject(newProject);
            case 4:
                return pillars[3].registerProject(newProject);
        }
        return false;
    }

    /**
     * Descripcion: Calcula el valor en dinero correspondiente al arrendamiento
     * mensual de todos los Edificios
     * pre: El arreglo edificios debe estar inicializado
     * 
     * @return String cadena en formato lista con la información de los
     *         Project registrados en el Pillar
     */
    public String queryProjectsByPillar(int pillarType) {
        String list = "";
        switch (pillarType) {
            case 1:
                list = pillars[0].getProjectList();
                break;
            case 2:
                list = pillars[1].getProjectList();
                break;
            case 3:
                list = pillars[2].getProjectList();
                break;
            case 4:
                list = pillars[3].getProjectList();
                break;
        }

        return list;

    }
}

