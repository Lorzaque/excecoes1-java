package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reserva(Integer roomNumber, Date checkIn, Date checkOut) {
		this.numeroQuarto = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return numeroQuarto;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.numeroQuarto = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duracao() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public String updateDates(Date checkIn, Date checkOut) {
        Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			return "As datas de reserva para atualiza��o devem ser datas futuras!";
		}
		if (!checkOut.after(checkIn)) {
			return "A data de check-out deve ser posterior � data de check-in!";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
		
	}

	@Override
	public String toString() {
		return "Quarto " + numeroQuarto + ", check-in: " + sdf.format(checkIn) + ", check-out: " + sdf.format(checkOut)
				+ ", " + duracao() + " noites";
	}
}
