package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	
	
	private Integer quarto;
	private Date checkEntrada;
	private Date checkSaida;
	
	//Essa classe é statica para que não seja instanciado  
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reserva() {
		
	}

	public Reserva(Integer quarto, Date checkEntrada, Date checkSaida) {
		this.quarto = quarto;
		this.checkEntrada = checkEntrada;
		this.checkSaida = checkSaida;
	}

	public Integer getQuarto() {
		return quarto;
	}

	public void setQuarto(Integer quarto) {
		this.quarto = quarto;
	}

	public Date getCheckEntrada() {
		return checkEntrada;
	}

	public Date getCheckSaida() {
		return checkSaida;
	}

	public long duracaoDaReserva() {
		
		//GetTime devolve uma data em milissegundos
		long diferenca = getCheckSaida().getTime() - getCheckEntrada().getTime();
		
		//TIMEUNIT é uma classe do java complexa com varias funções e uma delas é a conversão
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
		
	}
	
	public void atualizarReserva(Date checkIn, Date checkOut) {
		
		this.checkEntrada = checkIn;
		this.checkSaida = checkOut;
	}
	
	@Override
	public String toString() {
		
		return "Quarto: "
				+ quarto
				+ " - "
				+ sdf.format(checkEntrada)
				+ " -> "
				+ sdf.format(checkSaida)
				+ " - "
				+ duracaoDaReserva() // Não há problema em colocar um LONG(tipo inteiro) no metodo que retorna STRINGs
				+ " noites";
	}
}
