package model;

public class Project {

    private String id;
    private String name;
    private String description;
    private boolean status;

    public Project(String id, String name, String description, boolean status) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;

    }

    @Override
    public String toString() {
        String estado = "";
        if (status) {
            estado = "Activo";
        } else {
            estado = "Inactivo";
        }
        return id + "| nombre: " + name + "| descripcion: " + description + "| Estado: " + estado;
    }

}
