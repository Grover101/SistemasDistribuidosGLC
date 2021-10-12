package laboratorio.pkg1;

import java.io.Serializable;

public class RespuestaSegip implements Serializable {
    boolean estado;
    String mensaje;

    public RespuestaSegip(boolean estado, String mensaje) {
        this.estado = estado;
        this.mensaje = mensaje;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
