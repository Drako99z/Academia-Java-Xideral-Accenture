package com.arturo.v0;

public class Configuracion {
	
	//VARIABLE DE REFERENCIA static COMO ATRIBUTO DE LA CLASE QUE ES DEL MISMO TIPO QUE LA CLASE
	static private Configuracion config = null;
	
	//ATRIBUTOS DE LA CLASE -> 2 VARIBALES DE REFERENCIA String Y UN VALOR PRIMITIVO
	private String savePath;
	private String theme;
	private boolean showThumbs;
	
	//MÉTODO CONTRUCTOR PRIVADO PARA EVITAR CREACIÓN DE INSTANCIAS FUERA DE LA CLASE
	private Configuracion() {
		this.savePath = "/home/Documentos/MiAplicacion";
		this.showThumbs = false;
		this.theme = "light_theme";
	}
	
	//MÉTODO DE OBTENCIÓN DE LA ÚNICA INSTANCIA DE Configuracion (SINGLETON)
	public static Configuracion getConfiguracion() {
		if(config == null) {
			//CREACIÓN DE LA INSTANCIA SI AÚN NO HA SIDO CREADA
			config = new Configuracion();
		}
		return config;
	}
	
	//MÉTODOS DE LA CLASE
	public boolean saveConfig() {
		System.out.println("Guardado correcto en: " + savePath);
		return true;
	}

	//SOBREESCRITURA DEL MÉTODO toString CON LOS ATRIBUTOS DE LA CLASE
	@Override
	public String toString() {
		return "Configuracion [savePath=" + savePath + ", showThumbs=" + showThumbs + ", theme=" + theme + "]";
	}

	//***************************
	//MÉTODOS DE ENCAPSULACIÓN DE LA CLASE
	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public boolean getShowThumbs() {
		return showThumbs;
	}

	public void setShowThumbs(boolean showThumbs) {
		this.showThumbs = showThumbs;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}
	
	
}
