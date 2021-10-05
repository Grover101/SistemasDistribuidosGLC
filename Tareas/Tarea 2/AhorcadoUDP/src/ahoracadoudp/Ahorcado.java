package ahoracadoudp;

import java.util.Scanner;

/**
 *
 * @author grover
 */
public class Ahorcado {
    private String palabras[] = { "nabucodonosor", "anticostitucionalmente", "electrodomesticos", "ovoviviparo",
            "omoplato", "sabiduria", "deuteronomio", "malaquias", "rigurosidad", "caleidoscopio" };
    private String palabra;
    private String palabraFormada = "";
    private int vida;
    Scanner input = new Scanner(System.in);

    public Ahorcado() {
        this.palabra = this.palabras[(int) (Math.random() * 9)];
        this.vida = 7;
        this.palabraFormada = palabraInicial();
    }

    public String palabraInicial() {
        for (int i = 0; i < this.palabra.length(); i++)
            this.palabraFormada += "_";
        return this.palabraFormada;
    }

    public void verificarLetra(char letra) {
        boolean acerto = false;
        for (int i = 0; i < this.palabra.length(); i++)
            if (this.palabra.charAt(i) == letra) {
                acerto = true;
                this.palabraFormada = this.palabraFormada.substring(0, i) + letra
                        + this.palabraFormada.substring(i + 1);
            }
        if (!acerto)
            this.vida--;
    }

    public boolean gana() {
        return this.palabra.equals(this.palabraFormada) ? true : false;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getPalabraFormada() {
        return palabraFormada;
    }

    public void setPalabraFormada(String palabraFormada) {
        this.palabraFormada = palabraFormada;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

}
