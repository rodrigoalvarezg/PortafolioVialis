
package Modelo;

public class Inspec_Avan {
    
    private String Id_Ins_Ava;
    private double Porcentaje_Ins_Avan;
    private String Descrip_Ins_Avan, Hito_Id_Hito, Hito_Id_Proy;
    
    public Inspec_Avan(){}

    public Inspec_Avan(String Id_Ins_Ava, double Porcentaje_Ins_Avan, String Descrip_Ins_Avan, String Hito_Id_Hito, String Hito_Id_Proy) {
        this.Id_Ins_Ava = Id_Ins_Ava;
        this.Porcentaje_Ins_Avan = Porcentaje_Ins_Avan;
        this.Descrip_Ins_Avan = Descrip_Ins_Avan;
        this.Hito_Id_Hito = Hito_Id_Hito;
        this.Hito_Id_Proy = Hito_Id_Proy;
    }

    public String getId_Ins_Ava() {
        return Id_Ins_Ava;
    }

    public void setId_Ins_Ava(String Id_Ins_Ava) {
        this.Id_Ins_Ava = Id_Ins_Ava;
    }

    public double getPorcentaje_Ins_Avan() {
        return Porcentaje_Ins_Avan;
    }

    public void setPorcentaje_Ins_Avan(double Porcentaje_Ins_Avan) {
        this.Porcentaje_Ins_Avan = Porcentaje_Ins_Avan;
    }

    public String getDescrip_Ins_Avan() {
        return Descrip_Ins_Avan;
    }

    public void setDescrip_Ins_Avan(String Descrip_Ins_Avan) {
        this.Descrip_Ins_Avan = Descrip_Ins_Avan;
    }

    public String getHito_Id_Hito() {
        return Hito_Id_Hito;
    }

    public void setHito_Id_Hito(String Hito_Id_Hito) {
        this.Hito_Id_Hito = Hito_Id_Hito;
    }

    public String getHito_Id_Proy() {
        return Hito_Id_Proy;
    }

    public void setHito_Id_Proy(String Hito_Id_Proy) {
        this.Hito_Id_Proy = Hito_Id_Proy;
    }
    
    
    
}
