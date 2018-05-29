
package Modelo;

import java.util.Date;

public class Dias_Trabajados {
    
    private Date Dia, Hora_Ingreso, Hora_Salida;
    private String Trabajador_Run_Trab, Trabajador_Dv_Trab;
    
    public Dias_Trabajados(){}

    public Dias_Trabajados(Date Dia, Date Hora_Ingreso, Date Hora_Salida, String Trabajador_Run_Trab, String Trabajador_Dv_Trab) {
        this.Dia = Dia;
        this.Hora_Ingreso = Hora_Ingreso;
        this.Hora_Salida = Hora_Salida;
        this.Trabajador_Run_Trab = Trabajador_Run_Trab;
        this.Trabajador_Dv_Trab = Trabajador_Dv_Trab;
    }

    public Date getDia() {
        return Dia;
    }

    public void setDia(Date Dia) {
        this.Dia = Dia;
    }

    public Date getHora_Ingreso() {
        return Hora_Ingreso;
    }

    public void setHora_Ingreso(Date Hora_Ingreso) {
        this.Hora_Ingreso = Hora_Ingreso;
    }

    public Date getHora_Salida() {
        return Hora_Salida;
    }

    public void setHora_Salida(Date Hora_Salida) {
        this.Hora_Salida = Hora_Salida;
    }

    public String getTrabajador_Run_Trab() {
        return Trabajador_Run_Trab;
    }

    public void setTrabajador_Run_Trab(String Trabajador_Run_Trab) {
        this.Trabajador_Run_Trab = Trabajador_Run_Trab;
    }

    public String getTrabajador_Dv_Trab() {
        return Trabajador_Dv_Trab;
    }

    public void setTrabajador_Dv_Trab(String Trabajador_Dv_Trab) {
        this.Trabajador_Dv_Trab = Trabajador_Dv_Trab;
    }
    
    
    
}
