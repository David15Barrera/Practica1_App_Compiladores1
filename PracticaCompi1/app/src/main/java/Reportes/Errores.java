package Reportes;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

import kotlin.jvm.internal.Intrinsics;

public class Errores implements Serializable {
    private String lexema;
    private int linea;
    private int columna;
    private String tipo;
    private String descripcion;

    @NotNull
    public final String getLexema() {
        return this.lexema;
    }

    public final int getLinea() {
        return this.linea;
    }

    public final int getColumna() {
        return this.columna;
    }

    @NotNull
    public final String getTipo() {
        return this.tipo;
    }

    @NotNull
    public final String getDescripcion() {
        return this.descripcion;
    }

    public Errores() {
        this.lexema = "";
        this.tipo = "";
        this.descripcion = "";
    }

    public Errores(@NotNull String lexema, int linea, int columna, @NotNull String tipo, @NotNull String descripcion) {
        Intrinsics.checkNotNullParameter(lexema, "lexema");
        Intrinsics.checkNotNullParameter(tipo, "tipo");
        Intrinsics.checkNotNullParameter(descripcion, "descripcion");
        this.lexema = "";
        this.tipo = "";
        this.descripcion = "";
        this.lexema = lexema;
        this.linea = linea;
        this.columna = columna;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }
}
